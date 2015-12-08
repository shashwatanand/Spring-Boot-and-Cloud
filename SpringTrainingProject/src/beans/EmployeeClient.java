package beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeClient {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans/employees.xml");
		
		System.out.println(ctx.getBean("defaultEmployee"));
		System.out.println(ctx.getBean("defaultDeveloper"));
	}
}
