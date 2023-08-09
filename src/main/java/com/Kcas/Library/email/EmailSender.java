package com.Kcas.Library.email;

import com.Kcas.Library.appbook.AppBook;
import com.Kcas.Library.appuser.AppUser;
import com.Kcas.Library.appuser.TakenBooks;

public interface EmailSender {
    void sendregistrationmail(AppUser user, String link);
    void sendchangepasswordmail(AppUser user, String link);
    void sendNotificationMessage(AppUser user, AppBook book, TakenBooks takenBooks);

}
