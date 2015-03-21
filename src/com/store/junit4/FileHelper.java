package com.store.junit4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileHelper {

	public File f;
	/*String text_file[] = {"Category.dat","Discounts.dat","Member.dat","Products.dat","StoreKeepers"
			              ,"Transaction.dat","VendorsMug.dat"};
	*/
	static int MAXIMUM_FILE_NUMBER = 100;
	String text_file[] = new String [MAXIMUM_FILE_NUMBER];
	String work_path = System.getProperty("user.dir")+"/res/";
	String file_path = System.getProperty("user.dir")+"/res/file_name.xml";
	ArrayList<String> file_list = new ArrayList<String>();
	
	
	public FileHelper () {
		
		//initialize the file_names
		read_file_name();
		//initialize file path
		initialize_text_file();
		//read file
		//read_from_line(work_path+file_list.get(0));
	   
		
		
		
		
	}
	
	
	private void initialize_text_file(){
		
		for (int i = 0 ; i < file_list.size() ; i ++){
			text_file[i] = file_list.get(i);
		}
	}
	
	
	public ArrayList<String> read_file_name(){
		
		
		
		  try {
				File fXmlFile = new File(file_path);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
			 
				//optional, but recommended
				//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
				doc.getDocumentElement().normalize();
			 
				//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			 
				NodeList nList = doc.getElementsByTagName("file");
			 
				//System.out.println("----------------------------");
			 
				for (int temp = 0; temp < nList.getLength(); temp++) {
			 
					Node nNode = nList.item(temp);
			 
					//System.out.println("\nCurrent Element :" + nNode.getNodeName());
			 
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			 
						Element eElement = (Element) nNode;
			 
						//System.out.println("file id : " + eElement.getAttribute("id"));
						//System.out.println("file name : " + eElement.getElementsByTagName("filename").item(0).getTextContent());
						//System.out.println("file type : " + eElement.getElementsByTagName("filetype").item(0).getTextContent());
			            file_list.add(eElement.getElementsByTagName("filename").item(0).getTextContent() + 
			            		eElement.getElementsByTagName("filetype").item(0).getTextContent());
			            //System.out.println(file_list.get(temp));
					}
				}
			    } catch (Exception e) {
				e.printStackTrace();
			    }
			  
		
		return file_list;
		
		
	}
	
	
	public ArrayList<String> read_from_line(String file_path) throws IOException{
		
		ArrayList<String> list_by_line = new ArrayList<String>();
	    BufferedReader br = new BufferedReader(new FileReader(file_path));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            list_by_line.add(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        String everything = sb.toString();
	        //System.out.println(everything);
	    } finally {
	        br.close();
	    }
		
		
		return list_by_line;
	}
	
	public boolean write_in_file(String content,String file_name){
		
		try {
			 
			//String content = "This is the content to write into file";
 
			File file = new File(work_path+file_name);
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				//file.createNewFile();
				System.out.println("can't write in file, because "+file_name+"is not exist!");
				//this section should add some log
				/*************log******************/
				
				System.exit(0);
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content+"\n");
			bw.close();
 
			System.out.println("write in Successfully!");
			return true;
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean modify_file(String filename, String delete_element,boolean clear) throws IOException{
		
		File file = new File(work_path+filename);
		String rl = null;
		String special = delete_element;
		StringBuffer bf = new StringBuffer();
		BufferedReader br = new BufferedReader(new FileReader(file));
		boolean isDeleteAvailable = false;
		//BufferedWriter out = new BufferedWriter(new FileWriter(file));
		
		
		if (clear == true){
			br.close();
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write("");
			out.flush();
			out.close();
		}else{
		while(( rl = br.readLine()) != null)
		{
			rl = rl.trim();
			if(rl.indexOf(special) == -1){ //或者!r1.startsWith(special)
				bf.append(rl).append("\r\n");
			}else {
				isDeleteAvailable = true;
			}
		}
		
		br.close();
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		out.write(bf.toString());
		out.flush();
		out.close();
	         }
		
		
	 return isDeleteAvailable;
		
	}
	
	
	
	
	public ArrayList<String> SeperateFieldFromLine(String line){
		
		ArrayList<String> element = new ArrayList<String>();
		
		
		int line_length = line.length();
		int num_element = 0;
		int mark = 0;
		
		//System.out.println(line.substring(mark,12));
		
		
		for (int i = 0 ; i < line_length ; i++){
			
			if (line.substring(i,i+1).equals(",")){
				element.add(line.substring(mark,i));
				num_element++;
				mark = i + 1;
			}
		}
		
		element.add(line.substring(mark,line_length));
		
		return element;
		
	}
	
	
	
}
