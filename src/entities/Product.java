package entities;

public class Product {
	
	private String name;
	private Double price;
	private Integer quantity;
	private Double total;
	
	public Product() {
	}

	public Product(String name, Double price, Integer quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.total = totalValue(price, quantity);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double totalValue(Double price, int quantity) {
		return quantity * price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n|---------------------------------------------------------------|\n");
		builder.append("PRODUTO:	");
		builder.append(name);
		builder.append("\nPreço: ");
		builder.append(" 	R$");
		builder.append(String.format("%.2f", price));
		builder.append("\nQuantidade:     ");
		builder.append(quantity + " unidades\n");
		builder.append("Subtotal:");
		builder.append("       R$");
		builder.append(String.format("%.2f", total));
		return builder.toString();
	}
	
}
