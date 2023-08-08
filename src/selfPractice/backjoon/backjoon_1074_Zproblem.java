package selfPractice.backjoon;

import java.util.*;
import java.io.*;

public class backjoon_1074_Zproblem {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int result = Z(0, (int) Math.pow(2, N), r, c);
		System.out.println(result);

	}
	
	static int Z(int startP, int N, int r, int c) {
		
		int mid = N/2;
		int interv = N*N/4;
		
		if(N == 2) {
			if(r==0 && c==0) {
				return startP;
			}
			else if(r==0 && c==1) {
				return startP +1;
			}
			else if(r==1 && c==0) {
				return startP +2;
			}
			else if(r==1 && c==1) {
				return startP +3;
			}
		}
		
		if(r < mid && c < mid) {
			return Z(startP, mid, r, c);
		}
		else if(r < mid && c >= mid) {
			return Z(startP + interv, mid, r, c-mid);
		}
		else if(r >= mid && c < mid) {
			return Z(startP + 2*interv, mid, r-mid, c);
		}
		else if(r >= mid && c >= mid) {
			return Z(startP + 3*interv, mid, r-mid, c-mid);
		}
		
		return -1;
	}

}
