package Exer10;

public class Node {

	// we don't want them to be private
	int data;
	Node next;

	public Node(int data){
		this.data = data;
		this.next = null;
	}
	
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}


	public boolean hasNext(){
		return (this.next != null);
	}

	public int getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	@Override
	public String toString(){
		return (this.data + "");
	}
}
