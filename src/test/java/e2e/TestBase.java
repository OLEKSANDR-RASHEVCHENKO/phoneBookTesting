package e2e;

import org.testng.annotations.BeforeMethod;


public class TestBase {
    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setupTest(){
        app.init();
    }

    @BeforeMethod
    public void tearDown(){
        app.stop();
    }
}
