package com.store.junit4;

import static org.junit.Assert.*;

import com.store.main.StoreApplication;
import com.store.model.*;
import com.store.ui.CheckoutFrame;
import com.store.ui.ManageCategoriesFrame;
import com.store.ui.dialog.AddPurchaseProductDialog;
import com.store.model.Product;

import java.io.IOException;
import java.text.DecimalFormat;
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

public class CheckOutControllerAddProductAndTotalPriceTest {

	static FileHelper fh;
	static StoreApplication sa;
	static CheckoutFrame cf;
	static AddPurchaseProductDialog appd;
	static JTable jt;
	static JTable jtAddProductDialog;

	// Bring in Category.dat
	ArrayList<String> CategoryByLine = new ArrayList<String>();
	// Generate Categories Map by Object
	ArrayList<Category> CategoryIndex = new ArrayList<Category>();

	// Bring in Products.dat
	ArrayList<String> ProductByLine = new ArrayList<String>();
	// HashMap <String,ArrayList> ProductIndex;

	// Generate Products Map by Object
	ArrayList<Product> ProductIndex = new ArrayList<Product>();

	// Bring in Members.dat
	// ArrayList <String> MemberByLine;
	// HashMap <String,ArrayList> MemberIndex;

	// Bring in Discounts.dat
	// ArrayList <String> DiscountByLine;
	// HashMap <String,ArrayList> DiscountIndex;

	// Generate ProductItem
	// ArrayList <String> ProductItemByLine;
	// HashMap <String,ArrayList> ProductItemIndex;

	// Generate ProductItem By Obejct
	HashMap<Product, Integer> productItemIndex = new HashMap<Product, Integer>();

	// Generate transcation_array
	// ArrayList <String> TransactionByLine;
	// public void initObjectIndex(Object class, int fileListIndex)

	public void initCategoryIndex() throws IOException {
		ArrayList<String> temp = new ArrayList<String>();
		CategoryByLine = fh.read_from_line(fh.work_path + fh.file_list.get(0));
		Iterator<String> i = CategoryByLine.iterator();
		while (i.hasNext()) {

			temp = fh.SeperateFieldFromLine(i.next());
			if (temp.size() == 2) {
				Category category = new Category(temp.get(0), temp.get(1));
				CategoryIndex.add(category);
			} else {
				System.out
						.println("CheckOutController initCategoryIndex(), file format is wrong!");
				System.exit(0);
			}

		}
	}

	public void initProductIndex() throws IOException {

		// init Category
		initCategoryIndex();
		Category category = null;
		ArrayList<String> temp = new ArrayList<String>();
		ProductByLine = fh.read_from_line(fh.work_path + fh.file_list.get(3));
		Iterator<String> i = ProductByLine.iterator();
		while (i.hasNext()) {
			temp = fh.SeperateFieldFromLine(i.next());
			// tranverse the CategoryIndex
			Iterator<Category> iter = CategoryIndex.iterator();
			while (i.hasNext()) {

				category = iter.next();
				if (category.getCategoryCode().equals(
						fh.splitBySlash(temp.get(0)))) {
					break;
				}
			}

			if (category != null) {
				// end tranverse the categoryIndex
				if (temp.size() == 8) {
					Product product = new Product(category, temp.get(1),
							temp.get(0), temp.get(2), Integer.valueOf(temp
									.get(3)), Float.parseFloat(temp.get(4)),
							Integer.valueOf(temp.get(5)), Integer.valueOf(temp
									.get(6)), Integer.valueOf(7));

					ProductIndex.add(product);
				} else {
					System.out
							.println("CheckOutController initProductIndex product file format is wrong!");
					System.out
							.println("CheckOutController initProductIndex System.exit");
					System.exit(0);
				}
			} else {
				System.out
						.println("CheckOutController initProductIndex, Categroy is null!");
				System.out.println("system exit");
				System.exit(0);
			}
		}// end outside while

	}

	public String calculateTotal(HashMap<Product, Integer> productItemIndex) {

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
		
		DecimalFormat r=new DecimalFormat();  
		r.applyPattern("#0.00");//保留小数位数，不足会补零 
		
		return r.format(TotalPrize);
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// initialize the GUI
		fh = new FileHelper();
		sa = new StoreApplication();
		cf = new CheckoutFrame(sa);
		cf.setLocationRelativeTo(null);
		cf.setVisible(true);

		jt = ((CheckoutFrame) cf).getTableModel();
		// jtAddProductDialog = ()

		String test = "11";
		test = "22";

		// initialize the productItemIndex

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addProductTest() throws IOException {
		// jt.setValueAt("TEST", 3, 3);
		DefaultTableModel tableModel = (DefaultTableModel) jt.getModel();
		// test add directly
		// tableModel.addRow(new Object[]{"CLO/12", "Bikinis",
		// "1","What is this?","25.80"});
		// test add logically
		/***
		 * assume that we finished the function below
		 * 
		 */

		/**
		 * Then We got those data Assume user chose the Row 1 and Row 4 and
		 * quantity: Row 1 is 2 Row 4 is 10, then submit by clicking "ok"
		 */

		// init variables
		String productCode = "";
		String productName = "";
		String availableQuantity = "";
		String unitPrice = "";
		String price = "";
		String totalPrice = "";

		// initial ProductIndex
		initProductIndex();

		/**
		 * user is choosing products
		 */
		Product userChosen1 = ProductIndex.get(0);
		Product userChosen2 = ProductIndex.get(3);

		/**
		 * user is entering the number they want to but this product they
		 * seleted
		 */
		int userChosenQuantity_1 = 2;
		int userChosenQuantity_2 = 10;

		/**
		 * transfer String to right format
		 */

		availableQuantity = String.valueOf(userChosen1.getAvaliableQuantity());
		unitPrice = String.valueOf(userChosen1.getPrice());
		price = String.valueOf(userChosen1.getAvaliableQuantity()
				* userChosen1.getPrice());
		tableModel.addRow(new Object[] { userChosen1.getProductCode(),
				userChosen1.getProductName(), availableQuantity, unitPrice,
				price });

		availableQuantity = String.valueOf(userChosen2.getAvaliableQuantity());
		unitPrice = String.valueOf(userChosen2.getPrice());
		price = String.valueOf(userChosen2.getAvaliableQuantity()
				* userChosen2.getPrice());
		tableModel.addRow(new Object[] { userChosen2.getProductCode(),
				userChosen2.getProductName(), availableQuantity, unitPrice,
				price });

		/**
		 * user clicked ok
		 */

		/**
		 * initial ProductItemIndex
		 */
		productItemIndex.put(userChosen1, userChosenQuantity_1);
		productItemIndex.put(userChosen2, userChosenQuantity_2);
		
		System.out.println(userChosen1.getPrice());
		System.out.println(userChosen2.getPrice());

		/**
		 * Calculating the totalPrice
		 */
		totalPrice = calculateTotal(productItemIndex);
		

		assertEquals("74.40", totalPrice);

		/*
		 * //init GUI appd = new AddPurchaseProductDialog(cf); appd.setSize(500,
		 * 650); appd.setVisible(true);
		 * 
		 * //init variables String productCode = ""; String productName = "";
		 * String availableQuantity = ""; String price = "";
		 * 
		 * DefaultTableModel addProductTable = (DefaultTableModel)
		 * appd.table.getModel(); // test add directly
		 * 
		 * 
		 * //initial ProductIndex initProductIndex(); //Traverse the
		 * ProductIndex Iterator<Product> iter = ProductIndex.iterator(); while
		 * (iter.hasNext()){ Product product = iter.next(); availableQuantity =
		 * String.valueOf(product.getAvaliableQuantity()); price =
		 * String.valueOf(product.getPrice());
		 * 
		 * 
		 * addProductTable.addRow(new Object[]{product.getProductCode(),
		 * product.getProductName(), availableQuantity, price}); }
		 */

		/******
		 * 
		 * 
		 * There should be add a pop out dialog, and this dialog should provide
		 * user a frame to choose how many number of this product they selected
		 * they want to buy, use button actionPerformed to sumbit the data
		 * 
		 */

		String test = "11";
		test = "22";
	}

}
