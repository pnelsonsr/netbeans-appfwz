// $Id: java-head-netbeans 67 2008-11-30 07:57:41Z root $
//==============================================================================
// FileName TestArrayClone.java
// CodeJock patrick@nelware.com
//-----------------------------------------------------------------------------
// Description: Java (class) code
// Location...: svn repo
// Company....: Nelware
//-----------------------------------------------------------------------------
// This program is distributed strictly as a learning aid and Nelware
// disclaims all warranties - including but not limited to: fitness for a
// particular purpose, merchantability, loss of business, harm to your
// system, etc... ALWAYS BACK UP YOUR SYSTEM BEFORE INSTALLING ANY SCRIPT
// OR PROGRAM FROM ANY SOURCE!
//-----------------------------------------------------------------------------
//     *** Copyright (c) 2009 Nelware LLC.  All Rights Rreserved. ***
//==============================================================================
package test;

import java.util.Arrays;

//=======================================================
/**
 * Base Class for TestArrayClone
 * @name   TestArrayClone Class
 * @author patrick@nelware.com
*/
public class TestArrayClone
{//=======================================================

  //---------Begin Attributes---------
  //----------End Attributes----------

  //--------Begin Constructors--------
  public void testArrays()
  {
    Object arr = new int[][]
    {
      {5},
      {9, 4},
      {1, 7, 8},
      {8, 3, 2, 10}
     };
    Object arrCopy = copyNd(arr);
    int height = Array.getLength(arr);
    for (int r = 0; r < height; r++)
    {
      Object rowOrigonal = Array.get(arr, r);
      Object rowCopy = Array.get(arrCopy, r);
      int width = Array.getLength(rowOrigonal);
      for (int c = 0; c < width; c++)
      {
        assertTrue(rowOrigonal.getClass().isArray());
        assertTrue(rowCopy.getClass().isArray());
        assertEquals(Array.get(rowOrigonal, c), Array.get(rowCopy, c));
        System.out.println(Array.get(rowOrigonal, c) + ":" + Array.get(rowCopy, c));
      }
    }
  }
  //---------End Constructors---------

  //-------Begin Nested Classes------
  //--------End Nested Classes-------

  //-----------Begin Methods----------
  public static Object copyNd(Object arr)
  {
    if (arr.getClass().isArray())
    {
      int innerArrayLength = Array.getLength(arr);
      Class component = arr.getClass().getComponentType();
      Object newInnerArray = Array.newInstance(component, innerArrayLength);
      //copy each elem of the array
      for (int i = 0; i < innerArrayLength; i++)
      {
        Object elem = copyNd(Array.get(arr, i));
        Array.set(newInnerArray, i, elem);
      }
      return newInnerArray;
    } else {
      return arr;
    }//cant deep copy an opac object??
  }
  //------------End Methods-----------

  public static void main(String[] args) {
  //-----------------------------------------------------
  } //---eom---

}//=======================================================


/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/* notes
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-------------------------------------------------------------------------------

-------------------------------------------------------------------------------
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
