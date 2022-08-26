import org.testng.Assert;
import org.testng.annotations.*;

public class HomeTest {


//    @BeforeClass
//    public void setUpHomeTest() {
//        System.out.println(" Home Class level set up");
//
//    }
//
//
//    @BeforeMethod
//    public void setUpHomeTestMethod()
//    {
//        System.out.println(" Home Method level set up");
//    }
//
//
//    @Test
//    public void homeTest()
//    {
//        System.out.println(" This is a home test");
//    }
//
    @Test(groups = { "regression"})
        public void tc1()
    {
        System.out.println(" This is tc1");
    }

    @Test(groups="sanity")
    public void tc2()
    {
        System.out.println(" This is tc2");
        Assert.fail();
    }

    @Test(groups = "regression", dependsOnGroups = "sanity")
    public void tc3()
    {
        System.out.println(" This is tc3");
    }

    @Test(groups="sanity")
    public void tc4()
    {
        System.out.println(" This is tc4");

    }

    @Test
    public void tc5()
    {
        System.out.println(" This is tc5");
    }

//
//
//    @AfterMethod
//        public void tearDownHomeTestMethod()
//    {
//        System.out.println(" Home Method level Tear down");
//    }
//

//    @AfterClass
//    public void tearDownHomeTest()
//    {
//        System.out.println(" Home Class level Tear down");
//
//    }
}


