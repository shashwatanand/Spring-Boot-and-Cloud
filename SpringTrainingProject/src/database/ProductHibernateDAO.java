package database;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class ProductHibernateDAO implements DataAccessObject<Product> {
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public Product add(Product e) {
		getTemplate().persist(e);
		return e;
	}

	@Override
	public List<Product> list() {
		return getTemplate().find("from Product");
	}

	@Override
	public Product find(int key) {
		return getTemplate().get(Product.class, key);
	}
}
