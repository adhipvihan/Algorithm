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
		
		
		public static void main(String[] args){
			LinkedLists x = new LinkedLists();
			x.insertAtBegin(new ListNode(2));
			x.insertAtBegin(new ListNode(1));
			x.insert(5, 2);
			x.printList();
			System.out.println();
			System.out.println(x.nthFromEnd(2).data);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
