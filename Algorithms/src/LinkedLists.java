import javax.swing.SwingConstants;

class ListNode{
	int data;
	ListNode next;
		
			public ListNode(int data){
				this.data = data;
				this.next = null;
			}
}

public class LinkedLists {
	
	ListNode head;
	int length;
	
		public LinkedLists(){
			length = 0;
		}
		
		public synchronized ListNode getHead(){
			return this.head;
		}
		
		public synchronized void insertAtBegin(ListNode node){
			if(this.head==null){
				head = node;
				length++;
			}
			else{
				node.next = head;
				head = node;
				length++;
			}
		}
		
		public synchronized void insertAtEnd(ListNode node){
			if(head==null)
				head = node;
			else{
				ListNode temp = head;
				while(temp.next!=null)
					temp=temp.next;
				
				temp.next = node;
				node.next = null;
			}
			
			length++;
		}
		
		public void insert(int data, int position){
			ListNode node = new ListNode(data);
			
				if(position<0)
					position =0;
				if(position>length)
					position = length;
				
				if(head==null)
					head = node;
				
				else if(position==0){
					node.next = head;
					head = node;
				}
				else{
					int count = 1;
					ListNode temp = head;
					
					while(count<position){
						count++;
						temp=temp.next;
					}
						node.next = temp.next;
						temp.next = node;
				}
				
				length++;
		}
		
		public synchronized ListNode removeFromEnd(){
			if(head == null)
				return head;
			
			ListNode temp = head;
			
			while(temp.next.next!=null){
				temp=temp.next;
			}
			ListNode result = temp.next;
			temp.next = null;
			length--;
			return result;
		}
		
		public synchronized void removeMatched(ListNode node){
			if(head == null)
				return;
			
			if(node.equals(head)){
				head = head.next;
			}
			
			ListNode p = head;
			ListNode q = head.next;
			
			while(q!=null){
				if(q.equals(node)){
					p.next = q.next;
					return;
				}
				
				p = q;
				q= q.next;
			}
			length--;
		}
		
		public void remove(int position){
			if(position<0)
				position =0;
			if(position>length)
				position = length;
			
			if(head == null)
				return;
			
			else if(position==0){
				head = head.next;
			}
			
			else{
				int count =1;
				ListNode temp = head;
				
				while(count<position){
					temp=temp.next;
					count++;
				}
				
				temp.next = temp.next.next;
			}
			
			length--;
				
		}
		
		public void printList(){
			
			ListNode temp = head;
			
			while(temp!=null){
				System.out.print(temp.data);
				if(temp.next != null)
					System.out.print("->");
				temp=temp.next;
			}
		}
		
		public ListNode nthFromEnd(int n){
			ListNode p = null;
			ListNode q = head;
			
			int count = 1;
			
			while(count<n && q!=null){
				q= q.next;
				count++;
			}
			
			while(q!=null){
				if(p == null)
					p= head;
				else
					p=p.next;
				q=q.next;
			}
			
			return p;
		}
		
		
		
		static ListNode reverseNode(ListNode root,ListNode prev){
			
			if(root==null)
				return prev;
		
			ListNode next = root.next;
			root.next = prev;
			prev = root;
			
			return reverseNode(next, prev);
			
		}
		
		
		public static ListNode findMid(ListNode head){
			if(head== null || head.next==null)
				return head;
			
			ListNode slow = head;
			ListNode fast = head;
			
			while(slow!=null && fast!=null && fast.next!=null){
				
				slow=slow.next;
				fast=fast.next.next;
			}
			
			return slow;
		}
		
		public static boolean checkPalindrome(ListNode head){
			if(head== null)
				return true;
			ListNode mid = findMid(head);
			
			ListNode head2 = reverseNode(mid.next,null);
			mid.next = null;
			
			ListNode p1 = head;
			ListNode p2 = head2;
			
			while(p1!=null && p2!=null){
				if(p1.data != p2.data ){
					mid.next = reverseNode(head2,null);
					return false;
				}
				p1=p1.next;
				p2=p2.next;
			}
			
			mid.next = reverseNode(head2,null);
			return true;
		}
		
		public static ListNode kthFromEnd(ListNode head,int k){
			
			ListNode slow = head;
			ListNode fast = head;
			int count = 0;
			
			while(count<k && fast!=null){
				fast=fast.next;
				count++;
			}
			
			if(count!=k || fast==null){
				throw new IllegalStateException("K is larger than list size");
			}
			

			
			
			while(fast!=null){
				fast = fast.next;
				slow=slow.next;
			}
			
			return slow;
		}
		
		public static ListNode swapPairwise(ListNode head){
			if(head==null || head.next==null)
				return head;
			
			ListNode recursive = head.next.next;
			ListNode origHead = head;
			head.next.next = origHead;
			
			head = head.next;
			origHead.next = swapPairwise(recursive);
			return head;
		}
		
		static ListNode MergeSort(ListNode head){
			if(head == null || head.next == null)
				return head;
			
			ListNode mid = findMid(head);
			
			ListNode h2 = mid.next;
			ListNode h1 = head;
			mid.next = null;
			
			h1 = MergeSort(h1);
			h2 = MergeSort(h2);
			
			ListNode result = mergeSorted(h1, h2);
			
			return result;
		}
		
		
		static ListNode addNumberInList(ListNode h1,ListNode h2){
			int sum = 0;
			int carry =0;
			ListNode tail = null;
			ListNode head = null;
			ListNode temp = null;
			while(h1!=null || h2!=null){
				
				
				sum = carry+ (h1!=null?h1.data:0) + (h2!=null?h2.data:0);
				carry = sum>=10?1:0;
			
				
				sum%=10;
				temp = new ListNode(sum);
				
				if(head==null){
					head = temp;
				}
				else{
					tail.next = temp;
				}
				
				tail = temp;
			
				if(h1!=null)
					h1=h1.next;
				if(h2!=null)
					h2=h2.next;
			}
			
			if(carry>0)
				temp.next = new ListNode(carry);
			
			return head;
		}
		
		static ListNode mergeSorted(ListNode h1,ListNode h2){
			if(h1==null)
				return h2;
			else if(h2==null)
				return h1;
			
			ListNode x = null ;
			
			if(h1.data<=h2.data){
				x  = h1;
				x.next = mergeSorted(h1.next, h2);
			}
			
			else{
				x = h2;
				x.next = mergeSorted(h1, h2.next);
			}
			
			return x;
		}
		
		static ListNode rotateLinkedList(ListNode head,int k){
			ListNode p1 = head;
			
			for(int i=0;i<k && p1!=null;i++){
				p1 = p1.next;
			}
			
			System.out.println("P1 last" + p1.data);
			ListNode p2 = p1.next;
			ListNode temp = p1;
			p1.next = null;
		
			
			p1 = reverseNode(head, null);
			p2 = reverseNode(p2, null);
			
			System.out.println("p1" + p1.data);
			head.next = p2;
			ListNode result = reverseNode(p1, null);
			
			return result;
		}
		
		public static boolean isCircularRemoveLoop(ListNode head){
			ListNode slow = head;
			ListNode fast = head;
			
			while(slow!=null && fast!=null && fast.next!=null){
				slow=slow.next;
				fast=fast.next.next;
				
				if(slow==fast){
					removeLoop(slow,head);
					return true;
				}
			}
			return false;
		}
		
		public static ListNode ReverseInBlock(ListNode head,int k){
			if(head==null || head.next==null)
				return head;
			
			ListNode current = head;
			ListNode next = null;
			ListNode prev = null;
			
			
			int count = 0;
			ListNode p1 = head;
			while(count<k && p1!=null){
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
				count++;
			}
			
			if(next!=null)
				current.next = ReverseInBlock(next, k);
			return prev;
		}
		
		public static void removeLoop(ListNode slow,ListNode head){
			int len = 0;
			ListNode p1= slow;
			ListNode p2 = slow;
			
			while(p1!=p2){
				len++;
				p1=p1.next;
			}
			
			p1 = head;
			p2 = head;
			
			for(int i=0;i<len;i++){
				p1=p1.next;
				p2 = p2.next;
			}
			
			while(p2!=p1){
				p1=p1.next;
				p2=p2.next.next;
			}
			
			while(p2.next!=p1)
				p2=p2.next;
			
			p2.next = null;
		}
		
		
		public static void main(String[] args){
			LinkedLists x = new LinkedLists();
			x.insertAtBegin(new ListNode(5));
			x.insertAtBegin(new ListNode(4));
			x.insertAtBegin(new ListNode(3));
			x.insertAtBegin(new ListNode(2));
			x.insertAtBegin(new ListNode(1));
			//x.printList();
			//System.out.println();
			LinkedLists y = new LinkedLists();
			ListNode test1 = new ListNode(6);
			y.insertAtBegin(test1);
			y.insertAtBegin(new ListNode(4));
			y.insertAtBegin(new ListNode(5));
			ListNode test = new ListNode(7);
			y.insertAtBegin(test);
			y.printList();
			System.out.println();
			

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
