// $Id$
//==============================================================================
// FileName TestString.java
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
package test;

public class TestString {
/**====================================================== 
 * @name   TestString Class
 * @author patrick@nelware.com  
 **====================================================*/


  public static void main(String[] args) {
  //-----------------------------------------------------
    String aLine = "neldad.npn   dude" ;
    System.out.println("-aLine -> "+aLine) ;
    int spaceIndex = aLine.indexOf(' ') ;
    if (spaceIndex == -1) {
      System.out.println("Invalid line") ;
    }
    System.out.println("before while -> "+spaceIndex) ;
    while ( true ) {
      if ( aLine.charAt(spaceIndex+1) == ' ' ) {
        spaceIndex++ ;
        System.out.println("-in while -> "+spaceIndex) ;
        continue ;
      }
      System.out.println("-breaking while -> "+spaceIndex) ;
      break ;
    }
    String host = aLine.substring(0,spaceIndex) ;
    String student = aLine.substring(spaceIndex+1) ;
    System.out.println("Read: "+student+"@"+host) ;
  } //---eom---

} //===eoc===


/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/* notes
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-------------------------------------------------------------------------------

-------------------------------------------------------------------------------
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
