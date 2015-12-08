package database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductClient {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				//"database/jdbc.xml");
				"database/hibernate.xml");
		DataAccessObject<Product> pDAO =
				(DataAccessObject<Product>) ctx.getBean("productDAO");
		
		pDAO.add(new Product(1224,"New Product",34343));
		
		System.out.println(pDAO.find(1222));
		
		for(Product p:pDAO.list()){
			System.out.println(p);
		}
	
	}
}







