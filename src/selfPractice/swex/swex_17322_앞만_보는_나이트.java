package selfPractice.swex;

import java.io.*;
import java.util.*;

public class swex_17322_앞만_보는_나이트 {
	
	public static long[] dparr= new long[100000000];
	static int m = 1000000007;
	static {
		dparr[0] = 1;
		dparr[1] = 1;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swex_17322_앞만_보는_나이트_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			long result;
			if((i+j)%3 !=0)
				result = 0;
			else {
				int N = ((i+j) / 3);
				int R = i-N;
				
				int n=2;
				for(;n<=N;n++) {
					dparr[n] = (dparr[n-1]*n)%m;
				}
				long A = (dparr[R]*dparr[N-R])%m;
				long B = nani(A, m-2);
			
				result = (dparr[N]*B) % m;
			}
			
			System.out.printf("#%d %d\n", tc, result);
		}

	}
	static long nani(long C, int k) {
		if(k==0)
			return 1;
		else if(k==1)
			return C;
		else if(k%2==0) {
			long temp = nani(C, k/2);
			return (temp*temp)%m;
		}
		else {
			long temp = nani(C, (k-1)/2);
			return (((temp*temp)%m)*C)%m;
		}
		
	}

	
	
}
