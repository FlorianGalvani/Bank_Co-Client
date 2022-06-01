package com.nfs.bank_co.utils.email;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

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
      static final String HOST = "node18-eu.n0c.com";
      static final String TLS_PORT = "587";

      static final String SSL_PORT = "465";
      static final String USERNAME = "bankco.noreply@legilmalas.fr";
      static final String PASSWORD = "bv/K&eK1?be:v&5://";

    StringBuilder contentBuilder = new StringBuilder();


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
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }

        });
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(USERNAME));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));

            message.setSubject(subject);

            //TODO CENTRALISER LES DIFFERENTS FORMATS DE MAIL
                InputStream in = EmailUtility.class.getClassLoader().getResourceAsStream("email_templates/template1.html");
//                InputStream in = EmailUtility.class.getClassLoader().getResourceAsStream("email_templates/templateTEST.html");
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                StringBuilder someHtmlMessage = new StringBuilder();

                br.lines().forEach(line -> someHtmlMessage.append(line));


                message.setContent(someHtmlMessage.toString(), "text/html; charset=utf-8");
                System.out.println("sending...");
                // Send message
                Transport.send(message);
                System.out.println("Sent message successfully....");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}