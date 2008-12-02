// $Id$
//===========================================================================
// FileName TestMenuColor01.java
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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestMenuColor01 implements ActionListener, ItemListener {
/**-------------------------------------------------------------------------- 
 * @name   TestMenuColor01 Class
 * @author patrick@nelsons.name  
 **------------------------------------------------------------------------*/

  //---------Begin Attributes---------
  private JFrame    window;
  private JMenuBar  mBar ;
  private JMenu mMain01,mMain02,mMain03 ;
  private JCheckBoxMenuItem mCkBx01,mCkBx02,mCkBx03,mCkBx04,mCkBx05,mCkBx06;
  //----------End Attributes----------
  
  public static void main(String[] args) { 
  //-----------------------------------------------------
    TestMenuColor01 MyMenu = new TestMenuColor01(); 
    MyMenu.init();
	} //---eom---

  //--------Begin Constructors--------
  public TestMenuColor01() { }
  //---------End Constructors---------
    
  //-----------Begin Methods----------
  public void init() {
    window = new JFrame("PJ Color Menu");
    mBar = new JMenuBar();
    // Menu Setup
    mMain01 = new JMenu("File");
    mMain02 = new JMenu("Edit");
    mMain03 = new JMenu("Help");
    mBar.add(mMain01);
    mBar.add(mMain02);
    mBar.add(mMain03);
    window.setJMenuBar(mBar) ;
    // File
    mCkBx01 = new JCheckBoxMenuItem("New") ;
    mCkBx02 = new JCheckBoxMenuItem("Save") ;
    mCkBx03 = new JCheckBoxMenuItem("Load") ;
    mCkBx04 = new JCheckBoxMenuItem("Quit") ;
    mCkBx05 = new JCheckBoxMenuItem("Persistent") ;
    mCkBx06 = new JCheckBoxMenuItem("About") ;
    mCkBx01.addItemListener(this);
    mCkBx02.addItemListener(this);
    mCkBx03.addItemListener(this);
    mCkBx04.addItemListener(this);
    mCkBx05.addItemListener(this);
    mCkBx06.addItemListener(this);
    mMain01.add(mCkBx01);
    mMain01.add(mCkBx02);
    mMain01.add(mCkBx03);
    mMain01.addSeparator() ;
    mMain01.add(mCkBx04);
    mMain02.add(mCkBx05);
    mMain03.add(mCkBx06);
    // Colors
    Color purple = new Color(255,0,255) ;
    mMain01.setForeground(Color.BLUE);
    mMain02.setForeground(Color.BLACK);
    mMain03.setForeground(Color.GRAY);
    mCkBx01.setForeground(Color.GREEN);mCkBx01.setBackground(Color.BLUE  ) ;
    mCkBx02.setForeground(Color.GREEN);mCkBx02.setBackground(Color.RED   ) ;
    mCkBx03.setForeground(Color.BLACK);mCkBx03.setBackground(Color.WHITE ) ;
    mCkBx04.setForeground(Color.BLUE );mCkBx04.setBackground(Color.YELLOW) ;
    mCkBx05.setForeground(Color.BLACK);mCkBx05.setBackground(Color.PINK  ) ;
    mCkBx06.setForeground(Color.WHITE);mCkBx06.setBackground(purple      ) ;
    // Window Display
    window.setSize(300,300);
    window.setVisible(true);
  }
  public void actionPerformed( ActionEvent argAE ) {
    String me,dad ;
    JMenuItem target = (JMenuItem) argAE.getSource() ;
    me = target.getActionCommand() ;
    if (me.equals("New")  || me.equals("Save") || 
        me.equals("Load") || me.equals("Quit")   ) dad = "File" ;
    else if (me.equals("Persistent"))              dad = "Edit" ;
    else if (me.equals("About"))                   dad = "Help" ;
    else                                           dad = "????" ;
    System.out.println("\""+dad+"\""+" Menu Item \""+me+"\" was pressed") ; 
    if (me.equals("Quit")) { System.exit(0) ; }
  }
  public void itemStateChanged( ItemEvent argIE ) {
    String state,me,dad ;
    state=(argIE.getStateChange()==ItemEvent.SELECTED)?"checked":"un-checked" ;
    JCheckBoxMenuItem target = (JCheckBoxMenuItem) argIE.getSource() ;
    me = target.getActionCommand() ;
    if (me.equals("New")  || me.equals("Save") || 
        me.equals("Load") || me.equals("Quit")   ) dad = "File" ;
    else if (me.equals("Persistent"))              dad = "Edit" ;
    else if (me.equals("About"))                   dad = "Help" ;
    else                                           dad = "????" ;
    System.out.println("\""+dad+"\""+" Menu Checkbox \""+me+"\" was "+state) ; 
    if (me.equals("Quit")) { System.exit(0) ; }
  }
  //------------End Methods-----------

} //---eoc---


/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/* notes
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-------------------------------------------------------------------------------

-------------------------------------------------------------------------------
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
