package no.miles;

import static no.miles.dom.Product.aProduct;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Collections;

import no.miles.dom.Product;
import no.miles.service.ProductQueryService;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.spi.container.TestContainerException;

@Ignore("no?")
public class CanIMockDependenciesThroughJersey extends JerseyTest {

	@Mock
	private ProductQueryService productQueryService;

	public CanIMockDependenciesThroughJersey() throws TestContainerException {
		super("no.miles");
	}

	@Before
	public void setUpMocks() {
		initMocks(this);
		when(productQueryService.list()).thenReturn(Collections.singletonList(defaultProduct()));
	}

	@Test
	public void whenICallListIShouldGetTheMockedQueryResult() throws Exception {
		WebResource webResource = resource();
		String responseMsg = webResource.path("product").get(String.class);
		assertThat(
				responseMsg,
				is(equalTo("<product id='testID'><name>testName</name><description>testDescription</description><price>15.5</price></product></productList>")));
	}

	private Product defaultProduct() {
		return aProduct()
				.withId("testID")
				.withName("testName")
				.withItemPrice(15.5)
				.withDescription("testDescription")
				.build();
	}
}
