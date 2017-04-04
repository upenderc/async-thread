package com.poc.async.thread8;

import java.util.List;
import java.util.function.Predicate;

public interface MROFilter {

	List<String> apply(List<String> acLines, Predicate<String> p);
}
