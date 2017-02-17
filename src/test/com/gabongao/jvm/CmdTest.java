package test.com.gabongao.jvm; 

import com.gabongao.jvm.Cmd;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import junit.framework.*;

import java.util.Arrays;

/** 
* Cmd Tester. 
* 
* @author <Authors name> 
* @since <pre>¶þÔÂ 17, 2017</pre> 
* @version 1.0 
*/ 
public class CmdTest extends TestCase {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: parseCmd(String[] args) 
* 
*/ 
@Test
public void testParseCmd() throws Exception { 
//TODO: Test goes here...
    Cmd cmd = new Cmd();
    cmd.parseCmd(new String[]{"-cp","classpath1","MyApp"});
    assertEquals("classpath1",cmd.getCpOption());
    assertEquals("MyApp",cmd.getClassName());
    cmd.reset();

    cmd.parseCmd(new String[]{"-version","MyApp","classpath1","args2"});
    assertEquals(false,cmd.isHelpFlag());
    assertEquals(true,cmd.isVersionFlag());
    assertEquals("MyApp",cmd.getClassName());
    assertEquals(true, Arrays.asList(new String[]{"classpath1", "args2"}).equals(Arrays.asList(cmd.getArgs())));
    assertEquals("",cmd.getCpOption());
    cmd.reset();

    cmd.parseCmd(new String[]{"-help","MyApp","classpath1","args2"});
    assertEquals("",cmd.getCpOption());
    assertEquals(true,cmd.isHelpFlag());
    assertEquals(false,cmd.isVersionFlag());
    assertEquals(true, Arrays.asList(new String[]{"classpath1", "args2"}).equals(Arrays.asList(cmd.getArgs())));
    assertEquals("MyApp",cmd.getClassName());
    cmd.reset();

    cmd.parseCmd(new String[]{"-?","MyApp","classpath1","args2"});
    assertEquals("",cmd.getCpOption());
    assertEquals(true,cmd.isHelpFlag());
    assertEquals(false,cmd.isVersionFlag());
    assertEquals(true, Arrays.asList(new String[]{"classpath1", "args2"}).equals(Arrays.asList(cmd.getArgs())));
    assertEquals("MyApp",cmd.getClassName());
    cmd.reset();


    cmd.parseCmd(new String[]{"-classpath","classpath1","MyApp","args1","args2"});
    assertEquals("classpath1",cmd.getCpOption());
    assertEquals(false,cmd.isHelpFlag());
    assertEquals(false,cmd.isVersionFlag());
    assertEquals(true, Arrays.asList(new String[]{"args1", "args2"}).equals(Arrays.asList(cmd.getArgs())));
    assertEquals("MyApp",cmd.getClassName());
    cmd.reset();

    cmd.parseCmd(new String[]{"-classpath","classpath1","MyApp","args1","args2","-version"});
    assertEquals("classpath1",cmd.getCpOption());
    assertEquals(false,cmd.isHelpFlag());
    assertEquals(true,cmd.isVersionFlag());
    assertEquals(true, Arrays.asList(new String[]{"args1", "args2"}).equals(Arrays.asList(cmd.getArgs())));
    assertEquals("MyApp",cmd.getClassName());
    cmd.reset();


    cmd.parseCmd(new String[]{"-classpath","classpath1","-version","MyApp","args1","args2"});
    assertEquals(true,"".equals(cmd.getJreOption()));
    assertEquals("classpath1",cmd.getCpOption());
    assertEquals(false,cmd.isHelpFlag());
    assertEquals(true,cmd.isVersionFlag());
    assertEquals(true, Arrays.asList(new String[]{"args1", "args2"}).equals(Arrays.asList(cmd.getArgs())));
    assertEquals("MyApp",cmd.getClassName());
    cmd.reset();

    cmd.parseCmd(new String[]{"-classpath","classpath1","MyApp","-version","args1","args2","-Xjre","jreoption","args3"});
    assertEquals("classpath1",cmd.getCpOption());
    assertEquals(false,cmd.isHelpFlag());
    assertEquals(true,cmd.isVersionFlag());
    assertEquals(true,"jreoption".equals(cmd.getJreOption()));
    assertEquals(true, Arrays.asList(new String[]{"args1", "args2","args3"}).equals(Arrays.asList(cmd.getArgs())));
    assertEquals("MyApp",cmd.getClassName());
    cmd.reset();

}

/** 
* 
* Method: printUsage(String[] args) 
* 
*/ 
@Test
public void testPrintUsage() throws Exception { 
//TODO: Test goes here... 
} 


} 
