// $Id$
//==============================================================================
// FileName SimpleServer.java
// CodeJock patrick@nelware.com 
//-----------------------------------------------------------------------------
// Description: Java (class) code
// Location...: 
// Company....: Nelware
//-----------------------------------------------------------------------------
// This program is distributed strictly as a learning aid and Nelware
// disclaims all warranties - including but not limited to: fitness for a
// particular purpose, merchantability, loss of business, harm to your
// system, etc... ALWAYS BACK UP YOUR SYSTEM BEFORE INSTALLING ANY SCRIPT
// OR PROGRAM FROM ANY SOURCE!
//-----------------------------------------------------------------------------
//     *** Copyright (c) 2008 Nelware LLC.  All Rights Rreserved. ***
//==============================================================================
package TestNet;

import java.net.* ;
import java.io.* ;

public class SimpleServer {
/**====================================================== 
 * @name   SimpleServer Class
 * @author patrick@nelware.com  
 **====================================================*/

  //---------Begin Attributes---------
  //----------End Attributes----------
  
  //--------Begin Constructors--------
  public SimpleServer() { }
  //---------End Constructors---------
    
  //-----------Begin Methods----------
  //------------End Methods-----------

  public static void main(String[] args) {
  //-----------------------------------------------------
    ServerSocket s = null ;
    try { s = new ServerSocket(5432); } 
    catch (Exception e) { e.printStackTrace(); }
    while (true) {
      try { 
        Socket s1 = s.accept() ;
        OutputStream s10 = s1.getOutputStream() ;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s10)) ;
        bw.write("Hello Net World!\n") ;
        bw.write("Flowing the data stream to you!\n") ;
        for ( int i=1; i<11 ;i++ ) { bw.write("Hey "+i+" \n"); }
        bw.close() ;
        s1.close() ; 
      } catch (Exception e) { e.printStackTrace(); }
    }//while
  } //---eom---

} //===eoc===


/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/* notes
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-------------------------------------------------------------------------------

-------------------------------------------------------------------------------
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
