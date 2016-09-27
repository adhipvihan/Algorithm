			/* Algorithm Practice For Amazon */
			/* Binary Tree Algorithms*/
			/* Adhip Vihan */

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
	
	static int NumberOfNodes(BinaryTreeNode root){
		if(root==null)
			return 0;
		
		return 1+NumberOfNodes(root.left)+NumberOfNodes(root.right);
	}
	
	static int MaxElement(BinaryTreeNode root){
		if(root==null)
			return -1;
		int lmax = MaxElement(root.left);
		int rmax = MaxElement(root.right);
		
		return Math.max(Math.max(lmax, rmax), root.data);
		
	}
	
	static BinaryTreeNode search(BinaryTreeNode root,BinaryTreeNode node){
		if(root==null)
			return null;
		if(root.data==node.data)
			return root;
		return search(root.right,node)!=null?search(root.right,node):search(root.left, node);
	}
	
	static int numberOfLeaves(BinaryTreeNode root){
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 1;
		return numberOfLeaves(root.left) + numberOfLeaves(root.right);
	}
	
	static int fullNodes(BinaryTreeNode root){
		if(root==null)
			return 0;
		if(root.left!=null && root.right!=null)
			return 1+fullNodes(root.getRight())+fullNodes(root.getLeft());
		else
			return 0;
	}
	
	static int maxwidth(BinaryTreeNode root){
		int max = Integer.MIN_VALUE;
		int height = height(root);
		for(int i=1;i<=height;i++){
			int count = numberOfNodesAtLevel(root, i);
			if(count>max)
				max=count;
		}
		
		return max;
	}
	
	static int numberOfNodesAtLevel(BinaryTreeNode root,int level){
		if(root==null)
			return 0;
		if(level==1)
			return 1;
		else
			return numberOfNodesAtLevel(root.left,level-1)+ numberOfNodesAtLevel(root.right,level-1);
	}
	
	static void printAllPaths(BinaryTreeNode root,int[] path,int pathlen){
		if(root==null)
			return;
		
		path[pathlen] = root.data;
		pathlen++;
		
		if(root.left==null && root.right==null)
			printPath(path,pathlen);
		else{
			printAllPaths(root.left,path,pathlen);
			printAllPaths(root.right,path,pathlen);
		}
	}
	
	static void printPath(int[] p,int plen){
		System.out.println("\n");
		for(int i=0;i<plen;i++){
			System.out.print(p[i]);
		}
			
	}
	
	static void printAllPaths(BinaryTreeNode root){
		int[] path = new int[256];
		printAllPaths(root, path, 0);
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
		//LevelOrder(bt.root);
		//BinaryTreeNode x = new BinaryTreeNode(2);
		//System.out.println(MaxElement(bt.root));
		//System.out.println(search(bt.root, x).data);
		//System.out.println(fullNodes(bt.root));
		//System.out.println(maxwidth(bt.root));
		printAllPaths(bt.root);
	}
	
	
}
