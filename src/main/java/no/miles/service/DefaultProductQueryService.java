package no.miles.service;

import static no.miles.dom.Product.aProduct;

import java.util.Collections;
import java.util.List;

import no.miles.dom.Product;

/**
 * The Stub is for figuring out Jersey and injection.
 */
public class DefaultProductQueryService implements ProductQueryService {

	@Override
	public List<Product> list() {
		return Collections.singletonList(aProduct()
				.withId("DefaultId")
				.withName("DefaultName")
				.withDescription("DefaultDescription")
				.withItemPrice(123.456)
				.build());
	}

}
