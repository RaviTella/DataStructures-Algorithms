package algorithms.sorting;

public class Sort {
	int[] iArray;

	public Sort(int[] iArray) {
		this.iArray = iArray;
	}

	public void mergeSort() {
		recursiveMerge(0, iArray.length - 1, new int[iArray.length]);
	}

	private void recursiveMerge(int sIndex, int eIndex, int[] tArray) {
		//BASE CASE
		if (sIndex == eIndex) {
			return;
		}
        //DIVIDE
		int mIndex = (sIndex + eIndex) / 2;
		recursiveMerge(sIndex, mIndex, tArray);
		recursiveMerge(mIndex + 1, eIndex, tArray);
		//ACTION
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

}
