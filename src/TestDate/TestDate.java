// $Id$
//==============================================================================
// FileName TestDate.java
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
package TestDate;

import java.util.Date;
import java.util.Calendar;
//import java.util.TimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//=======================================================
/**
 * Class for Testing Java Date
 * @name   TestDate Class
 * @author patrick@nelware.com
 */
public class TestDate {
  //---------Begin Attributes---------
  private static final String DATE_FORMAT = "MM/dd/yy";
  private Date dob;
  //----------End Attributes----------

  //--------Begin Constructors--------
  public TestDate() {
    dob=null;
  }
  public TestDate(Date dob) {
    this.dob = dob;
  }
  //---------End Constructors---------

  public static void main(String[] args) {
  //-----------------------------------------------------
    System.out.println();
    System.out.println("In the Main Operation");
    TestDate td = new TestDate();
    DateFormat sdf =  new SimpleDateFormat(DATE_FORMAT);
    Calendar c1 = Calendar.getInstance();
    Date d1 = new Date();
    c1.set(1961, 1, 8);
    d1 = c1.getTime();
    System.out.println("Date in Calendar Object Format : "+c1);
    System.out.println("c1.getTime() : "+c1.getTime());
    System.out.println("c1 YEAR): " + c1.get(Calendar.YEAR));
    System.out.println("c1 MONTH): " + c1.get(Calendar.MONTH));
    System.out.println("c1 DATE): " + c1.get(Calendar.DATE));
    System.out.println("c1 DOW): " + c1.get(Calendar.DAY_OF_WEEK));
    System.out.println("c1 DOWIM): " + c1.get(Calendar.DAY_OF_WEEK_IN_MONTH));
    System.out.println("c1 JUILIAN): " + c1.get(Calendar.DAY_OF_YEAR));
    System.out.println("Todays date in Date Format : "+d1);
    c1.set(1999,0 ,20);
    System.out.println("c1.set(1999,0 ,20) : "+sdf.format(c1.getTime()));
    int dayz = 2;
    c1.add(Calendar.DATE,dayz);
    System.out.println("Date + "+dayz+" days is : " + sdf.format(c1.getTime()));
    System.out.println("Date format again : " + sdf.format(d1));
    System.out.println();
  } //---eom---

} //===eoc===


/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/* notes
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-------------------------------------------------------------------------------

-------------------------------------------------------------------------------
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
