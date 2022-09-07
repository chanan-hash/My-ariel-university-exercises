package UA_exercises_and_test;
//UA_Ex11 classes and linkedlist
// we are going only to create the first class
public class Node {

	private int data;
	private Node next;
	
	public Node (int data) {
		this.data = data; 
	}
	
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}

	int getData() {
		return data;
	}

	/*void setData(int data) {
		this.data = data;
	}
*/
	Node getNext() {
		return next;
	}

	void setNext(Node next) {
		this.next = next;
	}

	
}