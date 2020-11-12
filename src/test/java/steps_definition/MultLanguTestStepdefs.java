package steps_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MultLanguTestStepdefs {
    WebDriver driver;
    Actions action ;
    WebElement we;
    String PageTitle="";
    Boolean goodCondition=false;




    @Given("use open page in the url {string}")
    public void useOpenPageInTheUrl(String targetUrl) {
        System.setProperty("webdriver.chrome.driver","c:\\Drivers\\chromedriver.exe");
        driver =new ChromeDriver();
        action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(targetUrl);
        System.out.println("getTitle = " +driver.getTitle());

    }

    @And("the page Title should containe {string}")
    public void thePageTitleShouldContaine(String titlePart) {
        PageTitle=driver.getTitle();
        goodCondition=PageTitle.contains(titlePart);
        Assert.assertTrue(goodCondition);

    }

    @And("user click on element determined by the id{string}")
    public void userClickOnLinkElementDeterminedByTheId(String elemId) {

        we=driver.findElement(By.id(elemId));

        goodCondition=we!=null && we.isDisplayed() ;
        System.out.println("goodCondition="+goodCondition);
        we.click();
        Assert.assertTrue(goodCondition);

    }
    //
    @And("use go over the element determined by id {string}")
    public void useGoOverTheElementDeterminedById(String elemId) {
        we=driver.findElement(By.id(elemId));
        action = new Actions(driver);
        goodCondition=we!=null;
        action.moveToElement(we).build().perform();

       Assert.assertTrue(goodCondition);
    }

    @And("user sould land in a page title contains {string}")
    public void userSouldLandInAPageWhereTitledContains(String textInTitle) {
        PageTitle=driver.getTitle();
        System.out.println("PageTitle=="+PageTitle);
        goodCondition=PageTitle.contains(textInTitle);
        Assert.assertTrue(goodCondition);
    }

    @And("user white tell element identefied by {string} sows up")
    public void userWhiteTellElementIdentefiedBySowsUp(String elemId) {
        //we=driver.findElement(By.id(elemId));
        we=null;
        goodCondition=false;
        int i=0;
        while (  (we==null || !we.isDisplayed()) &&  i<5 ) {

            try {
                //driver.wait(1000);
                //driver.manage().sl;
                Thread.sleep(1000);
                we=driver.findElement(By.id(elemId));

            } catch (InterruptedException e) {
                goodCondition=false;
            }
            i++;
            System.out.println( "wait...");

        }
           goodCondition=we.isDisplayed();
           Assert.assertTrue(goodCondition);
        }

    @And("user click on element determined by the xpath{string}")
    public void userClickOnElementDeterminedByTheXpath(String xpath) {
        List<WebElement> listE=driver.findElements(By.xpath(xpath));
        goodCondition= listE.size()==1;
        we=listE.get(0);
        we.click();
        Assert.assertTrue(goodCondition);

    }




    @And("user click on tagElement {string} having as content{string}")
    public void userClickOnTagElementHavingAsContent(String tag, String txt) {
        String pth="//"+tag+"[text()='"+txt+"']";
        List<WebElement> listE=driver.findElements(By.xpath(pth));
        goodCondition= listE.size()==1;
        we=listE.get(0);
        we.click();
        Assert.assertTrue(goodCondition);
    }


    @And("user click on tagElement {string} contaning in {string}")
    public void userClickOnTagElementContaningIn(String tag, String txt) {
        //String pth="//"+tag+"[text()='"+txt+"']";
        String pth="//"+tag+"[contains(text(),'"+txt+"')]"; //span[contains(text(),'Go to website')]
        List<WebElement> listE=driver.findElements(By.xpath(pth));
        goodCondition= listE.size()==1;
        we=listE.get(0);
        we.click();
        Assert.assertTrue(goodCondition);
    }

    @And("user click on  parent of  tagElement {string} contaning in {string}")
    public void userClickOnParentOfTagElementContaningIn(String tag, String txt) {

        String pth="//"+tag+"[contains(text(),'"+txt+"')]"; //span[contains(text(),'Go to website')]
        List<WebElement> listE=driver.findElements(By.xpath(pth));
        goodCondition= listE.size()==1;
        we=listE.get(0);
        WebElement parent=we.findElement(By.xpath(".."));
        parent.click();
        Assert.assertTrue(goodCondition);
    }

    @And("user sould land in new tab were page title contains {string}")
    public void userSouldLandInNewTabWerePageTitleContains(String textInTitle) {

        //t
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"9");

        String w0=driver.getWindowHandle();
        String w0a=(String) driver.getWindowHandles().toArray()[0];
        String w1= (String) driver.getWindowHandles().toArray()[1];
        System.out.println(driver.getWindowHandles().size());
        System.out.println(w0);
        System.out.println(w0a);
        System.out.println(w1);
        PageTitle=driver.getTitle();
        System.out.println("PageTitle befor switch=="+PageTitle);

        driver.switchTo().window(w1);
        PageTitle=driver.getTitle();
        System.out.println("PageTitle after switch=="+PageTitle);
        goodCondition=PageTitle.contains(textInTitle);
        Assert.assertTrue(goodCondition);

    }
}
