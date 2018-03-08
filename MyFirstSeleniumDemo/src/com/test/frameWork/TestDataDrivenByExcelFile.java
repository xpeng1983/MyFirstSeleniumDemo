package com.test.frameWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataDrivenByExcelFile {
	
//	public static Object[][] words(){
//		//调用类中的静态方法getTestData,获取Excel文件的测试数据
//		
//	}
	
	public static Object[][] getTestData(String filePath,String fileName,String sheetName) throws IOException{
		//根据参数传入的数据文件路径和文件名称，组合出Excel数据文件绝对路径
		//声明一个File文件对象
		File file=new File(filePath+"\\"+fileName);
		//创建用于读取Excel文件
		FileInputStream inputStream=new FileInputStream(file);
		//声明Workbook对象
		Workbook workBook=null;
		//获取文件名参数的扩展名，判断是.xlsx文件还是.xls文件
		String fileExtensionName=fileName.substring(fileName.indexOf("."));
		//判断文件类型如果是.xlsx，则使用XSSFWorkbook对象进行实例化
		//判断文件类型如果是.xls，则使用SSFWorkbook对象进行实例化
		if(fileExtensionName.equals(".xlsx")) {
			workBook=new XSSFWorkbook(inputStream);
		}else {
			workBook=new HSSFWorkbook(inputStream);
		}
		
		//通过sheetName参数，生成Sheet对象
		Sheet sheet=workBook.getSheet(sheetName);
		//获取Excel数据文件Sheet1中数据的行数，getLastRowNum文件获取数据最后一行的行号
		//getFirstRowNum方法获取数据的第一行行号，相减之后算出数据的行数
		//注意：Excel文件的行号和列号都是从0开始的
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		//创建名为records的list对象来存储从Excel数据文件读取的数据
		List<Object[]> records=new ArrayList<Object[]>();
		//使用两个for循环遍历Excel数据文件的所有数据（除了第一行，第一行是数据列名称）
		//所以i从1开始,而不是从0开始
		for(int i=1;i<rowCount+1;i++) {
			//使用getRow文法获取行对象
			Row row=sheet.getRow(i);
			//声明一个数组，用来存储Excel数据文件每行中的3个数据，数组的大小用
			//getLastCellNum办法来进行动态声明，实现测试数据个数和数组大小相一致
			String fields[]=new String[row.getLastCellNum()];
			for(int j=0;j<row.getLastCellNum();j++) {
				//调用getCell和getStringCellValue方法获取Excel文件中单元格的数据
			}
		}
		return null;
	}
}
