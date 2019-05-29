package ua.salon.schedule.ssl_email_sender;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.command.GetAllBookingsByDayCommand;
import ua.salon.schedule.model.booking.Booking;
import ua.salon.schedule.singleton_executor.ScheduledExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

///**@Deprecated(since="9") see:https://docs.oracle.com/javase/9/docs/api/java/util/Observer.html*/
public class MailClient implements Observer {
    private Observable observable;
    private static final Logger rootLogger = LogManager.getRootLogger();

    public MailClient() {
        observable = ScheduledExecutor.INSTANCE.getCommand();
        observable.addObserver(this);
    }

    private static ua.salon.schedule.ssl_email_sender.Sender sslSender = new ua.salon.schedule.ssl_email_sender.Sender("ann.lubska@gmail.com", "2204071anna");

    public static void main(String[] args) {
        sslSender.send("Я отправила это со своего проекта", "Мне уже начинает нравиться! Эгегей!",  "ann.lubska@gmail.com", "alexey.lubskiy@gmail.com");
    }

    @Override
    public void update(Observable obs, Object arg) {
        rootLogger.debug("update() method started execution: "+this.getClass());
        if(obs instanceof GetAllBookingsByDayCommand) {
            rootLogger.debug("Observer was notified by GetAllBookingsByDayCommand.class extends Observable");
            List<Booking> result = ((ArrayList<Booking>) arg);
            for (Booking booking : result) {
                sslSender.send("Я отправила это со своего проекта", "Мне уже начинает нравиться! Эгегей!",  "ann.lubska@gmail.com", booking.getClient().getEmail());
            }

        }
    }
}
