package ir.viratech.pond_ms.ui.cli;

import org.junit.*;

/**
 * Created by justro on 2/17/18.
 */
public class MyTest {

    @BeforeClass
    public static void startup() {
        System.out.println("Setup");
    }

    @AfterClass
    public static void shutdown() {
        System.out.println("TearDown");
    }

    @Before
    public  void setup() {
        System.out.println("Startup");
    }

    @After
    public  void tierDown() {
        System.out.println("Shutdown");
    }

    @Test
    public  void testDiv() {
        System.out.println("TestDiv");
    }

    @Test
    public  void testMult() {
        System.out.println("TestMult");
    }

}
