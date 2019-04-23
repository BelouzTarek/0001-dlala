package com.dlala.dao.injection;

import com.google.inject.Injector;

public class GuiceInjector {
	
	public static Injector injector;

	public static Injector getInjector() {
		return injector;
	}

	public static void setInjector(Injector injector) {
		GuiceInjector.injector = injector;
	}
	
	

}
