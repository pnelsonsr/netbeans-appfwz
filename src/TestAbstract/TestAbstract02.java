package TestAbstract;

public class TestAbstract02 {
  public static void main(String argv[]){
    TestAbstract02 m = new TestAbstract02();
    m.go();
  }
  public void go(){
    Great g = new Great();
    g.show();
  }
  private class Great{
    public void show(){
      System.out.println("Show");     
    }
  }
}