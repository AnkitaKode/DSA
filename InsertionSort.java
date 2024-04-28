public class InsertionSort {
    public static void main(String[] args) {

        int nums[] = { 2, 14, 9, 5, 8, 99, 11, 65, 29 };
        int size = nums.length;
        int temp = 0;
        System.out.println("Before Sorting:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        for (int i = 1; i < size; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;

            }
            nums[j + 1] = key;
        }

        System.err.println();
        System.out.println("After Sorting:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}
