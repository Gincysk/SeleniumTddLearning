import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CalculatorDataProviderTest {


    @DataProvider
    public Object[][] sumDataProvider()
    {
        Object[][] data = {{4, 5, 9},
                {10000, 20000, 30000},
                {99, 12, 111},
                {50, 30, 80}};

        return data;
    }

    @DataProvider
    public Iterator<Object[]> divideDataProvider() {
        List<Object[]> data = new ArrayList<>();
        List<Object> line1 = Arrays.asList(10, 5, 2);
        List<Object> line2 = Arrays.asList(100, 5, 20);

        data.add(line1.toArray());
        data.add(line2.toArray());
        return data.iterator();
    }


}

