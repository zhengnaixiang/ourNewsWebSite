package com.qf.userInfo.utils;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailSendUtils {

    @Autowired
    private Email email;
    public void send(String subject,String msg,String to){
        try {
            email.setSubject(subject);
            email.setMsg(msg);
            email.addTo(to);
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
