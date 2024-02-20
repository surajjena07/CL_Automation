package src.in.valtech.util;
import java.io.File; 
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.PropertyConfigurator;
import org.testng.TestNG;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.codoid.products.fillo.Recordset;

import src.in.valtech.config.BaseTest;

public class GenerateFrontXMLfile {

	public static Properties commonProp = new Properties();
	public static String rootDirectory = getRootDir();
	public static Properties sysProps = System.getProperties();
	public static String environmentNametxt;

	public static void generateXMLfile(String environmentName) throws Exception {
		System.out.println("----------------Inside Generate XML-----------");
		List<String> featureNameList = new ArrayList<>();
		String environment = "";
		String suitePath = "";
		String threadCount = "";
		environmentNametxt = environmentName;
		if (environmentName.equalsIgnoreCase("HomoEnv")) {
			System.out.println("----------------Inside HomoEnv------------");
			featureNameList = ExcelReader
					.getGlobalFeatureSheets(commonProp.getProperty("cl.automation.excel.path.homoenv"));
			environment = commonProp.getProperty("cl.automation.excel.path.homoenv");
			suitePath = commonProp.getProperty("cl.automation.test.suite.path.homoenv");
			threadCount = commonProp.getProperty("cl.browserstack.thread.count.homoenv");
		} else if (environmentName.equalsIgnoreCase("StagingEnv")) {
			System.out.println("----------------Inside StagingEnv------------");
			featureNameList = ExcelReader
					.getGlobalFeatureSheets(commonProp.getProperty("cl.automation.excel.path.stagingenv"));
			environment = commonProp.getProperty("cl.automation.excel.path.stagingenv");
			suitePath = commonProp.getProperty("cl.automation.test.suite.path.stagingenv");
			threadCount = commonProp.getProperty("cl.browserstack.thread.count.stagingenv");
		} else if (environmentName.equalsIgnoreCase("StagingEnv1")) {
			System.out.println("----------------Inside StagingEnv1------------");
			featureNameList = ExcelReader
					.getGlobalFeatureSheets(commonProp.getProperty("cl.automation.excel.path.stagingenv1"));
			environment = commonProp.getProperty("cl.automation.excel.path.stagingenv1");
			suitePath = commonProp.getProperty("cl.automation.test.suite.path.stagingenv1");
			threadCount = commonProp.getProperty("cl.browserstack.thread.count.stagingenv1");
		} else if (environmentName.equalsIgnoreCase("IntegrationEnv")) {
			System.out.println("----------------Inside IntegrationEnv------------");
			featureNameList = ExcelReader
					.getGlobalFeatureSheets(commonProp.getProperty("cl.automation.excel.path.integrationenv"));
			environment = commonProp.getProperty("cl.automation.excel.path.integrationenv");
			suitePath = commonProp.getProperty("cl.automation.test.suite.path.integrationenv");
			threadCount = commonProp.getProperty("cl.browserstack.thread.count.integrationenv");
		} else if (environmentName.equalsIgnoreCase("HomoEnv1")) {
			System.out.println("----------------Inside HomoEnv1------------");
			featureNameList = ExcelReader
					.getGlobalFeatureSheets(commonProp.getProperty("cl.automation.excel.path.homoenv1"));
			environment = commonProp.getProperty("cl.automation.excel.path.homoenv1");
			suitePath = commonProp.getProperty("cl.automation.test.suite.path.homoenv1");
			threadCount = commonProp.getProperty("cl.browserstack.thread.count.homoenv1");
		} else if (environmentName.equalsIgnoreCase("Integration6Env")) {
			System.out.println("----------------Inside Integration6Env------------");
			featureNameList = ExcelReader
					.getGlobalFeatureSheets(commonProp.getProperty("cl.automation.excel.path.integration6env"));
			environment = commonProp.getProperty("cl.automation.excel.path.integration6env");
			suitePath = commonProp.getProperty("cl.automation.test.suite.path.integration6env");
			threadCount = commonProp.getProperty("cl.browserstack.thread.count.homoenv1");
		}
		else if (environmentName.equalsIgnoreCase("HomoEnv2")) {
			System.out.println("----------------Inside HomoEnv2------------");
			featureNameList = ExcelReader
					.getGlobalFeatureSheets(commonProp.getProperty("cl.automation.excel.path.homoenv2"));
			environment = commonProp.getProperty("cl.automation.excel.path.homoenv2");
			suitePath = commonProp.getProperty("cl.automation.test.suite.path.homoenv2");
			threadCount = commonProp.getProperty("cl.browserstack.thread.count.HomoEnv2");
		}

		for (int i = 0; i < featureNameList.size(); i++) {

			generateModuleXMLFile(featureNameList.get(i).toLowerCase(), environment, suitePath, environmentNametxt,
					threadCount);
		}

	}

	public static void generateModuleXMLFile(String module, String environment, String suitePath, String envCode,
			String threadCount) {

		int i = 0;
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements :Suite
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("suite");
			doc.appendChild(rootElement);
			Element listeners = doc.createElement("listeners");
			rootElement.appendChild(listeners);
			// Element listener = doc.createElement("listener");
			listeners.setAttribute("class-name", "src.in.valtech.util.ExtentTestNGIReporterListener");
			Element listener1 = doc.createElement("listener");
			listener1.setAttribute("class-name", "src.in.valtech.util.ExtentReport");

			// Set the name attribute
			Attr attr = doc.createAttribute("name");
			attr.setValue("CL-Automation ON:" + module.toUpperCase());
			rootElement.setAttributeNode(attr);

			Attr rootParallelAttribute = doc.createAttribute("parallel");
			rootParallelAttribute.setValue("tests");

			rootElement.setAttributeNode(rootParallelAttribute);

			Attr rootThreadCountAttribute = doc.createAttribute("thread-count");
			rootThreadCountAttribute.setValue(threadCount);
			rootElement.setAttributeNode(rootThreadCountAttribute);

			Recordset recordset = ExcelReader.getFilloConnection(environment, module.toUpperCase());

			while (recordset.next()) {

				if (recordset.getField("EXECUTE").equalsIgnoreCase("YES")) {
					i++;

					// tests elements
					Element tests = doc.createElement("test");
					rootElement.appendChild(tests);
					// Set the name attribute
					Attr attr1 = doc.createAttribute("name");
					attr1.setValue(recordset.getField("TESTCASE") + "_" + recordset.getField("LOCALE") + "_"
							+ recordset.getField("DRIVER") + "_" + recordset.getField("BREAKPOINT"));

					tests.setAttributeNode(attr1);

					// parameter TC
					Element par = doc.createElement("parameter");
					tests.appendChild(par);
					// Set the name attribute
					Attr attr2 = doc.createAttribute("name");
					attr2.setValue("TESTCASE");
					par.setAttributeNode(attr2);
					Attr attr21 = doc.createAttribute("value");

					attr21.setValue(recordset.getField("TESTCASE"));
					par.setAttributeNode(attr21);

					// parameter
					Element par3 = doc.createElement("parameter");
					tests.appendChild(par3);
					// Set the name attribute
					Attr attr4 = doc.createAttribute("name");
					attr4.setValue("LOCALE");
					par3.setAttributeNode(attr4);
					Attr attr41 = doc.createAttribute("value");
					attr41.setValue(recordset.getField("LOCALE"));
					par3.setAttributeNode(attr41);

					Element par5_1 = doc.createElement("parameter");
					tests.appendChild(par5_1);
					// Set the name attribute
					Attr attr12 = doc.createAttribute("name");
					attr12.setValue("DS_CONFIG");
					par5_1.setAttributeNode(attr12);
					Attr attr612 = doc.createAttribute("value");
					attr612.setValue(recordset.getField("DS_CONFIG"));
					par5_1.setAttributeNode(attr612);

					// parameter
					Element par5 = doc.createElement("parameter");
					tests.appendChild(par5);
					// Set the name attribute
					Attr attr6 = doc.createAttribute("name");
					attr6.setValue("APPLICATION");
					par5.setAttributeNode(attr6);
					Attr attr61 = doc.createAttribute("value");
					attr61.setValue("FRONT");
					par5.setAttributeNode(attr61);

					// parameter
					Element par6 = doc.createElement("parameter");
					tests.appendChild(par6);
					// Set the name attribute
					Attr attr7 = doc.createAttribute("name");
					attr7.setValue("ACTUAL_TC");
					par6.setAttributeNode(attr7);
					Attr attr71 = doc.createAttribute("value");
					attr71.setValue(recordset.getField("ACTUAL_TC"));
					par6.setAttributeNode(attr71);

					// parameter
					Element par7 = doc.createElement("parameter");
					tests.appendChild(par7);
					// Set the name attribute
					Attr attr8 = doc.createAttribute("name");
					attr8.setValue("BREAKPOINT");
					par7.setAttributeNode(attr8);
					Attr attr81 = doc.createAttribute("value");
					attr81.setValue(recordset.getField("BREAKPOINT"));
					par7.setAttributeNode(attr81);

					// parameter
					Element par8 = doc.createElement("parameter");
					tests.appendChild(par8);
					// Set the name attribute
					Attr attr9 = doc.createAttribute("name");
					attr9.setValue("URL");
					par8.setAttributeNode(attr9);
					Attr attr91 = doc.createAttribute("value");
					attr91.setValue(recordset.getField("URL"));
					par8.setAttributeNode(attr91);

					// parameter
					Element par9 = doc.createElement("parameter");
					tests.appendChild(par9);
					// Set the name attribute
					Attr attr10 = doc.createAttribute("name");
					attr10.setValue("DRIVER");
					par9.setAttributeNode(attr10);
					Attr attr101 = doc.createAttribute("value");
					attr101.setValue(recordset.getField("DRIVER"));
					par9.setAttributeNode(attr101);

					// parameter
					Element par10 = doc.createElement("parameter");
					tests.appendChild(par10);
					// Set the name attribute
					Attr attr14 = doc.createAttribute("name");
					attr14.setValue("BROWSERSTACK");
					par10.setAttributeNode(attr14);
					Attr attr111 = doc.createAttribute("value");
					attr111.setValue(recordset.getField("BROWSERSTACK"));
					par10.setAttributeNode(attr111);

					if (recordset.getField("DRIVER").equals("ANDROID") || recordset.getField("DRIVER").equals("IOS"))

					{
						Element par11 = doc.createElement("parameter");
						tests.appendChild(par11);
						// Set the name attribute
						Attr attr15 = doc.createAttribute("name");
						attr15.setValue("BROWSER_DEVICE_VERSION");
						par11.setAttributeNode(attr15);
						Attr attr121 = doc.createAttribute("value");
						attr121.setValue(recordset.getField("OS") + ":" + recordset.getField("DEVICE") + ":"
								+ recordset.getField("BROWSER_VERSION"));
						par11.setAttributeNode(attr121);
					}

					else {

						Element par11 = doc.createElement("parameter");
						tests.appendChild(par11);
						// Set the name attribute
						Attr attr15 = doc.createAttribute("name");
						attr15.setValue("BROWSER_DEVICE_VERSION");
						par11.setAttributeNode(attr15);
						Attr attr121 = doc.createAttribute("value");
						attr121.setValue(recordset.getField("BROWSER_VERSION"));
						par11.setAttributeNode(attr121);
					}

					// Adding Unique Test Name
					Element uniquePar = doc.createElement("parameter");
					tests.appendChild(uniquePar);
					// Set the name attribute
					Attr uniqueName = doc.createAttribute("name");
					uniqueName.setValue("TESTCASENAME");
					uniquePar.setAttributeNode(uniqueName);
					Attr uniqueValue = doc.createAttribute("value");
					uniqueValue.setValue(attr1.getValue());
					uniquePar.setAttributeNode(uniqueValue);

					// Adding Unique Test Name
					Element uniquePar1 = doc.createElement("parameter");
					tests.appendChild(uniquePar1);
					// Set the name attribute
					Attr uniqueName1 = doc.createAttribute("name");
					uniqueName1.setValue("ENVIRONMENT");
					uniquePar1.setAttributeNode(uniqueName1);
					Attr uniqueValue1 = doc.createAttribute("value");
					uniqueValue1.setValue(envCode);
					uniquePar1.setAttributeNode(uniqueValue1);

					// classes
					Element classes = doc.createElement("classes");
					tests.appendChild(classes);

					String[] array = null;
					// ArrayList<String> depclasses = new ArrayList<String>();
					if (!recordset.getField("DEPENDENCIES").equalsIgnoreCase("NA")) {
						array = recordset.getField("DEPENDENCIES").split(",");

						Recordset resultset = ExcelReader.getFilloConnection(environment, module.toUpperCase());
						while (resultset.next()) {
							for (String e : array) {

								if (e.equalsIgnoreCase(resultset.getField("TESTCASE"))) {
									String class_name = resultset.getField("ACTUAL_TC");
									Element class_names = doc.createElement("class");
									classes.appendChild(class_names);
									Attr depclass = doc.createAttribute("name");
									depclass.setValue("src.in.valtech.cl.scenarios." + class_name);
									class_names.setAttributeNode(depclass);

								}
							}
						}
					}

					Element class_names = doc.createElement("class");
					classes.appendChild(class_names);
					Attr attr11 = doc.createAttribute("name");
					attr11.setValue("src.in.valtech.cl.scenarios." + recordset.getField("ACTUAL_TC"));
					class_names.setAttributeNode(attr11);
					// write xml to file
					TransformerFactory transformerFactory = TransformerFactory.newInstance();

					Transformer transformer = transformerFactory.newTransformer();
					transformer.setOutputProperty(OutputKeys.INDENT, "yes");
					transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
					DOMSource source = new DOMSource(doc);
					StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + suitePath +"scenarios"+".xml").getPath());
					transformer.transform(source, result);
				}

			}
			System.out.println("List Size : " + i);
			System.out.println("Feature name: " + module);
			
		} catch (Exception e) {

		}
	}

	public static void main(String args[]) throws Exception {

		// configuration for log4j property file path
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/resources/log4j_StagingEnv1.properties");

		// configuration for common execution property file path
		commonProp = new Properties();
		commonProp.load(
				new FileInputStream(System.getProperty("user.dir") + "/resources/front/common_execution.properties"));

		// Fetching the Test data values & generating the XML file for execution.
		generateXMLfile("StagingEnv1");
		Thread.sleep(2000);

		// running the xml file from testSuites folder
		autoRunXml();
		
	}

	public static String getRootDir() {
		File path = new File("");
		String absPath = path.getAbsolutePath();
		File dir = new File(absPath);
		String rootDir = dir.getParent();
		return rootDir;
	}

	public static Properties getCommonProp() {
		return commonProp;
	}

	public static void setCommonProp(Properties commonProp) {
		GenerateFrontXMLfile.commonProp = commonProp;
	}

	@SuppressWarnings("unchecked")
	public static void autoRunXml()
	{
		// Create a list
		List files = new ArrayList();

		// Add the required xml files to the list
		files.add(System.getProperty("user.dir") + "/testSuites/front/StagingEnv1/TestSuite_scenarios.xml");

		// create object for TestNG
		TestNG tng = new TestNG();

		// Add the list of files to create a suite
		tng.setTestSuites(files);

		// Run the suite
		tng.run();

	}

}
