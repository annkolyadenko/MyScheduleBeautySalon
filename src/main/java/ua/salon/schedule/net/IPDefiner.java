package ua.salon.schedule.net;

import com.sun.istack.internal.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDefiner {
    private static final Logger rootLogger = LogManager.getRootLogger();
    @Nullable
    public static String defineIP() {
        InetAddress currentIP = null;
        try {
            currentIP = InetAddress.getLocalHost();
            rootLogger.debug("currentIP was defined");

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return currentIP.getHostAddress();
    }
}
