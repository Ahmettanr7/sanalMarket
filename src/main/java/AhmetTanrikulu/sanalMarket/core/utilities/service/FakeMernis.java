package AhmetTanrikulu.sanalMarket.core.utilities.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FakeMernis {
	public static boolean validate(String nationalityId) {

		 String regex = "^[0-9]+$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(nationalityId);
	     
		if(nationalityId.length() > 11 || nationalityId.length() < 11) {
			return false;
		}
		
		else if(matcher.matches() && !nationalityId.startsWith("0")) {
			return true;
		}
		
		
		
		else {
			return false;
		}
		
	}
}