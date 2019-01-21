package dataStructures.generalPurpose.list;

public class SinglyLinkedList {
	private int nElements;
	private SingleLink head;
	private SingleLink tail;

	public SinglyLinkedList() {
		this.nElements = 0;
		this.head = null;
		this.tail = null;
	}

	public void addAtHead(int val) {
		if (nElements == 0) {
			this.head = new SingleLink(val, null);
			this.tail = this.head;
		} else {
			this.head = new SingleLink(val, this.head);
		}
		nElements++;
	}

	public void addAtTail(int val) {
		SingleLink newTail = new SingleLink(val, null);
		if (nElements == 0) {
			this.head = newTail;
			this.tail = this.head;
		} else {
			this.tail.nextLink = newTail;
			this.tail = newTail;
		}
		nElements++;
	}

	public void addAtIndex(int index, int val) {
		// index out of range
		if (index < 0 || index > nElements) {
			return;
		}
		// adding head
		if (index == 0) {
			addAtHead(val);
			return;
		}
		// adding tail
		if (index == nElements) {
			addAtTail(val);
			return;
		}
		// in between head and tail
		if (index > 0 && index < nElements) {
			int cIndex = 0;
			SingleLink currentLink = head;
			while (cIndex != index - 1) {
				currentLink = currentLink.nextLink;
				cIndex++;
			}
			SingleLink prevNext = currentLink.nextLink;
			currentLink.nextLink = new SingleLink(val, prevNext);
			nElements++;
		}

	}

	public int get(int index) {
		if (index >= nElements || index < 0) {
			return -1;
		}
		int cIndex = 0;
		SingleLink currentLink = head;
		while (cIndex != index) {
			currentLink = currentLink.nextLink;
			cIndex++;
		}
		return currentLink.val;
	}

	public void deleteAtIndex(int index) {
		// out of range
		if (index < 0 || index >= nElements) {
			return;
		}
		// if head link
		if (index == 0) {
			head = head.nextLink;
			nElements--;
			return;
		}
		// if tail link
		if (index == nElements - 1) {
			int cIndex = 0;
			SingleLink currentLink = head;
			while (cIndex != nElements - 2) {
				currentLink = currentLink.nextLink;
				cIndex++;
			}
			currentLink.nextLink = null;
			this.tail = currentLink;
			nElements--;
			return;
		}
		// if between tail and head
		if (index > 0 && index < nElements - 1) {
			int cIndex = 0;
			SingleLink currentLink = head;
			while (cIndex != index - 1) {
				currentLink = currentLink.nextLink;
				cIndex++;
			}
			currentLink.nextLink = currentLink.nextLink.nextLink;
			nElements--;
			return;
		}

	}
}
