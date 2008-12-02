// $Id: java-head 62 2008-10-10 04:58:05Z root $
//==============================================================================
// FileName SyncTest.java
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
//     *** Copyright (c) 2008 Patrick J Nelson.  All Rights Rreserved. ***
//==============================================================================
package TestSync ;

public class SyncTest {
/**====================================================== 
 * @name   SyncTest Class
 * @author patrick@nelsons.name  
 **====================================================*/

  //---------Begin Attributes---------
  //----------End Attributes----------
  
  //--------Begin Constructors--------
  public SyncTest() { }
  //---------End Constructors---------
    
  //-----------Begin Methods----------
  //------------End Methods-----------

  public static void main(String[] args) {
  //-----------------------------------------------------
    SyncStack stack = new SyncStack() ;

    Producer p1 = new Producer(stack) ;
    Thread prodT1 = new Thread(p1) ;
    prodT1.start() ;

    Producer p2 = new Producer(stack) ;
    Thread prodT2 = new Thread(p2) ;
    prodT2.start() ;

    Producer p3 = new Producer(stack) ;
    Thread prodT3 = new Thread(p3) ;
    prodT3.start() ;

    Consumer c1 = new Consumer(stack);
    Thread consT1 = new Thread(c1);
    consT1.start();

    Consumer c2 = new Consumer(stack);
    Thread consT2 = new Thread(c2);
    consT2.start();

    Consumer c3 = new Consumer(stack);
    Thread consT3 = new Thread(c3);
    consT3.start();
  } //---eom---

} //===eoc===


/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/* notes
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-------------------------------------------------------------------------------

-------------------------------------------------------------------------------
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
