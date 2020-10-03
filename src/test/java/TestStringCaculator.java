import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestStringCaculator {

    private StringCaculator stringCaculator;
    @BeforeEach
    public void setUp(){
        stringCaculator = new StringCaculator();
    }
    @Test
    public void testEmptyString() throws Exception {
        int empty = stringCaculator.add("");
        Assertions.assertEquals(0,empty);
    }

    @Test
    public void testOneNumber() throws Exception {
        int oneNumber = stringCaculator.add("1");
        Assertions.assertEquals(1,oneNumber);
    }

    @Test
    public void testTwoNumber() throws Exception {
        int twoNumber = stringCaculator.add("1,2");
        Assertions.assertEquals(3,twoNumber);
    }

    @Test
    public void testUnknowNumber(){
        Exception exception = assertThrows(NumberFormatException.class, () ->{stringCaculator.add("n");});
    }

    @Test
    public void testMultipleLine() throws Exception {
        int multipleLine = stringCaculator.add("1\n2,3");
        Assertions.assertEquals(6,multipleLine);
    }

    @Test
    public void testIgnoreInvalidNumer() throws Exception {
        int invalidNumber = stringCaculator.add("1,\n");
        Assertions.assertEquals(1,invalidNumber);
    }

    @Test
    public void testNegativeNumber() throws Exception {
       Exception exception = assertThrows(Exception.class, () ->{stringCaculator.add("-1,2,-5,-6");} );
        Assertions.assertThrows(Exception.class, () ->{stringCaculator.add("-1,2");} );
        Assertions.assertTrue(exception.getMessage().contains("-1"));
        System.out.println(exception.getMessage());
    }

    @Test
    public void testIngoreOverthousand() throws Exception {
        int thousand = stringCaculator.add("1002,1");
        Assertions.assertEquals(1, thousand);
    }
}
