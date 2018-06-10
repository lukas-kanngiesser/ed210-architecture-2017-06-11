package at.arz.ed210.architecture;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class MyService {

	@EJB
	private OtherService otherService;

	public String sayHello() {
		return otherService.sayHelloTo("arquillian");
	}
}
