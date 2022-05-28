package application.context;

import application.context.impl.PostgresApplicationContextImpl;
import application.db.DbConnectionProvider;
import application.db.postgres.PostgresDbConnectionProviderImpl;
import application.servlet.attributes.GlobalAttributes;
import application.servlet.webcommand.CommandContainer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        //TODO Establish db connection
        DbConnectionProvider dbConnectionProvider = new PostgresDbConnectionProviderImpl();
        Connection con = dbConnectionProvider.getConnection();

        ApplicationContext applicationContext = new PostgresApplicationContextImpl(dbConnectionProvider);
        CommandContainer commandContainer = new CommandContainer(applicationContext);
        ctx.setAttribute(GlobalAttributes.DB_CONNECTION, con);
        ctx.setAttribute(GlobalAttributes.COMMAND_CONTAINER, commandContainer);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        Connection con = (Connection) ctx.getAttribute(GlobalAttributes.DB_CONNECTION);

        //TODO Close DB connection

    }

}