using System;

class garland
{
	public static void findGarland(string word)
	{
		int count = 0;
		string start="";
		string end="";
		while (count < word.Length/2)
		{
			start = word.Substring(0,word.Length/2+1-(count));
			end = word.Substring(word.Length/2 + (count));
Console.WriteLine("start:"+start+" end:"+end);
			if (start == end)
			{
				Console.WriteLine(start.Length);
				break;
			}
			count++;
		}
		///printing out chain
		for (int i=0;i<10;i++)
		{
			Console.WriteLine(start+" "+word.Substring(count+1, 1));//word.Length-(count*2)));
		}
	}

	static void Main()
	{
		string word = "onion";
		findGarland(word);
	}
}
