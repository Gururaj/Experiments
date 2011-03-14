package com.test;

import java.lang.reflect.Method;

public class FactoryPattern {
	public static void main(String [] args)  {
		try {
			Class cls = Class.forName(args[0]);
			Object obj = cls.newInstance();
			Method method = cls.getMethod(args[1]);
			method.invoke(obj);
		} catch(Exception e) {
			throw new RuntimeException(e.getCause());
		}
	}
}

class Type1 { public void type1() { System.out.println("I am type1"); } }

class Type2 { public void type2() { System.out.println("I am type2"); } }