package DataStructure;

public class TestLinkList {

		public static void main(String[] args) {
			LinkList linklist = new LinkList();
			//linklist.addFirstNode(20);
			//linklist.addFirstNode(21);
			//linklist.addFirstNode(19);
			//linklist.addFirstNode(18);
	        linklist.addNodeByPos(1, 22);
	        linklist.addNodeByPos(2, 23);
	        linklist.addNodeByPos(3, 99);
	        linklist.displayAllNodes();
	        //Node node = linklist.deleteNodeByData(19);
			//System.out.println("node:"+ node.data);
			//linklist.displayAllNodes();
			//Node node1 = linklist.findNodeByPos(0);
			//System.out.println("node1:"+ node1.data);
			//Node node2 = linklist.findNodeByData(22);
			//System.out.println("node2:"+ node2.data);
			//Node node3 = linklist.deleteNodeByData(21);
			//System.out.println(node3.data);
		}

	}

