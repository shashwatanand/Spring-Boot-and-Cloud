package database;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class ProductHibernateDAO implements DataAccessObject<Product>{
	HibernateTemplate template;
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public Product add(Product e) {
		template.persist(e);
		return e;
	}

	@Override
	public Product find(int id) {
		return template.get(Product.class,id);
	}

	@Override
	public List<Product> list() {
		return template.find("from Product");
	}

	@Override
	public void delete(int id) {
		getTemplate().delete(find(id));
	}
}
