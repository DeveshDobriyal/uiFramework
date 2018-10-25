package com.uiFramework.prive.slyaws.helper.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

/**
 * @author user
 * DEvesh Dobriyal
 * this calss listenes to the retry and does an action
 *
 */
public class RetryListner implements IAnnotationTransformer {

	public void transform(ITestAnnotation arg0, Class arg1, Constructor arg2, Method arg3) {
		// TODO Auto-generated method stub
		IRetryAnalyzer retry = arg0.getRetryAnalyzer();
		if (retry==null) {
			arg0.setRetryAnalyzer(Retry.class);
		}
	}

}
