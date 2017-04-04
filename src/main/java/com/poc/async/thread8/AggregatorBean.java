package com.poc.async.thread8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class AggregatorBean {

	private AtomicReference<List<String>> aggregator = new AtomicReference<List<String>>(Collections.EMPTY_LIST);
	
	private static final AggregatorBean INSTANCE = new AggregatorBean();

	public AggregatorBean() {
	
	}
	public void setResults(final List<String> results) {
		List<String> rs = new ArrayList<>(results);
		List<String> p = aggregator.get();
		rs.addAll(p);
		aggregator.set(rs);
		
		

	}
	
	public static AggregatorBean getInstance() {
		return INSTANCE;
	}
	public List<String> getFinalResult() {
		return aggregator.get();
	}
}

