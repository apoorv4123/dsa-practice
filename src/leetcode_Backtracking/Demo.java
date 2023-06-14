package leetcode_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Demo {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		ArrayList<Integer> al = new ArrayList<>();
		al.add(10);
		al.add(20);
		al.add(30);

		// new array list with exactly the same content as your older array list
		ArrayList<Integer> alnew = new ArrayList<Integer>(al);
		System.out.println(alnew);

		ArrayList<ArrayList<Integer>> l = new ArrayList<>();
		System.out.println(l);
		ArrayList<Integer> a = new ArrayList<>();
		a.add(10);
		a.add(20);
		l.add(a);
		System.out.println(l);
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(30);
		b.add(40);
		b.add(50);
		l.add(b);
		System.out.println(l);

		ArrayList<ArrayList<Integer>> main = new ArrayList<>();

		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(10);
		temp.add(20);

		main.add(new ArrayList<Integer>(temp));
//		main.add(temp);
		System.out.println(main);

		temp.add(30);
		main.add(new ArrayList<>(temp));
//		main.add(temp);
		System.out.println(main);

		temp.remove(temp.size() - 1);
		temp.remove(temp.size() - 1);

		main.add(new ArrayList<>(temp));
//		main.add(temp);
		System.out.println(main);

	}
}