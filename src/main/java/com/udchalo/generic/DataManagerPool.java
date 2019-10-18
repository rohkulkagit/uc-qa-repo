package com.udchalo.generic;
import java.io.FileInputStream;
import java.util.Hashtable;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @ScriptName : DataManagerPool
 * @Description : Excel Data Management
 * @Author : udchalo QA Automation Developer
 * @since : 05-Aug-2019
 */
public class DataManagerPool {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private FileInputStream excelFileIS;
	private Row headerRow;
	private Row testDataRow;

	/**
	 * @Method : loadTestData(String testCaseID, String testDataFile)
	 * @Description : Load Data from Excel for the running testCase and return
	 *              as Object array
	 * @author : udchalo QA Automation Developer
	 */
	public Hashtable<String, Hashtable<String, String>> loadTestData(String testDataFilePath) {
	
		Hashtable<String, Hashtable<String, String>> objDataProvider = null;

		// Logic to read the Excel workBook
		try {
			excelFileIS = new FileInputStream(testDataFilePath);
			workbook = new XSSFWorkbook(excelFileIS);
			sheet = workbook.getSheetAt(0);
			headerRow = sheet.getRow(0);
			testDataRow = sheet.getRow(1);
			int intLastRowNumber = sheet.getLastRowNum();
			int intRowIndex = 0;
			String strBufferCell = "";
			String strTCID = "";
			objDataProvider = new Hashtable<String, Hashtable<String, String>>();

			while (intRowIndex <= intLastRowNumber) {
				strBufferCell = this.getCellValue(sheet.getRow(intRowIndex), 0);
				if (strBufferCell.trim().equalsIgnoreCase("TC ID")) {
					headerRow = sheet.getRow(intRowIndex);
					testDataRow = sheet.getRow(intRowIndex + 1);
					strTCID = this.getCellValue(testDataRow, 0);

					Hashtable<String, String> dataValueSet = new Hashtable<String, String>();
					int intColumnNo = 0;
					// iterating over cells
					do {
						String strHeader = "", strTestData = "";
						// Key Data
						strHeader = this.getCellValue(headerRow, intColumnNo);
						// Value
						strTestData = this.getCellValue(testDataRow, intColumnNo);

						if (!strHeader.equals(""))
							dataValueSet.put(strHeader, strTestData);
						intColumnNo++;

					} while (intColumnNo < headerRow.getLastCellNum());
					
					// put the dataValueSet hash-table in objDataProvider
					intColumnNo = 0;
					objDataProvider.put(strTCID, dataValueSet);
				}
				intRowIndex++;

				intRowIndex++;
			}
			excelFileIS.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			// hashTableList = null;
		}
		return objDataProvider;
	}

	/**
	 * @Method : getCellValue(Cell testDataCell, int columnNumber)
	 * @Description : Get Cell value for given cell (Used in loadDataProvider)
	 * @author : udchalo QA Automation Developer
	 */
	private String getCellValue(Row testDataRow, int intColumnNumber) {
		if (testDataRow == null)
			return "";
		else {
			Cell testDataCell = testDataRow.getCell(intColumnNumber, Row.RETURN_BLANK_AS_NULL);
			if (testDataCell == null)
				return "";
			else
				return testDataCell.toString().trim();
		}
	}
}
