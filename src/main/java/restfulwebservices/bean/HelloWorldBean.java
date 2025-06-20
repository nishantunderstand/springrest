package restfulwebservices.bean;

public class HelloWorldBean {
	
	private String message;

	public HelloWorldBean(String message) {
		System.out.println("This is helping in Printing in Console");
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

	
	
}
