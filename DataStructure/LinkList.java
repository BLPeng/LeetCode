package DataStructure;

public class LinkList { //单链表
    public Node first; //定义一个头结点
    private int pos = 0; //节点的位置
    
    public LinkList(){
    	this.first = null;
    }
    
    //插入一个头结点
    public void addFirstNode(int data){
    	Node node = new Node(data);
    	first = node;
    	node.next = first;
    }
    
    // 删除一个头结点并返回头结点
    public Node deleteFirstNode(){
    	Node tempNode = first;
    	first = tempNode.next;
    	return tempNode;
    }
    
    //在任意位置插入节点 在index的后面插入
    public void addNodeByPos(int index,int data){
    	Node node = new Node(data);
    	Node current = first;
    	Node previous = first;
    	while (pos!=index){
    		previous = current;
    		current = current.next;
    		pos++;
    	}
    	node.next = current;
    	previous.next = node;
    	pos = 0;
    }
    
    //删除任意位置的节点
	public Node deleteNodeByPos(int index){
		Node current = first;
		Node previous = first;
		while (pos!=index){
			pos++;
			previous = current;
			current = current.next;
		}
		if (current==first){
			first = first.next;
		} else{
			pos = 0;
			current = current.next;
			previous.next = current.next;
		}
		return current;
	}
	
	//根据节点信息data删除节点（仅仅删除第一个）
	public Node deleteNodeByData(int data){
		Node current = first;
		Node previous = first;
		while (current.data!=data){
			if (current.next == null){
				return null;
			}
			previous = current;
			current = current.next;
		}
		if (current==first){
			first = first.next;
		} else{
			previous.next = current.next;
		}
		return current;
	}
	
	//显示所有节点信息
	public void displayAllNodes(){
		Node current = first;
		while (current!=null){
			current.display();
			current = current.next;
		}
		System.out.println();
	}
	
	//根据位置查找并返回节点
	public Node findNodeByPos(int index){
		Node current = first;
		while (pos!=index){
			current = current.next;
			pos++;
		}
		return current;
	}
	
	public Node findNodeByData(int data){
		Node current = first;
		while (current.data!=data){
			if (current.next==null){
				return null;
			}
			current = current.next;
		}
		return current;
	}
	
	public Node swapNodes(Node head){
		Node dummy = new Node(0);
		dummy.next = head;
		Node current = dummy;
		if (head==null) {
			return null;
		}
		while (current.next!=null && current.next.next!=null){
			Node temp = new Node(0);
			current.next = temp;
			temp = current.next.next;
			current.next.next = current.next;
			current = current.next.next;
		}
		return dummy.next;
	}
}
