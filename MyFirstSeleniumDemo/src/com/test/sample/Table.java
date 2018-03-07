package com.test.sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Table {
	// 声明一个 WElement对象，用于存储页面的表格元素对象
	private WebElement _table;

	public Table(WebElement table) {
		set_table(table);
	}

	public WebElement get_table() {
		return _table;
	}

	public void set_table(WebElement _table) {
		this._table = _table;
	}

	// 获取表格元素的行数，查找表格元素有几个tr元素
	// 有几个tr元素，就可以知道表格有几行，tr数量和表格行数相一致
	public int getRowCount() {
		List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
		return tableRows.size();
	}

	// 获取表格元素的列数
	public int getColumnCount() {
		List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
		return tableRows.get(0).findElements(By.tagName("td")).size();
	}

	// 获取表格中某行某列的单元格对象
	public WebElement getCell(int rowNo, int colNo) {
		try {
			List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
			System.out.println("行总数" + tableRows.size());
			WebElement currentRow = tableRows.get(rowNo - 1);
			List<WebElement> tablecols = currentRow.findElements(By.tagName("td"));
			System.out.println("列总数：" + tablecols.size());
			WebElement cell = tablecols.get(colNo - 1);
			System.out.println("列号：" + colNo);
			return cell;
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("没有找到相应的元素");
		}
	}

	/**
	 *  获取表格中某行某列的单元格的某个页面元素对象,by参数用于定位某个表
	 * @param rowNo
	 * @param colNO
	 * @param by
	 * @return
	 */
	public WebElement getWebElementInCell(int rowNo, int colNO, By by) {

		try {
			List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
			System.out.println("行总数" + tableRows.size());
			WebElement currentRow = tableRows.get(rowNo - 1);
			List<WebElement> tablecols = currentRow.findElements(By.tagName("td"));
			System.out.println("列总数：" + tablecols.size());
			WebElement cell = tablecols.get(colNO - 1);
			System.out.println("列号：" + colNO);

			return cell.findElement(by);
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("没有找到相应的元素");
		}
	}
	
	
}
