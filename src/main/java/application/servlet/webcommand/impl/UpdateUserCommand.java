package application.servlet.webcommand.impl;

import application.builder.userbuilder.AbstractUserBuilder;
import application.builder.userbuilder.HttpUserBuilder;
import application.entity.User;
import application.service.UserService;
import application.servlet.attributes.GlobalAttributes;
import application.servlet.pages.Pages;
import application.servlet.webcommand.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * Author Alexander
 */

public class UpdateUserCommand implements Command {

    private final UserService userService;

    public UpdateUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        AbstractUserBuilder builder = new HttpUserBuilder(req);
        User user = builder.buildUserWithAllFields();
        userService.updateUser(user);
        req.setAttribute(GlobalAttributes.USER, user);
        return Pages.USER_DETAILS_PAGE;
    }

}