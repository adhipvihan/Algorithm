import java.util.Stack;

class BstNode{
	int data;
	BstNode left;
	BstNode right;
		
	public BstNode(int data){
		this.data= data;
		this.right=null;
		this.left=null;
	}
}
public class BST {

	BstNode root;
	
		public BST(int data){
			root = new BstNode(data);
		}
		
		public BstNode insert(BstNode root,int data){
			BstNode temp = new BstNode(data);
			
			if(root==null)
				root = temp;
			else{
				if(root.data<data)
					root.right=insert(root.right,data);
				else
					root.left=insert(root.left,data);
			}
			return root;
		}
		
		public void Inorder(BstNode root){
			if(root!=null){
				Inorder(root.left);
				System.out.println(root.data);
				Inorder(root.right);
				
			}
			
		}
		
		static BstNode findMax(BstNode root){
			if(root==null)
				return null;
			if(root.right!=null)
				return findMax(root.right);
			return root;
		}
		
		public BstNode Delete(BstNode root,int data){
			if(root==null)
				System.out.println("Dayum");
			
			else if(data<root.data)
				root.left = Delete(root.left,data);
			
			else if(data>root.data)
				root.right = Delete(root.right,data);
			
			else{
				if(root.left!=null && root.right!=null){
					BstNode temp = findMax(root.left);
					root.data = temp.data;
					root.left = Delete(root.left,root.data);
				}
				
				else if(root.left==null && root.right==null)
						root=null;
				else{
					
					if(root.left==null)
						root=root.right;
					if(root.right==null)
						root=root.left;
				}
				
			}
			return root;
		}
		
		static boolean isBst(BstNode root, int min,int max){
			if(root==null)
				return true;
			return (root.data>min && root.data<=max && isBst(root.left,min,root.data) && isBst(root.right,root.data,max));
		}
		
		public void kSmallest(int k){
			if(root==null)
				return;
		
			Stack<BstNode> s = new Stack<BstNode>();
			s.push(root);
			int count=0;
			while(!s.isEmpty()){
				
				if(root.left!=null){
					s.push(root.left);
					root=root.left;
				}
				
				else{
					BstNode temp = s.pop();
					
					if(++count==k)
					System.out.println(temp.data);
					
					if(temp.right!=null)
						s.push(temp.right);
				}
			}
		}
		
		
		static BstNode binaryTreeToDLLHelper(BstNode root){
			if(root==null)
				return root;
			
			BstNode left = binaryTreeToDLLHelper(root.left);
			BstNode right = binaryTreeToDLLHelper(root.right);
			
			if(root.left!=null){
				BstNode temp = root.left;
				
				while(temp.right!=null)
					temp=temp.right;
				
				temp.right = root;
				root.left = temp;
			}
			
			if(root.right!=null){
				BstNode temp = root.right;
				
				while(temp.left!=null)
					temp=temp.right;
				temp.left= root;
				root.right=temp;
			}
			
			return root;
		}
		
		
		static BstNode binaryTreeToDLL(BstNode root){
			if(root==null)
				return root;
			
			BstNode node = binaryTreeToDLLHelper(root);
			
			while(node.left!=null)
				node=node.left;
			
			return node;
		}
		
		static BstNode LCA(BstNode root,BstNode n1,BstNode n2){
			if(root==null)
				return root;
			
			if(root.data>n1.data)
				return LCA(root.right,n1,n2);
			else if(root.data<n2.data)
				return LCA(root.left,n1,n2);
			return root;
		}
		
		static BstNode celing(BstNode root,int key){
			if(root==null)
				return root;
			
			if(root.data==key)
				return root;
			
			if(root.data<key)
				return celing(root.right,key);
				
				BstNode left = celing(root.left,key);
				
				return left.data>=key?left:root;						
		}
		
		static BstNode floor(BstNode root,int key){
			if(root==null)
				return root;
			
			if(root.data>key)
				return floor(root.left, key);
			
			BstNode x = floor(root.right,key);
			return x.data<=key?x:root;
		}
		
		static int checkBalance(BstNode root){
			if(root==null)
				return 0;
			
			return 1+Math.max(checkBalance(root.left), checkBalance(root.right));
		}
		
//		static int countRange(BstNode root,int a,int b){
//			if(root==null)
//				return 0;
//			
//			if(root.data>=a){
//				if(root.data==a)
//				return  1+countRange(root.left,a,b);
//				else
//					return 1+countRange(root.left,a,b);
//			}
//			if(root.data<b)
//				return countRange(root.right,a,b);
//			
//			if(root.data<=a && root.data<b)
//				return 1 + countRange(root.left,a,b) + countRange(root.right,a,b);
//			
//		}
		public static void main(String[] args){
			BST x = new BST(5);
			x.insert(x.root,1);
			x.insert(x.root,2);
			x.insert(x.root,8);
			x.Inorder(x.root);
			//x.kSmallest(3);
			//x.root = x.Delete(x.root, 2);
			//x.Inorder(x.root);
			//System.out.println(x.findMax(x.root).data);
			//System.out.println(isBst(x.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
			System.out.println(LCA(x.root,new BstNode(8),new BstNode(2)).data);
		}
}
