package database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductClient {
	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("database/hibernate.xml");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("database/jdbc.xml");
		
		DataAccessObject<Product>  dao = (DataAccessObject<Product>) ctx.getBean("productDAO");
		
		dao.add(new Product(3, "P3", 1620));
		
		for (Product product : dao.list()) {
			System.out.println(product.toString());
		}
	}
}
