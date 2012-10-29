package sort.bubble;


public class BubbleSort {
	public static void main(String[] args) {
		int[] array = new int[7];
		array[0] = 5;
		array[1] = 17;
		array[2] = 3;
		array[3] = 1;
		array[4] = 2;
		array[5] = 66;
		array[6] = 45;

		System.out.println("Съдържанието на масива преди сортиране:");
		printArray(array);

		bubbleSort(array);

		System.out.println("Съдържанието на масива след сортиране:");
		printArray(array);
	}

	public static void bubbleSort(int[] array) {
		int temp;
		boolean hasChange = false;
		do {
			hasChange = false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					hasChange = true;
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
