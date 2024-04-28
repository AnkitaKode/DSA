public class SelectionSort {

    public static void main(String[] args) {

        int nums[] = { 2, 14, 9, 5, 8, 11, 65, 29 };
        int size = nums.length;
        int temp = 0;
        int minIndex = -1;

        System.out.println("Before Sorting:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        for (int i = 0; i < size - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (nums[minIndex] > nums[j])
                    minIndex = j;
            }
            temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;

        }
        System.err.println();
        System.out.println("After Sorting:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
