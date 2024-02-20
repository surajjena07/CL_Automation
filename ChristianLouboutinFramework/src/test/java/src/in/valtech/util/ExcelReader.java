package src.in.valtech.util;
import java.io.FileInputStream; 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelReader {

	static Recordset recordset;
	public static String value = null;
	//static List<String> configDetails = new ArrayList<String>();

	/**
	 * Method:getColumnValue Description:This method fetches the column value
	 * for the specified version from the excel sheet.
	 * 
	 * @param fileName
	 *            :Excel File name from where data to be fetched
	 * @param sheet
	 *            : Sheet name of the excel
	 * @param dataVersion
	 *            : DataVesion for which column value to be retrieved
	 * @param colName
	 *            : Name of the column for which column value to be retrieved
	 * 
	 * @return :colValue
	 */
	public static String getColumnValue(String fileName, String sheet,
			String dataVersion, String colName) {

		int columnIndex = 0;
		String expString = null;
		/**
		 * Create a new instance for cellDataList
		 */
		List<List<XSSFCell>> cellDataList = new ArrayList<List<XSSFCell>>();
		try {
			/**
			 * Create a new instance for FileInputStream
			 */
			FileInputStream fileInputStream = new FileInputStream(fileName);

			/**
			 * Create a new instance for POIFSFileSystem class
			 */
			//POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);

			/*
			 * Create a new instance for HSSFWorkBook
			 */
			XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
			XSSFSheet hssfSheet = workBook.getSheet(sheet);
			/**
			 * Iterate the rows and cells of the spreadsheet * to get all the
			 * datas
			 */
			Iterator<Row> rowIterator = hssfSheet.rowIterator();

			while (rowIterator.hasNext()) {
				XSSFRow hssfRow = (XSSFRow) rowIterator.next();

				Iterator<Cell> iterator = hssfRow.cellIterator();

				List<XSSFCell> cellTempList = new ArrayList<XSSFCell>();
				while (iterator.hasNext()) {

					XSSFCell hssfCell = (XSSFCell) iterator.next();

					if (hssfRow.getRowNum() == 0) {
						if (hssfCell.getStringCellValue().equalsIgnoreCase(
								colName)) {
							columnIndex = hssfCell.getColumnIndex();
						}
					}

					cellTempList.add(hssfCell);
				}
				cellDataList.add(cellTempList);
			}
			for (int i = 0; i < cellDataList.size(); i++) {

				List cellTempList = (List) cellDataList.get(i);
				for (int j = 0; j < cellTempList.size(); j++) {

					if (cellTempList.get(j).toString()
							.equalsIgnoreCase(dataVersion)) {
						expString = cellTempList.get(columnIndex).toString();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return expString;
	}

	/**
	 * Method:getGlobalFeatureSheets Description:This method fetches the Global
	 * Feature Sheets
	 * 
	 * @param fileName
	 *            :Excel File name from where data to be fetched
	 * @return :
	 */
	public static List<String> getGlobalFeatureSheets(String fileName) {

		List<String> sheetList = new ArrayList<String>();

		try {
			/**
			 * Create a new instance for FileInputStream
			 */
			FileInputStream fileInputStream = new FileInputStream(fileName);

			/**
			 * Create a new instance for POIFSFileSystem class
			 */
			//POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);

			/*
			 * Create a new instance for HSSFWorkBook
			 */
			XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);

			// Get Sheet Count
			int sheetCount = workBook.getNumberOfSheets();

			// Add Feature GLOBALEXECUTER sheets to list
			for (int i = 0; i < sheetCount; i++) {
				if (workBook.getSheetName(i).contains("GLOBALEXECUTER"))
					sheetList.add(workBook.getSheetName(i).replace(
							"GLOBALEXECUTER_", ""));

			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return sheetList;
	}

	/**
	 * Method : To fetch the data from the Excel using Fillo
	 * 
	 * @param fileName
	 * @param sheetame
	 * @param colName
	 * @return
	 * @throws FilloException
	 */
	public static Recordset getFilloConnection(String fileName, String Sheetname) throws FilloException
			{

		List<String> sheetList = new ArrayList<String>();
		String sheet = null;
		sheetList = getGlobalFeatureSheets(fileName);

		for (int i = 0; i < sheetList.size(); i++) {
			if (sheetList.get(i).equalsIgnoreCase(Sheetname)) {
				sheet = "GLOBALEXECUTER_" + Sheetname;

			}
		}

		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection(fileName);
		String strQuery = "Select * from " + sheet;

		recordset = connection.executeQuery(strQuery);

		return recordset;
	}

	/**
	 * Method : To fetch the data from the Excel using Fillo
	 * 
	 * @param fileName
	 * @param sheetame
	 * @param colName
	 * @return
	 * @throws FilloException
	 */
	public static String getDataConfigDetails(String fileName,
			String Sheetname, String colname, String Dataversion)
			throws FilloException {
		String value = null;
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection(fileName);
		String strQuery = "Select * from " + Sheetname
				+ " Where DATA_VERSION='" + Dataversion + "'";
		recordset = connection.executeQuery(strQuery);
		while (recordset.next()) {

			value = recordset.getField(colname);
		}
		return value;
	}

}
