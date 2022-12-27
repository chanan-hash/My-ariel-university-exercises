package Exer10;

public class LinkMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			MyLinkedList linkedList = new MyLinkedList();
			int[] arr = {1, 7, 5, 6};
			for (int num: arr)
			{
				linkedList.add(num);
			}
			System.out.println(linkedList);
			linkedList.add(9);
			linkedList.add(100);
			System.out.println(linkedList);
			
			linkedList.remove(1);
			System.out.println(linkedList);
			linkedList.remove(2);
			System.out.println(linkedList);
			linkedList.remove(5);
			
			System.out.println(linkedList);
			linkedList.reverselist(linkedList.head);
			System.out.println(linkedList);
			
		}

	}


