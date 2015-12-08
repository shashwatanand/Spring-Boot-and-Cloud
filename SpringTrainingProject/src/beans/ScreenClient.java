package beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScreenClient {
	public static void main(String[] args) {
		/*ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans/screens.xml");*/
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ScreenFactory.class);
		
		WelcomeScreen screen = (WelcomeScreen)ctx.getBean("simpleScreen");
		screen.showScreen("Shashwat");
		
		/*WelcomeScreen screen1 = (WelcomeScreen)ctx.getBean("newScreen");
		screen1.showScreen("Shashwat");*/
		
		//ctx.refresh();
		
		ctx.destroy();
	}
}
