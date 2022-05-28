package application.servlet.webcommand.impl;

import application.service.UserService;
import application.servlet.webcommand.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * Author Dmitriy
 */

public class GetUserByIdCommand implements Command {

    private UserService userService;

    public GetUserByIdCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        return null;
    }

}
