package ua.salon.schedule.command.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.command.*;

/**
 * Enum that contains enumeration of all commands used in application
 */
public enum CommandEnum {

    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    RETURN {
        {
            this.command = new ReturnToHomePageCommand();
        }
    },
    GET_ALL_MASTERS {
        {
            this.command = new GetAllMastersCommand();
        }
    },
    APPROVE_BOOKING {
        {
            this.command = new BookingApprovalCommand();
        }
    },
    ADD_BOOKING {
        {
            this.command = new AddBookingCommand();
        }
    },
    GET_BOOKINGS_BY_MASTER_AND_DATE {
        {
            this.command = new DisplayBookingsByMasterAndDateCommand();
        }
    }
    ;

    private static final Logger rootlogger = LogManager.getRootLogger();

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        rootlogger.debug("Current command was defined: " + command.toString());
        return command;
    }
}
