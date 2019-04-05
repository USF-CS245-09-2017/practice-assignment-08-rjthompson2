public class BST<T>{
	public Node root = null;
	public class Node{
		Comparable data;
		Node left;
		Node right;
		Node(Comparable d){
			data = d;
			left = null;
			right = null;
		}
	}
	public boolean find(Comparable item){
		Node temp = null;
		temp = findNode(root, item);
		if(temp == null){
			return false;
		}
		return true;
	}
	public Node findNode(Node temp, Comparable item){
		if(temp == null || temp.data == item){
			return temp; 
		}
	    if(temp.data.compareTo(item) > 0){
			return findNode(temp.right, item);  
	    }
		return findNode(temp.left, item);
	}
	public void insert(Comparable item){
		root = insertNode(root, item);
	}
	public Node insertNode(Node temp,Comparable item){
		if(temp == null){
			temp = new Node(item);
			return temp;
		}else if(temp.data.compareTo(item) > 0){
			temp.right = insertNode(temp.right, item);
		}else{
			temp.left = insertNode(temp.left, item);
		}
		return temp;
	}
	public void print(){
		printLTR(root);

	}
	public void printLTR(Node temp) { 
		if (temp != null) { 
			printLTR(temp.right); 
			System.out.println(temp.data); 
			printLTR(temp.left); 
		} 
	} 
	public void delete(Comparable item){
		root = deleteNode(root, item);
	}
	public Node deleteNode(Node temp, Comparable item){
		if(temp == null){
			return temp;
		}
        if(temp.data.compareTo(item) < 0){
			temp.left = deleteNode(temp.left, item);
        }
		else if(temp.data.compareTo(item) > 0){
			temp.right = deleteNode(temp.right, item);
		}
		else{
			if (temp.left == null){
				return temp.right;
			}
			else if (temp.right == null){
				return temp.left;
			}
			temp.data = getMin(temp.right);
			temp.right = deleteNode(temp.right, temp.data);
		}
		return temp;
	}
	public Comparable getMin(Node temp){
		Comparable min = temp.data;
		while(temp.left != null){
			temp = temp.left;
			min = temp.data;
		}
		return min;
	}
}
