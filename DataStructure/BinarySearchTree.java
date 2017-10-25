package DataStructure;

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
import java.lang.Integer;

public class BinarySearchTree {
    
	private TreeNode<Integer> root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public TreeNode<Integer> buildBST(Integer[] array){ //单靠数组构建二叉搜索树
		if (array.length==0){
			return null;
		} else {
			root = null;
			for (int i =0; i<array.length; i++) {
				root = insertNode(root,array[i]);
			}
			return root;
		}
	}
	
	public TreeNode<Integer> insertNode(TreeNode<Integer> node, Integer data){ //node当做根节点，data是被插入节点的数据域
		if (node==null){
			node = new TreeNode<Integer>(data);
		} else {
			if (node.getData()==data){
				
			} else {
				if (node.getData()>data){
					node.setLchild(insertNode(node.getLchild(),data));
			} else {
				    node.setRchild(insertNode(node.getRichild(),data));
			}
		}
	}
		return node;
		}
	
	public void InOrderTraversal(TreeNode<Integer> node){
		if (node!=null) {
			InOrderTraversal(node.getLchild());
			System.out.print(node.getData()+" ");
			InOrderTraversal(node.getRichild());
		}
	}
	
	public void LevelOrderTraversal(TreeNode<Integer> root){
		Queue<TreeNode<Integer>> nodequeue = new LinkedList<TreeNode<Integer>>();
		TreeNode<Integer> node = null;
		nodequeue.add(root);
		while (!nodequeue.isEmpty()){
			node = nodequeue.poll();
			System.out.print(node.getData()+" ");
			if (node.getLchild()!=null){
				nodequeue.add(node.getLchild());
			}
			if (node.getRichild()!=null){
				nodequeue.add(node.getRichild());
			}
		}
	}
	
	public TreeNode<Integer> searchNode(TreeNode<Integer> node, Integer data){
		while (node!=null && node.getData()!=data){
			if (node.getData()>data){
				node = node.getLchild();
			} else {
				node = node.getRichild();
			}
		}
		return node; //循环做完才跳出来
	}
	
	public TreeNode<Integer> getMinData(TreeNode<Integer> node){ //node是要找的节点
		if (node.getLchild()==null){
			return node;
		} else {
			return getMinData(node.getLchild());
		}
	}
	
	public TreeNode<Integer> getMaxData(TreeNode<Integer> node){  //node是要找的节点
		if (node.getRichild()==null){
			return node;
		} else {
			return getMaxData(node.getRichild());
		}
	}
	
	public TreeNode<Integer> getParentNode(TreeNode<Integer> root, Integer data){  //根据data的信息得到它的父节点
		TreeNode<Integer> parentnode = root;
		if (parentnode.getData()==data){
			return null;  //根节点没有父节点
		}
		while (parentnode!=null){
			if ((parentnode.getLchild()!=null && parentnode.getLchild().getData()==data) || (parentnode.getRichild()!=null && parentnode.getRichild().getData() ==data)){
				return parentnode;
			} else{
				if (parentnode.getData()>data){
					parentnode = parentnode.getLchild();
				} else {
					parentnode = parentnode.getRichild();
				}
			}
		}
		return null;
	}
	
	public TreeNode<Integer> getPrecessor(TreeNode<Integer> root, TreeNode<Integer> node){
		TreeNode<Integer> parentnode = getParentNode(root,node.getData());
		if (node==null){
			return null;
		}
		if (node.getLchild()!=null){
			return getMaxData(node.getLchild());
		} else {
			while (parentnode!=null && node==parentnode.getLchild()){
				node = parentnode;
			    parentnode = getParentNode(root,parentnode.getData());
		}
			return parentnode;
	}
		}
	
	public TreeNode<Integer> getSuccessor(TreeNode<Integer> root, TreeNode<Integer> node){
		TreeNode<Integer> parentnode = getParentNode(root,node.getData());
		if (node==null){
			return null;
		}
		if (node.getRichild()!=null){
			return getMinData(node.getRichild());
		} else {
			while (parentnode!=null && node==parentnode.getRichild()){
				node = parentnode;
				parentnode = parentnode.getRichild();
			}
			return parentnode;
		}
	}
	
	public boolean deleteNode(TreeNode<Integer> node, Integer data){
		if (node==null){
			return false;
		}
		TreeNode<Integer> delnode = searchNode(node,data);
		TreeNode<Integer> parentnode = null;
		if (delnode==null){
			return false;
		} else {
			parentnode = getParentNode(node,data);
			if (delnode.getLchild()==null && delnode.getRichild()==null){
				if (delnode==parentnode.getLchild()){
					parentnode.setLchild(null);
				} else {
					parentnode.setRchild(null);
				}
				return true;
		}
			if (delnode.getLchild()!=null && delnode.getRichild()==null){
				if (delnode==parentnode.getLchild()){
					parentnode.setLchild(delnode.getLchild());
				} else {
					parentnode.setRchild(delnode.getLchild());
				}
				delnode.setLchild(null);
				return true;
			}
			if (delnode.getRichild()!=null && delnode.getLchild()==null){
				if (delnode==parentnode.getLchild()){
					parentnode.setLchild(delnode.getRichild());
				} else {
					parentnode.setRchild(delnode.getRichild());
				}
				delnode.setRchild(null);
				return true;
			}
			if (delnode.getLchild()!=null && delnode.getRichild()!=null){
				TreeNode<Integer> successornode = getSuccessor(root,delnode);
				deleteNode(node,successornode.getData());
				delnode.setData(successornode.getData());
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Integer[] array = {8,3,10,1,6,14,4,7,13};
        BinarySearchTree bst = new BinarySearchTree();
		TreeNode<Integer> root = bst.buildBST(array);
		System.out.print("Level order traversal: ");
		bst.LevelOrderTraversal(root);
		System.out.print("\n"+"In order traversal: ");
		bst.InOrderTraversal(root);
		System.out.println();
		System.out.print("The minimal element is: ");
		System.out.print(bst.getMinData(root).getData()+" "+"\n");
		System.out.print("The maximal element is: ");
		System.out.print(bst.getMaxData(root).getData()+" "+"\n");
		System.out.print("Insert a data into BST: ");
		int data = input.nextInt();
		System.out.print("In order traversal after insertation: ");
		root = bst.insertNode(root, data);
		bst.InOrderTraversal(root);
		
		System.out.print("\n"+"The target data is: ");
		data = input.nextInt();
		System.out.print("Data's parentnode is: ");
        if (bst.getParentNode(root, data)==null){
    		System.out.println("null");
        } else {
    		System.out.println(bst.getParentNode(root, data).getData());
        }
		System.out.print("The traget data is: ");
		data = input.nextInt();
        if (bst.deleteNode(root, data)){
    		System.out.print("Level order traversal after deleting: ");
            bst.LevelOrderTraversal(root);
    		System.out.print("\n"+"In order traversal after deleting: ");
            bst.InOrderTraversal(root);   
        }
	}

}
