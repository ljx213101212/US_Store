package com.store.junit4;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;


public class FileHelperTest {

	
	FileHelper fh =  new FileHelper();
	
	ArrayList content_test = new ArrayList();
	String element = "";
	ArrayList elements_list = new ArrayList();
	@Test
	public void doSomething() throws IOException{
		
		content_test = fh.read_from_line(fh.work_path+fh.file_list.get(0));
		//test read_from_line
		//System.out.println(content_test);
		//test seperete_from_line
		
		//System.out.println(content_test.get(0));
		
		element = (String) content_test.get(0);
		
		// initialize the elements_list
		elements_list = fh.SeperateFieldFromLine(element);
	   // System.out.println(elements_list.get(0));
	    
	    //System.out.println(System.getProperty("user.dir"));
	    
	    // write_in testing
	    
	    //fh.write_in_file("1.test,asdasdsad","write_in_test.dat");
	    //fh.write_in_file("2.mask,ksksks", "write_in_test.dat");
	    
	    // modify testing
	    // delete 1.test
	    fh.modify_file("write_in_test.dat", "1.test", false);
	}
}
