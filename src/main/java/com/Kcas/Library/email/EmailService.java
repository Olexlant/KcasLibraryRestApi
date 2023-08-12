package com.Kcas.Library.email;

import com.Kcas.Library.entities.Book;
import com.Kcas.Library.entities.TakenBooks;
import com.Kcas.Library.entities.User;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDate;
import java.util.Locale;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    @Async
    public void sendregistrationmail(User user, String link) {
        try {
            Context context = new Context();
            Locale locale = LocaleContextHolder.getLocale();
            context.setLocale(locale);
            context.setVariable("user", user);
            context.setVariable("link", link);
            String process = templateEngine.process("emails/confirm-email", context);
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setSubject("sdad");
            helper.setSubject(user.getLastName()+" "+user.getFirstName());
            helper.setText(process, true);
            helper.setTo(user.getEmail());
            javaMailSender.send(mimeMessage);
        } catch (jakarta.mail.MessagingException e) {
            throw new RuntimeException("Message not sent");
        }

    }


    @Async
    public void sendchangepasswordmail(User user, String link) {
        try {
            Context context = new Context();
            Locale locale = LocaleContextHolder.getLocale();
            context.setLocale(locale);
            context.setVariable("user", user);
            context.setVariable("link", link);
            String process = templateEngine.process("emails/change-password", context);
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setSubject(user.getLastName()+" "+user.getFirstName());
            helper.setText(process, true);
            helper.setTo(user.getEmail());
            javaMailSender.send(mimeMessage);
        }catch (jakarta.mail.MessagingException e) {
            throw new RuntimeException("Message not sent");
        }
    }

    @Async
    public void sendNotificationMessage(User user, Book book, TakenBooks takenBooks) {
        try {
            Context context = new Context();
            Locale locale = LocaleContextHolder.getLocale();
            context.setLocale(locale);
            context.setVariable("user", user);
            context.setVariable("book", book);
            context.setVariable("takenbook", takenBooks);
            context.setVariable("date", LocalDate.now());
            String process = templateEngine.process("emails/book-return-notification", context);
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setSubject(user.getLastName()+" "+user.getFirstName());
            helper.setText(process, true);
            helper.setTo(user.getEmail());
            javaMailSender.send(mimeMessage);
        }catch (jakarta.mail.MessagingException e) {
            throw new RuntimeException("Message not sent");
        }
    }
}