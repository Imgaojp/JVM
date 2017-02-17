package test.com.gabongao.jvm.classpath; 

import com.gabongao.jvm.classpath.Entry_Composite;
import junit.framework.Test;
import junit.framework.TestSuite; 
import junit.framework.TestCase; 

/** 
* Entry_Composite Tester. 
* 
* @author <Authors name> 
* @since <pre>02/17/2017</pre> 
* @version 1.0 
*/ 
public class Entry_CompositeTest extends TestCase { 
public Entry_CompositeTest(String name) { 
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
    Entry_Composite entry_composite = new Entry_Composite("D:\\Programming\\Java\\JVM\\src\\com\\gabongao\\jvm\\classpath;D:\\Programming\\Java\\JVM\\out\\production\\JVM\\com\\gabongao\\jvm\\;D:\\Programming\\Java\\JVM\\lib\\commons-cli-1.3.1;C:\\Program Files\\Java\\jdk1.8.0_77\\jre\\lib\\jfxswt.jar");
    entry_composite.readClass("javafx/embed/swt/CustomTransfer.class");
    System.out.println(entry_composite.toString());
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
return new TestSuite(Entry_CompositeTest.class); 
} 
} 
