package net.himavat.koma.restmock;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Main class for starting the mock server.
 * @author koma
 */
public class Starter {

    /**
     * Starts the Jetty server with deployed servlet.
     * @param args A directory containing JSON files can be passed as an argument
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.setAttribute(RestServlet.PARAM_JSON_FOLDER, args.length > 0 ? args[0] : System.getProperty("user.dir"));
        server.setHandler(context);

        context.addServlet(new ServletHolder(new RestServlet()),"/*");

        server.start();
        server.join();
    }
}
