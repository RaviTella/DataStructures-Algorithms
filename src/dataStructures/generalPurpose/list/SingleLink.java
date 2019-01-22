package dataStructures.generalPurpose.list;

public class SingleLink<T> {
	T val;
	SingleLink<T> nextLink;

	SingleLink(T val, SingleLink<T> nextLink) {
		this.val = val;
		this.nextLink = nextLink;
	}
}
