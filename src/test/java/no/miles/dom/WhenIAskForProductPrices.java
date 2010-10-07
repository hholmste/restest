package no.miles.dom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class WhenIAskForProductPrices {

	@DataPoints
	public static int[] numberOfItems = { 1, 2, 3, 4, 5 };

	@DataPoints
	public static String[] ids = { "X14", "X13", "DS150" };

	@Theory
	public void iShouldGetADiscountOnXProducts(int numberOfItems, String id) {
		Product product = new Product("name", "description", id, 50);

		if (id.startsWith("X")) {
			assertTrue(numberOfItems * 50
					+ " is not larger than "
					+ product.totalPrice(numberOfItems)
					+ " for product "
					+ id, numberOfItems * 50 > product.totalPrice(numberOfItems));
		}
	}

	@Theory
	public void iShouldNotGetADiscountOnDSProducts(int numberOfItems, String id) {
		Product product = new Product("name", "description", id, 50);
		if (id.startsWith("DS")) {
			assertEquals(numberOfItems * 50, product.totalPrice(numberOfItems), 0);
		}
	}
}
