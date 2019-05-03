package ua.salon.schedule.ssl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Sender {
    private static final Logger rootLogger = LogManager.getRootLogger();
    private String username;
    private String password;
    private Properties props;

    public Sender(String username, String password) {
        this.username = username;
        this.password = password;

        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.SocketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","465");
        rootLogger.debug("Mail Properties() constructor successfully initialized");
    }

    public void send(String subject, String text, String fromEmail, String toEmail) {
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return super.getPasswordAuthentication();
            }
        });

        try {
            Message message = new MimeMessage(session);
            rootLogger.debug("Mail was created");
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            rootLogger.debug("Mail successfully send to recipient");

        } catch (AddressException e) {
            e.printStackTrace();
            rootLogger.warn("AddressException: ", e);
        } catch (MessagingException e) {
            rootLogger.warn("Mail successfully send to recipient");
        }
    }
}
