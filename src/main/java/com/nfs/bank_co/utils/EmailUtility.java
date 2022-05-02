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

//TODO Gerer envoie du mail de confirmation de reception de demande d'ouverture de compte
// Trucs utiles : public static Map<String,String> getenv()
public class EmailUtility {
    private static final String HOST = "smtp.gmail.com";
    private static final String TLS_PORT = "587";
    private static final String SSL_PORT = "465";
    private static final String USERNAME = "bankco.noreply@gmail.com";
    private static final String PASSWORD = "P@s$w0rd76";

    public static void createNewCustomerRequestPendingConfirmationEmail(String toAddress) {
         String subject = "Confirmation de reception de votre demande";
         String message = "BLABLA ";
        try {
            sendEmail(toAddress,subject,message);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    public static void sendEmail(String toAddress, String subject, String message) throws AddressException, MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", SSL_PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust","smtp.gmail.com");

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        };

        Session session = Session.getInstance(properties, auth);

        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(USERNAME));
        InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);

        SMTPTransport t = (SMTPTransport)session.getTransport("smtp");

        t.connect("smtp.gmail.com", USERNAME, PASSWORD);
        t.sendMessage(msg, msg.getAllRecipients());
        t.close();
    }
}