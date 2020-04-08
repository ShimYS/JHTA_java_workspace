package practice;

import java.util.Scanner;

public class StarDemo2 {

	public static void main(String[] args) {
		
		for(int i=0; i<=4; i++) {
			for(int j=0; j<=4; j++) {
				if(i + j < 2 || i + j > 6 || i-j < -2 || i-j > 2) {
					System.out.print(" ");
				} else
					System.out.print("*");
			}
			System.out.println();
		}

	}

}
