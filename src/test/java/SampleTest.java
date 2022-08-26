import org.testng.annotations.*;

public class SampleTest {

//    @BeforeSuite
//    public void setUpSuiteLevel() {
//        System.out.println(" Setting up on suite level");
//    }
//
//
//    @BeforeTest
//    public void setUpTestLevel() {
//        System.out.println(" Setting up on test level");
//    }
//
//    @BeforeClass
//    public void setUpSampleTest() {
//        System.out.println(" Sample Class level set up");
//    }

    @Test(groups="regression")
    public void sampleTest()
    {
        System.out.println(" This is a sample test");
    }


//    @AfterClass
//    public void tearDownSampleTest() {
//        System.out.println(" Sample Class level tear down");
//    }
//
//
//    @AfterTest
//    public void tearDownTestLevel() {
//        System.out.println(" Tearing down on test level");
//    }
//
//
//    @AfterSuite
//    public void tearDownSuiteLevel() {
//        System.out.println(" Tearing down on suite level");
//    }
//
//
}
