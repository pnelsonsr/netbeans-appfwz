// $Id$
//==============================================================================
// FileName SyncStack.java
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

import java.util.* ;

public class SyncStack {
/**====================================================== 
 * @name   SyncStack Class
 * @author patrick@nelsons.name  
 **====================================================*/

  //---------Begin Attributes---------
  private List<Character> buffer = new ArrayList<Character>(400) ;
  //----------End Attributes----------
  
  //--------Begin Constructors--------
  public SyncStack() { }
  //---------End Constructors---------
    
  //-----------Begin Methods----------
  public synchronized char pop() {
    char c ;
    while ( buffer.size()==0 ) {
      try { this.wait() ; } catch (InterruptedException e) { }
    }//while
    c = buffer.remove(buffer.size()-1) ;
    return c ;
  }//pop
  public synchronized void push(char c) {
    this.notify() ;
    buffer.add(c) ;
  }
  //------------End Methods-----------

  public static void main(String[] args) {
  //-----------------------------------------------------
  } //---eom---

} //===eoc===


/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/* notes
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-------------------------------------------------------------------------------

-------------------------------------------------------------------------------
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
