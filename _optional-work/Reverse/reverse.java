import java.util.*;

class Reverse {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Provide your string: ");
		String myString = scan.nextLine();

		//String myString = "String2t3st";

		char[] array = myString.toCharArray();

		System.out.print("Reversed string: ");
		for (int i = array.length -1; i >= 0;  i--) {
			System.out.print(array[i]);
		}
		System.out.println();
	}
}
