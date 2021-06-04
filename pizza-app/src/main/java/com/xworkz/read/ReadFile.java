package com.xworkz.read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile {

	public static <Workbook> void main(String[] args) throws FileNotFoundException {
		String URL = "jdbc:mysql://localhost:3306/xworkzdb";
		String username = "root";
		String password = "root";
	
	String excelFilePath = "E:\\Hibernate-S\\pizza";
    int batchSize = 4;
    Connection connection = null;

    try {
        long start = System.currentTimeMillis();
         
        FileInputStream inputStream = new FileInputStream(excelFilePath);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = firstSheet.iterator();

        connection = DriverManager.getConnection(URL, username, password);
        connection.setAutoCommit(false);

        String sql = "INSERT INTO pizza_details (name, location, price, is_avilable, size,type) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);    
         
        int count = 0;
         
        rowIterator.next(); 
         
        while (rowIterator.hasNext()) {
            Row nextRow = rowIterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();

                int columnIndex = nextCell.getColumnIndex();

                switch (columnIndex) {
  

           		   	 case 1:
					 String name = nextCell.getStringCellValue();
					 statement.setString(1,name);
					

				case 2:
					String location = nextCell.getStringCellValue();
					 statement.setString(2,location);
					

				case 3:
					int price = (int) nextCell.getNumericCellValue();
					 statement.setInt(3,price);
					

				case 4:
					boolean is_available = nextCell.getBooleanCellValue();
					 statement.setBoolean(4,is_available);
					

				case 5:
					String size = nextCell.getStringCellValue();
					 statement.setString(5,size);
					

				case 6:
					String type = nextCell.getStringCellValue();
					 statement.setString(6,type);
					
				}

                statement.addBatch();
                
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }              
 
            }
 
            workbook.close();
             
            statement.executeBatch();
  
            connection.commit();
            connection.close();
             
            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));
        }
    }
             
          catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        } catch (SQLException ex2) {
            System.out.println("Database error");
            ex2.printStackTrace();
        }
	}
}