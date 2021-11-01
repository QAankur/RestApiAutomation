package authentication;

import java.util.Base64;

public class BasicAuth {

	public static void main(String[] args) {
		
		String credentials="myUserName:myPassword";
		String base64Encoded=Base64.getEncoder().encodeToString(credentials.getBytes());
		System.out.println("Encoded string is :" + base64Encoded);
		byte[] decodedString=Base64.getDecoder().decode(base64Encoded);
		System.out.println("Decoded String : " + new String(decodedString));

	}

}
