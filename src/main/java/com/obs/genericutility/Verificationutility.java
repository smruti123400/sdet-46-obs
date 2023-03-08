package com.obs.genericutility;

public class Verificationutility {
	/**
	 * 
	 * @param actual
	 * @param expected
	 */
	public void exactVerify(String actual, String expected,String strategy) {
		if(strategy.equalsIgnoreCase("tc"))	{
			if (actual.equals(expected)) {
				System.out.println("TC is pass");
			} else {
				System.out.println("TC is fail");
			}
		}
		else if(strategy.equalsIgnoreCase("page")) {
			if (actual.equals(expected)) {
				System.out.println(expected+" page is displayed");
			} else {
				System.out.println(expected+" page is not displayed");
			}
		}
		
		}
		
		public void partialVerify(String actual, String expected,String strategy) {
			if(strategy.equalsIgnoreCase("tc"))	{
				if (actual.equalsIgnoreCase(expected)) {
					System.out.println("TC is pass");
				} else {
					System.out.println("TC is fail");
				}
			}
			else if(strategy.equalsIgnoreCase("page")) {
				if (actual.equalsIgnoreCase(expected)) {
					System.out.println(expected+" page is displayed");
				} else {
					System.out.println(expected+" page is not displayed");
				}
			}
		}
}

