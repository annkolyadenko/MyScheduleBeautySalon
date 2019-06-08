package ua.salon.schedule.net_email;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

class Sender {
    private static final Logger rootLogger = LogManager.getRootLogger();

    private String username;
    private String password;
    private Properties props;

    Sender(String username, String password) {
        this.username = username;
        this.password = password;

        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
    }

    void send(String subject, String text, String fromEmail, String toEmail){
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        /**
         * How to fix encoding in emails: https://docs.oracle.com/javaee/6/api/javax/mail/internet/package-summary.html
         * */
        try {
            System.setProperty("mail.mime.charset", "UTF-8");
            Message message = new MimeMessage(session);
            rootLogger.debug("Mail was created");
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            rootLogger.debug("Mail successfully send to recipient");

        } catch (MessagingException e) {
            rootLogger.warn("MessagingException: ", e);
        }
    }
}
