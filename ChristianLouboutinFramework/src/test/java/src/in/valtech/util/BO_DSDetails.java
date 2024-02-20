package src.in.valtech.util;

/**
 * @Author: Gopal
 */

public class BO_DSDetails
{
	private String dataVersion;
	private String BO_URL;
	private String BO_Username;
	private String BO_Password;
	
	/**
	 * @return the dataVersion
	 */
	public String getDataVersion() {
		return dataVersion;
	}

	/**
	 * @param dataVersion
	 *  MethodName=setDataVersion()     
	 */
	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}
	

	/**
	 * @return the BO_URL
	 */
	public String getBO_URL() {
		return BO_URL;
	}

	/**
	 * @param BO_URL
	 *  MethodName=setBOURL()     
	 */
	public void setBO_URL(String BO_URL) {
		this.BO_URL = BO_URL;
	}

	
	/**
	 * @return BO_Username
	 */
	public String getBO_Username() {
		return BO_Username;
	}

	/**
	 * @param BO_Username
	 * MethodName=setBO_Username()
	 */
	public void setBO_Username(String BO_Username) {
		this.BO_Username = BO_Username;
	}

	/**
	 * @return BO_Password
	 */
	public String getBO_Password() {
		return BO_Password;
	}

	/**
	 * @param BO_Password
	 * MethodName=setBO_Password()
	 */
	public void setBO_Password(String BO_Password) {
		this.BO_Password = BO_Password;
	}

	/**
	 * @param BO_RootCategory
	 * MethodName=setBO_RootCategory()
	 */
}