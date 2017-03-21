package util;

public class NumberUtil {

	// 에러 발생시 기본값을 넘겨줄것
	public static int StringToInt(String str, int defaultvalue) {
		if (str == null) {
			return defaultvalue;
		}
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return defaultvalue;
		}
	}
}
