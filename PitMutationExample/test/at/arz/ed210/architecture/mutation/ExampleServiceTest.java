package at.arz.ed210.architecture.mutation;

import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class ExampleServiceTest {

	private ExampleService cut;

	@Before
	public void setup() {
		cut = new ExampleService();
	}

	@Test
	public void should_working() {

		int result = cut.doStuff(1, 2, 3, 4, true);

		assertThat(result, is(-123));
	}

	@Test
	public void should_also_working() {

		int result = cut.doStuff(1, 1, 3, 4, false);

		assertThat(result, is(-123));
	}
}
