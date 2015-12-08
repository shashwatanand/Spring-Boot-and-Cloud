package beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScreenFactory {
	
	@Bean(name="simpleScreen", initMethod="start")
	@Scope("singleton")
	@Lazy(true)
	public WelcomeScreen getScreen() {
		ConsoleWelcomeScreen scr = new ConsoleWelcomeScreen();
		scr.setMessage("Welcome to Spring Annotations");
		return scr;
	}
}
