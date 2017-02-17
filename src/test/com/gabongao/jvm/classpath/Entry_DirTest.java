package test.com.gabongao.jvm.classpath; 

import com.gabongao.jvm.classpath.Entry_Dir;
import junit.framework.Test;
import junit.framework.TestSuite; 
import junit.framework.TestCase; 

/** 
* Entry_Dir Tester. 
* 
* @author <Authors name> 
* @since <pre>02/17/2017</pre> 
* @version 1.0 
*/ 
public class Entry_DirTest extends TestCase { 
public Entry_DirTest(String name) { 
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
    Entry_Dir entry_dir = new Entry_Dir("D:\\Programming\\Java\\JVM\\out\\production\\JVM\\com\\gabongao\\jvm\\");
    entry_dir.readClass("Cmd.class");
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
return new TestSuite(Entry_DirTest.class); 
} 
} 
