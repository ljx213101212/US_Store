package com.store.junit4;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.store.main.StoreApplication;
import com.store.ui.ManageCategoriesFrame;
import com.store.util.CustomTableModel;

public class CategoryControllerTest {

	static StoreApplication sa;
	static ManageCategoriesFrame mcf;
	static FileHelper fh;
	//static CustomTableModel dm = ((ManageCategoriesFrame) mcf).getTableModel();
	ArrayList content_test = new ArrayList();
	String element = "";
	ArrayList elements_list = new ArrayList();
	private String filename = fh.read_file_name().get(0);
	
	public static Component getChildName(Component parent, String name){
		
		if (name.equals(parent.getName())){
			return parent;
		}
		
		if (parent instanceof Container) {
			
			Component[] children = ((Container) parent).getComponents();
			
			
			for (int i = 0 ;i < children.length ; ++i) {
				
				Component child = getChildName(children[i],name);
				if (child != null){
					return child;
				}
			}
			
					                
		}
		
		return null;
		
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		sa = new StoreApplication();
		mcf = new ManageCategoriesFrame(sa);
		fh = new FileHelper();
		mcf.setVisible(true);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		//refresh
		
		int rowCount =  ((ManageCategoriesFrame) mcf).getTableModel().getRowCount();
		//Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
					 ((ManageCategoriesFrame) mcf).getTableModel().removeRow(i);
				}
		content_test = fh.read_from_line(fh.work_path+fh.file_list.get(0));

		Iterator<String> i = content_test.iterator ();
		String line = "";
        while (i.hasNext ()) {
            line = (String)i.next();
            //System.out.println(line);
            elements_list = fh.SeperateFieldFromLine(line);
            if (elements_list.size() == 2){
            ((ManageCategoriesFrame) mcf).getTableModel().addRow(new Object[]{elements_list.get(0), elements_list.get(1),"Original"});
            }
        }
	}

	@After
	public void tearDown() throws Exception {
		setUp();
	}
	
	
	
	@Test
	public void write_in_test(){
		
		String content = "TESTCODE,TESTING";
		
		//fh.write_in_file(content, filename);
		//System.out.println(filename);
		
		/*
		fh.write_in_file("CLO,Clothing",filename);
		fh.write_in_file("MUG,Mugs", filename);
		fh.write_in_file("STA,Stationary", filename);
		fh.write_in_file("DIA,Diary", filename);
		*/
			
	}
	
	@Test
	public void delete_test() throws IOException{
		
		String content = "TESTCODE,TESTING";
		//fh.modify_file(filename, content, false);
	}
	
	@Test
	public void modify_test() throws IOException{
		
		String old_content = "TESTCODE,TESTING";
		String new_content = "NEWTESTCODE,NEWTESTING";
		/*
		if (fh.modify_file(filename, old_content, false)){
			fh.write_in_file(new_content, filename);
		}
		*/
		
	}
	

}
