package DataStructure;

public class Stack {
    private Object[] data = null;
    private int maxsize = 0; //栈容量
    private int top = -1; //顶栈指针
    
    // 构造函数，初始化栈容量，栈数据，顶点指针
    Stack(){
    	this(10);
    }
	
    Stack(int initialSize){
    	if (initialSize>=0){
    		this.maxsize = initialSize;
    		data = new Object[initialSize];
    		top = -1;
    	} else {
    		throw new RuntimeException("error");
    	}
    }
    //
    
    public boolean empty(){
    	return top==-1 ? true:false;
    }
    
    public int length(){
    	if (top==-1){
   		 throw new RuntimeException("error");
    	} else{
    		return (top+1);
    	}
    }
    
    //遍历输出个个元素
    public void displayAllData(){
    	if (top==-1){
      		 throw new RuntimeException("error");
    	} else {
    		for (int i=top;i>-1;i--){
    			System.out.print(data[i]+" ");
    		}
    		System.out.print("\n");
    		for (int i=0;i<=top;i++){
    			System.out.print(data[i]+" ");
    		}
    	}
    }
    
    //进栈第一个元素，top=0
    public void push(int e){
    	if (top==maxsize-1){
    		 throw new RuntimeException("error");
    	} else{
    	     data[++top] = e;
    	}
    }
    
    public int checkpeek(){
    	if (top == -1){
   		 throw new RuntimeException("error");
    	}
    	return (int) data[top];
    }
    
    //弹出顶栈元素
    public int pop(){
    	if (top==-1){
   		 throw new RuntimeException("error");
    	} else{
    		return (int)data[top--];
    	}
    }
    
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(2);
		s.push(4);
		s.push(6);
		s.push(8);
		s.push(10);
        System.out.println(s.length());
        System.out.println(s.pop());
        s.displayAllData();
	}
}
