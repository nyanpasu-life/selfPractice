package selfPractice.backjoon;
import java.io.*;
import java.util.*;

public class Main_bj_g3_2146_다리_만들기 {
	final static int[] di = {-1, 1, 0, 0};
	final static int[] dj = {0, 0, -1, 1};
	static int N;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[][] a = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int groupcount = 2;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(a[i][j]==1)
					makeGroup(a, i, j, groupcount++);
			}
		}
		
		int min = 999999999;
		
		for(int i1=0;i1<N;i1++) {
			for(int j1=0;j1<N;j1++) {
				for(int i2=0;i2<N;i2++) {
					for(int j2=0;j2<N;j2++) {
						if(i1>i2 || (i1==i2 && j1>=j2))
							continue;
						
						if(a[i1][j1]==0)
							continue;
						else if(a[i2][j2]==0)
							continue;
						else if(a[i1][j1]==a[i2][j2])
							continue;
						
						min = Math.min(min, getBridge(i1, j1, i2, j2));
					}
				}
				
			}
		}
		
		System.out.println(min);

	}
	
	static void makeGroup(int[][] a, int row, int col, int g) {
		a[row][col] = g;
		for(int k=0;k<4;k++) {
			int i = row + di[k];
			int j = col + dj[k];
			if(0<=i && i<N && 0<=j && j<N && a[i][j]==1)
				makeGroup(a, i, j, g);
		}
	}
	
	
	static int getBridge(int x, int y, int x2, int y2){
		return Math.abs(x-x2) + Math.abs(y-y2) -1;
	}
	
	

}
