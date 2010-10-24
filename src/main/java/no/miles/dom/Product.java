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

	public StringBuilder productToXML() {
		return new StringBuilder("<product id='").append(id).append("'><name>")
				.append(name).append("</name><description>")
				.append(description).append("</description><price>")
				.append(itemPrice).append("</price></product>");
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

	public static Builder aProduct() {
		return new Builder();
	}
	
	public static class Builder {
		private String name;
		private String description;
		private String id;
		private double itemPrice;
		
		public Builder withName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder withDescription(String description) {
			this.description = description;
			return this;
		}
		
		public Builder withId(String id) {
			this.id = id;
			return this;
		}
		
		public Builder withItemPrice(double itemPrice) {
			this.itemPrice = itemPrice;
			return this;
		}
		
		public Product build() {
			return new Product(name, description, id, itemPrice);
		}
	}
	
}
