
public class AVL {

	int data;
	int height;
	AVL left;
	AVL right;
	
		public AVL(int data){
			this.data=data;
		}
		
		public int height(AVL node){
			if(node==null)
				return 0;
			
			return 1+ Math.max(height(node.left), height(node.right));
		}
		
		
		public AVL LL(AVL root){
			AVL x = root.left;
			root.left = x.right;
			x.right = root;
			return x;
		}
		
		public AVL RR(AVL root){
			AVL x = root.right;
			root.right = x.left;
			x.left = root;
			return x;
		}
		
		public AVL LR(AVL root){
			root.left = RR(root.left);
			root = LL(root);
			return root;
		}
		
		public AVL RL(AVL root){
			root.right = LL(root.left);
			root = RR(root);
			return root;
		}
		
		public AVL insert(AVL root,int data){
			if(root==null)
				root = new AVL(data);
			
			if(root.data<= data){
				root.left = insert(root.left,data);
				
				if( height(root.left) - height(root.right) == 2){
					if(data<root.left.data)
						root = LL(root);
					else
						root = LR(root);
				}
					
			}
			
			else if(root.data>data){
				root.right = insert(root.right,data);
				
				if(height(root.right)-height(root.left) == 2){
					if(data>root.right.data)
						root = RR(root);
					else
						root= RL(root);
				}
			}
			
			root.height = 1 +  Math.max(height(root.left), height(root.right));
			return root;
		}
		
		public static void main(String[] args){
			AVL x = new AVL(2);
			System.out.println(x.height);
		}
}
