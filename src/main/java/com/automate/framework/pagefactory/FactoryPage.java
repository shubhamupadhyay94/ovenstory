package com.automate.framework.pagefactory;

public class FactoryPage {

	public static Object factoryMethod(Class<?> classname) {
		Object obj = null;
		try {
			obj = Class.forName(classname.toString()).newInstance();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;

	}

}
