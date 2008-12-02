package TestAbstract;

//import TestAbstract.TestAbstract02 ;
abstract class Base {
  abstract int lamprey();
}

public class TestAbstract01 extends Base {
//  public static void main(String argv[]){
//    TestAbstract01 ta = new TestAbstract01();
//    System.out.println("main -> " + ta.lamprey());
//  }
  public int lamprey(){
    System.out.println("lamprey");
    return 99;
  }
//  native public void mynative();
}

//class InnerClass {
//  public void m3() { }
//}
//
//public class TestAbstract01 {
//  public InnerClass m1() {
//    return new InnerClass();
//  }
//
//  public void m2(final InnerClass innerClass) { }
//
//  public static void main(String[] args) {
//    final TestAbstract01 callee = new TestAbstract01();
//    callee.m1();
//    callee.m1().m3();
//    callee.m2(null);
//  }
//}
