package no.miles.dom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class WhenIRenameAProduct {

	private final Product product = new Product("aName", "aDescription", "anId", 11.11);

	@DataPoints
	public static String[] newNames = { "aNewName", "A different name" };

	@Theory
	public void iShouldGetANewProductInstance(String newName) {
		Product sameProduct = product.rename(newName);

		assertThat(sameProduct, not(equalTo(product)));
	}

	@Theory
	public void theNewInstanceShouldHaveTheNewName(String newName) {
		Product sameProduct = product.rename(newName);

		assertThat(newName, equalTo(sameProduct.getName()));
	}

	@Theory
	public void allOtherFieldsShouldStayTheSame(String newName) {
		Product sameProduct = product.rename(newName);

		assertThat(sameProduct.getDescription(), equalTo(product.getDescription()));
		assertThat(sameProduct.getId(), equalTo(product.getId()));
		assertThat(sameProduct.getItemPrice(), equalTo(product.getItemPrice()));
	}
}
