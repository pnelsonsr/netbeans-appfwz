/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

/**
 *
 * @author patrick.nelson
 */
public class TestMapTest {

  public TestMapTest() { }

  // Before and After Class Methods
  @BeforeClass
  public static void setUpClass() throws Exception {
    System.out.println("* TestMapTest: @BeforeClass method");
  }
  @AfterClass
  public static void tearDownClass() throws Exception {
    System.out.println("* TestMapTest: @AfterClass method");
  }
  // Before and After Each Test Methods
  @Before
  public void setUp() {
    System.out.println("* TestMapTest: @Before method");
  }
  @After
  public void tearDown() {
    System.out.println("* TestMapTest: @After method");
  }

  //---------------------------------------------------
  //  The Test Case Methods
  //---------------------------------------------------
  
  @Test
  public void testMain() {
    System.out.println("* TestMapTest: @Test testMain method");
    assertEquals(true, true);
  }
  
//  @Ignore
  @Test
  public void testMainAgain() {
    System.out.println("* TestMapTest: @Test testMainAgain method");
    assertEquals(true, true);
  }

}