package com.jaichaudhary.algorithms.DynamicProgramming;

import java.util.*;

public class SafeBreakIn {
	private class Sequence {
		ArrayList<String> sequence;

		public boolean exists(String item) {
			return sequence.contains(item); 
		}
		public void add(String digit) {
			if (sequence.size() > 1){
				String lastItem = sequence.get(sequence.size() - 1));
				String lastDigit = lastItem.charAt(lastItem.length() - 1));
				if(!exists(lastDigit + digit){
					sequence.add(lastDigit + digit);
				}
			}
		}
	}

	public static void main(String[] args) {

		int[] digits = {0 , 1};
		int mostSignificantBit = 2;

		//calculating sequences with most overlapping numbers with n digits
		// E.g. 0010 4 digits 3 overlapping UNIQUE numbers of 2 digits - 00 01 10

		String[] numbers = {"00", "01", "10", "11"};
		int maxCountOfOverlappingNums = 1;
		ArrayList<ArrayList<String>> sequencesWithMostNums = new ArrayList<ArrayList<String>>();

		while(maxCountOfOverlappingNums < 4) {
			
		}

	}
} 