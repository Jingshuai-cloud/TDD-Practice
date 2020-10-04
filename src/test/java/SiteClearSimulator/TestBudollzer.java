package SiteClearSimulator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

public class TestBudollzer {
    @Test
    public void testTurnAction(){
        Budollzer budollzer = new Budollzer();
        budollzer.turn("left");
        Assertions.assertEquals("NORTH", budollzer.getPosition().get("facing") );
    }

    @Test
    public void testAdvance(){
        Budollzer budollzer = new Budollzer();
        budollzer.advance(5);
        Assertions.assertEquals("4",budollzer.getPosition().get("X"));
    }
}
