package com.test.testng;

import org.testng.annotations.Test;
import java.util.function.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test2 {

	@Test
	public void testFunction() {

		Function<Date, String> function = new Function<Date, String>() {
			@Override
			public String apply(Date input) {
				return new SimpleDateFormat("yyyy-MM-dd").format(input);
			}
		};
	}
}
