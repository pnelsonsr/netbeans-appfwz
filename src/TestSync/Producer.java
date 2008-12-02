// $Id$
//===========================================================================
// FileName Producer.java
// CodeJock patrick@nelsons.name 
//-----------------------------------------------------------------------------
// Description: Java code DOES NOT RUN!
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
package TestSync;

public class Producer implements Runnable {
/**====================================================== 
 * @name   Producer Class
 * @author patrick@nelsons.name  
 **====================================================*/

  //---------Begin Attributes---------
  private SyncStack stack ;
  private int num ;
  private static int counter = 1 ;
  //----------End Attributes----------

  //--------Begin Constructors--------
  public Producer(SyncStack s) {
    stack = s ;
    num = counter++ ;
  }
  //---------End Constructors---------
	
  //-----------Begin Methods----------
  public void run() {
    char c;
    for ( int i = 0;i<200;i++ ) {
      c = (char)(Math.random()*26 + 'A') ;
      stack.push(c) ;
      System.out.println("Producer"+ num +": "+ c) ;
      try {
        Thread.sleep((int)(Math.random() * 300)) ;
      } catch (InterruptedException e) { }
    } //for
  } //run
  //------------End Methods-----------

} //===eoc===


/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/* notes
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-------------------------------------------------------------------------------

-------------------------------------------------------------------------------
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
