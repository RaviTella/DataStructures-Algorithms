package algorithms.sorting;



public class BinarySearch {
	private int[] a;

	public BinarySearch(int[] a) {
		this.a = a;
	}

	public static void main(String[] args) {
		 int[] a = { 3, 7, 9, 12, 17, 20,70 };
		//int[] a = { 2, 5 };

		// System.out.println(new BinarySearch(new long[1]).binarySearch(1));
		System.out.println(new BinarySearch(a).search(20));

	}
    //Retruns the index of the search key
	public int search(int key) {
		return recursiveBinarySearch(key, 0, a.length - 1);
	}

	private int recursiveBinarySearch(int key, int sIndex, int eIndex) {
		// Divide
		int mIndex = (sIndex + eIndex) / 2;
		// Action
		if (key == a[mIndex]) {
			return mIndex;
			// Base Case
		} else if (sIndex == eIndex) {
			return -1;
		} else {
			if (key <= a[mIndex]) {
				return recursiveBinarySearch(key, sIndex, mIndex);
			} else {
				return recursiveBinarySearch(key, mIndex + 1, eIndex);
			}
		}

	}

}
