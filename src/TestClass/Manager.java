// $Id$
//==============================================================================
// FileName Manager.java
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

import java.util.Date;
import java.util.Calendar;

//=======================================================
/**
 * Class for extending Employee Class
 * @name   Manager Class
 * @author patrick@nelware.com
 */
public class Manager extends Employee {
//=======================================================

  //---------Begin Attributes---------
  private String department;
  //----------End Attributes----------

  //--------Begin Constructors--------
  public Manager() { // This code fails: no super()
    department = "Unknown";
  }
  public Manager(String name, double salary, Date dob, String dept) {
    super(name, salary, dob);
    department = dept;
  }
  public Manager(String name, double salary, String dept) {
    super(name, salary);
    department = dept;
  }
  public Manager(String name, String dept) {
    super(name);
    department = dept;
  }
  public Manager(String dept) { // This code fails: no super()
    department = dept;
  }
  //---------End Constructors---------

  //-----------Begin Methods----------
  @Override
  public String getDetails() {
    // call parent method
    String ret = super.getDetails() + "\nOrg:    " + department;
    return ret;
  }
  //------------End Methods-----------

  public static void main(String[] args) {
  //-----------------------------------------------------
    Calendar c1 = Calendar.getInstance();
    c1.set(1961, 0, 1);
    Date d1 = new Date();
    d1 = c1.getTime();
    Employee e = new Employee();
    Manager m = new Manager("Patrick Nelson", 10000 , d1, "R&D");
    System.out.println(" -- > e <-- \n" + e.getDetails());
    System.out.println(" -- > m <-- \n" + m.getDetails());
    Employee r = new Manager();
    System.out.print(" -- > r <-- \n" + r.getDetails());
    TaxService ts = new TaxService();
    System.out.println(ts.getTaxRate(r));
  } //---eom---

} //===eoc===



/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/* notes
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-------------------------------------------------------------------------------
//    Manager m = new Manager();
//    Manager m = new Manager("Patrick Nelson",10000,"R&D");
//    Manager m = new Manager("Patrick Nelson","R&D");
//    Manager m = new Manager("R&D");
-------------------------------------------------------------------------------
//    System.out.println("Date no format -> " + d1);
//    System.out.println("Date w/ format -> " + sdf.format(d1));
-------------------------------------------------------------------------------
//import java.util.Date ;
//import test.*;
//
//class Employee {
//  private String name;
//  private double salary;
//  private Date   dob;
//
//  public String getDetails() {
//    String ret="Name:     " + name +
//               "\nSalary: " + salary +
//               "\nDOB:    " + dob ;
//    return ret;
//  }
//}
-------------------------------------------------------------------------------
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
