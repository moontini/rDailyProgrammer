using System;

class Code
{
	public static void Main()
	{
		string[] lines = System.IO.File.ReadAllLines("input.txt");
		for (int i=0;i<lines.Length;i++)
		{
		//	char[] arr = StringToAscii(lines[i]);
			char[,] results = decode(StringToAscii(lines[i]));
		}
	}

	static char[,] decode(char[] arr)
	{
		char[,] ret = new char[4,arr.Length];
		for (int i=0;i<arr.Length;i++)
		{
			ret[0,i] = (char)Convert.ToInt32(arr[i] ^ 0x32);//xor the 5th bit for Omicron V
			ret[1,i] = (char)Convert.ToInt32(arr[i] -10); //subtract 10 from the ascii value
			ret[2,i] = (char)Convert.ToInt32(arr[i]+1);
			ret[3,arr.length-i] = (char)Convert.ToInt32(arr[i]); //fill result backwards for Htrae
		}
		return ret;
	}
}
