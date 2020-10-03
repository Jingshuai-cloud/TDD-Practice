import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGreeting {
    private Greeting greeting;

    @BeforeEach
    public void setUp(){
        greeting = new Greeting();
    }
    @Test
    public void testGreetingOneName(){
        String name = greeting.sayHello(new String[]{"Bob"});
        Assertions.assertEquals("Hello Bob", name);
    }

    @Test
    public void testGreeingEmptyName(){
        String emptyName = greeting.sayHello(new String[]{""});
        Assertions.assertEquals("Hello myfriend", emptyName);
    }

    @Test
    public void testUpperCaseName(){
        String uppercaseName = greeting.sayHello(new String[]{"JERRY"});
        Assertions.assertEquals("HELLO JERRY", uppercaseName);
    }

    @Test
    public void testTwoNames(){
        String twoNams = greeting.sayHello(new String[]{"Jill", "Jane"});
        Assertions.assertEquals("Hello, Jill and Jane.", twoNams);
    }

    @Test
    public void testThreeNames(){
        String threeNames = greeting.sayHello(new String[] {"Amy", "Brian", "Charlotte"});
        Assertions.assertEquals("Hello, Amy, Brian, and Charlotte.", threeNames);
    }

    @Test
    public void testThreeNameWithOneUppsercase(){
        String names = greeting.sayHello(new String[] {"Amy", "BRIAN", "Charlotte"});
        Assertions.assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN!", names);
    }

    @Test
    public void testSplitName(){
        String names = greeting.sayHello(new String[] {"Bob", "Charlie", "Dianne"});
        Assertions.assertEquals("Hello, Bob, Charlie, and Dianne.", names);
    }

    @Test
    public void testCSVName(){
        String names = greeting.sayHello(new String[] {"Bob", "Charlie, Dianne"});
        Assertions.assertEquals("Hello, Bob and Charlie, Dianne.", names);
    }
}
