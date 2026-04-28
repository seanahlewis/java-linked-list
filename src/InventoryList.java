package assignment10;

public class InventoryList {
	
	private Node<Item> head;
	private int size;
	
	public InventoryList() {
		head = null;
		size = 0;
	}
	
	// Add item to end
	public void addItem(Item item) {
		Node<Item> newNode = new Node<>(item, null);
		
		if (head == null) {
			head = newNode;
		} else {
			Node<Item> current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
		
		size++;
	}
	
	// Add item to front
	public void addFirst(Item item) {
		head = new Node<>(item, head);
		size++;
	}
	
	// Remove first item
	public Item removeFirst() {
		if (head == null) 
			return null;
		
		Item removed = head.getItem();
		head = head.getNext();
		size--;
		
		return removed;
	}
	
	// Remove last item
	public Item removeLast() {
		if (head == null) 
			return null;
		
		if (head.getNext() == null) {
			Item removed = head.getItem();
			head = null;
			size--;
			return removed;
		}
		
		Node<Item> current = head;
		while (current.getNext() != null && current.getNext().getNext() != null) {
			current = current.getNext();
		}
		
		Item removed = current.getNext().getItem();
		current.setNext(null);
		size--;
		
		return removed;
	}
	
	// Find item at specific location
	public Item getItem(int index) {
		if (index < 0 || index >= size) 
			return null;
		
		Node<Item> current = head;
		
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		
		return current.getItem();		
	}
	
	// Remove item at specific location
	public Item removeItem(int index) {
		if (index < 0 || index >= size)
			return null;
		
		if (index == 0) {
			return removeFirst();
		}
		
		Node<Item> current = head;
		
		for (int i = 0; i < index -1; i++) {
			current = current.getNext();
		}
		
		Node<Item> nodeToRemove = current.getNext();
		
		if (nodeToRemove == null)
			return null;
		
		Item removed = nodeToRemove.getItem();
		
		current.setNext(nodeToRemove.getNext());
		
		size--;
		return removed;
	}
	
	// Find item by name
	public Item findItem(String name) {
		Node<Item> current = head;
		
		while (current != null) {
			if (current.getItem().getName().equalsIgnoreCase(name)) {
				return current.getItem();
			}
			current = current.getNext();
		}
		
		return null;
	}
	
	// Update qty of item by name
	public boolean updateQuantity(String name, int newQuantity) {
		Item item = findItem(name);
		
		if (item == null)
			return false;
		
		item.setQuantity(newQuantity);
		return true;
		
	}
	
	// Current size of inventory
	public int size() {
		return size;
	}
	
	// Is inventory empty
	public boolean isEmpty() {
		return size == 0;
	}
	
	// Inventory toString
	@Override
	public String toString() {
		String result = "";
		Node<Item> current = head;
		
		while (current != null) {
			result += current.getItem().toString() + "\n";
			current = current.getNext();
		}
		
		return result;		
	}

}
