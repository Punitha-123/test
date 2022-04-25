package mypackage;
 
import java.io.File;

	import java.io.FileWriter;
	import java.util.Scanner;
	import java.util.Collections;
	import java.util.LinkedList;
	import java.util.ArrayList;

	
	public class LockerPro3
	{
	static final String folderPath = "C:\\Users\\punit\\OneDrive\\Desktop\\project\\LockedMe";
		static Scanner fileScanner;

		public static void main(String[] args) {
			int choice = -1;
			Scanner scanner = new Scanner(System.in);
			
			
			do
			{
				displayMenu();
				System.out.println("Enter your Choice: \t");
				choice = scanner.nextInt();
				
				switch(choice)
				{
				case 1: getAllFiles();
						break;
				case 2: createFiles();
						break;
				case 3: deleteFiles();
						break;
				case 4: searchFiles();
						break;
				case 5: System.out.println("Exited Successfully: ");
						System.exit(0);
						break;
						
				default:System.out.println("Invalid option");
						
				}
				
			}
			while(choice > 0);
			
				scanner.close();
				fileScanner.close();
		}

		
	public static void displayMenu()
	{
		System.out.println("Welcome to LockedMe.com: \n");
		
		System.out.println("Developed By : M Punitha Lakshmi \t Batch : Mar 14");
		System.out.println("\n 1.Display all the files");
		System.out.println("\n 2.Add a new file");
		System.out.println("\n 3.Delete a file");
		System.out.println("\n 4.Search a file");
		System.out.println("\n 5.Exit");
	}

	// return all the files

	public static void getAllFiles()
	{
		try
	{
			File folder = new File(folderPath);
			File[] listOfFiles = folder.listFiles();
			
			
			ArrayList<String> arrayListOfFiles = new ArrayList<String>();
			
			if (listOfFiles.length == 0)
			{
				System.out.println("No Files exist");
			}
			else
			{
				for (var file : listOfFiles)
				{
					arrayListOfFiles.add(file.getName());
				}
				
				Collections.sort(arrayListOfFiles);
				
				for (var fileName : arrayListOfFiles)
				{
					System.out.println(fileName);
				}
			}
	}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	// Files are created in this method

	public static void createFiles()
	{
		try
		{
			fileScanner = new Scanner(System.in);
			
			String fileName;
			
			System.out.println("Enter file name: ");
			
			fileName = fileScanner.nextLine();
			
			while (fileName.length() == 0)
			{
				System.out.println("Enter file name: ");
				fileName = fileScanner.nextLine();
			}
			
			
			int lineCount;
			
			System.out.println("Enter how many lines in the file: ");
			
			lineCount =Integer.parseInt(fileScanner.nextLine());
			
			while (lineCount == 0)
			{
				System.out.println("Enter how many lines in the file: ");
				
				lineCount =Integer.parseInt(fileScanner.nextLine());
			}
			
			FileWriter myWriter = new FileWriter(folderPath + "\\" + fileName);
			
			for (int i = 1; i <= lineCount; i++)
			{
				System.out.println("Enter the " + i + " line : ");
				myWriter.write(fileScanner.nextLine()+"\n");
			}
			
			System.out.print("File Created Successfully: \n");
			myWriter.close();
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	/* THis method will deleted the files*/

	public static void deleteFiles()
	{
		 fileScanner = new Scanner(System.in);
		
		 try 
		 {
			  System.out.println("Enter the file name to be deleted: ");
			  
			  String fileName = fileScanner.nextLine();
			  
			  while (fileName.length() == 0)
				{
				  System.out.println("Enter the file name to be deleted: ");
				  
				  fileName = fileScanner.nextLine();
				}
			  
			  File file = new File(folderPath + "\\" + fileName);
			  
			  if(file.exists())
			  {
				  file.delete();
				  System.out.println("File deleted Successfully : " + fileName);
			  }
			  else
			  {
				  System.out.println("File doesn't Exist");
			  }
		 }
		 catch (Exception ex)
		 {
			 System.out.println(ex.getMessage());
		 }	
	}

	public static void searchFiles()
	{
		fileScanner = new Scanner(System.in);
		
		try 
		 {
			  System.out.println("Enter the file name to search: ");
			  
			  String fileName = fileScanner.nextLine();
			  
			  while (fileName.length() == 0)
				{
				  System.out.println("Enter the file name to search: ");
				  
				  fileName = fileScanner.nextLine();
				}
			  
			  File folder = new File(folderPath);
			  File[] listOfFiles = folder.listFiles();
			  
			  LinkedList<String> listOfFileNames = new LinkedList<String>();
			  
			  for (var file : listOfFiles)
			  {
				  listOfFileNames.add(file.getName());
			  }
			  
			  if (listOfFileNames.contains(fileName))
			  {
				  System.out.println("File found :" + fileName);
			  }
			  else
			  {
				  System.out.println("File not found");
			  }
		 }
		 catch (Exception ex)
		 {
			 System.out.println(ex.getMessage());
		 }	
	  }
	}

