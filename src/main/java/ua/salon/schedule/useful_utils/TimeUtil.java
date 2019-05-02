package ua.salon.schedule.useful_utils;

public class TimeUtil {
    private static final int timeGap = 1;

    public static String addTimeGap(String timeStart){
        String [] split = timeStart.split(":");
        Integer time = Integer.parseInt(split[0])+timeGap;
        String timeEnd = null;
        if(time.toString().length()==1){
            timeEnd = 0 + time.toString() + ":" + split[1];
        } else {
            timeEnd = time.toString() + ":" + split[1];
        }
        return timeEnd;
    }
}
