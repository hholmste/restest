package no.miles;

import no.miles.ProductController;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpHost;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpParamsFactory;

import java.io.IOException;

public class CanIAccessProductServices {

    private ProductController productController;

    public CanIAccessProductServices() {
        productController = new ProductController();
    }

    public int listProducts() throws IOException {
        HttpClient client = new HttpClient();
        return client.executeMethod(new GetMethod("http://localhost:8080/restest/product"));
    }

}
