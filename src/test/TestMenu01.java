// $Id$
//===========================================================================
// FileName TestMenu01.java
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
        
import java.awt.event.* ;
import javax.swing.* ;

public class TestMenu01 implements ActionListener, ItemListener {
/**-------------------------------------------------------------------------- 
 * @name   TestMenu01 Class
 * @author patrick@nelsons.name  
 **------------------------------------------------------------------------*/

  //---------Begin Attributes---------
  private JFrame window ;
  private JMenuBar mBar ;
  private JMenu mMain01,mMain02,mMain03 ;
  private JMenuItem mItem01,mItem02,mItem03,mItem04,mItem05 ;
  private JCheckBoxMenuItem mCkBx01 ;
  //----------End Attributes----------
  
  public static void main ( String args[] ) {
  //-----------------------------------------------------
    TestMenu01 MyMenu = new TestMenu01() ;
    MyMenu.frame() ;
	} //---eom---

  //--------Begin Constructors--------
  public TestMenu01() { }
  //---------End Constructors---------
    
  //-----------Begin Methods----------
  public void frame() {
    window  = new JFrame("Menu") ;
    // Menu Setup
    mBar    = new JMenuBar() ;
    mMain01 = new JMenu("File") ;
    mMain02 = new JMenu("Edit") ;
    mMain03 = new JMenu("Help") ;
    mBar.add(mMain01) ;
    mBar.add(mMain02) ;
    mBar.add(mMain03) ;
    window.setJMenuBar(mBar) ; 
    // File
    mItem01 = new JMenuItem("New" ) ;
    mItem02 = new JMenuItem("Save") ;
    mItem03 = new JMenuItem("Load") ;
    mItem04 = new JMenuItem("Quit") ;
    mItem01.addActionListener(this) ;
    mItem02.addActionListener(this) ;
    mItem03.addActionListener(this) ;
    mItem04.addActionListener(this) ;
    mMain01.add(mItem01) ;
    mMain01.add(mItem02) ;
    mMain01.add(mItem03) ;
    mMain01.addSeparator() ;
    mMain01.add(mItem04) ;
    // Edit
    mCkBx01 = new JCheckBoxMenuItem("Persistent") ;
    mCkBx01.addItemListener(this) ;
    mMain02.add(mCkBx01) ;
    // Help
    mItem05 = new JMenuItem("About") ;
    mItem05.addActionListener(this) ;
    mMain03.add(mItem05) ;
    // Window Display
    window.setSize(200,200) ;
    window.setVisible(true) ;
  }
  public void actionPerformed( ActionEvent argAE ) {
    String me,dad ;
    JMenuItem target = (JMenuItem) argAE.getSource() ;
    me = target.getActionCommand() ;
    if      (me.equals("New")  || 
             me.equals("Save") || 
             me.equals("Load") || 
             me.equals("Quit")      ) dad = "File" ;
    else if (me.equals("Persistent")) dad = "Edit" ;
    else if (me.equals("About")     ) dad = "Help" ;
    else                              dad = "????" ;
    System.out.println("\""+dad+"\""+" Menu Item \""+me+"\" was pressed") ; 
    if (me.equals("Quit")) { System.exit(0) ; }
  }
  public void itemStateChanged( ItemEvent argIE ) {
    String state,me,dad ;
    state=(argIE.getStateChange()==ItemEvent.SELECTED)?"checked":"un-checked" ;
    JCheckBoxMenuItem target = (JCheckBoxMenuItem) argIE.getSource() ;
    me = target.getActionCommand() ;
    if      (me.equals("New")  || 
             me.equals("Save") || 
             me.equals("Load") || 
             me.equals("Quit")      ) dad = "File" ;
    else if (me.equals("Persistent")) dad = "Edit" ;
    else if (me.equals("About")     ) dad = "Help" ;
    else                              dad = "????" ;
    System.out.println("\""+dad+"\""+" Menu Checkbox \""+me+"\" was "+state) ; 
  }
  //------------End Methods-----------

} //---eoc---


/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/* notes
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
String state = (argIE.getStateChange()==ItemEvent.SELECTED)?"checked":"un-checked" ;
JCheckBoxMenuItem target = (JCheckBoxMenuItem) argIE.getSource();
dad = (me.equals("Persistent"))? "Edit" : "No Idea" ; 
Menu me = argIE.getItem() ;
Component Parent = mItem04.getParent() ;
System.out.println("Menu Checkbox \"Persistant\" was " + state) ; 
System.out.println("dad -> " + dad) ; 
-------------------------------------------------------------------------------
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/