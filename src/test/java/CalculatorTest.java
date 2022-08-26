import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CalculatorTest {

    Calculator calculator;

    @Parameters("url")
    @BeforeSuite
    public void setUp(String url) {
        System.out.println(url);
      calculator = new Calculator();
    }

    @Test(dataProvider = "sumDataProvider", dataProviderClass = CalculatorDataProviderTest.class )
    public void sumPositive(int num1, int num2, int exp)
    {
        int outcome = calculator.sum(num1,num2);
        Assert.assertEquals(outcome,exp);

    }

    @Test
    public void sumNegative()
    {
        int outcome = calculator.sum(2,3);
        Assert.assertEquals(outcome,5);

    }

    @Test(dataProvider = "divideDataProvider", dataProviderClass = CalculatorDataProviderTest.class)
    public void dividePositive(int num1,int num2, int exp)
    {
        int outcome = calculator.divide(num1,num2);
        Assert.assertEquals(outcome, exp);
    }


    @Test(expectedExceptions={RuntimeException.class}, expectedExceptionsMessageRegExp="You cannot divide by 0")
    public void divideNegative()
    {
        int outcome = calculator.divide(4,0);
        Assert.assertEquals(outcome, 0);
    }


}
