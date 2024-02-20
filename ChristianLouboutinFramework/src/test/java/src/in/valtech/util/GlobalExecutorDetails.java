package src.in.valtech.util;

public class GlobalExecutorDetails {

	private String execute;
	private String relativeTc;
	private String actualTc;
	private String dataSetConfig;
	private String driver;
	private String locale;
	private String url;
	private String breakPoint;
	private String environment;
	private String feature;
	
	/**
	 * @return the feature
	 */
	public String getFeature() {
		return feature;
	}
	/**
	 * @param feature the feature to set
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}
	/**
	 * @return the execute
	 */
	public String getExecute() {
		return execute;
	}
	/**
	 * @param execute: the execute to set
	 */
	public void setExecute(String execute) {
		this.execute = execute;
	}
	/**
	 * @return the relativeTc
	 */
	public String getRelativeTc() {
		return relativeTc;
	}
	/**
	 * @param relativeTc: the relativeTc to set
	 */
	public void setRelativeTc(String relativeTc) {
		this.relativeTc = relativeTc;
	}
	/**
	 * @return the actualTc
	 */
	public String getActualTc() {
		return actualTc;
	}
	/**
	 * @param actualTc: the actualTc to set
	 */
	public void setActualTc(String actualTc) {
		this.actualTc = actualTc;
	}
	/**
	 * @return the dataSetConfig
	 */
	public String getDataSetConfig() {
		return dataSetConfig;
	}
	/**
	 * @param dataSetConfig: the dataSetConfig to set
	 */
	public void setDataSetConfig(String dataSetConfig) {
		this.dataSetConfig = dataSetConfig;
	}
	/**
	 * @return the driver
	 */
	public String getDriver() {
		return driver;
	}
	/**
	 * @param driver: the driver to set
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}
	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}
	/**
	 * @param locale: the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url: the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * @return the breakPoint
	 */
	public String getBreakPoint() {
		return breakPoint;
	}
	/**
	 * @param breakPoint: the breakPoint to set
	 */
	public void setBreakPoint(String breakPoint) {
		this.breakPoint = breakPoint;
	}
	
	
	/**
	 * @return the environment
	 */
	public String getenvironment() {
		return environment;
	}
	/**
	 * @param environment: the environment to set
	 */
	public void setenvironment(String environment) {
		this.environment = environment;
	}
}
