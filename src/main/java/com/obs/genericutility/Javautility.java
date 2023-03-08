package com.obs.genericutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * 
 * @author achar
 *
 */
public class Javautility {

	private SimpleDateFormat sdf;
	    private Calendar cal;
	    
	    
	    /**
	     * this method is used for take account number
	     * @param alertText
	     * @return
	     */
public String getAcnoFromAlertString(String alertText) {
	String accnum=alertText.replaceAll("[^0-9]","");
	return accnum;
}



/**
 * This generic method will return current date
 * @return 
 */
public String getCurrentStringDateTime() {
      sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	 cal=Calendar.getInstance();
	String date=sdf.format(cal.getTime());
	return date;
}
}