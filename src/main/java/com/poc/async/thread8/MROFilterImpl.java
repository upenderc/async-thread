package com.poc.async.thread8;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MROFilterImpl implements MROFilter {

	public List<String> apply(List<String> acLines, Predicate<String> p) {
		return acLines.stream().filter(s->p.test(s)).collect(Collectors.toList());
	}
}
