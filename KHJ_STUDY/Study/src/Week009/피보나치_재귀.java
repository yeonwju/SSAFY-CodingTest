package Week009;

public class 피보나치_재귀 {
	public static void main(String[] args) {
		int N = 50;
		for(int i = 1; i <= N; i++) {
			System.out.print(dfs(i) + " ");
		}
		
	}
	static int dfs(int idx) {
		if(idx == 1 || idx == 2) {
			return 1;
		}else {
			return dfs(idx - 1) + dfs(idx - 2);
		}
	}
}
