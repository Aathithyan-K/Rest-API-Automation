package week3day1;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class JavaFaker {

	@Test
	public void fakerGenerator() {
		Faker fakeValue = new Faker();
		
		String fname ="";
		String lname ="";
		String email ="";
		
		for(int i = 0; i<50; i++) {
			fname = fakeValue.name().firstName();
			lname = fakeValue.name().lastName();
			email = fakeValue.internet().emailAddress();
			System.out.println(i+1+ " " +fname+ " " +lname+ " " +email);
		}
	}
}
