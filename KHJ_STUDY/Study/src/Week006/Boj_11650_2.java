package Week006;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj_11650_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		ArrayList<Point> arr = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr.add(new Point(x,y));
		}
		Collections.sort(arr);
		
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).x + " " +arr.get(i).y);
		}
	}
	
}
class Point implements Comparable<Point> {
	public int x; 
	public int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point o) {
		if(this.x == o.x) {
			return this.y - o.y;
		}else {
			return this.x - o.x;
		}
	}
}
