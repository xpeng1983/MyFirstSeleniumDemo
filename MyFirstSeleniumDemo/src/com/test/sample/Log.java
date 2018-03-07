package com.test.sample;

import org.apache.log4j.Logger;

public class Log {
	// ��ʼ��һ��Logger����
	private static Logger log = Logger.getLogger(Log.class.getName());

	public static void startTestCase(String sTestCaseName) {
		log.info("--------------------------------------------");
		log.info("******      " + sTestCaseName + "          *****");
	}

	// ����һ����̬���������Դ�ӡ�Զ����ĳ��������������ִ�е���־��Ϣ
	public static void endTestCase(String sTestCaseName) {
		log.info("***************" + "��������ִ�н���" + " ***************");
		log.info("------------------------------------------------");
		;
		;
		;
	}
	

	// ��ӡ�Զ����info������־��Ϣ
	public static void info(String message) {
		log.info(message);
	}

	// ��ӡ�Զ����error������־��Ϣ
	public static void error(String message) {
		log.error(message);
	}

	// ��ӡ�Զ����warn������־��Ϣ
	public static void fatal(String message) {
		log.fatal(message);
	}

	// ��ӡ�Զ����warn������־��Ϣ
	public static void debug(String message) {
		log.debug(message);
	}

}
