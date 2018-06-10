package at.arz.ed210.architecture;

import java.text.MessageFormat;

import javax.ejb.Stateless;

@Stateless
public class OtherService {

	public String sayHelloTo(String name) {
		return MessageFormat.format("Hello {0}!", name);
	}

}
