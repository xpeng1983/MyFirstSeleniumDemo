package com.test.testng;

import org.testng.annotations.Test;

public class Grouping {
	
	@Test(groups= {"��"})
	public void student() {
		System.out.println("ѧ��");
	}
	@Test(groups= {"��"})
	public void teacher() {
		System.out.println("��ʦ");
	}
	@Test(groups= {"����"})
	public void cat() {
		System.out.println("è");
	}
	@Test(groups= {"����"})
	public void dog() {
		System.out.println("��");
	}
	@Test(groups= {"��","����"})
	public void feeder() {
		System.out.println("����Ա");
	}
}
