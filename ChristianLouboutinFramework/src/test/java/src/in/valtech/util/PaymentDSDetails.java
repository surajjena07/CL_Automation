package src.in.valtech.util;

public class PaymentDSDetails {
	
	
	private String locale;
	private String cardType;
	private String cardNumber;
	private String cardHolderName;
	private String cardExpiryDate;
	private String cardCVV;
	private String dataVersion;
	private String DS_Username;
	private String DS_Password;

	
	/**
	 * @return the dataVersion
	 */
	public String getDataVersion() {
		return dataVersion;
	}
	/**
	 * @param dataVersion the dataVersion to set
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
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	
	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	
	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
	/**
	 * @return the cardHolderName
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}
	/**
	 * @param cardHolderName the cardHolderName to set
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	
	
	/**
	 * @return the cardExpiryDate
	 */
	public String getCardExpiryDate() {
		return cardExpiryDate;
	}
	/**
	 * @param cardExpiryDate
	 */
	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	
	
	/**
	 * @return the cardCVV
	 */
	public String getCardCVV() {
		return cardCVV;
	}
	/**
	 * @param cardCVV
	 */
	public void setCardCVV(String cardCVV) {
		this.cardCVV = cardCVV;
	}
	
	/**
	 * @return the 3DS_Username
	 */
	public String get3DS_Username() {
		return DS_Username;
	}
	/**
	 * @param cardExpiryDate
	 */
	public void set3DS_Username(String DS_Username) {
		this.DS_Username = DS_Username;
	}
	
	
	/**
	 * @return the 3DS_Password
	 */
	public String get3DS_Password() {
		return DS_Password;
	}
	/**
	 * @param cardCVV
	 */
	public void set3DS_Password(String DS_Password) {
		this.DS_Password = DS_Password;
	}


}
