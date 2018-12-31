package module6;

import org.testng.annotations.Test;

public class Prioritizing {

	@Test(priority = 0)
	public void Shifali() {
		System.out.println("This is the Test Case 1");
	}

	@Test(priority = 1)
	public void Nimy() {
		System.out.println("This is the Test Case 2");
	}

	@Test(priority = 2, dependsOnMethods = "Anu")
	public void Rosy() {
		System.out.println("This is the Test Case 3");
	}

	@Test(priority = 3, enabled = false)
	public void Carmely() {
		System.out.println("This is the Test Case 4");
	}
	
	@Test(priority = 4)
	public void Anu() {
		System.out.println("This is the Test Case 5");
	}
}
