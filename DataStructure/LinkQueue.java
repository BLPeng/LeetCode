package DataStructure;

public class LinkQueue {
    private class Node{
    	Node next;
    	int data;
    
    public Node(int data){
    	this.data = data;
    }
}
    private Node front;
    private Node rear;
    private int size;
    
    public LinkQueue(){
    	front = rear = null;
    }
    
    public void Enqueue(int e){
    	if (size==0){
    		front = new Node(e);
    		rear = front;
    	} else{
    		rear.next = new Node(e); //让尾节点的next指向新增的节点
    		rear = new Node(e); //以新节点作为新的尾节点
    	}
    	size ++;
    }
    
    public Node Dequeue(){
    	if (size==0){
    		throw new RuntimeException("empty");
    	} else {
    		Node value = front;
    		front = front.next;
    		value.next = null;
    		size--;
    		return value;
    	}
    }
    
	public static void main(String[] args) {
		LinkQueue lq = new LinkQueue();
		lq.Enqueue(1);
		lq.Enqueue(2);
		lq.Enqueue(3);
		lq.Enqueue(4);
		lq.Enqueue(5);
        Node a = lq.Dequeue();
        System.out.println(a.data);
        Node b = lq.Dequeue();
        System.out.println(b.data);
        System.out.println(a.data);
        System.out.println(a.data);
	}
}
