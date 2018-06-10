package at.arz.ed210.architecture.mutation;

public class ExampleService {

	public int doStuff(int a, int b, int c, int d, boolean flag) {

		// Conditionals Boundary Mutator
		if (a < b) {
			// do something
			System.out.println("hello!");
		}

		// Negate Conditionals Mutator
		if (a == b) {
			// do something
			System.out.println("hello!");
		}

		// Math Mutator
		a = b + c;

		// Void Method Calls Mutator
		someVoidMethod(method(d));

		if ("A".equals(foo(flag))) {
			System.out.println("hello!");
		}

		// Return Values Mutator
		return negate(123);
	}

	// Increments Mutator
	public int method(int i) {
		i++;
		return i;
	}

	// Invert Negatives Mutator
	public int negate(final int i) {
		return -i;
	}

	// Return Values Mutator
	public String foo(boolean flag) {
		return flag ? "A" : "B";
	}

	// Void Method Calls Mutator
	public void someVoidMethod(int i) {
		System.out.println("hello!");
	}

}
