package no.miles.dom;

public class Product {

	private final String name;
	private final String description;
	private final String id;
	private final double itemPrice;

	public Product(String name, String description, String id, double itemPrice) {
		this.name = name;
		this.description = description;
		this.id = id;
		this.itemPrice = itemPrice;
	}

	public double totalPrice(int numberOfUnits) {
		if (id.startsWith("X")) {
			return (double) itemPrice * (double) numberOfUnits * 0.97;
		} else {
			return (double) itemPrice * (double) numberOfUnits;
		}
	}

	public Product rename(String newName) {
		return new Product(newName, description, id, itemPrice);
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getId() {
		return id;
	}

	public double getItemPrice() {
		return itemPrice;
	}

}
