//Adhip Vihan//

import java.util.*;
class BinaryTree{
	BinaryTreeNode root;
	
	public BinaryTree(int data){
		root = new BinaryTreeNode(data);
		root.setLeft(null);
		root.setRight(null);
	}
}

public class BinaryTreeNode {

	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	
	public BinaryTreeNode(int data){
		this.data = data;
		this.left= null;
		this.right = null;
	}
	
	public int getData(){
		return this.data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public BinaryTreeNode getLeft(){
		return this.left;
	}
	
	public void setLeft(BinaryTreeNode left){
		this.left = left;
	}
	
	public BinaryTreeNode getRight(){
		return this.right;
	}
	public void setRight(BinaryTreeNode right){
		this.right = right;
	}
	
	
	static void InorderWithoutRecursion(BinaryTreeNode root){
		ArrayList<Integer> rs = new ArrayList<Integer>();
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		boolean done = false;
		BinaryTreeNode current = root;
		
		while(!done){
			if(current!=null){
				s.push(current);
				current = current.left;
			}
			else{
				if(s.isEmpty()){
					done=true;
				}
				else{
					current = s.pop();
					rs.add(current.data);
					current = current.right;
				}
			}
		}
		
		for(int i=0;i<rs.size();i++)
			System.out.print(rs.get(i));
	}
	
	static int height(BinaryTreeNode root){
		if(root==null)
			return 0;
		
		return 1+ Math.max(height(root.left), height(root.right));
	}
	
	static boolean checkMirrors(BinaryTreeNode root1,BinaryTreeNode root2){
		if(root1==null && root2==null)
			return true;
		if(root1!=null && root2!=null && root1.data==root2.data)
			return checkMirrors(root1.getRight(),root2.getLeft()) && checkMirrors(root1.getLeft(), root2.getRight());
		
		return false;
	}
	
	static void Preorder(BinaryTreeNode root){
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		ArrayList<Integer> rs = new ArrayList<>();
		s.push(root);
		BinaryTreeNode prev = null;
		while(!s.isEmpty()){
			
			BinaryTreeNode current = s.peek();
			if(prev==null || prev.getLeft()==current || prev.getRight()==current ){
				
				if(current.left!=null)
					s.push(current.left);
				else if(current.right!=null)
					s.push(current.right);
				else{
					s.pop();
					rs.add(current.data);
				}
			}
			
			else if(current.left==prev){
				
				if(current.right!=null){
					s.push(current.getRight());
				}
				else{
					s.pop();
					rs.add(current.data);
				}
			}
			
			else if(current.right==prev){
				s.pop();
				rs.add(current.data);
			}
			prev = current;
		}
		
		for(int i=0;i<rs.size();i++)
			System.out.print(rs.get(i));
	}
	
	static int diameter(BinaryTreeNode root){
		if(root==null)
			return 0;
		
		int lheight = height(root.right);
		int rheight = height(root.left);
		
		int ldiam = diameter(root.left);
		int rdiam = diameter(root.right);
		
		return Math.max(1+lheight+rheight,Math.max(ldiam,rdiam));
	}

	static void LevelOrder(BinaryTreeNode root){
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		ArrayList<Integer> rs = new ArrayList<Integer>();
		q.offer(root);
		
		while(!q.isEmpty()){
			BinaryTreeNode temp = q.poll();
			rs.add(temp.data);
			if(temp.getLeft()!=null)
				q.offer(temp.left);
			if(temp.getRight()!=null)
				q.offer(temp.getRight());
		}
		for(int i=0;i<rs.size();i++)
			System.out.print(rs.get(i));
		
	}
	
	static void LevelOrderWithLevels(BinaryTreeNode root){
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
		
		q.offer(root);
		q.offer(null);
		ArrayList<Integer> curr = new ArrayList<Integer>();
		while(!q.isEmpty()){
			BinaryTreeNode temp = q.poll();
	
			if(temp!=null){
				curr.add(temp.data);
				if(temp.getLeft()!=null)
					q.offer(temp.left);
				if(temp.getRight()!=null)
					q.offer(temp.getRight());
				}
			else{
				ArrayList<Integer> tmp = new ArrayList<Integer>(curr);
				rs.add(tmp);
				curr.clear();
			}
			if(!q.isEmpty())
				q.offer(null);
		}
	}
	
	
	public static void main(String[] args){
		BinaryTree bt = new BinaryTree(1);
		bt.root.setLeft(new BinaryTreeNode(2));
		bt.root.setRight(new BinaryTreeNode(3));
		bt.root.getLeft().setLeft(new BinaryTreeNode(4));
		bt.root.getLeft().setRight(new BinaryTreeNode(5));
		bt.root.getRight().setLeft(new BinaryTreeNode(6));
		bt.root.getRight().setRight(new BinaryTreeNode(7));
		//InorderWithoutRecursion(bt.root);
		//Preorder(bt.root);
		LevelOrder(bt.root);
	}
	
	
}
