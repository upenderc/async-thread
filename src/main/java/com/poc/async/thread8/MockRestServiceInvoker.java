package com.poc.async.thread8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;

public class MockRestServiceInvoker {

	
	
	public static void main(String [] args) throws InterruptedException, ExecutionException, TimeoutException {
		//filter
	Predicate<String> mroPredicate = (s)->s.equalsIgnoreCase("MRO1");
	
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    
	//retrieving data from host server page by page
    RestServiceRetriever retriever = new RestServiceRetrieverImpl();

    // filter only MRO1s
	 MROFilter filter = new MROFilterImpl();
	//handle filter results
	 ResultHandler resultHandler = new ResultHandlerImpl();
	  
	 //submitting task async
			/*	CompletableFuture.supplyAsync(()->filter.apply(retriever.pageRetriever(1),mroPredicate), executorService).thenAccept(resultHandler::collect);
				CompletableFuture.supplyAsync(()->filter.apply(retriever.pageRetriever(2),mroPredicate), executorService).thenAccept(resultHandler::collect);
				CompletableFuture.supplyAsync(()->filter.apply(retriever.pageRetriever(3),mroPredicate), executorService).thenAccept(resultHandler::collect);
				CompletableFuture.supplyAsync(()->filter.apply(retriever.pageRetriever(4),mroPredicate), executorService).thenAccept(resultHandler::collect);
				*/
	 CompletableFuture<List<String>> cf1=CompletableFuture.supplyAsync(()->filter.apply(retriever.pageRetriever(1),mroPredicate), executorService);
	 CompletableFuture<List<String>> cf2=CompletableFuture.supplyAsync(()->filter.apply(retriever.pageRetriever(2),mroPredicate), executorService);
	 CompletableFuture<List<String>> cf3=CompletableFuture.supplyAsync(()->filter.apply(retriever.pageRetriever(3),mroPredicate), executorService);
	 CompletableFuture<List<String>> cf4=CompletableFuture.supplyAsync(()->filter.apply(retriever.pageRetriever(4),mroPredicate), executorService);
		//Approach-1
		List<String>  finalResults = cf1.thenCombine(cf2, (a,b)->{a.addAll(b);return a;}).thenCombine(cf3, (a,b)->{a.addAll(b);return a;}).thenCombine(cf4, (a,b)->{a.addAll(b);return a;}).join();
		System.out.println(finalResults); 
		/*//sleeping for finishing async tasks Approach-2
		TimeUnit.SECONDS.sleep(3);
	        System.out.println(AggregatorBean.getInstance().getFinalResult());*/
	    //shutting dow thread pool
		executorService.shutdown();
	}
}
