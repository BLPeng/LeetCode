package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E> {
	
	private TreeNode<E> root; //根节点， <E> 泛型变量
    private LinkedList<TreeNode> nodelist = null; //
    
    public BinaryTree(){  //两个构造函数
    	
    }
    
    public BinaryTree(TreeNode<E> root){  //两个构造函数
    	this.root = root;
    }
    
//    public TreeNode<E> buildBinaryTree(E[] array){
//    	LinkedList<TreeNode<E>> nodelist = new LinkedList<TreeNode<E>>();
//    	for (int i=0; i< array.length; i++){
//    		nodelist.add(new TreeNode(array[i]));
//    	}
//    	for (int j=0; j<array.length/2-1; j++){
//    		nodelist.get(j).setLchild(nodelist.get(j*2+1));
//    		nodelist.get(j).setRchild(nodelist.get(j*2+2));
//    	}
//    	int index = array.length/2-1;
//    	nodelist.get(index).setLchild(nodelist.get(index*2+1));
//    	if (array.length%2==1){
//    		nodelist.get(index).setRchild(nodelist.get(index*2+2));
//    	}
//    	root = nodelist.get(0);
//    	return root;
//    }
    
    public TreeNode<E> BuildBinaryTree(E[] array){
    	LinkedList<TreeNode<E>> nodelist = new LinkedList<TreeNode<E>>();
    	for (int i=0; i<array.length; i++){
    		nodelist.add(new TreeNode(array[i]));
    	}
    	for (int j=0; j<array.length/2-1; j++){
    		nodelist.get(j).setLchild(nodelist.get(j*2+1));
    		nodelist.get(j).setRchild(nodelist.get(j*2+2));
    	}
    	int index = array.length/2-1;
    	nodelist.get(index).setLchild(nodelist.get(index*2+1));
    	if (array.length%2==1) {
    		nodelist.get(index).setRchild(nodelist.get(index*2+2));
    	}
    	TreeNode<E> root = nodelist.get(0);
    	return root;
    }
    
    public int height(TreeNode<E> node){
    	if (node==null){
    		return 0;
    	} else{
    		int i = height(node.getLchild());
    		int j = height(node.getRichild());
    		return (i<j)?(j+1):(i+1);
    	}
    }
    
    public int size(TreeNode<E> node){
    	if (node==null){
    		return 0;
    	} else {
    		return 1+size(node.getLchild())+size(node.getRichild());
    	}
    }
    
    public void PreOrderTraversal(TreeNode<E> node){
    	if (node!=null){
    		System.out.print(node.getData()+" ");
    		PreOrderTraversal(node.getLchild());
    		PreOrderTraversal(node.getRichild());
    	}
    }
    
//    public void nonRecPreOrderTraversal(TreeNode<E> node){
//    	Stack<TreeNode<E>> nodestack = new Stack<TreeNode<E>>();  //建立一个以树节点为元素的栈，如果不加<TreeNode<E>>,电脑无法分别栈里元素的类型
//    	TreeNode<E> nodetemp = node; //nodetemp遍历指针
//    	while (nodetemp!=null || !nodestack.isEmpty()) {
//    		if (nodetemp!=null){
//    			nodestack.push(nodetemp);  //进栈
//    			System.out.print(nodetemp.getData()+" "); //进了马上print
//    			nodetemp = nodetemp.getLchild();  //然后遍历左子树
//    		} else { //左子树已遍历完
//    			nodetemp = nodestack.pop(); //弹出nodetemp，也就是指向左子树的最后一个元素的指针（已print）  
//    			nodetemp = nodetemp.getRichild();  //开始遍历右子树，还在while循环内，重新进入70行操作
//    		}
//    	}
//    }
    
    public void nonRecPreOrderTraversal(TreeNode<E> node){
        TreeNode<E> nodetemp = node;
    	Stack<TreeNode<E>> nodestack = new Stack<TreeNode<E>>();
    	while (nodetemp!=null || !nodestack.isEmpty()){
    		if (nodetemp!=null){
    			nodestack.push(nodetemp);
    			System.out.print(nodetemp.getData()+" ");
    			nodetemp = nodetemp.getLchild();
    		}
    		else {
    			nodetemp = nodestack.pop();
    			nodetemp = nodetemp.getRichild();
    		}
    	}
    }
    
    public void InOrderTraversal(TreeNode<E> node){
    	if (node!=null){
    		InOrderTraversal(node.getLchild());
    		System.out.print(node.getData()+" ");
    		InOrderTraversal(node.getRichild());
    	}
    }
    
    
//    public void nonRecInOrderTraversal(TreeNode<E> node){
//    	Stack<TreeNode<E>> nodestack = new Stack<TreeNode<E>>();
//    	TreeNode<E> nodetemp = node;
//    	while (nodetemp!=null || !nodestack.isEmpty()){
//    		if (nodetemp!=null){
//    			nodestack.push(nodetemp);
//    			nodetemp = nodetemp.getLchild();
//    		} else {
//    			nodetemp = nodestack.pop();  //弹出指针，与先序遍历不同的是，先序遍历用不是通常意义上的栈，所以中序遍历这里才弹出，再print
//    			System.out.print(nodetemp.getData()+" ");
//    			nodetemp = nodetemp.getRichild();
//    		}
//    	}
//    }
    
    public void nonRecInOrderTraversal(TreeNode<E> node){
    	Stack<TreeNode<E>> nodestack = new Stack<TreeNode<E>>();
    	TreeNode<E> nodetemp = node;
    	while (nodetemp!=null || !nodestack.isEmpty()) {
    		if (nodetemp!=null) {
    			nodestack.push(nodetemp);
    			nodetemp = nodetemp.getLchild();
    		} else {
    			nodetemp = nodestack.pop();
    			System.out.print(nodetemp.getData()+" ");
    			nodetemp = nodetemp.getRichild();
    		}
    	}
    }
    
    public void PostOrderTraversal(TreeNode<E> node){
    	if (node!=null) {
    		PostOrderTraversal(node.getLchild());
    		PostOrderTraversal(node.getRichild());
    		System.out.print(node.getData()+" ");
    	}
    }
    
    
    public void nonRecPostOrderTraversal(TreeNode<E> node){
    	Stack<TreeNode<E>> nodestack = new Stack<TreeNode<E>>();
    	TreeNode<E> nodetemp = node;
    	TreeNode<E> prenode = null;
    	while (nodetemp!=null || !nodestack.isEmpty()){
    		while (nodetemp!=null) {
    			nodestack.push(nodetemp);
    			nodetemp = nodetemp.getLchild();
    		} 
    		nodetemp = nodestack.peek();
    		if (nodetemp.getRichild()==null || nodetemp.getRichild()==prenode){
    			nodetemp = nodestack.pop();
    			System.out.print(nodetemp.getData()+" ");
    			prenode = nodetemp;
    			nodetemp = null;
    		} else {
    			nodetemp = nodetemp.getRichild();
    		}
    	}
    }
    
    public void LevelOrderTraversal(TreeNode<E> root){  //注意这里用的是root，因为层序遍历相当于每一层都有root
    	Queue<TreeNode<E>> nodequeue = new LinkedList<TreeNode<E>>();  //注意这里用的是LinkedList
    	TreeNode<E> node = null;
    	nodequeue.add(root);  //根节点进队
    	while (!nodequeue.isEmpty()) {
    		node = nodequeue.peek();
    		System.out.print(node.getData()+" ");
    		nodequeue.poll();  //队头元素出队
    		if (node.getLchild()!=null) {
    			nodequeue.add(node.getLchild());  //左入队
    		}
    		if (node.getRichild()!=null) {
    			nodequeue.add(node.getRichild());  //右入队
    		}
    	}
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		if (root==null) return ll;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		int count = 1;
		q.add(root);
		while (!q.isEmpty() || !s.isEmpty()){
			if (count%2==1){
				++ count;
				int size = q.size();
				for (int i=0; i<size; i++){
					l.add(q.poll().val);
					if (root.getLchild()!=null) s.push(root.getLchild());
					if (root.getRichild()!=null) s.push(root.getRichild());
				}
			} else {
				++ count;
				int size = s.size();
				for (int i=0; i<size; i++){
					l.add(s.pop().val);
					if (root.getLchild()!=null) q.add(root.getLchild());
					if (root.getRichild()!=null) q.add(root.getRichild());
				}
			}
			ll.add(l);
		}
		return ll;
	}
    
	public static void main(String args[]) {
		//将数组转换为完全二叉树
		Object[] array = {1,2,3,4,5,6,7,8};
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.BuildBinaryTree(array);
		System.out.println(bt.zigzagLevelOrder(root));
//        System.out.print("The height of tree: ");
//        System.out.println(bt.height(root));
//        System.out.print("The number of nodes: ");
//        System.out.println(bt.size(root));
//        System.out.print("PreOrderTraversal: ");
//        bt.PreOrderTraversal(root);
//        System.out.println();
//        System.out.print("nonRecPreOrderTraversal: ");
//        bt.nonRecPreOrderTraversal(root);
//        System.out.println();
//        System.out.print("InOrderTraversal: ");
//        bt.InOrderTraversal(root);
//        System.out.println();
//        System.out.print("nonRecInOrderTraversal: ");
//        bt.nonRecInOrderTraversal(root);
//        System.out.println();
//        System.out.print("PostOrderTraversal: ");
//        bt.PostOrderTraversal(root);
//        System.out.println();
//        System.out.print("nonRecPostOrderTraversal: ");
//        bt.nonRecPostOrderTraversal(root);
//        System.out.println();
//        System.out.print("LevelOrderTraversal: ");
//        bt.LevelOrderTraversal(root);
//        System.out.println();
//        
//        //手动健树
//        TreeNode nodeA = new TreeNode("A");
//        TreeNode nodeB = new TreeNode("B");
//        TreeNode nodeC = new TreeNode("C");
//        TreeNode nodeD = new TreeNode("D");
//        TreeNode nodeE = new TreeNode("E");
//        TreeNode nodeF = new TreeNode("F");
//        TreeNode nodeG = new TreeNode("G");
//        TreeNode nodeH = new TreeNode("H");
//        TreeNode nodeI = new TreeNode("I");
//        nodeA.setLchild(nodeB);
//        nodeA.setRchild(nodeC);
//        nodeB.setLchild(nodeD);
//        nodeB.setRchild(nodeE);
//        nodeC.setLchild(nodeF);
//        nodeC.setRchild(nodeG);
//        nodeD.setLchild(nodeH);
//        nodeD.setRchild(nodeI);
//        
//        System.out.print("The height of tree: ");
//        System.out.println(bt.height(nodeA));
//        System.out.print("The number of nodes: ");
//        System.out.println(bt.size(nodeA));
//        System.out.print("PreOrderTraversal: ");
//        bt.PreOrderTraversal(nodeA);
//        System.out.println();
//        System.out.print("nonRecPreOrderTraversal: ");
//        bt.nonRecPreOrderTraversal(nodeA);
//        System.out.println();
//        System.out.print("InOrderTraversal: ");
//        bt.InOrderTraversal(nodeA);
//        System.out.println();
//        System.out.print("nonRecInOrderTraversal: ");
//        bt.nonRecInOrderTraversal(nodeA);
//        System.out.println();
//        System.out.print("PostOrderTraversal: ");
//        bt.PostOrderTraversal(nodeA);
//        System.out.println();
//        System.out.print("nonRecPostOrderTraversal: ");
//        bt.nonRecPostOrderTraversal(nodeA);
//        System.out.println();
//        System.out.print("LevelOrderTraversal: ");
//        bt.LevelOrderTraversal(nodeA);
//        System.out.println();       
         }
}
