package app;

import org.junit.Assert;
import org.junit.Test;

public class ConvertText {
	
	@Test
	public void testConvertText() {
		
		TextConvert convert = new TextConvert();
		String result = convert.upper("abc");
		
		Assert.assertEquals("ABC", result);
		
	}
	
}
