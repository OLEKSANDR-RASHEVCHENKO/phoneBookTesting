package e2e;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected static AplicationManager app = new AplicationManager();

    @BeforeMethod
    public void setAppTest(){
        app.init();
    }

    @AfterMethod
    public void tearDown(){
        app.stop();
    }

}
