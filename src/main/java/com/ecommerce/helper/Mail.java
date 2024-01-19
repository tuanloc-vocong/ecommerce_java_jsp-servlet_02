package com.ecommerce.helper;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

public class Mail {
    public static void sendMail(String recipientMailId, String subject, String body){
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");

        String emailId = "";
        String password = "";

        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication // bhagatanirudh
        })
    }
}
