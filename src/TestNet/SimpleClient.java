// $Id$
//==============================================================================
// FileName SimpleClient.java
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

public class SimpleClient {
/**====================================================== 
 * @name   SimpleClient Class
 * @author patrick@nelware.com  
 **====================================================*/

  //---------Begin Attributes---------
  //----------End Attributes----------
  
  //--------Begin Constructors--------
  public SimpleClient() { }
  //---------End Constructors---------
    
  //-----------Begin Methods----------
  //------------End Methods-----------

  public static void main(String[] args) {
  //-----------------------------------------------------
//  String host = "127.0.0.1" ; int port = 5432 ;
    String host = "10.32.1.20" ; int port = 5432 ;
    try {
      Socket s1 = new Socket(host, port) ;
      BufferedReader br = new BufferedReader(
        new InputStreamReader(s1.getInputStream()) 
      ) ;
      System.out.println("Connected to "+host+":"+port) ;
      while ( br.ready() ) { System.out.println(br.readLine()); }
      br.close() ;
      s1.close() ;
    } catch (ConnectException connExc) {
      System.err.println("Could not connect!");
    } catch (IOException e) { }
  } //---eom---

} //===eoc===


/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/* notes
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-------------------------------------------------------------------------------

-------------------------------------------------------------------------------
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
