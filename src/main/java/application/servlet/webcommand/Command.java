package application.servlet.webcommand;

import javax.servlet.http.HttpServletRequest;

public interface Command {

    String execute(HttpServletRequest req);

}
