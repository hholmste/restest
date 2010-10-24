package no.miles;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;

import com.sun.jersey.spi.spring.container.servlet.SpringServlet;

/**
 * The JettyEmbedder will run an embedded Jetty server, loading the default
 * Spring context. I have yet to find a way to inject mock dependencies into the
 * Jersey resource classes.
 * 
 */
public class JettyEmbedder {

	private final Server server;

	private final String contextPath;

	public JettyEmbedder() {
		this.contextPath = "classpath:application.xml";
		this.server = setUpServer();
	}

	public JettyEmbedder(String contextPath) {
		this.contextPath = contextPath;
		this.server = setUpServer();
	}

	private Server setUpServer() {
		Server localServer = new Server(8080);

		Context root = new Context(localServer, "/restest");

		addServlet(root);

		addSpringContext(root);

		return localServer;
	}

	private void addServlet(Context root) {
		ServletHolder servletHolder = new ServletHolder(SpringServlet.class);
		servletHolder.setInitParameter("com.sun.jersey.config.property.packages", "no.miles");
		root.addServlet(servletHolder, "/*");
	}

	@SuppressWarnings("unchecked")
	private void addSpringContext(Context root) {
		// root.getInitParams().put("contextConfigLocation",
		// "classpath:application.xml");
		root.getInitParams().put("contextConfigLocation", contextPath);
		ContextLoaderListener listener = new ContextLoaderListener();
		root.addEventListener(listener);
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
