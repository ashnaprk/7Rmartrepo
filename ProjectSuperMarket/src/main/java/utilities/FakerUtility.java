package utilities;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class FakerUtility {
	Faker faker = new Faker(); //globally declared
	public String getFakeFirstName() {

		
		Address address = faker.address();
		String text = address.firstName();
		return text;

	}

	public String getPassword() {

		Address address = faker.address();
		String text = address.lastName();
		return text;
	}
	
	public String getMailId()
	{
		return faker.internet().emailAddress();
	
	}

}
