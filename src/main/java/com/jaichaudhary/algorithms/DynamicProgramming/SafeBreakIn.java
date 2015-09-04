package com.jaichaudhary.algorithms.DynamicProgramming;

import java.util.*;

import edu.princeton.cs.algs4.StdOut;

public class SafeBreakIn {
	private static class Sequence {
		ArrayList<String> sequence = new ArrayList<String>();

		public boolean exists(String item) {
			return sequence.contains(item); 
		}

		public Sequence(String[] nums) {
			for(String num: nums) {
				sequence.add(num);
			}
		}
		public void add(String digit) {
			if (sequence.size() > 1){
				String lastItem = sequence.get(sequence.size() - 1);
				String lastDigit = lastItem.substring(lastItem.length() - 1);
				if(!exists(lastDigit + digit)){
					sequence.add(lastDigit + digit);
				}
			}
		}

		public String toString(){
			return sequence.stream().reduce("", (a,b) -> a + ", " + b);
		}
	}

	public static void main(String[] args) {

		int[] digits = {0 , 1};
		int mostSignificantBit = 2;

		//calculating sequences with most overlapping numbers with n digits
		// E.g. 0010 4 digits 3 overlapping UNIQUE numbers of 2 digits - 00 01 10

		int maxCountOfOverlappingNums = 1;
		Sequence seq = new Sequence(new String[] {"00", "01", "10", "11"});
		StdOut.println(seq);
		ArrayList<Sequence> sequencesWithMostNums = new ArrayList<Sequence>();

		while(maxCountOfOverlappingNums < 4) {
			
		}

	}
} 