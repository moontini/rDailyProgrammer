
/**
 *This class defines a card object, that is compomarble
 *it has a vlue, an emum suite and a name that is generated on creation
*/

public class Card implements Comparable<Card>
{
	int value;
	Suite suite;
	String name;

	public Card(int valueIn, Suite suiteIn)
	{
		value = valueIn;
		suite = suiteIn;
		name = getName();
	}
	
	@Override
	public String toString()
	{
		return name;
	}

	@Override
	public int compareTo(Card o)
	{
		return Integer.compare(this.value,o.value);
	}



	private String getName()
	{
		String v ="";
		String s ="";
		switch (value)
		{
			case 1:
				v = "Ace";
				break;
			case 2:
				v = "Two";
				break;
			case 3:
				v = "Three";
				break;
			case 4:
				v = "Four";
				break;
			case 5:
				v = "Five";
				break;
			case 6:
				v = "Six";
				break;
			case 7:
				v = "Seven";
				break;
			case 8:
				v = "Eight";
				break;
			case 9:
				v = "Nine";
				break;
			case 10:
				v = "Ten";
				break;
			case 11:
				v = "Jack";
				break;
			case 12:
				v = "Queen";
				break;
			case 13:
				v = "King";
				break;
		}
		switch (suite)
		{
			case SPADES:
				s = "Spades";
				break;
			case DIAMONDS:
				s = "Diamonds";
				break;
			case CLUBS:
				s = "Clubs";
				break;
			case HEARTS:
				s = "Hearts";
				break;
		}
		return v+" of "+s;
	}
}
