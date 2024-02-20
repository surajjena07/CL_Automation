package src.in.valtech.util;

import java.io.IOException;

import org.apache.log4j.Logger;

public class StartServers_iOS {

	public Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * 
	 * @throws InterruptedException
	 * 
	 *             This function 1. Closes all opened Terminals 2. Clears
	 *             Instruments 3. Releases port 4723 4. Starts Appium server
	 */
	public static void startAppiumServer() throws InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("Starting appium");
		String applescriptCommand = "tell application \"Terminal\"\n"
				+ "activate\n"
				+ "do script \"killall node\"\n"
				+ "end tell\n"
				+ "delay 5\n"
				+ "tell application \"Terminal\" to quit\n"
				+ "delay 5\n"
				+ "tell application \"Terminal\"\n"
				+ "activate\n"
				+ "do script \"sudo rm ing /tmp/instruments_sock\"\n"
				+ "delay 5\n"
				+ "do script \"Valtech1@\" in window 1\n"
				+ "delay 5\n"
				+ "do script \"lsof -P | grep ':4723' | awk '{print $2}' | xargs kill -9 \" in window 1\n"
				+ "delay 5\n" + "do script \"appium &\" in window 1\n"
				+ "delay 10\n" + "end tell";

		String[] args = { "osascript", "-e", applescriptCommand };

		try {
			Process process = runtime.exec(args);

		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(70000);
	}

	/**
	 * @throws InterruptedException
	 * 
	 *             This function
	 * 
	 *             1. Releases port 27753 2. Starts WebKit Proxy server
	 * 
	 *             Note: Change UDID based on iOS device "-c<UDID>:27753"
	 */
	public static void startWebKitProxyServer() throws InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("Starting WebKit Proxy");

		String applescriptCommand = "tell application \"Terminal\"\n"
				+ "activate\n"
				+ "do script \"cd Desktop\"\n"
				+ "delay 3\n"
				+ "do script \"cd appium\" in front window\n"
				+ "delay 3\n"
				+ "do script \"lsof -P | grep ':27753' | awk '{print $2}' | xargs kill -9 \" in front window\n"
				+ "delay 5\n"
				+ "do script \"./bin/ios-webkit-debug-proxy-launcher.js -cae7e4de6d18f3990190a6db32dbc6cb28a908a40:27753 -d\" in front window\n"
				+ "delay 12\n" +"end tell";

		String[] args = { "osascript", "-e", applescriptCommand };

		try {
			Process process = runtime.exec(args);

		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(70000);
	}

}
