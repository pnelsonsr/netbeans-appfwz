/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestTest;

import TestJUnit.Utils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

/**
 * Here on UtilsTest
 * @author patrick.nelson
 */
public class UtilsTest {
 /**
  * The SetUpClass Method
  * @author patrick.nelson
  */
  @BeforeClass
  public static void setUpClass() throws Exception {
    System.out.println("* UtilsTest: @BeforeClass method");
  }

 /**
  * @author patrick.nelson
  */
  @AfterClass
  public static void tearDownClass() throws Exception {
    System.out.println("* UtilsTest: @AfterClass method");
  }

 /**
  * @author patrick.nelson
  */
  @Before
  public void setUp() {
    System.out.println("* UtilsTest: @Before method");
  }

  @After
  public void tearDown() {
    System.out.println("* UtilsTest: @After method");
  }

  /**
   * Test of concatWords method, of class Utils.
   */
  @Test
  public void helloWorldCheck() {
    System.out.println("* UtilsTest: test method 1 - helloWorldCheck()");
    assertEquals("Hello, world!",
                 Utils.concatWords("Hello", ", ", "world", "!"));
  }

  /**
   * Test of computeFactorial method with timeout, of class Utils.
   */
  @Test(timeout = 1000)
  public void testWithTimeout() {
    System.out.println("* UtilsTest: test method 2 - testWithTimeout()");
    final int factorialOf = 1 + (int) (30000 * Math.random() );
    System.out.println("computing " + factorialOf + '!');
    System.out.println(factorialOf + "! = " +
                       Utils.computeFactorial(factorialOf));
  }

  /**
   * Test of computeFactorial method for exception handling, of class Utils.
   */
  @Test(expected=IllegalArgumentException.class)
  public void checkExpectedException() {
    System.out.println("* UtilsTest: test method 3 - checkExpectedException()");
    final int factorialOf = -5;
    System.out.println(factorialOf + "! = " + Utils.computeFactorial(factorialOf));
  }
  
  /**
   * Test of normalizeWord method, of class Utils.
   */
  @Ignore
  @Test 
  public void temporarilyDisabledTest() throws Exception {
    System.out.println("* UtilsTest: test method 4 - checkExpectedException()");
    assertEquals("Malm\u00f6", Utils.normalizeWord("Malmo\u0308"));
  }

}