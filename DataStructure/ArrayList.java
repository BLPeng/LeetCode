package DataStructure;

import java.lang.reflect.Array;

public class ArrayList {
    
	final int defaultSize = 0;
	Object[] arraylist;
	int maxsize;  //线性表最大长度
	int length; //线性表当前长度
	
	public ArrayList(int size){
		initList(size);
	}
	
	
	private void initList(int size) {
        if (size<0){
        	throw new RuntimeException("ERROR");
        } else {
        	this.maxsize = size;
        	this.length = 0;
        	this.arraylist = new Object[size];
        }
	}
	
	public int length(){
		return length;
	}
	
	public int locateElement(Object e){
		for (int i=0; i<length; i++){
			if (arraylist[i]==e){
				return i;
			}
		}
		return -1;
	}
	
	public Object getElement(int i){
		if (i<0 || i>length){
			return null;
		} 
		if (length==0){
			return null;
		}
		return arraylist[i];
	}
	
	public void insert(Object e, int i){
		if (i<0 || i>length+1){
			throw new RuntimeException("ERROR");
		}
		if (i>=maxsize){
			throw new RuntimeException("ERROR");
		}
		for (int j=length; j<i; j--){
			arraylist[j]=arraylist[j-1];
		}
		arraylist[i]=e;
		length++;
	}
	
	public void delete(int i, Object e){
		if (i<0 || i>length-1){
			throw new RuntimeException("ERROR");
		}
		if (length == 0){
			throw new RuntimeException("ERROR");
		}
		for (int j=i; j<length-1; j++){
			arraylist[j]=arraylist[j+1];
		}
		arraylist[length-1]="";
		length--;
	}

    public boolean isEmpty(){
    	return length==0 ? true:false;
    }
	
    public void destoryList(){
    	this.arraylist=null;
    	this.length=0;
    	this.maxsize=0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
