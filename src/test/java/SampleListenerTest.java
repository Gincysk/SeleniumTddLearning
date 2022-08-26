import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SampleListenerTest implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("********STARTING TEST*************");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("********TEST PASSED*************");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("********TEST FAILED*************");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("********TEST CASE SKIPPED*************"+result.getName());
    }



    @Override
    public void onStart(ITestContext context) {
        System.out.println("********STARTING SUITE*************");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("********FINISHING SUITE*************");
    }
}
