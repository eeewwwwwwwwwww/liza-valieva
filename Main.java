
public class Main
{
	public static void main(String[] args) {
		//экземпляр
		LinkedListContainer<String> container = new LinkedListContainer<>();
		container.add("Element 1");
		container.add("Element 2");
		container.add("Element 3");

		System.out.println("elements in container: ");
		System.out.println(container.get(0)); // Output: Element 1
		System.out.println(container.get(1)); // Output: Element 2
		System.out.println(container.get(2)); // Output: Element 3

		System.out.println("after delete: ");
		container.remove(1);
		System.out.println(container.get(1)); // Output: Element 3

		System.out.println("size of the container: ");
		System.out.println(container.size()); // Output: 2
	}
}

