package com.test.sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Table {
	// ����һ�� WElement�������ڴ洢ҳ��ı��Ԫ�ض���
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

	// ��ȡ���Ԫ�ص����������ұ��Ԫ���м���trԪ��
	// �м���trԪ�أ��Ϳ���֪������м��У�tr�����ͱ��������һ��
	public int getRowCount() {
		List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
		return tableRows.size();
	}

	// ��ȡ���Ԫ�ص�����
	public int getColumnCount() {
		List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
		return tableRows.get(0).findElements(By.tagName("td")).size();
	}

	// ��ȡ�����ĳ��ĳ�еĵ�Ԫ�����
	public WebElement getCell(int rowNo, int colNo) {
		try {
			List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
			System.out.println("������" + tableRows.size());
			WebElement currentRow = tableRows.get(rowNo - 1);
			List<WebElement> tablecols = currentRow.findElements(By.tagName("td"));
			System.out.println("��������" + tablecols.size());
			WebElement cell = tablecols.get(colNo - 1);
			System.out.println("�кţ�" + colNo);
			return cell;
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("û���ҵ���Ӧ��Ԫ��");
		}
	}

	/**
	 *  ��ȡ�����ĳ��ĳ�еĵ�Ԫ���ĳ��ҳ��Ԫ�ض���,by�������ڶ�λĳ����
	 * @param rowNo
	 * @param colNO
	 * @param by
	 * @return
	 */
	public WebElement getWebElementInCell(int rowNo, int colNO, By by) {

		try {
			List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
			System.out.println("������" + tableRows.size());
			WebElement currentRow = tableRows.get(rowNo - 1);
			List<WebElement> tablecols = currentRow.findElements(By.tagName("td"));
			System.out.println("��������" + tablecols.size());
			WebElement cell = tablecols.get(colNO - 1);
			System.out.println("�кţ�" + colNO);

			return cell.findElement(by);
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("û���ҵ���Ӧ��Ԫ��");
		}
	}
	
	
}
