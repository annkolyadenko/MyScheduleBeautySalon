package ua.salon.schedule.ssl_email_sender;

public class MailClient {
    private static ua.salon.schedule.ssl_email_sender.Sender sslSender = new ua.salon.schedule.ssl_email_sender.Sender("ann.lubska@gmail.com", "2204071anna");

    public static void main(String[] args) {
        sslSender.send("Я отправила это со своего проекта", "Мне уже начинает нравиться! Эгегей!",  "ann.lubska@gmail.com", "alexey.lubskiy@gmail.com");
    }
}
