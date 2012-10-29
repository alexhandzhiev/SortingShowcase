package sort.bubble;


public class BubbleSort {
	public static void main(String[] args) {
		int[] array = new int[5];
		array[0] = 5;
		array[1] = 4;
		array[2] = 3;
		array[3] = 1;
		array[4] = 2;

		System.out.println("Съдържанието на масива преди сортиране:");
		printArray(array);

		bubbleSort(array);

		// Arrays.sort(array);

		System.out.println("Съдържанието на масива след сортиране:");
		printArray(array);
	}

	public static void bubbleSort(int[] array) {
		int temp;
		boolean hasChange = false;

		do {
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;

					hasChange = true;
				} else {
					hasChange = false;
				}
			}
		} while (hasChange);
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("array [" + i + "] = " + array[i]);
		}
	}
}
