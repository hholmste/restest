package no.miles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CanIStubDependenciesThroughJersey {

	private static JettyEmbedder jetty;

	@BeforeClass
	public static void setUp() {
		jetty = new JettyEmbedder("classpath:stub.xml");
		assertThat(jetty.start(), is(true));
	}

	@AfterClass
	public static void tearDown() {
		assertThat(jetty.stop(), is(true));
	}

	@Test
	public void whenICallListIShouldGetTheStubbedQueryResult() throws Exception {
		GetMethod method = new GetMethod("http://localhost:8080/restest/product");
		new HttpClient().executeMethod(method);

		String responseBody = method.getResponseBodyAsString();
		assertThat(
				responseBody,
				is(equalTo("<product id='StubId'><name>StubName</name><description>StubDescription</description><price>111.222</price></product></productList>")));
	}

}
