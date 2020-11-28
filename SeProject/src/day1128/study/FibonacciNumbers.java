package day1128.study;

public class FibonacciNumbers {
	public static void main(String[] args) {
		int i;
		int[] ret= new int[10];
		
		ret[0] =1;
		ret[1]=1;
		
		for (i = 2; i < 10; i++) {
			ret[i]=ret[i-1] + ret[i-2];
		}
		for (i = 0; i < 10; i++) {
			System.out.println(ret[i]);
		}
	}
}
