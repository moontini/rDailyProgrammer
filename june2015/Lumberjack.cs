using System;

class Lumberjack
{
	/*
	 * This is a solution to challenge #217
	 * It essentially asks to read in a file
	 * and add numbers slowly in a double sided
	 * array so that each index evens out 
	 * with each loop.
     *
     * This is my first ever time working with C#, so
	 * I am glade it is a simple problem
    */
	
	public static void Main()
	{
		//I didnt include any error checking, 
		//so hopefully the input file is correct
		Console.WriteLine("Enter Input File");
		string inputFile = Console.ReadLine();
		Console.WriteLine("2");
		string[] lines = System.IO.File.ReadAllLines(inputFile);
		int n = Convert.ToInt32(lines[0]);
		int logs = Convert.ToInt32(lines[1]);
		
		int[,] piles = new int[n,n];
		int min = 2000000000;//lets hope there wont be more than 2 billion logs

		for (int i=0;i<n;i++)
		{
			string[] line = lines[i+2].Split(' ');
			for (int j=0;j<n;j++)
			{
				piles[i,j] = Convert.ToInt32(line[j]);
				if (piles[i,j] < min)
				{
					min = piles[i,j];
				}
			}
		}
		//go through piles and add a log to the min stacks
		while (logs > 0)
		{
			for (int i=0;i<n;i++)
			{
				for (int j=0;j<n;j++)
				{
					if (piles[i,j] == min && logs > 0)
					{
						piles[i,j]++;
						logs--;
					}
				Console.WriteLine("second, i:"+i+" j:"+j+" logs:"+logs);
				}
			}
			min++;

		}
		//print out finished piles
		for (int i=0;i<n;i++)
		{
			for (int j=0;j<n;j++)
			{
				Console.Write(piles[i,j]+" ");
			}
			Console.WriteLine();
		}

	}
}
