package ua.salon.schedule.tags;

import ua.salon.schedule.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class UserRoleTag extends TagSupport {
    private String role;

    public void setRole(String role) {
        this.role = role;
    }

    public HttpServletRequest getRequest() {
        return (HttpServletRequest) pageContext.getRequest();
    }

    @Override
    public int doStartTag() throws JspException {
        if (getRequest().getSession().getAttribute("authorizedUser") == null) {
            if(role.equals("empty")) {
                return EVAL_BODY_INCLUDE;
            }
        } else {
            if (((User)getRequest().getSession().getAttribute("authorizedUser")).getRole().toString().equalsIgnoreCase(role)) {
                return EVAL_BODY_INCLUDE;
            }
        }
        return SKIP_BODY;
    }
}
