package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ProductJDBCDAO implements DataAccessObject<Product>{

	JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Product add(Product e) {
		String insertSQL ="insert into Spring_Products " +
				"(productId,name,unitPrice) values(?,?,?)";
		getTemplate().update(
			insertSQL, e.getProductId(),e.getName(),e.getUnitPrice());
		return e;
	}

	@Override
	public Product find(int id) {
		return getTemplate().queryForObject(
				"select * from SPRING_PRODUCTS where ProductId=?",
				new ProductMapper(), id);
	}

	@Override
	public List<Product> list() {
		return getTemplate().query("select * from SPRING_PRODUCTS", new ProductMapper());
	}

	static class ProductMapper implements RowMapper<Product>{
		@Override
		public Product mapRow(ResultSet rs, int index) throws SQLException {
			System.out.println("Mapping row "+index);
			return new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
		}
	}

	@Override
	public void delete(int id) {
		/*int rows = template.update(deleteSql, params, types);
		
		  System.out.println(rows + " row(s) deleted.");*/

		// TODO
	}
	
	
	
	
	
	
	
}
