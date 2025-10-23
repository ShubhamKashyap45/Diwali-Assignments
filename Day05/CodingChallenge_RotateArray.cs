using System;

class Program
{
    static void Rotate(int[] nums, int k)
    {
        k %= nums.Length;
        Array.Reverse(nums);
        Array.Reverse(nums, 0, k);
        Array.Reverse(nums, k, nums.Length - k);
    }

    static void Main()
    {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        Rotate(nums, k);

        Console.WriteLine("Rotated Array:");
        Console.WriteLine(string.Join(", ", nums));
    }
}
