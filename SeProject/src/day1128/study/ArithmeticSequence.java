package day1128.study;

//등차수열 
public class ArithmeticSequence {
	
	public static void main(String[] args) {
		int a = 4, d=3 ;
		int[] ret  = new int[100];
		int i;
		
		ret[0]=a;
		
		for ( i = 1; i < 100; i++) {
			ret[i] = ret[i-1]+d;
		}
		for (i = 0; i < 100; i++) {
			
			System.out.println(ret[i]);
		}
		
	}
}
