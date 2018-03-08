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
//		//�������еľ�̬����getTestData,��ȡExcel�ļ��Ĳ�������
//		
//	}
	
	public static Object[][] getTestData(String filePath,String fileName,String sheetName) throws IOException{
		//���ݲ�������������ļ�·�����ļ����ƣ���ϳ�Excel�����ļ�����·��
		//����һ��File�ļ�����
		File file=new File(filePath+"\\"+fileName);
		//�������ڶ�ȡExcel�ļ�
		FileInputStream inputStream=new FileInputStream(file);
		//����Workbook����
		Workbook workBook=null;
		//��ȡ�ļ�����������չ�����ж���.xlsx�ļ�����.xls�ļ�
		String fileExtensionName=fileName.substring(fileName.indexOf("."));
		//�ж��ļ����������.xlsx����ʹ��XSSFWorkbook�������ʵ����
		//�ж��ļ����������.xls����ʹ��SSFWorkbook�������ʵ����
		if(fileExtensionName.equals(".xlsx")) {
			workBook=new XSSFWorkbook(inputStream);
		}else {
			workBook=new HSSFWorkbook(inputStream);
		}
		
		//ͨ��sheetName����������Sheet����
		Sheet sheet=workBook.getSheet(sheetName);
		//��ȡExcel�����ļ�Sheet1�����ݵ�������getLastRowNum�ļ���ȡ�������һ�е��к�
		//getFirstRowNum������ȡ���ݵĵ�һ���кţ����֮��������ݵ�����
		//ע�⣺Excel�ļ����кź��кŶ��Ǵ�0��ʼ��
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		//������Ϊrecords��list�������洢��Excel�����ļ���ȡ������
		List<Object[]> records=new ArrayList<Object[]>();
		//ʹ������forѭ������Excel�����ļ����������ݣ����˵�һ�У���һ�������������ƣ�
		//����i��1��ʼ,�����Ǵ�0��ʼ
		for(int i=1;i<rowCount+1;i++) {
			//ʹ��getRow�ķ���ȡ�ж���
			Row row=sheet.getRow(i);
			//����һ�����飬�����洢Excel�����ļ�ÿ���е�3�����ݣ�����Ĵ�С��
			//getLastCellNum�취�����ж�̬������ʵ�ֲ������ݸ����������С��һ��
			String fields[]=new String[row.getLastCellNum()];
			for(int j=0;j<row.getLastCellNum();j++) {
				//����getCell��getStringCellValue������ȡExcel�ļ��е�Ԫ�������
			}
		}
		return null;
	}
}
