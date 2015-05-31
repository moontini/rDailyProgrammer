import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *This is the soluton to challange #216 on reddit.com/r/dailyprogrammer
 * 
 */


public class Networks
{
	public static void compare(int i, int j, int[] wires)
	{
		//check if the element at the first index 
		if (wires[i] > wires[j])
		{
			//i should be less than j, but just incase.
			if (i <= j)
			{
				int temp = wires[i];
				wires[i] = wires[j];
				wires[j] = temp;
			}
		}
	}
	
	public static void incrementBits(int[] bits)
	{
		boolean carry = true;
		int i = 0;
		while (carry == true && i<bits.length)
		{
			if (bits[i] == 0)
			{
				bits[i] = 1;
				carry = false;
			}
			else
			{
				bits[i] = 0;
			}
			i++;
		}

		for (i=bits.length-1;i >= 0;i--)
		{
			System.out.print(bits[i]);
		}
		System.out.println();
	}


	public static void main(String[] args)
	{
		Scanner scanner;
		int[] wires;

		//read in the network file
		try 
		{
			scanner = new Scanner(new File("test.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.err.println("File Not Found");
			return;
		}
		
		//read in network info
		String line = scanner.nextLine();
		String[] nums = line.split("[ ]+");
		int numOfWires = Integer.parseInt(nums[0]);
		int numOfComparitors = Integer.parseInt(nums[1]);
	
		//define amount of wires and comparitors
		wires = new int[numOfWires];
		int[][] compares = new int[numOfComparitors][2];

		for (int i=0;i<numOfComparitors;i++)
		{
			line = scanner.nextLine();
			nums = line.split("[ ]+");
			compares[i][0] = Integer.parseInt(nums[0]);
			compares[i][1] = Integer.parseInt(nums[1]);
		}

		//test the network
		int[] bits = new int[numOfWires];
		for (int i=0;i<numOfWires;i++)
		{
			bits[i] = 0;
		}
		
		int count=0;
		boolean valid = true;
		while (count < Math.pow(2,numOfWires) && valid)
		{
			for (int i=0;i<wires.length;i++)
			{
				wires[i] = bits[i];
			}
			for (int i=0;i<numOfComparitors;i++)
			{
				compare(compares[i][0], compares[i][1], wires);
			}
			//check if the input is not sorted
			for (int i=1;i<wires.length;i++)
			{
				if (wires[i-1] > wires[i])
				{
					valid = false;
				}
			}

			incrementBits(bits);
			count++;
		}
		if (valid)
		{
			System.out.println("This Network is valid");
		}
		else
		{
			System.out.println("invalid!");
		}
	}
}
