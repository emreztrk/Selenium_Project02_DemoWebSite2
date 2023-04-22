package TestingProject02;

import Utilities.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MultipleTestCase extends BaseDriver {

    @Test
    public void Case1(){
        driver.get("https://demowebshop.tricentis.com/");

        WebElement register= driver.findElement(By.linkText("Register"));

        Actions actions=new Actions(driver);

        Action action=actions.moveToElement(register).click().build();
        action.perform();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gender-male")));

        WebElement male= driver.findElement(By.id("gender-male"));
        action=actions.moveToElement(male).click().build();
        action.perform();

        WebElement firstname= driver.findElement(By.id("FirstName"));
        firstname.sendKeys("Rauf");

        WebElement lastname= driver.findElement(By.id("LastName"));
        lastname.sendKeys("Zamanlı");

        WebElement email= driver.findElement(By.id("Email"));
        email.sendKeys("osmanali21@gmail.com");

        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys("123456");

        WebElement confirmPassword= driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("123456");

        WebElement registerButton= driver.findElement(By.id("register-button"));

        action=actions.moveToElement(registerButton).click().build();
        action.perform();

        WebElement confirmation= driver.findElement(By.xpath("//div[@class='result']"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='result']")));


        Assert.assertEquals("Your registration completed", confirmation.getText());

        //WaitClose();
    }
    @Test
    public void Case2(){
        driver.get("https://demowebshop.tricentis.com/");

        WebElement register= driver.findElement(By.linkText("Register"));

        Actions actions=new Actions(driver);

        Action action=actions.moveToElement(register).click().build();
        action.perform();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gender-male")));

        WebElement male= driver.findElement(By.id("gender-male"));
        action=actions.moveToElement(male).click().build();
        action.perform();

        WebElement firstname= driver.findElement(By.id("FirstName"));
        firstname.sendKeys("Rauf");

        WebElement lastname= driver.findElement(By.id("LastName"));
        lastname.sendKeys("Zamanlı");

        WebElement email= driver.findElement(By.id("Email"));
        email.sendKeys("osmanali21@gmail.com");

        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys("123456");

        WebElement confirmPassword= driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("123456");

        WebElement registerButton= driver.findElement(By.id("register-button"));

        action=actions.moveToElement(registerButton).click().build();
        action.perform();

        WebElement alreadyExist= driver.findElement(By.xpath("//div[@class='validation-summary-errors']//li"));

        Assert.assertEquals("The specified email already exists", alreadyExist.getText());

        WaitClose();
    }

    @Test
    public void Case3() {
        driver.get("https://demowebshop.tricentis.com/");

        Actions actions = new Actions(driver);

        WebElement element = driver.findElement(By.linkText("Log in"));
        Action action = actions.moveToElement(element).click().build();
        action.perform();

        WebElement login = driver.findElement(By.id("Email"));
        action=actions.moveToElement(login).sendKeys("osmanali21@gmail.com").build();
        action.perform();

        WebElement password = driver.findElement(By.id("Password"));
        action=actions.moveToElement(password).click().sendKeys("123456").build();
        action.perform();

        WebElement login2 = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        action=actions.moveToElement(login2).click().build();
        action.perform();

        WebElement confirmation = driver.findElement(By.linkText("raufzamanlı113@gmail.com"));

        Assert.assertTrue("Fail", confirmation.getText().contains("osmanali21@gmail.com"));

        WaitClose();
    }
    @Test
    public void Case4(){
        driver.get("https://demowebshop.tricentis.com/");

        Actions actions = new Actions(driver);

        WebElement element = driver.findElement(By.linkText("Log in"));
        Action action = actions.moveToElement(element).click().build();
        action.perform();

        WebElement login = driver.findElement(By.id("Email"));
        action=actions.moveToElement(login).sendKeys("raufzamanlı201@gmail.com").build();
        action.perform();

        WebElement password = driver.findElement(By.id("Password"));
        action=actions.moveToElement(password).click().sendKeys("123456").build();
        action.perform();

        WebElement login2 = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        action=actions.moveToElement(login2).click().build();
        action.perform();

        WebElement loginFailed= driver.findElement(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));

        Assert.assertTrue("Failed", loginFailed.getText().contains("unsuccessful"));

        WaitClose();
    }
    @Test
    public void Case5(){
        driver.get("https://demowebshop.tricentis.com/");

        Actions actions = new Actions(driver);

        WebElement element = driver.findElement(By.linkText("Log in"));
        Action action = actions.moveToElement(element).click().build();
        action.perform();

        WebElement login = driver.findElement(By.id("Email"));
        action=actions.moveToElement(login).sendKeys("raufzamanlı113@gmail.com").build();
        action.perform();

        WebElement password = driver.findElement(By.id("Password"));
        action=actions.moveToElement(password).click().sendKeys("123456").build();
        action.perform();

        WebElement login2 = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        action=actions.moveToElement(login2).click().build();
        action.perform();

        WebElement computers = driver.findElement(By.xpath("(//a[contains(text(),'Computers')])[1]"));
        action=actions.moveToElement(computers).build();
        action.perform();

        WebElement notebooks = driver.findElement(By.xpath("(//a[contains(text(),'Notebooks')])[1]"));
        action=actions.moveToElement(notebooks).click().build();
        action.perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Add to cart']")));

        WebElement addToCard = driver.findElement(By.xpath("//input[@value='Add to cart']"));
        action=actions.moveToElement(addToCard).click().build();
        action.perform();

        WebElement added = driver.findElement(By.xpath("//p[@class='content']"));
        Assert.assertTrue("fail", added.getText().contains("has been added"));

        WebElement shoppingCard = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        action=actions.moveToElement(shoppingCard).click().build();
        action.perform();

        WebElement confirmation = driver.findElement(By.className("product-name"));
        Assert.assertTrue("fail",confirmation.getText().equals("14.1-inch Laptop"));

        WebElement checkBox = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        action=actions.moveToElement(checkBox).click().build();
        action.perform();

        WebElement checkBoxBtn = driver.findElement(By.xpath("//button[@id='checkout']"));
        action=actions.moveToElement(checkBoxBtn).click().build();
        action.perform();

        WebElement country= driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));

        Select slc=new Select(country);
        slc.selectByIndex(0);

        WebElement city= driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']"));
        city.sendKeys("Salt Lake City");

        WebElement adress= driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']"));
        adress.sendKeys("Bla Bla Bla");

        WebElement zipcode= driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"));
        zipcode.sendKeys("34250");

        WebElement phone= driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"));
        phone.sendKeys("555865999");

        WebElement continueBtn= driver.findElement(By.xpath("//input[@onclick='Billing.save()']"));
        action=actions.moveToElement(continueBtn).click().build();
        action.perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='Shipping.save()']")));

        WebElement continueSave= driver.findElement(By.xpath("//input[@onclick='Shipping.save()']"));
        action=actions.moveToElement(continueSave).click().build();
        action.perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='ShippingMethod.save()']")));

        WebElement continueMethod= driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']"));
        action=actions.moveToElement(continueMethod).click().build();
        action.perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='PaymentMethod.save()']")));

        WebElement continuePayment= driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']"));
        action=actions.moveToElement(continuePayment).click().build();
        action.perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='PaymentInfo.save()']")));

        WebElement continueInfo= driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']"));
        action=actions.moveToElement(continueInfo).click().build();
        action.perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='ConfirmOrder.save()']")));

        WebElement confirmOrder= driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']"));
        action=actions.moveToElement(confirmOrder).click().build();
        action.perform();

        WebElement textConfirm=driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));

        Assert.assertTrue("Failed", textConfirm.getText().contains("successfully processed!"));
    }
}
