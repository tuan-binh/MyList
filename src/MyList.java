import java.util.Arrays;

public class MyList<E> {
	//1. thuộc tính
	private static final int DEFAULT_CAPACITY = 10;
	private int size = 0;
	private Object[] elements;
	//2. constructor
	
	public MyList() {
		elements = new Object[DEFAULT_CAPACITY];
	}
	
	public MyList(int capacity) {
		elements = new Object[capacity];
	}
	
	//3. các phương thức
	// phương thức chèn phần tử vào vị trí index
	public void add(int index, E o) {
		if (index < 0 || index > size) {
			System.err.println("Đã vượt quá độ dài của mảng");
			return;
		}
		Object[] newElements = new Object[DEFAULT_CAPACITY];
		if (size >= DEFAULT_CAPACITY) {
			newElements = new Object[size + 1];
		}
		// sao chép các phần trước đó
		for (int i = 0; i < newElements.length; i++) {
			if (i < index) {
				newElements[i] = elements[i];
			} else if (i == index) {
				newElements[i] = o;
			} else {
				newElements[i] = elements[i - 1];
			}
		}
		// gán lại mảng mới vào elements
		size++;
		elements = newElements;
	}
	
	public E remove(int index) {
		if (index < 0 || index >= size) {
			System.err.println("Vượt quá độ dài mảng");
			return null;
		}
		E oldElement = get(index);
		Object[] newElements = new Object[size - 1];
		for (int i = 0; i < newElements.length; i++) {
			if (i < index) {
				newElements[i] = elements[i];
			} else {
				newElements[i] = elements[i + 1];
			}
		}
		size--;
		elements = newElements;
		return oldElement;
	}
	
	public int size() {
		return this.size;
	}
	
	// phương thức trả về một mảng mới không liên quan đến mảng cũ
	public Object clone() {
		MyList<E> newElement = new MyList<>();
		for (int i = 0; i < size; i++) {
			newElement.add((E) this.elements[i]);
		}
		return newElement;
	}
	
	// phương thức kiểm tra tồn tại phần tử
	public boolean contains(E o) {
		return indexOf(o) >= 0;
	}
	
	// phương thức trả về index của phần tử
	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (this.elements[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean add(E e) {
		add(size, e);
		return true;
	}
	
	public void ensureCapacity(int minCapacity) {
		elements = new Object[minCapacity];
	}
	
	public E get(int index) {
		if (index < 0 || index > size) {
			System.err.println("vượt quá độ dài mảng");
			return null;
		}
		for (int i = 0; i < size; i++) {
			if (i == index) {
				return (E) elements[i];
			}
		}
		return null;
	}
	
	public void clear() {
		this.size = 0;
		elements = new Object[size];
	}
	
	@Override
	public String toString() {
		// [1, 2, 3, 4]
		StringBuilder result = new StringBuilder("[ ");
		for (int i = 0; i < size; i++) {
			if (i == size - 1) {
				result.append(this.elements[i]);
			} else {
				result.append(this.elements[i] + ", ");
			}
		}
		result.append(" ]");
		return result.toString();
	}
}
