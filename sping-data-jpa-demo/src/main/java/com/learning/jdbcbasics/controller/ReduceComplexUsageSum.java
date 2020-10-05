package com.learning.jdbcbasics.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//This class illustrates that moethods part of stream api has to be pure
//they can have mutability but on local variable level and not on shared mutability
public class ReduceComplexUsageSum {

	public static void main(String[] args) {
		//bad approach
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17);
		//sum is easier
		//no shared mutation here and henc ewont cause issue in parallel
		
		int sum =numbers.stream()
				.parallel()
				.filter(a -> a % 2 == 0)
				.reduce(0, Integer::sum);
		System.out.println(sum);
	}
}
