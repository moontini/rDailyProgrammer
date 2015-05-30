import java.util.Vector;

public class SadCycles
{
	public static void sadC(int n, int p, Vector<Integer> v)
	{
		int sum = 0;
		while (n > 0)
		{
			sum =  sum + (int)Math.pow(n%10, p);
			n = n / 10;
		}
		if (v.contains(sum))
		{
			return;
		}
		else
		{
			v.add(sum);
			sadC(sum, p, v);
			return;
		}
	}

	public static void main(String[] args)
	{
		Vector<Integer> v = new Vector<Integer>();
		sadC(12,2,v);

		for (int i=0;i<v.size();i++)
		{
			System.out.println(v.get(i));
		}
	}
}
