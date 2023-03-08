package com.obs.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.obs.genericutilityenum.Propertyfile;

public class PropertyFileUtility {
	
		FileInputStream fis=null;
		FileOutputStream fos=null;
		Properties p=null;
		public PropertyFileUtility() {
			initialize();
		}
		/**
		 * this method is used to intialize
		 */
		public void initialize() {

			try {
				fis=new FileInputStream(Constant.TEST_PROPERTY_FILE_PATH);
				p=new Properties();
				p.load(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/**
		 * this method is used to set the path
		 */
		
		public void set() {
			try {
				fos=new FileOutputStream(Constant.TEST_PROPERTY_FILE_PATH,true);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		/**
		 * this method used to return key value
		 * @param key
		 * @return
		 */
		public String getPropertyData(Propertyfile key) {	
			String k=key.name().toLowerCase();
			String data=p.getProperty(k,"").trim();
			return data;
		}
	/**
	 * this method used to return key and value
	 * @param key
	 * @param value
	 */
		public void setPropertyData(String key,String value) {
			p.setProperty(key, value);
		       try {
				p.store(fos, " New Data Added ");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	

}