package at.arz.ed210.architecture.biselect;

public class MyService {

	public static void main(String[] args) {
		System.out.println("green, green, broken, green");
		throw new RuntimeException("broken");
	}
}
