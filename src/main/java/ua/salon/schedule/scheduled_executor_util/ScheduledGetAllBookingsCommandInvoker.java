package ua.salon.schedule.scheduled_executor_util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.command.GetAllBookingsByDayCommand;

import java.time.LocalDate;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledGetAllBookingsCommandInvoker {
    private static ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private static final Logger rootLogger = LogManager.getRootLogger();


    /*public static void threadInvoke() {
        try{
            Runnable task = () -> GetAllBookingsByDayCommand.invokeDAO(LocalDate.now().toString());
            executor.scheduleAtFixedRate(task,1,5, TimeUnit.MINUTES);
        } catch (Exception e) {
            rootLogger.warn("Exception occured by thread invokation", e);
        }
    }*/
}
