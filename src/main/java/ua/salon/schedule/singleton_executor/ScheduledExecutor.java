package ua.salon.schedule.singleton_executor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.command.GetAllBookingsByDayCommand;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public enum ScheduledExecutor {
    INSTANCE;
    private ScheduledExecutorService executor;
    private GetAllBookingsByDayCommand command;
    private static final Logger rootLogger = LogManager.getRootLogger();

    ScheduledExecutor() {
        executor = Executors.newScheduledThreadPool(1);
        command = new GetAllBookingsByDayCommand();
    }

    public static ScheduledExecutor getInstance(){
        return INSTANCE;
    }
    public void threadInvoke() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Europe/Kiev"));
        ZonedDateTime nextRun = now.withHour(11).withMinute(45).withSecond(0);
        rootLogger.debug("Next run of executor" + nextRun);
        if(now.compareTo(nextRun) > 0){
            nextRun = nextRun.plusDays(1);
            System.out.println("nextRun"+nextRun);
        }
        Duration duration = Duration.between(now, nextRun);
        System.out.println("duration"+duration);
        long initalDelay = duration.getSeconds();
        System.out.println("initalDelay"+initalDelay);
        try{
            Runnable task = () -> command.invokeDAO(LocalDate.now().toString());
            executor.scheduleAtFixedRate(task,initalDelay, TimeUnit.DAYS.toSeconds(1), TimeUnit.SECONDS);
            System.out.println("Hope so!");
        } catch (Exception e) {
            rootLogger.warn("Exception occured in threadInvoke()", e);
        }
    }

    public void threadShutdown() {
        executor.shutdownNow();
        rootLogger.debug("Executor of daily email sender successfully shutdown" + executor.isShutdown());
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            rootLogger.warn(ScheduledExecutor.class.getName(), e);
        }
    }
}
