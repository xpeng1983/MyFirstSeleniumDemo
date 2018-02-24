package com.test.testng;

import org.testng.annotations.Test;

public class Grouping {
	
	@Test(groups= {"人"})
	public void student() {
		System.out.println("学生");
	}
	@Test(groups= {"人"})
	public void teacher() {
		System.out.println("老师");
	}
	@Test(groups= {"动物"})
	public void cat() {
		System.out.println("猫");
	}
	@Test(groups= {"动物"})
	public void dog() {
		System.out.println("狗");
	}
	@Test(groups= {"人","动物"})
	public void feeder() {
		System.out.println("饲养员");
	}
}
