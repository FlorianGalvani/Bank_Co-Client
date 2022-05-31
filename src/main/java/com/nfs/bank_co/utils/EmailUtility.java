package com.nfs.bank_co.utils;

import com.sun.mail.smtp.SMTPTransport;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//TODO Modifier style du mail
//Truc utile : public static Map<String,String> getenv()
public class EmailUtility {
//      static final String HOST = "smtp.gmail.com";
      static final String HOST = "mail.yahoo.com";
      static final String TLS_PORT = "587";

      static final String SSL_PORT = "465";
//      static final String USERNAME = "bankco.noreply@gmail.com";
      static final String USERNAME = "bank_co@yahoo.com";
      static final String PASSWORD = "pqattifqxirubyvy";

    public static boolean createNewCustomerRequestPendingConfirmationEmail(String toAddress) {
         String subject = "Confirmation de reception de votre demande";
         String message = "BLABLA";
        try {
            //Envoi du mail client
            // DEMANDE PRISE EN COMPTE
            sendEmail(toAddress,subject,message);
            //Envoi du mail Banquier
            //NOUVELLE DEMANDE EN ATTENTE DE VALIDATION
            //FIXME envoyer ce mail a tout les banquiers (adresse gmail bancko pour le dev) plutot qu'au client
//            sendEmail(toAddress,subject,message);

            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println(e);
            return false;
        }
    }
    public static void sendEmail(String toAddress, String subject ,String messageBody) throws AddressException, MessagingException {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", SSL_PORT);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.starttls.required", "true");
//        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
//        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }

        });
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(USERNAME));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));

            message.setSubject(subject);

//            message.setText(messageBody);
            String someHtmlMessage = "<div style='background-color: #f00, width: 100%'><p style='color:blue;'>Test</p></div>";
            message.setContent(someHtmlMessage, "text/html; charset=utf-8");
            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}