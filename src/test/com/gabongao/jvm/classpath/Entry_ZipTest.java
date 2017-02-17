package test.com.gabongao.jvm.classpath; 

import com.gabongao.jvm.classpath.Entry_Zip;
import junit.framework.Test;
import junit.framework.TestSuite; 
import junit.framework.TestCase; 

/** 
* Entry_Zip Tester. 
* 
* @author <Authors name> 
* @since <pre>02/17/2017</pre> 
* @version 1.0 
*/ 
public class Entry_ZipTest extends TestCase { 
public Entry_ZipTest(String name) { 
super(name); 
} 

public void setUp() throws Exception { 
super.setUp(); 
} 

public void tearDown() throws Exception { 
super.tearDown(); 
} 

/** 
* 
* Method: readClass(String className) 
* 
*/ 
public void testReadClass() throws Exception { 
//TODO: Test goes here...
    Entry_Zip entry_zip = new Entry_Zip("C:\\Program Files\\Java\\jdk1.8.0_77\\jre\\lib\\jfxswt.jar");
    entry_zip.readClass("javafx/embed/swt/CustomTransfer.class");
} 

/** 
* 
* Method: toString() 
* 
*/ 
public void testToString() throws Exception { 
//TODO: Test goes here... 
} 



public static Test suite() { 
return new TestSuite(Entry_ZipTest.class); 
} 
} 
