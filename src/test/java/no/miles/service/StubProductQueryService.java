package no.miles.service;

import static no.miles.dom.Product.aProduct;

import java.util.Collections;
import java.util.List;

import no.miles.dom.Product;

public class StubProductQueryService implements ProductQueryService {

	@Override
	public List<Product> list() {
		return Collections.singletonList(aProduct()
				.withId("StubId")
				.withName("StubName")
				.withDescription("StubDescription")
				.withItemPrice(111.222)
				.build());
	}

}
