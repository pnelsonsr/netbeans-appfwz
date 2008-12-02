// $Id: java-head-netbeans 65 2008-10-15 20:56:34Z root $
//==============================================================================
// FileName TestAbstract03.java
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
package TestAbstract;

/**non public class package*/
class C1 {
    private String str = "";
    public void setStr(String str) {
      this.str = str;
    }
}

/**abstract class for the private class*/
abstract class AbsClass {
  protected C1 c1;
  public C1 getC1(){
    return c1;
  }
  public void createC1(){
    c1 = new C1();
  }
  public abstract void doStr();
}

/**method for the private class*/
class A extends C1 {
  public void doStr() {
    this.setStr("strs");
  }
}

/**public class*/
class B {
  private AbsClass absClass;
  public void setAbsClass(AbsClass aC) {
    absClass = aC ;
  }
  public C1 getC1() {
    return absClass.getC1() ;
  }
  public void constructC1() {
    absClass.createC1() ;
  }
}

class TestAbstract03 {
    public static void main(String[] args) {
    // create new public class
    B b = new B();
    // get private methods or get the private class instead
    AbsClass absClass = new A();
    // from here on you import from C1 to B through your methods in A
    b.setAbsClass(absClass);
  }
}















