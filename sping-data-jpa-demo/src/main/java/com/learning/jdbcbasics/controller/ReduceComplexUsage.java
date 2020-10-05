package com.learning.jdbcbasics.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//This class illustrates that moethods part of stream api has to be pure
//they can have mutability but on local variable level and not on shared mutability
public class ReduceComplexUsage {

	public static void main(String[] args) {
		//bad approach
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17);
		//shared variable -> bad approach to ave shared variable mutated
		List<Integer> evenNumbers = new ArrayList<Integer>();
		numbers.stream()
		//shared mutation cuase issue in parallel
		//.parallel()
				.filter(a -> a % 2 == 0)
				.reduce(evenNumbers, (nums,num) -> {nums.add(num);
				return nums;
				}
						, (a,b) -> {
							a.addAll(b);
							return a;
						});
		
		System.out.println(evenNumbers);
		
		//good approach
		
		//shared variable -> bad approach to ave shared variable mutated
		List<Integer> evenNumbers1=
		numbers.stream()
		//shared mutation cuase issue in parallel
		//.parallel()
				.filter(a -> a % 2 == 0)
				//no shared mutation
				//each thread will have its own array list
				.reduce(new ArrayList<Integer>(), (nums,num) -> {nums.add(num);
				return nums;
				}
						, (a,b) -> {
							a.addAll(b);
							return a;
						});
		
		System.out.println(evenNumbers1);
	}
}
