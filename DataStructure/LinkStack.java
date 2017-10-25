package DataStructure;

public class LinkStack {
	private class Node{
		Node next;
		int data;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	private Node top;
	private int size;
	
	//以链表的方式构建一个空栈
	public LinkStack(){
		top = null;
	}
	
	//当前栈的大小
	public int lenght(){
		return size;
	}
	
	//判断是否为空栈
	public boolean empty(){
		return size==0;
	}
	
	//入栈: 让top指向新建的元素，新元素指向原来的top
	public void push(int data){
		top = new Node(data);
		size ++;
	}
	
	//查看栈顶元素但不删除
	public Node checkpeek(int data){
		if (empty()){
			throw new RuntimeException("empty");
		} else{
			return top;
		}
	}
	
	public Node pop(){
		if (empty()){
			throw new RuntimeException("empty");
		} else{
			Node value = top;
			top = top.next;
			value.next = null;
			size--;
			return value;
		}
	}
	
	public static void main(String[] args) {
		LinkStack ls = new LinkStack();
		ls.push(1);
		ls.push(3);
		ls.push(5);
		ls.push(7);
		ls.push(9);
		Node node = ls.pop();
        System.out.println(node.data);
	}
}
