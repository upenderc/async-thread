package com.poc.async.thread8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

public class RestServiceRetrieverImpl implements RestServiceRetriever {

	private static final Logger LOG = Logger.getLogger(RestServiceRetrieverImpl.class);
	public RestServiceRetrieverImpl() {
		
	}
	public List<String> pageRetriever(int pageSize) {
		
		switch(pageSize) {
		case 1:
			LOG.info("page1 mock data");
			return MockRestRetrieverRepository.getAcLines1();
		case 2:
			LOG.info("page2 mock data");
			return MockRestRetrieverRepository.getAcLines2();
		case 3:
			LOG.info("page3 mock data");
			return MockRestRetrieverRepository.getAcLines3();
		case 4:
			LOG.info("page4 mock data");
			return MockRestRetrieverRepository.getAcLines4();
		 default:
			 LOG.info("empty list");
			 return Collections.EMPTY_LIST;
		}
	}

}

//mock data
class MockRestRetrieverRepository {
	
	static List<String> getAcLines1() {
		
		return Arrays.asList("MRO1","MRO1","MRO3","MRO4","MRO1","MRO6","MRO1","MRO8","MRO10","MRO11");
	}
	static List<String> getAcLines2() {
		return Arrays.asList("MRO12","MRO13","MRO14","MRO15","MRO1","MRO16","MRO17","MRO18","MRO19","MRO20");
	}
	static List<String> getAcLines3() {
		return Arrays.asList("MRO21","MRO1","MRO23","MRO24","MRO25","MRO26","MRO27","MRO28","MRO29","MRO11");
	}
	static List<String> getAcLines4() {
		return Arrays.asList("MRO30","MRO31","MRO33","MRO34","MRO1","MRO36","MRO41","MRO48","MRO140","MRO112");
	}
}