package test.com.gabongao.jvm.classpath; 

import com.gabongao.jvm.classpath.Entry_Wildcard;
import junit.framework.Test;
import junit.framework.TestSuite; 
import junit.framework.TestCase; 

/** 
* Entry_Wildcard Tester. 
* 
* @author <Authors name> 
* @since <pre>02/17/2017</pre> 
* @version 1.0 
*/ 
public class Entry_WildcardTest extends TestCase { 
public Entry_WildcardTest(String name) { 
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
    Entry_Wildcard entry_wildcard = new Entry_Wildcard("C:\\Program Files\\Java\\jdk1.8.0_77\\jre\\lib\\*");
    entry_wildcard.readClass("javafx/embed/swt/CustomTransfer.class");
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
return new TestSuite(Entry_WildcardTest.class); 
} 
} 
