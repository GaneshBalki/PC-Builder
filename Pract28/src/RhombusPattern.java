
public class RhombusPattern {

	public static void main(String[] args) {

		for (int i = 0; i < 7; i++) {
			for (int k = 0; k < i; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 4; j++) {

				System.out.print("* ");
			}
			System.out.println();

		}

	}
}