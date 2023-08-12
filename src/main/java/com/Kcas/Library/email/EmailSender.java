package com.Kcas.Library.email;

import com.Kcas.Library.entities.Book;
import com.Kcas.Library.entities.User;
import com.Kcas.Library.entities.TakenBooks;

public interface EmailSender {
    void sendregistrationmail(User user, String link);
    void sendchangepasswordmail(User user, String link);
    void sendNotificationMessage(User user, Book book, TakenBooks takenBooks);

}
