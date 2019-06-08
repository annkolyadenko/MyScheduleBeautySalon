package ua.salon.schedule.command.jsp_pages;
/**
* Interface with String constants that provide path to JSP pages;
*/
public interface PagesJSP {
    String MAIN_PAGE = "index.jsp";
    String SIGN_UP_PAGE = "/jsp/registration.jsp";
    String SIGN_IN_PAGE = "/jsp/common/login.jsp";
    String LOG_OUT_PAGE = "/jsp/common/firewell.jsp";
    String FEEDBACK_PAGE = "/jsp/feedback/feedback.jsp";
    String FEEDBACK_APPROVED = "/jsp/feedback/feedbackApproved.jsp";
    String FEEDBACK_NOT_APPROVED = "/jsp/feedback/feedbackNotApproved.jsp";
    String CLIENT_PAGE = "/jsp/authorized/client/clientPage.jsp";
    String ADMIN_PAGE = "/jsp/authorized/administrator/adminPage.jsp";
    String MASTER_PAGE = "/jsp/authorized/master/masterPage.jsp";
    String BOOKING_LIST = "/jsp/common/bookingList.jsp";
    String BOOKING_PAGE = "/jsp/common/booking.jsp";
    String BOOKING_APPROVED = "/jsp/common/bookingApproved.jsp";
    String ACCESS_DENIED = "/jsp/error-403.jsp";
    String COMMENT_LIST = "/jsp/authorized/admin/commentList.jsp";
    String PRICE_LIST = "/jsp/priceList.jsp";
    String SHIT_HAPPENS = "/jsp/common/shitHappens.jsp";
}
