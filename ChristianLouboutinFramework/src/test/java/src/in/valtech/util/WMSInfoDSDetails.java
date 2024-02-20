package src.in.valtech.util;
/**
 * @Author: Veena
 */
public class WMSInfoDSDetails {

	private String dataVersion;
	private String wmsurl;
	private String wmsUsername;
	private String wmsPassword;

	/**
	 * @return the dataVersion
	 */
	public String getDataVersion() {
		return dataVersion;
	}

	/**
	 * @param dataVersion
	 *            the dataVersion to set
	 */
	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}
	
	/**
	 * @return the wmsurl
	 */
	public String getWMSURL() {
		return wmsurl;
	}

	/**
	 * @param wmsurl
	 *            the WMS URL to set
	 */
	public void setWMSURL(String wmsurl) {
		this.wmsurl = wmsurl;
	}

	/**
	 * @return the wmsUsername
	 */
	public String getWmsUsername() {
		return wmsUsername;
	}

	/**
	 * @param wmsUsername
	 *            the wmsUsername to set
	 */
	public void setWmsUsername(String wmsUsername) {
		this.wmsUsername = wmsUsername;
	}

	/**
	 * @return the wmsPassword
	 */
	public String getWmsPassword() {
		return wmsPassword;
	}

	/**
	 * @param wmsPassword
	 *            the wmsPassword to set
	 */
	public void setWmsPassword(String wmsPassword) {
		this.wmsPassword = wmsPassword;
	}

}

