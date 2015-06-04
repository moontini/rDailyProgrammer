using System;

class Code
{
	public static void Main()
	{
		string[] lines = System.IO.File.ReadAllLines("input.txt");
		for (int i=0;i<lines.Length;i++)
		{
			char[] arr = StringToAscii(lines[i]);
			if (checkOmicronV(arr))
			{
				
			}
		}
	}

	static char[] StringToAscii(string line)
	{
		string[] nums = line.Split(' ');
		char[] charArr = new char[nums.Length];
		for (int i=0;i<nums.Length;i++)
		{
			charArr[i] = (char)Convert.ToInt32(nums[i]);
		}
		return charArr;
	}

	static boolean CheckOmicronV(arr)
	{
		
	}
}
