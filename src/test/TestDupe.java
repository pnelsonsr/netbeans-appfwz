// $Id$
//==============================================================================
// FileName TestDupe.java
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

import java.io.*;
import java.util.*;
import java.util.zip.*;

/**
 * Command line program to find and list duplicate files.
 * Requires Java 1.2 or higher.
 * Run with file and directory names as arguments.
 * @name   TestDupe Class
 * @author patrick@nelware.com  
 */
public class TestDupe {
//====================================================== 

 //---------Begin Attributes---------
	private static final String SEP = "\t";
  //----------End Attributes----------
  
  //--------Begin Constructors--------
  public TestDupe() { }
  //---------End Constructors---------
    
  //-----------Begin Methods----------
	public static void addFile(List files, File file)
	throws IOException {
		String fullName = file.getCanonicalPath();
		files.add(new FileInfo(fullName, new Long(file.length())));
	}
	public static void addDirEntry(List files, File dirEntry)
	throws IOException {
		if (dirEntry.isFile()) {
			addFile(files, dirEntry);
		} else
		if (dirEntry.isDirectory()) {
			File[] entries = dirEntry.listFiles();
			for (int i = 0; i < entries.length; i++) {
				addDirEntry(files, entries[i]);
			}
		}
	}
	/**
	 * Creates a checksum on the file denoted by the argument object
	 * and stores the checksum in the argument object.
	 * On I/O error, simply does not store a checksum.
	 * @param fileInfo file descriptor
	 */
	public static void createChecksum(FileInfo fileInfo) {
		InputStream in = null;
		try
		{
			System.out.print(fileInfo.getName());
			in = new FileInputStream(fileInfo.getName());
			byte[] buffer = new byte[4 * 1024];
			int numBytesRead;
			Checksum checksum = new CRC32();
			checksum.reset();
			while ((numBytesRead = in.read(buffer)) >= 0) {
				checksum.update(buffer, 0, numBytesRead);
			}
			in.close();
			long value = checksum.getValue();
			fileInfo.setChecksum(new Long(value));
			System.out.println(SEP + Long.toHexString(value));
		}
		catch (IOException ioe)
		{
			if (in != null) {
				try {
					in.close();
				} catch (IOException ioe2) {
					// ignore
				}
			}
		}
	}
	/**
	 * Creates a List of List objects where each of the contained List objects
	 * stores FileInfo objects which are equal according to the given Comparator.
	 * Side effect: may change order of elements in input list.
	 */
	public static List createDuplicateLists(List input, Comparator comp) {
		List result = new ArrayList();
		// return empty list for empty input
		if (input.size() < 1) {
			return result;
		}
		// sort input in ascending order according to Comparator
		Collections.sort(input, comp);
		// declare and initialize variables prev, list and index
		FileInfo prev = (FileInfo)input.get(0);
		List list = new ArrayList();
		list.add(prev);
		result.add(list);
		int index = 1;
		// run over input list, creating new sublists
		while (index < input.size()) {
			FileInfo fileInfo = (FileInfo)input.get(index++);
			if (comp.compare(prev, fileInfo) == 0) {
				list.add(fileInfo);
			} else {
				list = new ArrayList();
				list.add(fileInfo);
				result.add(list);
			}
			prev = fileInfo;
		}
		return result;
	}
	private static long dump(List duplicates) {
		FileInfo fileInfo = (FileInfo)duplicates.get(0);
		long size = fileInfo.getSize().longValue();
		System.out.print(size);
		Iterator iter = duplicates.iterator();
		while (iter.hasNext()) {
			fileInfo = (FileInfo)iter.next();
			System.out.print(SEP + fileInfo.getName());
		}
		System.out.println();
		return (duplicates.size() - 1) * size;
	}
	/**
	 * Create a simple list of objects from a list of list of objects.
	 * @param input list of lists
	 * @return new list with all elements contained in the input list's list elements
	 */
	public static List mergeListOfLists(List input) {
		Iterator iter = input.iterator();
		List result = new ArrayList(input.size());
		while (iter.hasNext()) {
			List list = (List)iter.next();
			result.addAll(list);
		}
		return result;
	}
	public static void processDuplicates(List duplList) {
		Iterator iter = duplList.iterator();
		long savings = 0;
		while (iter.hasNext()) {
			savings += dump((List)iter.next());
		}
		System.out.println("Combined size of duplicates in bytes: " + savings);
	}
	/**
	 * From the argument list of lists remove all lists with more than
	 * one entry.
	 * @param duplList list of lists
	 */
	public static void removeDuplicateLists(List duplList) {
		Iterator iter = duplList.iterator();
		while (iter.hasNext()) {
			List list = (List)iter.next();
			if (list.size() > 1) {
				iter.remove();
			}
		}
	}
	public static List removeDuplicateNameEntries(List files) {
		List duplList = createDuplicateLists(files, new FileInfoNameComparator());
		removeDuplicateLists(duplList);
		return mergeListOfLists(duplList);
	}
	public static void removeSingleElementLists(List duplList) {
		Iterator iter = duplList.iterator();
		while (iter.hasNext()) {
			List list = (List)iter.next();
			if (list.size() == 1) {
				iter.remove();
			}
		}
	}
	/**
	 * Create a list of lists of FileInfo objects which share the same
	 * checksum and size and return that list.
	 * @param input files list of FileInfo objects
	 * @return List of List of FileInfo duplicates
	 */
	public static List removeUniqueChecksumSizeEntries(List files) {
		List duplList = createDuplicateLists(files, new FileInfoChecksumSizeComparator());
		removeSingleElementLists(duplList);
		return duplList;
	}
	public static List removeUniqueSizeEntries(List files) {
		List duplList = createDuplicateLists(files, new FileInfoSizeComparator());
		removeSingleElementLists(duplList);
		return mergeListOfLists(duplList);
  }
  //------------End Methods-----------
    
	public static void main(String[] args) throws IOException {
  //-----------------------------------------------------
		System.out.println("Creating list of files to be compared...");
		// find all files specified by args and put them in a list
		List files = new ArrayList();
		for (int i = 0; i < args.length; i++) {
			addDirEntry(files, new File(args[i]));
		}
		// remove duplicate list elements by file name
		files = removeDuplicateNameEntries(files);
		// remove all files that have a unique file size
		files = removeUniqueSizeEntries(files);
		if (files.size() <= 1) {
			return;
		}
		// create checksums on remaining files
		Iterator iter = files.iterator();
		while (iter.hasNext()) {
			createChecksum((FileInfo)iter.next());
		}
		// remove unique files (by size and checksum)
		List duplList = removeUniqueChecksumSizeEntries(files);
		// process duplicates
		processDuplicates(duplList);
  } //---eom---

} //===eoc===


/**
 * Data class to store name, size and checksum of a file.
 */
class FileInfo {
//====================================================== 
	private final String name;
	private final Long size;
	private Long checksum;

	public FileInfo(String fileName, Long fileSize) {
		name = fileName;
		size = fileSize;
	}

	public int compareChecksumAndSizes(FileInfo fi) {
		int relChecksum = checksum.compareTo(fi.checksum);
		int relSize = compareSizes(fi);
		if (relChecksum == 0 && relSize == 0) {
			return 0;
		} else {
			if (relChecksum != 0) {
				return relChecksum;
			} else {
				return relSize;
			}
		}
	}

	public int compareNames(FileInfo fi) {
		return name.compareTo(fi.name);
	}

	public int compareSizes(FileInfo fi) {
		return size.compareTo(fi.size);
	}

	public String getName() {
		return name;
	}

	public Long getSize() {
		return size;
	}

	public boolean isChecksumEqual(Long ch) {
		return checksum != null && ch != null && checksum.equals(ch);
	}

	public void setChecksum(Long fileChecksum) {
		checksum = fileChecksum;
	}
}

/**
 * Comparator to compare names of FileInfo objects.
 */
class FileInfoNameComparator implements Comparator {
//====================================================== 
	public int compare(Object obj1, Object obj2) {
		FileInfo fi1 = (FileInfo)obj1;
		FileInfo fi2 = (FileInfo)obj2;
		return fi1.compareNames(fi2);
	}
}

/**
 * Comparator to compare sizes of FileInfo objects.
 */
class FileInfoSizeComparator implements Comparator {
//====================================================== 
	public int compare(Object obj1, Object obj2) {
		FileInfo fi1 = (FileInfo)obj1;
		FileInfo fi2 = (FileInfo)obj2;
		return fi1.compareSizes(fi2);
	}
}

/**
 * Comparator to compare sizes of FileInfo objects.
 */
class FileInfoChecksumSizeComparator implements Comparator {
//====================================================== 
	public int compare(Object obj1, Object obj2) {
		FileInfo fi1 = (FileInfo)obj1;
		FileInfo fi2 = (FileInfo)obj2;
		return fi1.compareChecksumAndSizes(fi2);
	}
}


/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/* notes
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-------------------------------------------------------------------------------

-------------------------------------------------------------------------------
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

