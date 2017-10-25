package DataStructure;

public class TreeNode<E> {
	private E data; //不能用int，因为数据不一定是整型数据
	private TreeNode<E> lchild;
	private TreeNode<E> rchild;
	public Integer val;
	
	public TreeNode(){   //第一种构建方法
		
	}
	
	public TreeNode(E data){   //第二种构建方法
		this.data = data;
	}
	
	public TreeNode(E data,TreeNode<E> lchild,TreeNode<E> rchild){   //第三种构建方法
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}
	
	public void setData(E data){
		this.data = data;
	}
	
	public E getData(){
		return this.data;
	}
	
	public void setLchild(TreeNode<E> lchild){
		this.lchild = lchild;
	}
	
	public TreeNode<E> getLchild(){
		return this.lchild;
	}
	
	public void setRchild(TreeNode<E> rchild){
		this.rchild = rchild;
	}
	
	public TreeNode<E> getRichild(){
		return this.rchild;
	}
}

	