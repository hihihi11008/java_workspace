package day1128.study;
//등비수열
public class GeometricSequence {
	public static void main(String[] args) {
		int a = 4, r=3;
		int[] ret= new int[10];
		int i;
		
		ret[0]=a;
		
		for (i = 1; i < 10; i++) {
			ret[i]= ret[i-1]*r;
			
		}
		for (i = 0; i < 10; i++) {
			System.out.println(ret[i]);
		}
	}
}
