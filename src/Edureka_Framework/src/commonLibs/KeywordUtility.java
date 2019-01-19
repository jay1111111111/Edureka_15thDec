package commonLibs;

import org.openqa.selenium.By;

public class KeywordUtility {
	
CommonDriver Driver;
	
	public KeywordUtility(){
		Driver  = new CommonDriver();
	}
	
	public String performAction(String sActionName, By oBy, String value) throws Exception{
		sActionName = sActionName.trim();
		
		if(sActionName.isEmpty()){
			return "No keyword found.."; 
		}
		
		if(sActionName.equalsIgnoreCase("click")){
			Driver.click(oBy);
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("openbrowser")){
			
			Driver.invokebrowser(value, "about:blank");
		
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("setPageLoadTimeOut")){
			
			Driver.setPageLoadTimeout(Long.valueOf(value));
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("setElementDetectionTimeout")){
			
			Driver.setElementDetectionTimeout(Long.valueOf(value));
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("navigateToUrl")){
			
			Driver.navigateToUrl(value);
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("navigateBack")){
				
			Driver.navigateBack();
				
				
				return "";
			}
			
		if(sActionName.equalsIgnoreCase("navigateForward")){
			
			Driver.navigateForward();
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("closeAllBrowser")){
			
			Driver.closeAllBrowser();
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("closeCurrentBrowser")){
			
			Driver.closeBrowser();
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("waitTillElementIsVisible")){
			
			
			Driver.waitTillElementVisible(oBy, Long.valueOf(value));
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("savepagesnapshot")){
			
			Driver.savePageSnapShot(value);
			
			
			return "";
		}
		
		
		if(sActionName.equalsIgnoreCase("clear")){
			
			Driver.clear(oBy);
			return "";
		}
		
		
		
		if(sActionName.equalsIgnoreCase("acceptAlert")){
			
			Driver.acceptAlert();
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("rejectAlert")){
			
			Driver.rejectAlert();
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("selectDefaultframe")){
			Driver.switchToFrame(value);
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("gettext")){
			return Driver.getText(oBy);
			 
		}
		
		if(sActionName.equalsIgnoreCase("getTitle")){
			return Driver.getTitle();
			 
		}
		
		if(sActionName.equalsIgnoreCase("getUrl")){
			return Driver.getCurrentUrl();
			 
		}
		
		if(sActionName.equalsIgnoreCase("setText")){
			 Driver.setText(oBy, value);
			 return "";
		}
		
		if(sActionName.equalsIgnoreCase("getstatus")){
			return String.valueOf(Driver.isSelected(oBy));
			 
		}
		
		
		
		if(sActionName.equalsIgnoreCase("selectitem")){
			Driver.selectViaVisibleText(oBy, value);
			return "";
		}
		
		
		
		if(sActionName.equalsIgnoreCase("isvisible")){
			
			return String.valueOf(Driver.isDisplayed(oBy));
		}
		
				
		
		return "Error: Unknown keyword..";

	}





}
