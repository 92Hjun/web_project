package util;

import java.security.MessageDigest;

public class MD5 {

	public static String hash(String text) throws Exception {

		// SHA가 좀더 강력한 방식입니다.
		// 지금은 MD5 형식으로 암호화 하게됩니다.
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(text.getBytes());
		byte[] byteData = md.digest();

		// byte데이터를 16진수 문자열로 변환하기
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}
}
