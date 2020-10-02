import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFuzzyBuzzy {

    private FuzzyBuzzy fuzzyBuzzy;

    @BeforeEach
    public void setUp(){
     fuzzyBuzzy = new FuzzyBuzzy();
    }
    @Test
    public void testOutPutisNumber(){
        String first = fuzzyBuzzy.playGame(1);
        String second = fuzzyBuzzy.playGame(2);
        Assertions.assertEquals("1", first);
        Assertions.assertEquals("2", second);
    }

    @Test
    public void testOutputIsFuzzy(){
        String five = fuzzyBuzzy.playGame(5);
        String teen = fuzzyBuzzy.playGame(10);
        Assertions.assertEquals("Fuzzy",five);
        Assertions.assertEquals("Fuzzy",teen);
    }

    @Test
    public void testOutputIsBuzzy(){
        String three = fuzzyBuzzy.playGame(3);
        String nine = fuzzyBuzzy.playGame(9);
        Assertions.assertEquals("Buzzy",three);
        Assertions.assertEquals("Buzzy",nine);
    }

    @Test
    public void testOutputIsFuzzyBuzzy(){
        String fifteen = fuzzyBuzzy.playGame(15);
        String thirty = fuzzyBuzzy.playGame(30);
        Assertions.assertEquals("FuzzyBuzzy",fifteen);
        Assertions.assertEquals("FuzzyBuzzy",thirty);
    }

    @Test
    public void testOneToHundredCorrectly(){
        for(int i = 0; i < 100; i++){
            String outcome = fuzzyBuzzy.playGame(i);
            System.out.println(outcome);
        }
    }
}
