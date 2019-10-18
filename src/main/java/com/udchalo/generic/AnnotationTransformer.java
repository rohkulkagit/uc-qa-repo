package com.udchalo.generic; 
/**
 * @ScriptName    : SignUpFlow
 * @Description   : This class is used by retryAnalyzer class to retry multiple execution count.   
 * @Author        : udchalo QA Automation Developer
 * @since		  : 02-Aug-2019
 */
 
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation arg0, Class arg1, Constructor arg2, Method arg3) {
		// TODO Auto-generated method stub
		
	}

	
}
