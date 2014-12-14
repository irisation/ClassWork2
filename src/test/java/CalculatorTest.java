import org.testng.Assert;
import org.testng.annotations.*;



public class CalculatorTest {
    Calculator  calc;

    @BeforeMethod
    public void setup(){
        calc = new Calculator();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("in afterMethod");
    }

    @Parameters({"value1", "value2","result"})

    @Test(description = "Test for sum")
    public void sumTest(int value1, int value2, int result){
        Assert.assertEquals(result, calc.sum(value1, value2));
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "calcData")
    public void dataTest(String value1, String value2, String result){

            Assert.assertEquals(Integer.valueOf(result), new Integer(calc.sum( Integer.parseInt(value2),  Integer.parseInt(value1))));

    }

}
