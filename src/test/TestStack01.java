// $Id$
//===========================================================================
// FileName TestStack01.java
// CodeJock patrick@nelsons.name 
//-----------------------------------------------------------------------------
// Description: Java (class) code
// Location...: 
// Company....: NelWare, LLC
//-----------------------------------------------------------------------------
// This program is distributed strictly as a learning aid and Patrick Nelson
// disclaims all warranties- including but not limited to: fitness for a
// particular purpose, merchantability, loss of business, harm to your
// system, etc... ALWAYS BACK UP YOUR SYSTEM BEFORE INSTALLING ANY SCRIPT
// OR PROGRAM FROM ANY SOURCE!
//-----------------------------------------------------------------------------
//     *** Copyright (c) 2008 Patrick J. Nelson.  All Rights Rreserved. ***
//==============================================================================
package test;

public class TestStack01 {
/**====================================================== 
 * @name   TestStack01 Class
 * @author patrick@nelsons.name  
 **====================================================*/

  //---------Begin Attributes---------
  int next = 0 ;
  char [] stack = new char[10] ;
  //----------End Attributes----------

  //--------Begin Constructors--------
  public TestStack01() { }
  //---------End Constructors---------
	
  //-----------Begin Methods----------
  public void push(char aC) { 
    if ( stack.length > next ) {
      stack[next++] = aC ; 
      System.out.println("Push \""+aC+"\" on Stack at "+(next-1) ) ;
    } else {
      int size = stack.length - 1 ;
      System.out.print(
        "--------------------------------------------------\n"+
        "- ERROR: Index Overrun: Next index pointer is set \n"+
        "- to "+next+" which is 1 more the max stack index value \n"+
        "- of "+size+" (index is zero based ie from 0 to "+size+")!\n"+
        "- ACTION: Value \""+aC+"\" not added to stack! \n"+
        "--------------------------------------------------\n"
      ) ;
    }
  }
  public char pop () { 
    return stack[--next] ; 
  }
  //------------End Methods-----------

  public static void main(String args[]) {
  //-----------------------------------------------------
    TestStack01 myStack = new TestStack01() ;
    System.out.println("Stack Size is "+myStack.stack.length) ;
    char list[] = {'a','b','c','d','e','f','g','h','i','j'} ;
//  char list[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m'} ;
    for ( char items : list ) { myStack.push(items); }
    System.out.println("Next pointer at "+myStack.next) ;
    int i ; int count = myStack.next + 1 ;
    for ( i = 1 ; i < count ; i++ ) {
      System.out.println(
        "Pop \""+myStack.pop()+"\" off Stack at "+(myStack.next) 
      ) ;
    }
    System.out.println("Next pointer at "+myStack.next) ;
  } //---eom---

} //===eoc===


/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/* notes
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-------------------------------------------------------------------------------

-------------------------------------------------------------------------------
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
