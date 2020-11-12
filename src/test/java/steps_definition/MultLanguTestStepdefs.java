package steps_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MultLanguTestStepdefs {
    WebDriver driver;
    Actions action ;
    WebElement we;
    String weId="";
    String weValue="";
    String weClassName="";
    String PageTitle="";
    //String url="https://www.google.com";
    String  url="https://www.google.com/?hl=eN&gl=us";
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
        goodCondition=we!=null;
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
        goodCondition=PageTitle.contains(textInTitle);
        Assert.assertTrue(goodCondition);
    }

    @And("user white tell element identefied by {string} sows up")
    public void userWhiteTellElementIdentefiedBySowsUp(String elemId) {
        we=driver.findElement(By.id(elemId));

        while (we==null || !we.isDisplayed() ) {
            try {
                driver.wait(1000);
            } catch (InterruptedException e) {
                goodCondition=false;
            }
            goodCondition=we.isDisplayed();
            Assert.assertTrue(goodCondition);
        }
        }

    @And("user click on element determined by the xpath{string}")
    public void userClickOnElementDeterminedByTheXpath(String xpath) {
        List<WebElement> listE=driver.findElements(By.xpath(xpath));
        goodCondition= listE.size()==1;
        we=listE.get(0);
        we.click();
        Assert.assertTrue(goodCondition);

    }



    @And("user click on tagElement \\{string} having as content\\{string}")
    public void userClickOnTagElementStringHavingAsContentString() {

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
}
