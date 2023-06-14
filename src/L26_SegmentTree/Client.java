package L26_SegmentTree;

public class Client {

	public static void main(String[] args) {

		// this segment tree is to find sum between 2 given indices of array
		SegmentTree st = new SegmentTree(new int[] { 3, 8, 7, 6, -2, -8, 4, 9 });
		st.display();
		System.out.println(st.sumBetweenIndices(2, 6));
		st.update(3, 14);
		st.display();
		System.out.println(st.sumBetweenIndices(2, 69));

	}

}
