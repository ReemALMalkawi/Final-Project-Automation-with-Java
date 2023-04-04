import static org.testng.Assert.assertEquals;

import java.awt.geom.Arc2D.Double;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MainClass extends Parameters{

	@Test(priority=1)
	public void Register() {
		
		//Click on create an account
		WebElement SignUp = driver.findElement(By.xpath("//header[@class='page-header']//li[3]//a[1]"));
		Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",SignUp);
		SignUp.click();
		
		//fill information
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement FirstName = driver.findElement(By.xpath("//input[@title='First Name']"));
		Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",FirstName);
		FirstName.sendKeys("Reem");
		
		
		WebElement LastName = driver.findElement(By.xpath("//input[@title='Last Name']"));
		Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",LastName);
		LastName.sendKeys("Malkawi");
		
		WebElement Email = driver.findElement(By.xpath("//input[@title='Email']"));
		Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",Email);
		Email.sendKeys("rmalkawi147@gmail.com");
		
		WebElement Password = driver.findElement(By.xpath("//input[@title='Password']"));
		Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",Password);
		Password.sendKeys("Reem2321999*");
		
		WebElement ConfirmPassword = driver.findElement(By.xpath("//input[@title='Confirm Password']"));
		Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",ConfirmPassword);
		ConfirmPassword.sendKeys("Reem2321999*");
		
		//Click create an Account Button
		WebElement CreateAnAccountbtn = driver.findElement(By.xpath("//button[@title='Create an Account']"));
		Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",CreateAnAccountbtn);
		CreateAnAccountbtn.click();
		
		//Test if create an account successfully
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String TextCheckActual = driver.findElement(By.xpath("//span[@class='base']")).getText();
		System.out.println(TextCheckActual);
		String TextCheckExpected = "My Account";
		myAssert.assertEquals(TextCheckActual, TextCheckExpected);
		myAssert.assertAll();
	}
    
	@Test(priority=2,invocationCount=5)
	public void SearchRandomly () {
		
		//select one item
		String [] TypeofSearch = {"Jacket","t-shirt","jeans for men","jeans for women","pants"};
		int RandomType = Rand.nextInt(TypeofSearch.length);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement SearchElement = driver.findElement(By.xpath("//input[@placeholder='Search entire store here...']"));
		Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",SearchElement);
		SearchElement.sendKeys(TypeofSearch[RandomType]+Keys.ENTER);
		
		String SearchResultActual = driver.findElement(By.xpath("//span[@class='base']")).getText();
		System.out.println(SearchResultActual);
		
		//Test if an item is found and displayed
		boolean ContainsValue = SearchResultActual.contains(TypeofSearch[RandomType]);
		myAssert.assertEquals(ContainsValue, true);
		myAssert.assertAll();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.navigate().back();
	}

    @Test(priority=3)
    public void AddItemsInExactQuantities_RandomcolorAndSize() throws InterruptedException
    {
    	//login
    	WebElement SignIn = driver.findElement(By.xpath("//div[@class='panel header']//li[@data-label='or']//a"));
    	Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",SignIn);
    	SignIn.click();
    	
    	//fill info signIn
    	WebElement Email = driver.findElement(By.xpath("//input[@title='Email']"));
    	Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",Email);
    	Email.sendKeys("rmalkawi147@gmail.com");
    	
    	WebElement Password = driver.findElement(By.xpath("//input[@title='Password']"));
    	Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",Password);
    	Password.sendKeys("Reem2321999*");
    	
    	WebElement SignInbtn = driver.findElement(By.xpath("//button[@class='action login primary']"));
    	Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",SignInbtn);
    	SignInbtn.click();
    	
    	driver.navigate().back();
    	driver.get("https://magento.softwaretestingboard.com/");
    	
    	//choose first item
    	WebElement  Radiant_tee_Item = driver.findElement(By.xpath("//main[@class='page-main']//li[1]"));
		Radiant_tee_Item.click();
		
		//input Quantity item
		driver.findElement(By.xpath("//input[@title='Qty']")).clear();
		WebElement Radiant_tee_Item_Quantity = driver.findElement(By.xpath("//input[@title='Qty']"));
		Radiant_tee_Item_Quantity.sendKeys("3");
		
		WebElement SizeDiv = driver.findElement(By.xpath("//div[@class='swatch-attribute size']//div[@role='listbox']"));
    	List<WebElement> Size = SizeDiv.findElements(By.tagName("div"));
    	
    	WebElement ColorDiv = driver.findElement(By.xpath("//div[@class='swatch-attribute color']//div[@role='listbox']"));
    	List<WebElement> Color = ColorDiv.findElements(By.tagName("div"));
    	
		//Choose size Randomly
		int RandomSize= Rand.nextInt(Size.size());
		Size.get(RandomSize).click();
		
		//choose color Randomly
		RandomSize= Rand.nextInt(Color.size());
		Color.get(RandomSize).click();
		Thread.sleep(4);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//Add to cart
		WebElement AddToCartbtn = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
    	Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",AddToCartbtn);
    	AddToCartbtn.click();
    	Thread.sleep(3);
    	
		//Back to home page
		driver.navigate().back();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//choose second item
    	WebElement  breathe_easy_tank_Item = driver.findElement(By.xpath("//body/div[@class='page-wrapper']/main[@class='page-main']/div[@class='columns']/div[@class='column main']/div[@class='widget block block-static-block']/div[@class='block widget block-products-list grid']/div[@class='block-content']/div[@class='products-grid grid']/ol[@class='product-items widget-product-grid']/li[2]/div[1]"));
		breathe_easy_tank_Item.click();
		
		//input Quantity item
		driver.findElement(By.xpath("//input[@title='Qty']")).clear();
		WebElement breathe_easy_tank_Item_Quantity = driver.findElement(By.xpath("//input[@title='Qty']"));
		breathe_easy_tank_Item_Quantity.sendKeys("2");
		
		WebElement SizeDiv1 = driver.findElement(By.xpath("//div[@class='swatch-attribute size']//div[@role='listbox']"));
    	List <WebElement>Size1 = SizeDiv1.findElements(By.tagName("div"));
    	
    	WebElement ColorDiv1 = driver.findElement(By.xpath("//div[@class='swatch-attribute color']//div[@role='listbox']"));
    	List <WebElement> Color1 = ColorDiv1.findElements(By.tagName("div"));
		
		//Choose size Randomly
		RandomSize= Rand.nextInt(Size1.size());
		Size1.get(RandomSize).click();
				
		//choose color Randomly
		RandomSize= Rand.nextInt(Color1.size());
		Color1.get(RandomSize).click();
		Thread.sleep(2);		
		//Add to cart
		WebElement AddToCartbtn1 = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",AddToCartbtn1);
		AddToCartbtn1.click();
		Thread.sleep(3);
		
		//Back to home page
	    driver.navigate().back();
	    
		//choose Third item
    	WebElement  argus_all_weather_tank_Item = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[3]/div"));
		argus_all_weather_tank_Item.click();
		
		//input Quantity item
		driver.findElement(By.xpath("//input[@title='Qty']")).clear();
		WebElement argus_all_weather_tank_Item_Quantity = driver.findElement(By.xpath("//input[@title='Qty']"));
		argus_all_weather_tank_Item_Quantity.sendKeys("4");
		
		WebElement SizeDiv2 = driver.findElement(By.xpath("//div[@class='swatch-attribute size']//div[@role='listbox']"));
    	List <WebElement>Size2 = SizeDiv2.findElements(By.tagName("div"));
    	
    	WebElement ColorDiv2 = driver.findElement(By.xpath("//div[@class='swatch-attribute color']//div[@role='listbox']"));
    	List <WebElement> Color2 = ColorDiv2.findElements(By.tagName("div"));
		
		//Choose size Randomly
		RandomSize= Rand.nextInt(Size2.size());
		Size2.get(RandomSize).click();
				
		//choose color Randomly
		RandomSize= Rand.nextInt(Color2.size());
		Color2.get(RandomSize).click();
		Thread.sleep(2);		
		//Add to cart
		WebElement AddToCartbtn2 = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",AddToCartbtn2);
		AddToCartbtn2.click();
		Thread.sleep(3);
		
		//Back to home page
	    driver.navigate().back();
		
		//choose fourth item
    	WebElement  hero_hoodie_Item = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[4]/div"));		
		hero_hoodie_Item.click();
		
		//input Quantity item
		driver.findElement(By.xpath("//input[@title='Qty']")).clear();
		WebElement hero_hoodie_Item_Quantity = driver.findElement(By.xpath("//input[@title='Qty']"));
		hero_hoodie_Item_Quantity.sendKeys("1");
		
		WebElement SizeDiv3 = driver.findElement(By.xpath("//div[@class='swatch-attribute size']//div[@role='listbox']"));
    	List <WebElement>Size3 = SizeDiv3.findElements(By.tagName("div"));
    	
    	WebElement ColorDiv3 = driver.findElement(By.xpath("//div[@class='swatch-attribute color']//div[@role='listbox']"));
    	List <WebElement> Color3 = ColorDiv3.findElements(By.tagName("div"));
		
		//Choose size Randomly
		RandomSize= Rand.nextInt(Size3.size());
		Size3.get(RandomSize).click();
				
		//choose color Randomly
		RandomSize= Rand.nextInt(Color3.size());
		Color3.get(RandomSize).click();
		Thread.sleep(2);		
		//Add to cart
		WebElement AddToCartbtn3 = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",AddToCartbtn3);
		AddToCartbtn3.click();
		Thread.sleep(3);
		
		//Back to home page
	    driver.navigate().back();
		
		//choose fifth item
    	WebElement  fusion_backpack_Item = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[5]/div"));
		fusion_backpack_Item.click();
		
		//Read Quantity item
		driver.findElement(By.xpath("//input[@title='Qty']")).clear();
		WebElement fusion_backpack_Item_Quantity = driver.findElement(By.xpath("//input[@title='Qty']"));
		fusion_backpack_Item_Quantity.sendKeys("5");		
		Thread.sleep(2);
		
		//Add to cart
		WebElement AddToCartbtn4 = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",AddToCartbtn4);
		AddToCartbtn4.click();
		Thread.sleep(3000);
		
		//Back to home page
	    driver.navigate().back();
	    
    	
	    //Test if items are added
	    //open the cart
	    driver.navigate().refresh();
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    WebElement Cart = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a"));
	    Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",Cart);
	    Cart.click();
	    Thread.sleep(3000);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    String ResultActual = driver.findElement(By.xpath("//*[@id=\"mini-cart\"]/li[1]/div/div/strong/a")).getText();
	    String ResultExpected = "Fusion Backpack";
	    myAssert.assertNotEquals(ResultActual, ResultExpected);
	    myAssert.assertAll();
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    String ResultActual1 = driver.findElement(By.xpath("//*[@id=\"mini-cart\"]/li[2]/div/div/strong/a")).getText();
	    String ResultExpected1 = "Hero Hoodie";
	    myAssert.assertNotEquals(ResultActual1, ResultExpected1);
	    myAssert.assertAll();
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    String ResultActual2 = driver.findElement(By.xpath("//*[@id=\"mini-cart\"]/li[3]/div/div/strong/a")).getText();
	    String ResultExpected2 = "Argus All-Weather Tank";
	    myAssert.assertNotEquals(ResultActual2, ResultExpected2);
	    myAssert.assertAll();
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    String ResultActual3 = driver.findElement(By.xpath("//*[@id=\"mini-cart\"]/li[4]/div/div/strong/a")).getText();
	    String ResultExpected3 = "Breathe-Easy Tank";
	    myAssert.assertNotEquals(ResultActual3, ResultExpected3);
	    myAssert.assertAll();
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    String ResultActual4 = driver.findElement(By.xpath("//*[@id=\"mini-cart\"]/li[5]/div/div/strong/a")).getText();
	    String ResultExpected4 = "Radiant Tee";
	    myAssert.assertNotEquals(ResultActual4, ResultExpected4);
	    myAssert.assertAll();
	    
	}
	@Test(priority=4)
	public void CompleteCheckout() throws InterruptedException {
		 
		
		
		 driver.navigate().refresh();
		 //open the cart
		 Thread.sleep(10000);
		 WebElement Cart = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a"));
		 Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",Cart);
		 Cart.click();
		 Thread.sleep(10000);
		 
		 //click proceed to checkout
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		 WebElement Checkoutbtn = driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]"));
		 Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",Checkoutbtn);
		 Checkoutbtn.click();
		 Thread.sleep(10000);
		 
		 //fill info shipping address
		 
		 Thread.sleep(10000);
		 WebElement Country = driver.findElement(By.name("country_id"));
		 Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",Country);
		 Country.sendKeys("Jordan");
		 
		 Thread.sleep(10000);
		 WebElement Street = driver.findElement(By.name("street[0]"));
		 Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",Street);
		 Street.sendKeys("AlnajebSt");
		 
		 Thread.sleep(10000);
		 WebElement City1 = driver.findElement(By.name("city"));
		 Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",City1);
		 City1.sendKeys("Irbid");
		 
		 Thread.sleep(10000);
		 WebElement State = driver.findElement(By.name("region"));
		 Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",State);
		 State.sendKeys("Irbid");
		 
		 Thread.sleep(10000);
		 WebElement PostalCode = driver.findElement(By.name("postcode"));
		 Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",PostalCode);
		 PostalCode.sendKeys("12345-1234");
		 
		 Thread.sleep(10000);
		 WebElement PhoneNumber = driver.findElement(By.name("telephone"));
		 Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",PhoneNumber);
		 PhoneNumber.sendKeys("0123456789");
		 
		 Thread.sleep(10000);
		 WebElement Company = driver.findElement(By.name("company"));
		 Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",Company);
		 Company.sendKeys("IrbidIT");
		 
		 //Next
	     Thread.sleep(10000);
	     WebElement divNext=driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div"));
	   	 List<WebElement> buttonNext=divNext.findElements(By.tagName("button"));
	   	 //Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",buttonNext);
	   	 buttonNext.get(0).click();
	   	 Thread.sleep(10000);
		 
		 //Test if Fill all info
		 Thread.sleep(10000);
		 String TextActual = driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).getText();
		 String TextExpected = "Place Order";
		 myAssert.assertNotEquals(TextActual, TextExpected);
		 myAssert.assertAll();
		 
	}
	@Test(priority=5)
	public void CheckTheFinalPriceIsCorrect() throws InterruptedException {
    	
		 String Price = driver.findElement(By.cssSelector("//strong//span[@class='price']")).getText();
		
		 //remove the $ from the results
		 Price = Price.replace("$","");
		 
		 //convert to float
     	 float ActualResults = Float.parseFloat(Price);
		 float ExpectedResults = (float) 467.00;
		 myAssert.assertEquals(ActualResults, ExpectedResults, ExpectedResults);
		 myAssert.assertAll();
		 driver.findElement(By.xpath("//button[@title='Place Order']")).click();
	}
	
	@Test(priority=6)
	public void reOrderTheSame5Times() throws InterruptedException {
		
		 //sign out
		 driver.navigate().back();
		 Thread.sleep(3);
		 driver.navigate().back();
		 Thread.sleep(3);
		 driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
		 driver.findElement(By.xpath("//div[@aria-hidden='false']//li[@data-label='or']//a")).click();
		 Thread.sleep(3);
		 
		 //SignIn Again
		 //login
	     WebElement SignIn = driver.findElement(By.xpath("//div[@class='panel header']//li[@data-label='or']//a"));
	     Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",SignIn);
	     SignIn.click();
	    	
	     //fill info signIn
	     WebElement Email = driver.findElement(By.xpath("//input[@title='Email']"));
	   	 Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",Email);
	   	 Email.sendKeys("rmalkawi147@gmail.com");
	    	
	     WebElement Password = driver.findElement(By.xpath("//input[@title='Password']"));
	     Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",Password);
	   	 Password.sendKeys("Reem2321999*");
	    	
	     WebElement SignInbtn = driver.findElement(By.xpath("//button[@class='action login primary']"));
	     Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",SignInbtn);
	   	 SignInbtn.click();
	   	 
	   	 for(int i=0;i<5;i++)
	   	 {
	   	   //Reorder
	   	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	   	   WebElement ReOrder = driver.findElement(By.xpath("//a[@class='action order']//span"));
	       Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",ReOrder);
	       ReOrder.click();
	     
	       //Checkout
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	       WebElement Checkout = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button"));
	       Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",Checkout);
	       Checkout.click();
	   	   
	   	 
	       //Next
	       Thread.sleep(10000);
	       WebElement divNext=driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div"));
	   	   List<WebElement> buttonNext=divNext.findElements(By.tagName("button"));
	   	   //Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",buttonNext);
	   	   buttonNext.get(0).click();
	   	   Thread.sleep(10000);
		 
		   //PlaceOrder
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		   WebElement PlaceOrder = driver.findElement(By.xpath("//button[@title='Place Order']"));
		   Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",PlaceOrder);
		   PlaceOrder.click();
		   Thread.sleep(10000);
		 
		   driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
		   driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")).click();
		   Thread.sleep(10000);
		   
	   	 }
		
	   	   WebElement MyOrder = driver.findElement(By.xpath("//div[@class='sidebar sidebar-main']//li[2]//a[1]"));
		   Jse.executeScript("arguments[0].setAttribute('style','background : yellow ; border : 2px solid red');",MyOrder);
		   MyOrder.click();
		   Thread.sleep(10000);
		   
		    //Test if the reorder 5 times
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		    String NumberOfOrders = driver.findElement(By.xpath("//p[@class='toolbar-amount']")).getText();
		    NumberOfOrders = NumberOfOrders.replace("Item(s)", "");
		    NumberOfOrders = NumberOfOrders.replace(" ", "");
		    int NumberOfOrdersActual = Integer.parseInt(NumberOfOrders);
		    int NumberOfOrdersExpected = 6;
		    myAssert.assertEquals(NumberOfOrdersActual, NumberOfOrdersExpected);
		    myAssert.assertAll();
		    Thread.sleep(10000);
	}
	
	@Test(priority=7)
	public void PriceOfThe5InvoicesAreTheSame() throws InterruptedException{
		
		Thread.sleep(3);
		List <WebElement> AllPrices = driver.findElements(By.className("price"));
		for(int i=0 ; i< AllPrices.size();i++) {
			String ElementOfPrice = AllPrices.get(i).getText();
			ElementOfPrice = ElementOfPrice.replace("$", "");
			float ActualResults = Float.parseFloat(ElementOfPrice);
			float ExpectedResults = (float) 467.0;
			myAssert.assertEquals(ActualResults, ExpectedResults, ExpectedResults);
			myAssert.assertAll();
		
		}
		
	}

	
	
	
	
}
