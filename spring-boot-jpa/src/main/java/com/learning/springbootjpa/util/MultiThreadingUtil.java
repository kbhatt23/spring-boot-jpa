package com.learning.springbootjpa.util;

import java.util.ArrayList;
import java.util.List;


public class MultiThreadingUtil {
	public static int THRESHOLD = 100;

	public static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void joinThread(Thread t) {
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
  
}
