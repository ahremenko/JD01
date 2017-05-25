package by.htp.ahremenko.set;

public class ALinkedList<T> {
	public Node<T> first;
	public Node<T> last;
	private int size;
	
	public ALinkedList() {
		size = 0;
	}
	
	public Node<T> addLast (T newEntity) {
		Node<T> newNode = new Node(newEntity);
		
		if (first == null) {
			this.first = newNode;
			this.last = newNode;
		} else {
			this.last.next = newNode;
			newNode.prev = last;
			this.last = newNode;
		}
		size++;
		return newNode;
	}
			
	public int getSize() {
		return this.size;
	}
	
	public String toString() {
		if (first == null) {
			return "";
		} else {
			return first.toShortString(); // + first.next.toShortString();
		}
		
	}
	
	class Node<T> {
		public Node<T> next;
		public Node<T> prev;
		private T ent;

		public Node(T k) {
			this.ent = k;
			this.prev = null;
			this.next = null;
		}
		
		public String toString() {
			if (ent != null) {
			   return " { prev: " + (this.prev==null ? "" : prev.toShortString()) + " [" + ent.toString() +"] " + "Next: " + (this.next == null ? "" : next.toShortString()) + " } ";
			} else {
   			   return "";
			}
		}
		
		public String toShortString() {
			StringBuilder sb = new StringBuilder();
			sb.append(" [" + (this.ent == null ? "" : ent.toString()) +"] ");
			if (next != null) {
				sb.append(next.toShortString());
			}
			return sb.toString();
		}
		
	}
	
}
