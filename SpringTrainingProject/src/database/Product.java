package database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Spring_Products")
public class Product {
	private int productId;
	private String name;
	private double unitPrice;

	public Product() {
	}

	public Product(int productId, String name, double unitPrice) {
		super();
		this.productId = productId;
		this.name = name;
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name
				+ ", unitPrice=" + unitPrice + "]";
	}

	@Id
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
}
