package beans;

public class ConsoleWelcomeScreen implements WelcomeScreen {
	private String message;
	
	public ConsoleWelcomeScreen() {
		System.out.println("Screen Created");
	}
	
	public void start() {
		System.out.println("Screen started with Message " + getMessage());
	}
	
	public void stop() {
		System.out.println("Screen stopped with Message " + getMessage());
		setMessage(null);
	}

	@Override
	public void showScreen(String name) {
		System.out.println(message + " : " + name);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		System.out.println("Message Set");
		this.message = message;
	}

}
