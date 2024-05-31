import org.testng.Assert;
import pages.HomePage;
import pages.Products;
import pages.SignUpLogin;

import java.time.Duration;

public class Test extends BaseTest {

    @org.testng.annotations.Test
    public void checkTitlePage(){
        HomePage homePage  = new HomePage(driver);
        System.out.println(homePage.verifyHomePage());
        Assert.assertEquals(homePage.verifyHomePage(), "Automation Exercise");
    }
    @org.testng.annotations.Test
    public void addTwoProductsAndCheckTotal() throws InterruptedException {
        Products products = new Products(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        products.acceptCookies();
        products.clickProductButton();
        products.scrollOne();
        Thread.sleep(500);
        products.clickProduct(0);
        Thread.sleep(200);
        products.clickAddToCartByIndex(1);
        products.clickContinueShoppingButton();
        products.clickProduct(1);
        Thread.sleep(200);
        products.clickAddToCartByIndex(3);
        products.clickViewAll();
        System.out.println("Numarul de produse din cos: ");
        System.out.println(products.numberOfProductinCart());
        Assert.assertEquals(products.numberOfProductinCart(), 2);
        System.out.println(products.getprice());
        System.out.println(products.formatPrices());
        products.pretTotalInCos();
        Thread.sleep(1000);

    }

    @org.testng.annotations.Test
    public void verifyScrollUpusingArrowbuttonandScrollDownfunctionality() throws InterruptedException {
        HomePage homePage  = new HomePage(driver);
        Products products = new Products(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        products.acceptCookies();
        homePage.scrollDownToTheBottom();
        homePage.goUp();
        homePage.verifyTextUpperPage();
        Thread.sleep(2000);


    }
    @org.testng.annotations.Test
    public void verifyScrollUpusingArrowbuttonandScrollDownfunctionality1() throws InterruptedException {
        HomePage homePage  = new HomePage(driver);
        Products products = new Products(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        products.acceptCookies();
        Assert.assertEquals(homePage.verifyHomePage(), "Automation Exercise");
        homePage.scrollDownToTheBottom();
        homePage.goUpWithoutclickArrowButton();
        homePage.verifyTextUpperPage();
        Thread.sleep(2000);

    }

    @org.testng.annotations.Test
    public void verifySignUpErrorWithAnExistingEmail() throws InterruptedException {
        Products products = new Products(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        products.acceptCookies();
        SignUpLogin signUpLogin = new SignUpLogin(driver);
        signUpLogin.clickSignUpSignIn();
        signUpLogin.verifySignupFromIsVisible();
        signUpLogin.registerWithEmailAlreadyExistsInDB("Alexandru", "Brontozaur52@email.com");
        signUpLogin.clickSignUp();
        signUpLogin.verifyErrorMessageWithEmailAlreadyRegistered();
        Thread.sleep(1000);

    }

    @org.testng.annotations.Test
    public void verifySearchProduct() throws InterruptedException {
        Products products = new Products(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        products.acceptCookies();
        products.clickProductButton();
        Thread.sleep(2000);
        products.verifyPageProducts();
        products.searchProduct(" shirt");
        products.getAttributesProduct();
        products.verifyManyProductsAreDisplayed();
        Thread.sleep(3000);

    }

    @org.testng.annotations.Test
    public void verifyReviewIsSent() throws InterruptedException {
        Products products = new Products(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        products.acceptCookies();
        products.clickProductButton();
        products.verifyPageProducts();
        products.scrollOne();
        products.clickViewProduct();
        products.verifyYourReviewIsVisible();
        products.reviewContent("Alexandru Madaras", "aleccsx4@icloud.com", "Best product ever");
        products.clickSubmit();
        products.alertSuccessIsDisplayed();
        Thread.sleep(4000);

    }
    @org.testng.annotations.Test
    public void RegisterAndDeleteAccount() throws InterruptedException {
        SignUpLogin signUpLogin = new SignUpLogin(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Products products = new Products(driver);
        products.acceptCookies();
        signUpLogin.clickSignUpSignIn();
        signUpLogin.signUpText();
        signUpLogin.signUpBasicInfo("Alex", "madarasalexandru2@gmail.com");
        Thread.sleep(5656);
        signUpLogin.clickSignUp();
        signUpLogin.verifySignUpIsPresent();
        signUpLogin.completeInfoSignUp(0,"parola98", 20, 05, "2001");
        Thread.sleep(5656);
        signUpLogin.selectCheckBoxes();
        signUpLogin.completeFirstName("Alexandru");
        signUpLogin.completeLastName("Madaras");
        signUpLogin.completeCompany("Testare SRL");
        signUpLogin.completeAdress("Baia Mare, Maramures, Romania");
        signUpLogin.selectCountry("Canada");
        signUpLogin.completeCityandState("Maramures", "Romania");
        signUpLogin.phoneNumber("0755667799");
        signUpLogin.completeZipCode("439433");
        signUpLogin.clickCreateAccount();
        signUpLogin.verifyAccountCreated();
        signUpLogin.clickContinuebutton();
        signUpLogin.verifyLoggedUser();
        signUpLogin.deleteAccount();
        signUpLogin.deleteConfirmation();
        Thread.sleep(5000);

    }



}


