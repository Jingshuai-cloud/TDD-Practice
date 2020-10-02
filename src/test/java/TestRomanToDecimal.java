import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRomanToDecimal {
    private RomanToDecimal romanToDecimal;

    @BeforeEach
    public void setUp(){
        romanToDecimal = new RomanToDecimal();
    }

    @Test
    public void testOnlyAddition(){
        int onlyAddition = romanToDecimal.transferToNumber("MMVI");
        Assertions.assertEquals(2006, onlyAddition);
    }

    @Test
    public void testAdditionAndSubstraction(){
        int testNumber1 = romanToDecimal.transferToNumber("MCMXLIV");
        Assertions.assertEquals(1944,testNumber1);

        int testNumer2 = romanToDecimal.transferToNumber("XCMDCM");
        Assertions.assertEquals(2290, testNumer2);
    }

    @Test
    public void testGetDecimalNumberCorrectly(){
        int M = romanToDecimal.getDecimalNumber("M");
        Assertions.assertEquals(1000,M);

        int D = romanToDecimal.getDecimalNumber("D");
        Assertions.assertEquals(500,D);

        int C = romanToDecimal.getDecimalNumber("T");
        Assertions.assertEquals(0,C);

    }
}
