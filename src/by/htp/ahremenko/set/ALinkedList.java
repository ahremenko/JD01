package by.htp.ahremenko.set;

import by.htp.ahremenko.set.ATreeSet.Node;

public class ALinkedList<T> {
	private volatile Node<T> first;
	private volatile Node<T> last;
	private volatile int size;
	
	public ALinkedList() {
		size = 0;
	}
	
	public Node<T> getFirst() {
		return first;
	}

	public Node<T> getLast() {
		return last;
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

	public Node<T> addFirst (T newEntity) {
		Node<T> newNode = new Node(newEntity);
		
		if (first == null) {
			this.first = newNode;
			this.last = newNode;
		} else {
			this.first.prev = newNode;
			newNode.next = first;
			this.first = newNode;
		}
		size++;
		return newNode;
	}

	public Node<T> get(Node<T> currentNode, T seekingEntity) {
		Node<T> foundedNode = new Node(seekingEntity);
		
		if (currentNode == null)
			return null;
		if (currentNode.equals(foundedNode))
			return currentNode;
		else 
			return get(currentNode.next, seekingEntity);
	}
	
	public String getAsString (Node<T> currentNode, T seekingEntity) {
		Node findedNode = null;
		findedNode = get(currentNode, seekingEntity); 
		if (findedNode != null ) 
			return findedNode.toStringOneEntity();
		else 
			return "Node not found!";
	}
	
	public Node<T> addAfter (T afterEntity, T newEntity) {
		Node<T> newNode = null;
		Node<T> afterNode = get (first, afterEntity);
		if (afterNode != null && afterNode.next != null) {
				newNode = new Node(newEntity);
				Node<T> tmpNode = afterNode.next;
				newNode.next = afterNode.next;
				newNode.prev = afterNode;
				afterNode.next = newNode;
				tmpNode.prev = newNode;
		} else // if not found or afterNode is Last - insert into the end 
			newNode = addLast(newEntity);
		size++;
		return newNode;
	}
	
	public boolean delete (T deletedEntity) {
		Node<T> deletedNode = get (first, deletedEntity);
		if (deletedNode != null) {
			Node<T> prevNode = deletedNode.prev;
			Node<T> nextNode = deletedNode.next;
			if ( prevNode != null ) {
				prevNode.next = deletedNode.next;
			}
			if (last == deletedNode) last = prevNode;
			if ( nextNode != null ) {
				nextNode.prev = deletedNode.prev;
			}
			if (first == deletedNode) first = nextNode;
			size--;
			return true;
		} else
			return false;
	}

	public String getFirstAndDelete () {
		String ret = ""; 
		if (first != null) {
			ret = this.first.toStringOneEntity();
			if (first.next != null) {
				Node<T> nodeWillBeFirst = first.next;
				nodeWillBeFirst.prev = null;
				this.first = nodeWillBeFirst;
			} else {
				this.first = null;
			}
			size--;
		}
		return ret;
	}
	
	
	public int getSize() {
		return this.size;
	}
	
	public String toString() {
		if (first == null) 
			return "";
		else 
			return first.toString(); 
	}
	
	public class Node<T> {
		public Node<T> next;
		public Node<T> prev;
		private T ent;

		public Node(T k) {
			this.ent = k;
			this.prev = null;
			this.next = null;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(" [" + (ent == null ? "" : ent.toString()) +"] ");
			if (next != null) 
				sb.append(next.toString());
			return sb.toString();
		}

		public String toStringOneEntity() {
			//return (prev == null ? "" : prev.ent.toString()) + "-[" + (ent == null ? "" : ent.toString()) +"]-" + (next == null ? "" : next.ent.toString());
			return ( (ent == null ? "" : ent.toString()) );
		}
		
		@Override
		public int hashCode() {
			final int prime = 73;
			int result = 1;
			result = prime * result + ((this.ent == null) ? 0 : this.ent.hashCode());
			return result;
		}
		
		public boolean equals(Node<T> comparedNode) {
			if (this == comparedNode)
				return true;
			if (comparedNode == null)
				return false;			
			if (getClass() != comparedNode.getClass())
				return false;
			if (!this.ent.equals(comparedNode.ent))
				return false;
			return true;			
		}
	}
	
}
