package Exer11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.hamcrest.core.Is;

public class Queue_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		Queue <Integer> qu = new LinkedList<Integer>(); 
		//		Queue<Integer> qu1 = new LinkedList<Integer>(); 
		//		Stack<Integer> sta = new Stack<Integer>();
		//
		//		for(int i = 1; i<=5; i++ ) {
		//			qu.add(i); //[1,2,3,4,5]
		//			if(i%2==0){
		//				qu.remove(i); //[1,3,5]
		//				sta.add(i); // [2,4] --> [4,2]
		//			}
		//		}
		//
		//		for(int i = 1; i<=5; i++) {
		//			if(i%2==1) {
		//				int temp = qu.poll();
		//				qu1.add(temp);
		//			}
		//			if(i%2==0) {
		//				int temp2 = sta.pop();
		//				qu1.add(temp2);
		//			}
		//		}
		//
		//		System.out.println(qu);
		//		System.out.println(sta);
		//		System.out.println(qu1);
		//	}

		
		
		Queue <Integer> qu = new LinkedList<Integer>(); 
	
		qu.add(1);
		qu.add(2);
		qu.add(3);
		qu.add(2);
		qu.add(1);

		System.out.println(isPalindrome(qu));
	}
	
	public static boolean isPalindrome(Queue<Integer> qu) {
		// we need that the stack and the queue will be equals
		
		Queue<Integer> quTemp = new LinkedList<Integer>();
		Stack<Integer> sta = new Stack<Integer>();
		while(!qu.isEmpty()) {
		int temp = qu.poll();
		quTemp.add(temp);
		sta.add(temp);
		}
	
		while(!quTemp.isEmpty() && !sta.isEmpty()) {
			if(quTemp.poll() != sta.pop()) {
				return false;
			}
		}
		return true;
	}
}