package com.gl.driver;

import java.util.Scanner;

import com.gl.services.Skyscraper;

public class SkyStackMain {
	
	/*
	 * public class SkyscraperConstruction { public static void main(String[] args)
	 * { Scanner sc = new Scanner(System.in);
	 * 
	 * System.out.println("Enter the total number of floors in the building:"); int
	 * n = sc.nextInt();
	 * 
	 * int maxSoFar = 0; Stack<Integer> floorSizes = new Stack<Integer>(); for (int
	 * i = 1; i <= n; i++) { System.out.println("Enter the floor size given on day "
	 * + i + ":"); int size = sc.nextInt();
	 */

	public static void main(String[] args) {
		System.out.println("Enter the total no of floors in the building : ");
		try (Scanner sc = new Scanner(System.in)) {
			int numberOfFloors = sc.nextInt();
			int[] listOfFloors = new int[numberOfFloors];
			for (int i = 0; i < numberOfFloors; i++) {
				System.out.println("Enter the floor size given on day : " + (i + 1));
				int floorSize = sc.nextInt();
				listOfFloors[i] = floorSize;
			}
			Skyscraper.calculateFloors(listOfFloors);
		}
	}

}