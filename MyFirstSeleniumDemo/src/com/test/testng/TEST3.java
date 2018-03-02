package com.test.testng;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.common.base.Function;

public class TEST3 implements Function<Date, String>{

	
	public static void main(String[] args) {
		
		TEST3 test3=new TEST3();
		System.out.println(test3.apply(new Date()));
	}

	@Override
	public String apply(Date arg0) {
		// TODO Auto-generated method stub
		  return new SimpleDateFormat("yyyy-MM-dd").format(arg0);
	}
 
}
