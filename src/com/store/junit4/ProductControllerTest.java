package com.store.junit4;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.store.main.StoreApplication;
import com.store.ui.ManageProductsFrame;

public class ProductControllerTest {

	
	static StoreApplication sa;
	static ManageProductsFrame mmf;
	static FileHelper fh;
	//static CustomTableModel dm = ((ManageCategoriesFrame) mmf).getTableModel();
	ArrayList content_test = new ArrayList();
	String element = "";
	ArrayList elements_list = new ArrayList();
	private String filename = fh.read_file_name().get(3); //check the file sequence in xml
	private int elements_list_size = 8;
	
	/*********************************/
	HashMap<String,Integer> hm = new HashMap<String,Integer>();
	String frontOfSlash = "";
	String backOfSlash = "";
	int backOfSlash_int = 0;
    //ArrayList<Integer> maximum_number = new ArrayList<Integer>();
	ArrayList<String> deleted_file_array_list = new ArrayList<String>();
	ArrayList<String> deleted_file_element_list = new ArrayList<String>();
	HashMap<String,Integer> deleted_maximum_id_product= new HashMap<String,Integer>();
	//String configuration_file_name = "Configuration.dat";
	String back_up_file_name = "DeletedMaximumProductsIdBackup.dat";
	HashMap<String,Integer> mark_is_from_back_up_file = new HashMap<String,Integer>();
	
	/**
	 * @throws IOException *******************************/
	public void build_deleted_maximum_id_product() throws IOException{
		
		deleted_file_array_list = fh.read_from_line(fh.work_path+back_up_file_name);
		Iterator <String> i = deleted_file_array_list.iterator();
		while(i.hasNext()){
		deleted_file_element_list = fh.SeperateFieldFromLine(i.next());
		if (deleted_file_element_list.size() == 2){
			int temp = Integer.valueOf(deleted_file_element_list.get(1));
		deleted_maximum_id_product.put(deleted_file_element_list.get(0),temp);
		}else{
			System.out.println("backup dat format is not right");
			System.exit(0);
			
		}
		}
	}
	
	
	public void build_maximum_prodcut_id() throws IOException{
		
		build_deleted_maximum_id_product();
		Iterator <String>i = content_test.iterator();
		String line = "";
		String s = "";
		while(i.hasNext()){
			line = i.next();
			fh.SeperateFieldFromLine(line);
			elements_list = fh.SeperateFieldFromLine(line);
			s = (String) elements_list.get(0);
			split_type_number(s);
			if (deleted_maximum_id_product.get(frontOfSlash) != null){
				hm.put(frontOfSlash, deleted_maximum_id_product.get(frontOfSlash));
				mark_is_from_back_up_file.put(frontOfSlash, 1);
				//fh.modify_file(back_up_file_name, frontOfSlash, false);
				
			}else{
			
		    if (hm.get(frontOfSlash) != null){
		    	if(backOfSlash_int >= hm.get(frontOfSlash)){
		    	hm.put(frontOfSlash, backOfSlash_int);
		    	}
		    }else {
		    	hm.put(frontOfSlash, 1);
		    }
		    
			}
			
		}
	}
	
	
	public void split_type_number(String s){
		
       for (int i = 0 ; i < s.length() ; i++){
			
			if (s.charAt(i) == '/'){
				frontOfSlash = s.substring(0, i);
				backOfSlash = s.substring(i+1,s.length());
				
				backOfSlash_int = Integer.parseInt(backOfSlash);
			}
		}
		
		
	}
	
	/*********************************/
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		sa = new StoreApplication();
		mmf = new ManageProductsFrame(sa);
		fh = new FileHelper();
		mmf.setVisible(true);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		//refresh
		
				int rowCount =  ((ManageProductsFrame) mmf).getTableModel().getRowCount();
				//Remove rows one by one from the end of the table
						for (int i = rowCount - 1; i >= 0; i--) {
							 ((ManageProductsFrame) mmf).getTableModel().removeRow(i);
						}
				content_test = fh.read_from_line(fh.work_path+filename);

				Iterator<String> i = content_test.iterator ();
				String line = "";
		        while (i.hasNext ()) {
		            line = (String)i.next();
		            //System.out.println(line);
		            elements_list = fh.SeperateFieldFromLine(line);
		            if (elements_list.size() == elements_list_size){
		            ((ManageProductsFrame) mmf).getTableModel().addRow(new Object[]{elements_list.get(0), elements_list.get(1)
		            		,elements_list.get(2),elements_list.get(3),elements_list.get(4),elements_list.get(5),elements_list.get(6)
		            		,elements_list.get(7)});
		            }
		        }
		        
		        build_maximum_prodcut_id();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void write_in_test() throws IOException{
		
		//String content = "TEST NAME,T0000000F3,-1";
		String Product = "CLO";
		String slash = "/";
		int number ;
	
		//这里很重要，每次都需要生成文件的最大索引map
		//build_maximum_prodcut_id();
		
		Iterator iter = hm.entrySet().iterator(); 
		while (iter.hasNext()) { 
		    Map.Entry entry = (Map.Entry) iter.next(); 
		    Object key = entry.getKey(); 
		    Object val = entry.getValue(); 
		    //System.out.println(key);
		    //System.out.println(val);
		} 
		
	
        number = hm.get(Product) + 1;
        //System.out.println(number);
        String number_string = String.valueOf(number);
        
       //System.out.print(number_string);
        
		String product_id = Product+slash+number_string;
		String content = product_id+",Test pp,a really test app,100,21.22,1000,10,100";
		
		//judge if the content is special
		if (mark_is_from_back_up_file.size() > 0){
			if (mark_is_from_back_up_file.get(Product) != null){
				fh.modify_file(back_up_file_name, Product, false);
			}
		}
		
		fh.write_in_file(content, filename);
		//fh.write_in_file(content, filename);
		//System.out.println(filename);
		
		/*
		fh.write_in_file("CLO/1,Centenary Jumper,A really nice momento,315,21.45,1234,10,100",filename);
		fh.write_in_file("MUG/1,Centenary Mug,A really nice mug this time,525,10.25,9876,25,150", filename);
		fh.write_in_file("STA/1,NUS Pen,A really cute blue pen,768,5.75,123459876,50,250", filename);
		fh.write_in_file("STA/2,NUS Notepad,Great notepad for those lectures,1000,3.15,6789,25,75", filename);
	   */
			
	}
	
	@Test
    public void delete_test() throws IOException{
		
		String content = "CLO/7";
		int number = 0;
		//ArrayList<String> temp = new ArrayList<String>();
		
		split_type_number(content);
	    number = backOfSlash_int;
		
	    //System.out.println(number);
	    //System.out.println(hm.get(frontOfSlash));
	    
	    
		/*
		if (number == hm.get(frontOfSlash)){
			fh.write_in_file(frontOfSlash+","+backOfSlash, back_up_file_name);
			fh.modify_file(filename, content, false);
			System.out.println("allright");
		}else{
			fh.modify_file(filename, content, false);
			System.out.println("no good");
		}
		*/
		//fh.modify_file(filename, content, false);
		
	}
	
	@Test
	public void modify_test() throws IOException{
		
		String old_content = "CLO/8,Test pp,a really test app,100,21.22,1000,10,100";
		String new_content = "CLO/8,New New,a really New app,111,11.11,1111,11,111";
		
		
		//fh.modify_file(filename, old_content, false);
		//fh.write_in_file(new_content, filename);
		/*
		if (fh.modify_file(filename, old_content, false)){
			fh.write_in_file(new_content, filename);
		}
	    */
		
	}

}
