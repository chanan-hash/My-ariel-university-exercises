package Exer10;

public class MyLinkedList {
	Node head;
	int size;

	public MyLinkedList(){
		this.head = null;
		this.size = 0;
	}

	public void add(int n){
		Node newNode = new Node(n);
		if (head == null){
			head = newNode;
		}
		else{
			Node temp = head;
			while (temp.hasNext()){
				temp = temp.next;
			}
			temp.next = newNode;
		}
		size++;
	}


	public String toString(){
		String retStr = "";

		Node temp = head;
		for (int i = 0; i < size; i++){
			if (i != 0)
			{
				retStr += " --> ";
			}
			retStr += temp;
			temp = temp.next;
		}
		return retStr;
	}


	public Node remove(int n){
		if (head == null)
			return null;

		if (head.data == n){
			Node temp = head;
			head = head.next;
			temp.next = null;
			size--;
			return temp;
		}

		// else
		Node temp = head;
		while (temp.hasNext() && temp.next.data != n){
			temp = temp.next;
		}
		if (temp.hasNext()){
			Node tempNext = temp.next;
			temp.next = temp.next.next;
			tempNext.next = null;
			size--;
			return temp;
		}
		return null;
	}

	public Node removeIndex(int index) {
		if (index<0 || index >=size) {
			throw new IndexOutOfBoundsException();
		}

		if (head == null)
			return null;

		Node temp = head;

		for (int i = 0; i < index - 1 && temp.hasNext(); i++) {
			temp = temp.next;
		}
		if (index == 0) {
			head = temp.next;
		} else if (temp.hasNext()){
			Node t = temp.next;
			temp.next = temp.next.next;
			temp = t;
		}
		size--;

		if (temp != null)
			temp.next = null;

		return temp;
	}

	// Going inside the reverse
	public void reverselist() {
		reverselist(head);
	}

	// The reverse
	public Node reverselist(Node n) {
		// Need to understand it again
		if(!n.hasNext()) {
			head = n;
			return head;
		}
		reverselist(n.getNext());
		n.getNext().setNext(n);
		n.setNext(null);
		Node tail = n;
		return tail;
	}
}
