package com.store.junit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import org.junit.Test;

import com.store.main.StoreApplication;




public class StoreApplicationTest {

	
	   StoreApplication sa = new StoreApplication();
	  // MessageUtil messageUtil = new MessageUtil(message);

	
       public void sayHello() {
                 System.out.println("hello world!");
       }
	   
	   @Test
	   public void testPrintMessage() {
		   // assertEquals -- if left is equal to right
	     // assertEquals(message,messageUtil.printMessage());
	      // assertFalse
	      //assertFalse(score > messageUtil.getNumber());
	      // assertNotNull
	      //assertNotNull(messageUtil.getObj1());
	      
		   //test if Object of StoreApplication can be Created!
		   assertNotNull(sa);
	      // test if the LoginFrame is set to be visible!
		   
	   }
	  
	   @Test
	   public void testSomething(){
		   
	   }
	  
	  
	
	
  

}
