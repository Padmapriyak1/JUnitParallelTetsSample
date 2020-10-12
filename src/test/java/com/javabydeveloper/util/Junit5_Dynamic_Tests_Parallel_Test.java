package com.javabydeveloper.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;


 
public class Junit5_Dynamic_Tests_Parallel_Test {
	
	@Execution(ExecutionMode.CONCURRENT)
	@TestFactory
	 Stream<DynamicTest> dynamicTestsExample() {
		String sourcePath="C:\\Office\\Source";
		String targetPath="C:\\Office\\Target";
		List<String>listOfFiles=Utils.listOFFields(sourcePath);
	 
		
		List<DynamicTest> dynamicTests = new ArrayList<>();
		
		for(int i=0; i < listOfFiles.size(); i++) {
			String sourceFilePath  = listOfFiles.get(i);
			String sourceFileName= sourceFilePath.substring(sourceFilePath.lastIndexOf("\\")+1);
			System.err.println("sourceFileName:: " + sourceFileName);
			DynamicTest dynamicTest = DynamicTest.dynamicTest("FileComparison_"+sourceFileName, () 
					->{
						Utils utils=new Utils();
						assertEquals("Success",utils.fileCompare(sourceFilePath,sourceFileName,targetPath));
						 //System.err.println("parallel Test " + Thread.currentThread().getName());
					  });
			dynamicTests.add(dynamicTest);
		}
		
		return dynamicTests.stream();
	}
	/*
	@Execution(ExecutionMode.CONCURRENT)
	@TestFactory
	Collection<DynamicTest> test_parallel_dynamictests1() {
		
	    return Arrays.asList(
	            dynamicTest("1st dynamic test", () -> { 
	            	assertTrue(MathUtil.isPrime(13)); 
	            	System.out.println(Thread.currentThread().getName()+" => 1st dynamic test");
	            }),
	            dynamicTest("2nd dynamic test", () -> {
	            	assertEquals(5, MathUtil.devide(25, 5));
	            	System.out.println(Thread.currentThread().getName()+" => 2nd dynamic test");
	            }),
	            dynamicTest("3rd dynamic test", () -> { 
	            	assertEquals(12, MathUtil.add(7, 5)); 
	            	System.out.println(Thread.currentThread().getName()+" => 3rd dynamic test");
	            })
	        );
	  }
	
	@Execution(ExecutionMode.SAME_THREAD)
	@TestFactory
	Collection<DynamicTest> test_parallel_dynamictests2() {
		
	    return Arrays.asList(
	            dynamicTest("4th dynamic test", () -> { 
	            	assertTrue(MathUtil.isPrime(13)); 
	            	System.out.println(Thread.currentThread().getName()+" => 4th dynamic test");
	            }),
	            dynamicTest("5th dynamic test", () -> {
	            	assertEquals(5, MathUtil.devide(25, 5));
	            	System.out.println(Thread.currentThread().getName()+" => 5th dynamic test");
	            }),
	            dynamicTest("6th dynamic test", () -> { 
	            	assertEquals(12, MathUtil.add(7, 5)); 
	            	System.out.println(Thread.currentThread().getName()+" => 6th dynamic test");
	            })
	        );
	  }*/
}
