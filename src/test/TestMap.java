// $Id$
//==============================================================================
// FileName TestMap.java
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
package test;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Tests HashMap creation and interator printing
 * @name   TestMap Class
 * @author patrick@nelware.com
 */
public class TestMap {
//======================================================

  public static void main(String[] args) {
  //-----------------------------------------------------
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("one", "1st");
    map.put("two", Integer.valueOf(2));
    map.put("three", "3rd");
    System.out.println("map.keySet()   -> " + map.keySet());
    System.out.println("map.values()   -> " + map.values());
    System.out.println("map.entrySet() -> " + map.entrySet());
    System.out.println("--------------------------------------------------- 1");
    map.put("three", "III");
    System.out.println("map.keySet()   -> " + map.keySet());
    System.out.println("map.values()   -> " + map.values());
    System.out.println("map.entrySet() -> " + map.entrySet());
    System.out.println("--------------------------------------------------- 2");
    System.out.println("one   -> " + map.get("one"));
    System.out.println("two   -> " + map.get("two"));
    System.out.println("three -> " + map.get("three"));
    System.out.println("--------------------------------------------------- 3");
    Iterator mapIt = map.keySet().iterator();
    while (mapIt.hasNext()) {
      String hashCode = mapIt.next().toString();
      System.out.println(hashCode + " -> " + map.get(hashCode));
    }
    System.out.println("--------------------------------------------------- 4");
    for(Object oMyObj : map.entrySet()) {
     Map.Entry entry = (Map.Entry) oMyObj;
     System.out.println(entry.getKey() + " -> " + entry.getValue());
    }
    System.out.println("-------------------------------------------------- 5");
    for(Object key: map.keySet()){
      System.out.println(key + " -> " + map.get(key));
    }
    System.out.println("-------------------------------------------------- 6");
  } //---eom---

} //===eoc===

/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//++ notes
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

-------------------------------------------------------------------------------
  @SuppressWarnings("unchecked") //goes befor method
    Map<String, Object> map = new HashMap();
    Map<String,String> map = new HashMap();
    Map<Object,Object> map = new HashMap();
    Map map = new HashMap();
    map.put("two", "2nd");
    map.put("two", new Integer(2));  //creates obj
-------------------------------------------------------------------------------
 // yes
    for (String key: map.keySet()) {
      System.out.println(key + " -> " + map.get(key));
    }
-------------------------------------------------------------------------------
// yes
    for (Map.Entry entry : map.entrySet()){
      System.out.println(entry.getKey() + " -> " + entry.getValue());
    }
-------------------------------------------------------------------------------
// yes
    Iterator mapIt = map.keySet().iterator();
    while (mapIt.hasNext()) {
      String hashCode = mapIt.next().toString();
      System.out.println(hashCode + " -> " + map.get(hashCode) );
    }
-------------------------------------------------------------------------------
// yes
    Collection c = map.values();
    Iterator it = c.iterator();
    while(it.hasNext()) {
      String hc2 = it.next().toString();
      System.out.println(hc2 + " -> " + map.get(hc2) );
    }
-------------------------------------------------------------------------------
// yes
    Collection c = map.values();
    Iterator it = c.iterator();
    while(it.hasNext()) {
      System.out.println(it.next());
    }
-------------------------------------------------------------------------------
// no
   for ( Integer s : map.keySet() ) {

   }
-------------------------------------------------------------------------------
// no
    Collection<HashMap> col = map.values();
    for (HashMap nl: col){
      System.out.println(nl.toString());
    }
-------------------------------------------------------------------------------
// no
    Collection col = map.values();
    for (Iterator<HashMap> i=col.iterator();i.hasNext();) {
      String hc2 = i.next().toString();
      System.out.println(hc2);
      System.out.println(hc2 + " -> " + map.get(hc2) );
    }
-------------------------------------------------------------------------------
// yes
    Set mapSet = map.entrySet();
    Iterator mapIt2 = mapSet.iterator();
    while (mapIt2.hasNext()) {
      Map.Entry entry = (Map.Entry) mapIt2.next();
      System.out.println(entry.getKey() + " -> " + entry.getValue());
    }
-------------------------------------------------------------------------------
// no
    Collection<HashMap> colIt = map.values();
    for (HashMap hm : colIt) {
      System.out.println(" -> " + hm.hc2());;
    }
-------------------------------------------------------------------------------
// no
    while ( true ) {
      map.values()
    }
-------------------------------------------------------------------------------
// no
    HashMap hmMapArgs  = (HashMap)   JPO.unpackArgs(args);
    HashMap hmParamMap = (HashMap)   hmMapArgs.get("paramMap");
    String sObjectId   = ((String[]) hmParamMap.get("objectId"))[0];
-------------------------------------------------------------------------------
// no
  public HashMap IsRevisionAllowed(Context aCtx, String[] args) throws Exception
  {
    logger.debug("Enter");
    HashMap hmMapArgs  = (HashMap) JPO.unpackArgs(args);
    HashMap hmParamMap = (HashMap) hmMapArgs.get("paramMap");
    String sObjectId   = (String)  hmParamMap.get("objectId");
  }
-------------------------------------------------------------------------------
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

