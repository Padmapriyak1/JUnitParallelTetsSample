package com.javabydeveloper.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Utils {

	public static int add(int x, int y) {
		return x+y;
	}
	
	public static List< String> listOFFields(String folderPath)
	{
		List< String> listOfFiles= new ArrayList<String>();
		
		 File directoryPath = new File(folderPath);
	      //List of all files and directories
	      File filesList[] = directoryPath.listFiles();
	     
	      for(File file : filesList) {
	         
	         System.out.println("File path: "+file.getPath());
	          
	         listOfFiles.add(   file.getPath());
	         System.out.println(" ");
	      }
	      return listOfFiles;
	}
	  public  String fileCompare(String srcFilePath, String srcFileName, String targetFilePath)
	  {
		  String retValue="";
		  File targetFile = new File(targetFilePath +"\\" + srcFileName); 
		  if (targetFile.exists()) {
			  System.out.println("Exists"); 
			  File srcFile = new File(srcFilePath); 
			  System.out.println( srcFileName +  "size::"+ srcFile.length()); 
			  System.out.println("target " + targetFile.getName() + "size::"+ targetFile.length()); 
			  if(srcFile.length() == targetFile.length()) {
				  System.out.println( srcFileName + " size matched!!!"); 
				  retValue= "Success";
			  }else {
				  System.out.println( srcFileName + " size unmatched!!!"); 
				  retValue="srcFileName: " + srcFileName + " and targetFile: " + targetFile.getName() + " size mismatched !!!";
			  }
		  }else {
			  System.out.println("Does not Exists"); 
			  retValue="srcFileName: " + srcFileName + " not find in target directory ";
		  }
	            
		  
		  return retValue;
	  }
}
