package com.obs.genericutilityenum;
/**
 * 
 * @author achar
 *
 */
public enum excel {
	STAFFMODULE("StaffModule");
	
	String key;
	/**
	 * this enum contains method to  get sheetname
	 * @param key
	 */
	private excel(String key) {
		this.key=key;
	}
	/**
	 * this method returns sheetname
	 * @return
	 */
	public String getSheetName() {
		return key;
	}
	

}

