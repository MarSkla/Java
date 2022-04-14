class MinMax {
	public static void main(String[] args) {
		int[] myArray = new int[] {1, 6, -8, 17, 10, 99};

		int minValue = myArray[0];
		int maxValue = myArray[0];

		for (int i = 0; i < 6; i++) {
			if (myArray[i] > maxValue) {
				maxValue = myArray[i];
			}
			if (myArray[i] < minValue) {
				minValue = myArray[i];
			}
		}

		System.out.println("Min value: " + minValue);
		System.out.println("Max value: " + maxValue);
	}
}
