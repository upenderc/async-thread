package com.poc.async.thread8;

import java.util.List;

import org.apache.log4j.Logger;

public class ResultHandlerImpl implements ResultHandler {

	private static final Logger LOG = Logger.getLogger(ResultHandlerImpl.class); 
	private AggregatorBean aggregatorBean = AggregatorBean.getInstance();
	
	public void collect(final List<String> results) {
		LOG.info("filter results received and submitting to Aggregator Bean");
		aggregatorBean.setResults(results);
	}

}
