package no.miles;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

import com.sun.jersey.spi.container.servlet.ServletContainer;

public class JettyEmbedder {

	private final Server server;

	public JettyEmbedder() {
		server = setUpServer();
	}

	private Server setUpServer() {
		Server localServer = new Server(8080);

		Context root = new Context(localServer, "/restest");

		ServletHolder servletHolder = new ServletHolder(ServletContainer.class);

		servletHolder.setInitParameter(
				"com.sun.jersey.config.property.packages", "no.miles");

		root.addServlet(servletHolder, "/*");

		return localServer;
	}

	public boolean start() {
		try {
			server.start();
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	public boolean stop() {
		try {
			server.stop();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean isRunning() {
		return server.isRunning();
	}

}
