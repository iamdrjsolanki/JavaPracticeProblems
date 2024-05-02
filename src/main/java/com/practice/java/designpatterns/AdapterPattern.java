package com.practice.java.designpatterns;

interface WebDriver {
	void getElement();
	void selectElement();
}

class ChromeDriver implements WebDriver {
	
	@Override
	public void getElement() {
		System.out.println("Get");
	}

	@Override
	public void selectElement() {
		System.out.println("Select");
	}
	
}


//Another Driver with same functionality but different implementation
class IEDriver {
	
	public void findElement() {
		System.out.println("Find");
	}

	public void clickElement() {
		System.out.println("Click");
	}
	
}

//Adapter class to access the IEDriver with same functionality but different implementation
class WebDriverAdapter implements WebDriver {
	
	IEDriver ieDriver;
	
	WebDriverAdapter(IEDriver ieDriver) {
		this.ieDriver = ieDriver;
	}
	
	@Override
	public void getElement() {
		this.ieDriver.findElement();
	}

	@Override
	public void selectElement() {
		this.ieDriver.clickElement();
	}
	
}


public class AdapterPattern {

	public static void main(String[] args) {
		
		ChromeDriver c = new ChromeDriver();
		c.getElement();
		c.selectElement();
		
		IEDriver i = new IEDriver();
		i.findElement();
		i.clickElement();
		
		WebDriver cwd = new ChromeDriver();
		cwd.getElement();
		cwd.selectElement();
		
		WebDriver iewd = new WebDriverAdapter(i);
		iewd.getElement();
		iewd.selectElement();
		
	}

}
