			/* Algorithm Practice For Amazon */
			/* Binary Tree Algorithms*/
			/* Adhip Vihan */

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
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
				
				if(!q.isEmpty())
					q.offer(null);
			}
			
		}
	}
	
	
	static int maxwidthIterative(BinaryTreeNode root){
		if(root==null)
			return 0;
		int max = Integer.MIN_VALUE;

		LinkedList<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		q.add(null);

		ArrayList<LinkedList<BinaryTreeNode>> rs = new ArrayList<LinkedList<BinaryTreeNode>>();
		LinkedList<BinaryTreeNode> cur = new LinkedList<BinaryTreeNode>();

		while(!q.isEmpty()){

			BinaryTreeNode curr = q.poll();

			if(curr!=null){

				cur.add(curr);
				if(curr.left!=null)
					q.add(curr.left);
				if(curr.right!=null)
					q.add(curr.right);
			}
			else{
				LinkedList<BinaryTreeNode> temp = new LinkedList<BinaryTreeNode>(cur);
				if(temp.size()>max)
					max = temp.size();
				rs.add(temp);
				cur.clear();

				if(!q.isEmpty())
				q.add(null);
			}
		}
		
		return max;
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
	
	static boolean hasSum(BinaryTreeNode root,int sum){
		if(root==null)
			return false;
		if(root.getLeft()!=null && root.getRight()!=null && root.data==sum)
			return true;
		else{
			return hasSum(root.left, sum-root.data) || hasSum(root.right, sum-root.data);
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
	
	/* Build tree from Inorder & Preorder Traversal */
	
	static void buildTree(int[] preorder,int[] inorder){
		buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
	}
	
	static BinaryTreeNode buildTree(int[] preorder,int pstart,int pend,int[] inorder,int istart,int iend){
		if( (pend>pstart) || (iend>istart) )
			return null;
		
		BinaryTreeNode cur = new BinaryTreeNode(preorder[pstart]);
		int offset = istart;
		while(offset<iend){
			if(inorder[offset]==cur.data)
				break;
			offset++;
		}
		/* Explanation of what has been done here
		 * Why are we incrementing postorder start and end like that?
		 * Because for left node of the root we know that it is +1 in the preorder array
		 * but we don't know what is the index of the right node. We are basically finding the number of nodes
		 * between the left node and the right node, so we increment the end by left + the number of nodes in the left sub-tree of root.
		 * which can be found by inorder index.
		 * Number of nodes in left subtree of root = start of preorder + (offset-start of inorder)
		 * */
		cur.left = buildTree(preorder, pstart+1,pend+(offset-istart), inorder, istart, offset-1);
		cur.right = buildTree(preorder, pstart+(offset-istart)+1,pend, inorder, offset+1, iend);
		
		return cur;
	}
	
	
	// Tree From Inorder & Postorder Traversal
	static BinaryTreeNode builtTree2(int[] inorder,int[] postorder){
		return buildTree2(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
	}
static BinaryTreeNode buildTree2(int[] inorder,int istart,int iend,int[] postorder,int pstart,int pend){
		if( (iend>istart) || (pend>pstart) )
			return null;
	
		BinaryTreeNode cur = new BinaryTreeNode(postorder[pend]);
		int offset=istart;
		while(offset<iend){
			if(inorder[offset]==cur.data)
				break;
			offset++;
		}
		cur.left = buildTree2(inorder, istart, offset-1, postorder, pstart, pend-(offset-istart)-1);
		cur.right = buildTree2(inorder, offset+1, iend, postorder, pstart+(offset-istart), pend-1);
		return cur;
	}

	static boolean printAllAncestors(BinaryTreeNode root,BinaryTreeNode node){
		if(root==null)
			return false;
		if(root.left.getData()==node.data || root.left.getData()==node.data || printAllAncestors(root.left, node) || printAllAncestors(root.right, node))
			{System.out.println(root.data);
			return true;
			} 
		return false;
	}
	
	static BinaryTreeNode LCA(BinaryTreeNode root,BinaryTreeNode node1,BinaryTreeNode node2){
		if(root==null)
			return null;
		if(root.data==node1.data || root.data==node2.data)
			return root;
		BinaryTreeNode left = LCA(root.left,node1,node2);
		BinaryTreeNode right = LCA(root.right,node1,node2);
		
		if(left!=null && right!=null)
			return root;
		else
			return left!=null?left:right;
	}
	
	static void zigzag(BinaryTreeNode root){
		
	}
	
	static void verticalSum(BinaryTreeNode root){
		//
	}
	
	
	static String serialize(BinaryTreeNode root){
		if(root==null)
			return "";
		
		StringBuilder sb = new StringBuilder();

		LinkedList<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();

		q.add(root);
		while(!q.isEmpty()){
			BinaryTreeNode curr = q.poll();

			if(curr!=null){
				sb.append(curr.data+",");
				q.add(curr.left);
				q.add(curr.right);
			}
			else
				sb.append("!,");
		}
		return sb.toString().substring(0,sb.length()-1);
	}
	
	static BinaryTreeNode deserialize(String data) {
	    if(data==null || data.length()==0)
	        return null;
	 
	    String[] arr = data.split(",");
	    BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(arr[0]));
	 
	 
	    LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
	    queue.add(root);
	 
	    int i=1;
	    while(!queue.isEmpty()){
	        BinaryTreeNode t = queue.poll();
	 
	        if(t==null)
	            continue;
	 
	        if(!arr[i].equals("#")){
	            t.left = new BinaryTreeNode(Integer.parseInt(arr[i]));    
	            queue.offer(t.left);
	 
	        }else{
	            t.left = null;
	            queue.offer(null);
	        }
	        i++;
	 
	        if(!arr[i].equals("#")){
	            t.right = new BinaryTreeNode(Integer.parseInt(arr[i]));    
	            queue.offer(t.right);
	 
	        }else{
	            t.right = null;
	            queue.offer(null);
	        }
	        i++;
	        
	    }
	 
	    return root;
	}
	
	static BinaryTreeNode Deserialize(String x){
		
		if(x==null || x.length()==0)
			return null;

		String[] temp = x.split(",");

		BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(temp[0]));
		LinkedList<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();

		q.add(root);
		int i=1;

		while(!q.isEmpty()){

			BinaryTreeNode curr = q.poll();

			if(curr==null)
				continue;
			
			if(!temp[i].equals("!")){
				curr.left = new BinaryTreeNode(Integer.parseInt(temp[i]));
				q.add(curr.left);
			}
			else{
				curr.left = null;
				q.add(null);
			}
			i++;

			if(!temp[i].equals("!")){
				curr.right = new BinaryTreeNode(Integer.parseInt(temp[i]));
				q.add(curr.right);
			}
			else{
				curr.right = null;
				q.add(null);
			}
			i++;

		}

		return root;

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
		System.out.println(maxwidthIterative(bt.root));
		//printAllPaths(bt.root);
		//System.out.println(serialize(bt.root));
		//BinaryTreeNode x = Deserialize(serialize(bt.root));
		//InorderWithoutRecursion(x);
	}
	
	
}
