using System;

class Program
{
    static int[] MergeSortedArrays(int[] nums1, int[] nums2)
    {
        int i = 0, j = 0, k = 0;
        int[] result = new int[nums1.Length + nums2.Length];

        while (i < nums1.Length && j < nums2.Length)
        {
            if (nums1[i] <= nums2[j])
                result[k++] = nums1[i++];
            else
                result[k++] = nums2[j++];
        }

        while (i < nums1.Length)
            result[k++] = nums1[i++];

        while (j < nums2.Length)
            result[k++] = nums2[j++];

        return result;
    }

    static void Main()
    {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};

        int[] merged = MergeSortedArrays(nums1, nums2);

        Console.WriteLine("Merged Sorted Array:");
        Console.WriteLine(string.Join(", ", merged));
    }
}
