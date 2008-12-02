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

//---------------------------------------------------------------------------
public class TestTread01 {
/**-------------------------------------------------------------------------- 
 * @name   TestTread01 Class
 * @author patrick@nelsons.name  
 **------------------------------------------------------------------------*/

  public static void main(String args[]) {
  //-----------------------------------------------------
    int i = 1 ; 
    boolean stop = false ; 
    String tcPriority ;
    Thread me = Thread.currentThread() ;
		ThreadController tc = new ThreadController() ;
		tc.startThread() ;
    while ( ! stop ) {
      System.out.println(me.getName()+" -> "+i++) ;
      if ( i%10==0 ) { 
        if      ( tc.getPriority()== 10 ) { tcPriority = "MAX (or 10)"; }
        else if ( tc.getPriority()== 5  ) { tcPriority = "Normal (or 5)"; }
        else if ( tc.getPriority()== 1  ) { tcPriority = "LOW (or 1)"; }
        else { tcPriority = "????";}
        System.out.println(
          tc.getName()+" is "+((tc.getState())?"ALIVE":"DEAD")+
          " with priority of "+tcPriority
        ) ;
        //tc.setPriority(Thread.MAX_PRIORITY);
        //tc.setPriority(Thread.NORM_PRIORITY);
        //tc.setPriority(Thread.MIN_PRIORITY);
        try{ me.sleep(1); } catch ( InterruptedException e ){ }
      }
      if ( i>100 ) { stop=true;tc.stopThread(); }
    }
    System.out.println(me.getName()+" -> COMPLETED") ;
	} //---eom---

} //---eoc---

class Runner implements Runnable {
/**--------------------------------------------------------------------------
 * @name   Runner Class
 * @author patrick@nelsons.name  
 **------------------------------------------------------------------------*/

  //---------Begin Attributes---------
  private boolean stop ;
  //----------End Attributes----------
	
  //-----------Begin Methods----------
	public void run() {
    int i = 1 ; 
    Thread me = Thread.currentThread() ;
    while ( ! stop ) {
      System.out.println(me.getName()+" -> "+i++) ;
      if ( i%10==0 ) { try{me.sleep(1);}catch(InterruptedException e){} }
      if ( i>100 ) { kill(); }
    }
    System.out.println(me.getName()+" -> COMPLETED") ;
  }
  public void kill() {
    stop = true ;
  }
  //------------End Methods-----------

} //---eoc---

class ThreadController {
/**-------------------------------------------------------------------------- 
 * @name   TreadController Class
 * @author patrick@nelsons.name  
 **-----------------------------------------------------------------------*/

  //---------Begin Attributes---------
  private Runner r = new Runner() ;
	private Thread t = new Thread(r) ;
  //----------End Attributes----------
	
  //-----------Begin Methods----------
	public void    startThread() { t.start(); }
  public void    stopThread()  { r.kill(); }
  public boolean getState()    { return t.isAlive(); }
  public String  getName()     { return t.getName(); }
  public int     getPriority() { return t.getPriority(); }
  public void    setPriority(int argNew) { t.setPriority(argNew); }
  //------------End Methods-----------

} //---eoc---


/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/* notes
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-------------------------------------------------------------------------------

-------------------------------------------------------------------------------
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
