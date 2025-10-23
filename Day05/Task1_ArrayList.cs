using System;
using System.Collections;

class Program
{
    static void Main()
    {
        ArrayList names = new ArrayList();

        Console.WriteLine("Enter 10 names:");
        for (int i = 0; i < 10; i++)
        {
            Console.Write($"Enter name {i + 1}: ");
            names.Add(Console.ReadLine());
        }

        names.Sort();

        Console.WriteLine("\nSorted Names:");
        foreach (string name in names)
        {
            Console.WriteLine(name);
        }
    }
}
