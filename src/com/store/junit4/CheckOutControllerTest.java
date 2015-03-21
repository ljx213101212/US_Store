package com.store.junit4;

import static org.junit.Assert.*;

import com.store.main.StoreApplication;
import com.store.model.*;
import com.store.ui.CheckoutFrame;
import com.store.ui.ManageCategoriesFrame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;











import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CheckOutControllerTest {
	
	 
	static StoreApplication sa;
	static CheckoutFrame cf;
    static 	JTable jt;
	//Bring in Products.dat
	//ArrayList <String> ProductByLine;
	//HashMap <String,ArrayList> ProductIndex;
	
	//Bring in Members.dat
	//ArrayList <String> MemberByLine;
	//HashMap <String,ArrayList> MemberIndex;
	
	//Bring in Discounts.dat
	//ArrayList <String> DiscountByLine;
	//HashMap <String,ArrayList> DiscountIndex;
	
	//Generate ProductItem
	//ArrayList <String> ProductItemByLine;
	//HashMap <String,ArrayList> ProductItemIndex;
	
    //Generate ProductItem By Obejct
	HashMap <Product,Integer> productItemIndex;
	
	//Generate transcation_array
	//ArrayList <String> TransactionByLine;
	
	
	public double calculateTotal(HashMap <Product,Integer> productItemIndex){
		
		double TotalPrize = 0.00;
		double prize = 0.00;
		int amount = 0;
	
		Map map = productItemIndex;
		Iterator iter = map.entrySet().iterator(); 
		while (iter.hasNext()) { 
		    Map.Entry entry = (Map.Entry) iter.next(); 
		    Product product_obj = (Product) entry.getKey(); 
		    int quantity = (Integer) entry.getValue(); 
		    
		    TotalPrize = TotalPrize + product_obj.getPrice() * quantity;
		    
		} 
		return TotalPrize;
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//initialize the GUI
		sa = new StoreApplication();
		cf = new CheckoutFrame(sa);
		cf.setLocationRelativeTo(null);
		cf.setVisible(true);
		
		jt = ((CheckoutFrame)cf).getTableModel();
		
		
		String test = "11";
		test = "22";
		
		//initialize the productItemIndex
		
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addProductTest() {
		//jt.setValueAt("TEST", 3, 3);
		DefaultTableModel tableModel = (DefaultTableModel) jt.getModel();
		tableModel.addRow(new Object[]{"CLO/12", "Bikinis", "1","What is this?","25.80"});
	
		String test = "11";
		test = "22";
	}
	
	

}
