package com.store.junit4;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.store.main.StoreApplication;
import com.store.ui.ManageCategoriesFrame;
import com.store.ui.ManageMembersFrame;

public class CustomerControllerTest {

	static StoreApplication sa;
	static ManageMembersFrame mmf;
	static FileHelper fh;
	//static CustomTableModel dm = ((ManageCategoriesFrame) mmf).getTableModel();
	ArrayList content_test = new ArrayList();
	String element = "";
	ArrayList elements_list = new ArrayList();
	private String filename = fh.read_file_name().get(2); //check the file sequence in xml
	private int elements_list_size = 3;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		sa = new StoreApplication();
		mmf = new ManageMembersFrame(sa);
		fh = new FileHelper();
		mmf.setVisible(true);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	//refresh
		
		int rowCount =  ((ManageMembersFrame) mmf).getTableModel().getRowCount();
		//Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
					 ((ManageMembersFrame) mmf).getTableModel().removeRow(i);
				}
		content_test = fh.read_from_line(fh.work_path+filename);

		Iterator<String> i = content_test.iterator ();
		String line = "";
        while (i.hasNext ()) {
            line = (String)i.next();
            //System.out.println(line);
            elements_list = fh.SeperateFieldFromLine(line);
            if (elements_list.size() == elements_list_size){
            ((ManageMembersFrame) mmf).getTableModel().addRow(new Object[]{elements_list.get(0), elements_list.get(1),elements_list.get(2)});
            }
        }
	}

	@After
	public void tearDown() throws Exception {
		setUp();
	}

	@Test
	public void test() {
		
	}
	
	@Test
	public void write_in_test(){
		
		String content = "TEST NAME,T0000000F3,-1";
		
		//fh.write_in_file(content, filename);
		//System.out.println(filename);
		
		/*
		fh.write_in_file("Yan Martel,F42563743156,150",filename);
		fh.write_in_file("Suraj Sharma,X437F356,250", filename);
		fh.write_in_file("Ang Lee,R64565FG4,-1", filename);
	   */
			
	}
	
	@Test
    public void delete_test() throws IOException{
		
		String content = "TEST NAME,T0000000F3,-1";
		
		//fh.modify_file(filename, content, false);
		
	}
	
	@Test
	public void modify_test() throws IOException{
		
		String old_content = "TEST NAME,T0000000F3,-1";
		String new_content = "NEW TEST NAME,T0000000F4,-1";
		
		/*
		if (fh.modify_file(filename, old_content, false)){
			fh.write_in_file(new_content, filename);
		}
	    */
		
	}
	
}
