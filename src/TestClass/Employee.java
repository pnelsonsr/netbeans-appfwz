// $Id: java-head-netbeans 65 2008-10-15 20:56:34Z root $
//==============================================================================
// FileName Employee.java
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
package TestClass;

import java.util.Date ;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//=======================================================
/**
 * Base Class for Employee
 * @aNam   Employee Class
 * @author patrick@nelware.com
 */
public class Employee {
//=======================================================

  //---------Begin Attributes---------
  private static final double BASE_SALARY = 15000.00;
  private static final String DATE_FORMAT = "MM/dd/yy";
  private String name;
  private double salary;
  private Date   dob;
  //----------End Attributes----------

  //--------Begin Constructors--------
  public Employee() {
    name   = "XXX";
    salary = BASE_SALARY;
    dob    = null;
  }
  public Employee(String aNam, double aSal, Date aDOB) {
    name   = aNam;
    salary = aSal;
    dob    = aDOB;
  }
  public Employee(String aNam, double aSal) {
    this(aNam, aSal, null);
  }
  public Employee(String aNam, Date aDOB) {
    this(aNam, BASE_SALARY, aDOB);
  }
  public Employee(String aNam) {
    this(aNam, BASE_SALARY);
  }
  //---------End Constructors---------

  //-----------Begin Methods----------
  public String getDetails() {
    String ret = "Name:   " + name + "\n" +
                 "Salary: " + salary + "\n" +
                 "DOB:    " + dob ;
    if ( dob != null ) {
      String dateFormat = DATE_FORMAT;
      DateFormat sdf =  new SimpleDateFormat(dateFormat);
      ret="Name:   " + name   + "\n" +
          "Salary: " + salary + "\n" +
          "DOB:    " + sdf.format(dob) ;
    }
    return ret;
  }
  //------------End Methods-----------

} //===eoc===


/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/* notes
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-------------------------------------------------------------------------------
//    System.out.println("In name-salary-dob method ");
//    System.out.println(" aDOB   -> " + aDOB);
//    System.out.println(" dob    -> " + dob);
//    String dateFormat = DATE_FORMAT;
//    DateFormat sdf =  new SimpleDateFormat(dateFormat);
//    System.out.println(" format -> " + sdf.format(dob));
//    System.out.println("In name-salary method ");
//    System.out.println("In name-dob method ");
//    System.out.println("In getDetails");
//    System.out.println(" dob    -> " + dob);
//      System.out.println(" no format -> " + dob);
//      System.out.println(" w/ format -> " + sdf.format(dob));
-------------------------------------------------------------------------------
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
