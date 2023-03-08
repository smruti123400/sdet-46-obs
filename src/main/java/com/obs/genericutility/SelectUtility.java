package com.obs.genericutility;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

	public class SelectUtility {
		Select s=null;
		
		public void initializeSelect(WebElement select) {
			s=new Select(select);
		}
		public void selectByIndex(int index) {
			s.selectByIndex(index);
		}
		public void selectByValue1(String value) {
			s.selectByValue(value);
		}
		public void selectByVisibleText(String visibleText) {
			s.selectByVisibleText(visibleText);
		}
		public void printOptions() {
			List<WebElement> options = s.getOptions();
			for(WebElement option:options) {
				System.out.println(option.getText());
			}
		}
		public void printSelectedOptions() {
			List<WebElement> selectedOptions = s.getAllSelectedOptions();
			for(WebElement selectedOption:selectedOptions) {
				System.out.println(selectedOption.getText());
			}
		}
		public void selectAllOption() {
			List<WebElement> options = s.getOptions();
			for(int i=0;i<options.size();i++) {
				s.selectByIndex(i);
			}

		}

		public void deSelectByIndex(int index) {
			s.deselectByIndex(index);
		}
		public void deSelectByValue(String value) {
			s.deselectByValue(value);
		}
		public void deSelectByVisibleText(String visibleText) {
			s.deselectByVisibleText(visibleText);


		}
		public void deSelectAllOption() {
			List<WebElement> options = s.getOptions();
			for(int i=0;i<options.size();i++) {
				s.deselectByIndex(i);
			}

		}
		public void selectByValue1(WebElement city) {
			// TODO Auto-generated method stub
			
		}


	}

