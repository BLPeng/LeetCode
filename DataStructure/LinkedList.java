package DataStructure;


public class LinkedList<E> {
	
	private Node head = null;
	int size = 0;
    
	public LinkedList(){
		this.head = new Node();
	}
	
	public int getLength(){
		return size;
	}
	
	public int locateElement(int data){
		Node nodetemp = head;
		int count=1;
		while (nodetemp.next!=null && nodetemp.data==data){
			nodetemp = nodetemp.next;
			count++;
		}
		return count;
	}
	
	public Node getNode(int i){
		if (i>size || i < 0){
			throw new RuntimeException("ERROR");
		}
		Node nodetemp = new Node();
		nodetemp = head;
		int count = 1;
		while (count!=i){
			nodetemp = nodetemp.next;
			count++;
		}
		return nodetemp;
	}
	
	public void insertToTail(int data){
		if (size==0){
			head.data = data;
		} else {
		Node newnode = new Node(data);
		Node tail = getNode(size);
		tail.next = newnode;
	}
	size++;
	}
  
	public void insertToHead(int data){
		if (size==0){
			head.data = data;
		} else {
		Node newnode = new Node(data);
		head = newnode;
		newnode.next = head;
	}
		size++;
	}
	
	public void insertToIndex(int data, int i){
		Node newnode = new Node(data);
		Node nodetemp = getNode(i-1);
		nodetemp.next = newnode;
		newnode.next = nodetemp.next;
		size++;
	}
	
	public void deleteToIndex(int i){
		Node previous = getNode(i-1);
		Node targetnode = previous.next;
		previous.next = targetnode.next;
		size--;
	}
	
	public boolean isEmpty(){
		return size==0 ? true:false;
	}
	
	public void destroyList(){
		head = null;
		size = 0;
	}
	
	
	public void displayNode(){
		Node nodetemp = head;
		while (nodetemp.next!=null){
		System.out.print(nodetemp.data+" ");
		nodetemp = nodetemp.next;
	}
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertToHead(24);
		ll.insertToHead(23);
		ll.insertToHead(22);
		ll.insertToHead(21);

        ll.displayNode(); 
	}

}
