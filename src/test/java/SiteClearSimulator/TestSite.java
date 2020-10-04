package SiteClearSimulator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class TestSite {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testReadSite() throws FileNotFoundException {
        Site site  = new Site("src/Site.txt");
        ArrayList<ArrayList<Character>> siteInfo = new ArrayList<>();
        siteInfo = site.readSite();
        Assertions.assertEquals(5,siteInfo.size());
        Assertions.assertEquals(10, siteInfo.get(0).size());
    }

    @Test
    public void testPrintSite() throws FileNotFoundException {
        Site site = new Site("src/Site.txt");
        site.readSite();
        site.printSite();
        Assertions.assertEquals(
                "o o t o o o o o o o \n" +
                "o o o o o o o T o o \n" +
                "r r r o o o o T o o \n" +
                "r r r r o o o o o o \n" +
                "r r r r r t o o o o",outputStreamCaptor.toString().trim());
    }
}
