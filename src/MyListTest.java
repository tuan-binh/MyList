import java.util.ArrayList;
import java.util.List;

public class MyListTest {
	public static void main(String[] args) {
//		System.out.println("Hello world!");
//		List<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.add(10,5);
//		System.out.println(list);
		
		MyList<Integer> list = new MyList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list.remove(2));
		System.out.println(list.size());
		System.out.println(list);
	}
}