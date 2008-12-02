/** TestAbstract04.java
*/
package TestAbstract;

class Parent {
  private final void privFinal() {
    System.out.println("Parent.privFinal()");
  }
  private void priv() {
    System.out.println("Parent.priv()");
  }
  public final void invoke() {
    privFinal();
    priv();
  }
}

/** Child .
// warning: "Exporting non-public type through public API" from IDE.
*/
public class TestAbstract04 extends Parent {
  private void privFinal() {
    System.out.println("Child.privFinal()");
  }
  private void priv() {
    System.out.println("Child.priv()");
  }
  public static void main( String [] args ) {
    Parent child = new TestAbstract04();
    child.invoke();
  }
}