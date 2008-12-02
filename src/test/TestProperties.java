// $Id$
//===========================================================================
// FileName TestTread01.java
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
package test ;

import java.util.Properties;

public class TestProperties {
/**-------------------------------------------------------------------------- 
 * @name   TestProperties Class
 * @author patrick@nelsons.name  
 **------------------------------------------------------------------------*/

  public static void main(String[] args) {
  //-----------------------------------------------------
		Properties props = System.getProperties();
		props.list(System.out);
	} //---eom---
  
} //---eoc---


/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/* notes
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
