package cf;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>BrickeryTest</code> contains tests for the class <code>{@link Brickery}</code>.
 *
 * @generatedBy CodePro at 3/2/16 6:53 PM
 * @author djash
 * @version $Revision: 1.0 $
 */
public class BrickeryTest
{
  /**
   * Run the boolean makeBricks(int,int,int) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 3/2/16 6:53 PM
   */
  @Test
  public void testMakeBricksfalse()
    throws Exception
  {
    Brickery fixture = new Brickery();
    int small = 2;
    int big = 3;
    int goal = 9;

    boolean result = fixture.makeBricks(small, big, goal);

    // add additional test code here
    assertEquals(false, result);
  }
  
  @Test
  public void testMakeBricks_2()
    throws Exception
  {
    Brickery fixture = new Brickery();
    int small = 0;
    int big = 3;
    int goal = 11;

    boolean result = fixture.makeBricks(small, big, goal);

    // add additional test code here
    assertEquals(false, result);
  }
  
  @Test
  public void testMakeBricks_3()
    throws Exception
  {
    Brickery fixture = new Brickery();
    int small = 1;
    int big = 3;
    int goal = 11;

    boolean result = fixture.makeBricks(small, big, goal);

    // add additional test code here
    assertEquals(true, result);
  }
  
  @Test
  public void testMakeBricks_4()
    throws Exception
  {
    Brickery fixture = new Brickery();
    int small = 1;
    int big = 3;
    int goal = 12;

    boolean result = fixture.makeBricks(small, big, goal);

    // add additional test code here
    assertEquals(false, result);
  }
  
  @Test
  public void testMakeBricks_5()
    throws Exception
  {
    Brickery fixture = new Brickery();
    int small = 1;
    int big = 3;
    int goal = 13;

    boolean result = fixture.makeBricks(small, big, goal);

    // add additional test code here
    assertEquals(false, result);
  }
  
  @Test
  public void testMakeBricks_6()
    throws Exception
  {
    Brickery fixture = new Brickery();
    int small = 1;
    int big = 3;
    int goal = 14;

    boolean result = fixture.makeBricks(small, big, goal);

    // add additional test code here
    assertEquals(false, result);
  }
  
  @Test
  public void testMakeBricks_7()
    throws Exception
  {
    Brickery fixture = new Brickery();
    int small = 1;
    int big = 3;
    int goal = 15;

    boolean result = fixture.makeBricks(small, big, goal);

    // add additional test code here
    assertEquals(true, result);
  }
  
  @Test
  public void testMakeBricks_8()
    throws Exception
  {
    Brickery fixture = new Brickery();
    int small = 1;
    int big = 3;
    int goal = 16;

    boolean result = fixture.makeBricks(small, big, goal);

    // add additional test code here
    assertEquals(true, result);
  }
  
  @Test
  public void testMakeBricks_9()
    throws Exception
  {
    Brickery fixture = new Brickery();
    int small = 2;
    int big = 3;
    int goal = 17;

    boolean result = fixture.makeBricks(small, big, goal);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Perform pre-test initialization.
   *
   * @throws Exception
   *         if the initialization fails for some reason
   *
   * @generatedBy CodePro at 3/2/16 6:53 PM
   */
  @Before
  public void setUp()
    throws Exception
  {
    // add additional set up code here
  }

  /**
   * Perform post-test clean-up.
   *
   * @throws Exception
   *         if the clean-up fails for some reason
   *
   * @generatedBy CodePro at 3/2/16 6:53 PM
   */
  @After
  public void tearDown()
    throws Exception
  {
    // Add additional tear down code here
  }

  /**
   * Launch the test.
   *
   * @param args the command line arguments
   *
   * @generatedBy CodePro at 3/2/16 6:53 PM
   */
  public static void main(String[] args)
  {
    new org.junit.runner.JUnitCore().run(BrickeryTest.class);
  }
}