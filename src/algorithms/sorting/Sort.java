package algorithms.sorting;

public class Sort {
	int[] iArray;

	public Sort(int[] iArray) {
		this.iArray = iArray;
	}

	public void mergeSortRecursive() {
		recursiveMerge(0, iArray.length - 1, new int[iArray.length]);
	}

	private void recursiveMerge(int sIndex, int eIndex, int[] tArray) {
		// BASE CASE
		if (sIndex == eIndex) {
			return;
		}
		// DIVIDE
		int mIndex = (sIndex + eIndex) / 2;
		recursiveMerge(sIndex, mIndex, tArray);
		recursiveMerge(mIndex + 1, eIndex, tArray);
		// ACTION
		merge(sIndex, mIndex, eIndex, tArray);
	}

	private void merge(int sIndex, int mIndex, int eIndex, int[] tArray) {
		// lower sub array start index
		int lSIndex = sIndex;
		// higher sub array start index
		int hSIndex = mIndex + 1;
		// Temporary array index
		int tIndex = sIndex;

		// compare and merge till both lower and higher sub arrays have elements
		while (lSIndex <= mIndex && hSIndex <= eIndex) {
			if (iArray[hSIndex] < iArray[lSIndex]) {
				tArray[tIndex] = iArray[hSIndex];
				tIndex++;
				hSIndex++;
			} else {
				tArray[tIndex] = iArray[lSIndex];
				tIndex++;
				lSIndex++;
			}
		}
		// copy remaining elements if any in the lower array to tArray. Compare
		// is not required
		while (lSIndex <= mIndex) {
			tArray[tIndex] = iArray[lSIndex];
			tIndex++;
			lSIndex++;
		}
		// copy remaining elements in any in the higher array to tArray. Compare
		// is not required
		while (hSIndex <= eIndex) {
			tArray[tIndex] = iArray[hSIndex];
			tIndex++;
			hSIndex++;
		}
		// Copy sorted sub arrays from temporary array to input array
		while (sIndex <= eIndex) {
			iArray[sIndex] = tArray[sIndex];
			sIndex++;

		}

	}

	public void display() {
		for (int e : iArray) {
			System.out.println(e);

		}
	}

	public void selectionSortIterative() {
		// last index of the sorted sub array
		int outer = 0;
		while (outer < iArray.length - 1) {
			// assume first element as the smallest
			int smallest = outer;
			int inner = outer + 1;
			// find the index of the smallest value
			while (inner < iArray.length) {
				if (iArray[smallest] > iArray[inner]) {
					smallest = inner;
				}
				inner++;
			}
			// swap if the assumed smallest element is not the smallest element
			if (smallest != outer) {
				swap(outer, smallest);
			}
			// Increment the sorted sub array
			outer++;
		}
	}

	public void selectionSortRecursive() {
		selectionSortRecur(0, iArray.length - 1);
	}

	// outer Loop replacement
	private void selectionSortRecur(int outer, int end) {
		if (outer == end) {
			return;
		}
		int smallest = outer;
		int inner = outer + 1;
		// find the index of the smallest value
		smallest = selectionSortRecurInner(smallest, inner, end);
		// swap if the assumed smallest element is not the smallest element
		if (smallest != outer) {
			swap(outer, smallest);
		}
		// Increment the sorted sub array
		outer++;
		// Recursive calls till the end of the outer loop is reached
		selectionSortRecur(outer, end);
	}

	// Inner Loop replacement
	private int selectionSortRecurInner(int smallest, int inner, int end) {
		if (inner > end) {
			return smallest;
		}
		if (iArray[inner] < iArray[smallest]) {
			smallest = inner;
		}
		inner++;
		return selectionSortRecurInner(smallest, inner, end);
	}

	private void swap(int x, int y) {
		int temp = iArray[x];

		iArray[x] = iArray[y];
		iArray[y] = temp;

	}

}
