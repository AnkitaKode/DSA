public class MergeSort {

    public static void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;

            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);

            merge(nums, l, mid, r); // Call merge to merge the sorted halves
        }
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] lnums = new int[n1];
        int[] rnums = new int[n2];

        for (int i = 0; i < n1; i++) {
            lnums[i] = nums[l + i];
        }
        for (int j = 0; j < n2; j++) {
            rnums[j] = nums[mid + 1 + j];
        }

        // Merge the two arrays back into nums[]
        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (lnums[i] <= rnums[j]) {
                nums[k++] = lnums[i++];
            } else {
                nums[k++] = rnums[j++];
            }
        }

        while (i < n1) {
            nums[k++] = lnums[i++];
        }

        while (j < n2) {
            nums[k++] = rnums[j++];
        }
    }

    public static void main(String[] args) {
        int nums[] = { 2, 14, 9, 5, 8, 11, 65, 29 };

        System.out.println("Before Sorting:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        mergeSort(nums, 0, nums.length - 1);

        System.out.println("After Sorting:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
