package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ProductJDBCDAO implements DataAccessObject<Product> {
	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Product add(Product e) {
		getTemplate().update("insert into Spring_Products values(?,?,?)"
				, e.getProductId(), e.getName(), e.getUnitPrice());
		return e;
	}

	@Override
	public List<Product> list() {
		return getTemplate().query("select * from Spring_Products", new ProductMapper());
	}

	@Override
	public Product find(int key) {
		return getTemplate().queryForObject("select * from Spring_Products where productId=?", 
				new ProductMapper(), key);
	}
	
	static class ProductMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int index) throws SQLException {
			return new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3));
		}
		
	}

}
