package collections;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexPractice {
	
	public static void main(String[] args) {
		System.out.println(isValidSocialSecurity("222-33-4444"));
		System.out.println(isValidSocialSecurity("222-33-444"));
		
	}
	
	public static boolean isValidSocialSecurity(String social) {
		Pattern regex = Pattern.compile("\\d{3}-\\d{2}-\\d{4}");
		Matcher socialSecurityMatcher = regex.matcher(social);
		return socialSecurityMatcher.matches();
	}
	
	

}
