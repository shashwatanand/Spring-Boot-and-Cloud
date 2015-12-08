package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import database.DataAccessObject;
import database.Product;

@Controller
public class ProductController {
	
	/*private static List<Product> products = new ArrayList<Product>();
	
	static {
		for (int i = 1; i <= 5; i++) {
			products.add(new Product(i, "Product" + i, i * 100));
		}
	}*/
	
	private DataAccessObject<Product>  productDAO;
	
	public DataAccessObject<Product> getProductDAO() {
		return productDAO;
	}

	@Autowired
	public void setProductDAO(DataAccessObject<Product> productDAO) {
		this.productDAO = productDAO;
	}

	@RequestMapping("/products/list.action")
	public String list(Model model) {
		/*model.addAttribute("message", products.size() + " Products Found!!!!");
		model.addAttribute("products", products);
		return "productList";*/
		
		List<Product> products = getProductDAO().list();
		model.addAttribute("message", products.size() + " Products Found!!!!");
		model.addAttribute("products", products);
		return "productList";
	}
	
	@RequestMapping("products/showForm.action")
	public String showForm(Model model) {
		model.addAttribute("pForm", new Product(-1, "UNKONWN", 0.0));
		return "productForm";
	}
	
	@RequestMapping(value="/products/register.action", method=RequestMethod.POST)
	public String register(Product newProduct, Model model) {
		//products.add(newProduct);
		
		getProductDAO().add(newProduct);
		return list(model);
	}
	
	@RequestMapping(value="/products/delete.action")
	public String delete(@RequestParam int pid, Model model) {
		System.out.println("Deleting Product " + pid);
		getProductDAO().delete(pid);
		return list(model);
	}
}
