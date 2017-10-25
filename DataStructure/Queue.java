package DataStructure;

public class Queue {
    
	private Object[] data = null;
    private int front;
    private int rear;
    private int maxsize;
    
    public Queue(){
    	this(10);
    }
    
    public Queue(int initialSize){
    	if (initialSize>=0){
    		this.maxsize = initialSize;
    		data = new Object[initialSize];
    		front = rear = 0;
    	} else {
    		throw new RuntimeException("error");
    	}
    }
    
    public void Enqueue(int e){
    	if (front == rear+1){
    		throw new RuntimeException("error");
    	} else {
    		data[rear++] = e;
    		// rear = rear +1;
    	}
    }
    
    public int Dequeue(){ //弹出需要一个弹出的value
    	if (front == rear){
    		throw new RuntimeException("error");
    	} else{
    		int value = (int)data[front]; //保留队列front端的元素值
    		data[front++] = null; //释放队列front端的元素
    		return value;
    	}
    }
    
    public int length(){
    	return rear-front;
    }
    
	public static void main(String[] args) {
		Queue q = new Queue();
		q.Enqueue(1);
		q.Enqueue(2);
		q.Enqueue(3);
		q.Enqueue(4);
		q.Enqueue(5);
		System.out.println(q.length());
		System.out.println(q.Dequeue());
		System.out.println(q.Dequeue());
	}
}
