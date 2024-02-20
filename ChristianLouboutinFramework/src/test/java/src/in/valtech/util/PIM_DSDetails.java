package src.in.valtech.util;

/**
 * @Author: Gopal
 */


public class PIM_DSDetails
{
	private String dataVersion;
	private String pimUsername;
	private String pimPassword;
	private String pimUrl;

	/**
	 * @return the dataVersion
	 */
	
	public String getDataVersion()
	{
		return dataVersion;
	}

	/**
	 * @param dataVersion
	 *            the dataVersion to set
	 */
	
	public void setDataVersion(String dataVersion) 
	{
		this.dataVersion = dataVersion;
	}

	/**
	 * @return the pimUsername
	 */
	
	public String getpimUsername() 
	{
		return pimUsername;
	}

	/**
	 * @param pimUsername
	 *            the pimUsername to set
	 */
	public void setpimUsername(String pimUsername)
	{
		this.pimUsername = pimUsername;
	}

	/**
	 * @return the pimPassword
	 */
	public String getpimPassword() {
		return pimPassword;
	}

	/**
	 * @param pimPassword
	 *            the pimPassword to set
	 */
	public void setpimPassword(String pimPassword) {
		this.pimPassword = pimPassword;
	}
	
	/**
	* @return the pim url
	*/
	public String getpimUrl() {
	return pimUrl;
	}

	/**
	* @param pim url
	* the pim url to set
	*/
	public void setpimUrl(String pimUrl) {
	this.pimUrl = pimUrl;
	}


}
