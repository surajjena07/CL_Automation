package src.in.valtech.util;

public class PayPalPaymentDSDetails {

	private String dataVersion;
	private String locale;
	private String payPalUsername;
	private String payPalPassword;

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
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale
	 *            the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * @return the payPalUsername
	 */
	public String getPayPalUsername() {
		return payPalUsername;
	}

	/**
	 * @param payPalUsername
	 *            the payPalUsername to set
	 */
	public void setPayPalUsername(String payPalUsername) {
		this.payPalUsername = payPalUsername;
	}

	/**
	 * @return the payPalPassword
	 */
	public String getPayPalPassword() {
		return payPalPassword;
	}

	/**
	 * @param payPalPassword
	 *            the payPalPassword to set
	 */
	public void setPayPalPassword(String payPalPassword) {
		this.payPalPassword = payPalPassword;
	}

}
