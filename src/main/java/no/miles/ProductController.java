package no.miles;

import java.util.List;

import no.miles.dom.Product;
import no.miles.service.ProductQueryService;

import org.apache.log4j.Logger;

import com.sun.jersey.spi.inject.Inject;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;

@RolesAllowed({ "guest", "user", "admin" })
@Path("/product")
public class ProductController {

	private static final Logger LOG = Logger.getLogger(ProductController.class);

	@Inject
	private ProductQueryService productQueryService;

	@GET
	@Produces("text/xml")
	public String listProducts() {
		LOG.trace("serving list of products");

		StringBuilder stringBuilder = new StringBuilder("<productList>");

		List<Product> products = productQueryService.list();

		for (Product p : products) {
			stringBuilder = p.productToXML();
		}

		return stringBuilder.append("</productList>").toString();
	}


	@POST
	@RolesAllowed("user")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("text/xml")
	public String purchaseProduct(@FormParam("id") Integer id) {
		LOG.trace("registering purchase of product#" + id);

		return "<em>purchase later</em>";
	}

	@PUT
	@RolesAllowed("admin")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("text/xml")
	public String addProduct(@FormParam("name") String name,
			@FormParam("description") String description) {
		LOG.trace("adding product " + name + ": '" + description + "'");

		return "<p>there will be no administrative work today</p>";
	}

	@DELETE
	@RolesAllowed("admin")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("text/xml")
	public String deleteProduct(@FormParam("id") Integer id) {
		LOG.trace("removing product#" + id);

		return "<p>not implemented</p>";
	}

	public void setProductQueryService(ProductQueryService productQueryService) {
		this.productQueryService = productQueryService;
	}

}