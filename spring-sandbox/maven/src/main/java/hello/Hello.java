
package main.java.hello;

import org.joda.time.LocalTime;

public class Hello {
	public static void main(String[] args) {

		final LocalTime currentTime = new LocalTime();
		System.out.println("Current local time is:" + currentTime);

		final Greeter greeter = new Greeter();
		System.out.println(greeter.sayHello());
	}
}