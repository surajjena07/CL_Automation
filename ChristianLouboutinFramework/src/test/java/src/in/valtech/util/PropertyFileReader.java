package src.in.valtech.util;

import src.in.valtech.custom.CustomFun;

import java.io.*;
import java.util.*;

/**
 * author Gopalaswamy
 */

public class PropertyFileReader {

	/**
	 * Properties.
	 */
	public static ThreadLocal<Properties> ObjRepoProp = new ThreadLocal<Properties>();
	public static ThreadLocal<Properties> TextProp = new ThreadLocal<Properties>();
	public static ThreadLocal<Properties> commonProp = new ThreadLocal<Properties>();

	public static String rootDir = CustomFun.getRootDir();

	/**
	 * Load Property File.
	 * 
	 **/
	public static void loadProprtyFile(String locale, String application) {

		ObjRepoProp.set(new Properties());
		TextProp.set(new Properties());
		commonProp.set(new Properties());

		try {

			if (application.equalsIgnoreCase("BACK")) {
				// NA
			}

			if (application.equalsIgnoreCase("FRONT")) {
				// Reading/loading the ObjectRepository property file.
				ObjRepoProp.get().load(new FileInputStream(System.getProperty("user.dir") + "/resources/front/ObjRepository.properties"));
				commonProp.get().load(new FileInputStream(System.getProperty("user.dir") + "/resources/front/common_execution.properties"));

				switch (locale) {

				case "CH_FR":
					// Reading/loading the Text property file-CH Locale.
					TextProp.get().load(new FileInputStream(System.getProperty("user.dir") + "/resources/front/textData/Text_CH_FR.properties"));
					break;
			
				case "FR_FR":
					// Reading/loading the Text property file-FR Locale.
					TextProp.get().load(new FileInputStream(System.getProperty("user.dir") + "/resources/front/textData/Text_FR_FR.properties"));
					break;

				case "CA":
					// Reading/loading the Text property file-CA Locale.
					TextProp.get().load(new FileInputStream(System.getProperty("user.dir") + "/resources/front/textData/Text_CA.properties"));
					break;

				default:
					// Reading/loading the Text property file-UK Locale.
					TextProp.get().load(new FileInputStream(System.getProperty("user.dir") + "/resources/front/textData/Text_UK_EN.properties"));

				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static ThreadLocal<Properties> getObjRepoProp() {
		return ObjRepoProp;
	}

	public static void setObjRepoProp(ThreadLocal<Properties> objRepoProp) {
		ObjRepoProp = objRepoProp;
	}

	public static ThreadLocal<Properties> getTextProp() {
		return TextProp;
	}

	public static void setTextProp(ThreadLocal<Properties> textProp) {
		TextProp = textProp;
	}

	public static ThreadLocal<Properties> getCommonProp() {
		return commonProp;
	}

	public static void setCommonProp(ThreadLocal<Properties> commonProp) {
		PropertyFileReader.commonProp = commonProp;
	}
}
