import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.util.Collections;


/**
 * This program is challenge #216 on reddit.com/r/dailyprogrammer
 *
 * @author Richard Moses
*/

public class Texas
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int players = 0;
		Vector<Card> deck = new Vector<Card>();

		System.out.println("How many players (2-8) ?");
		players = in.nextInt();
		while (players < 2 || players > 8)
		{
			System.out.println("you entered an invalid number, 2-8 players only");
			players = in.nextInt();
		}
		Card[][] hands = new Card[players][2];//players are essentially their hands in this
		
		initializeDeck(deck);
		Collections.shuffle(deck);
		
		System.out.println("burn");
		deck.remove(0);

		//give each player their cards;
		for (int i=0;i < players;i++)
		{
			hands[i][0] = deck.get(0);
			deck.remove(0);
			hands[i][1] = deck.get(0);
			deck.remove(0);
		}
		
		Card[] flop = new Card[3];
		for (int i=0;i<3;i++)
		{
			flop[i] = deck.get(0);
			deck.remove(0);
		}
		Card turn = deck.get(0);
		deck.remove(0);
		Card river = deck.get(0);
		deck.remove(0);
		
		System.out.println("flop:"+flop[0].name +", "+flop[1].name+", "+flop[2].name);
		System.out.println("turn:"+turn.name);
		System.out.println("river:"+river.name);
		for (int i=0;i<players;i++)
		{
			System.out.println("\nPlayer "+i+"'s hand:"+hands[i][0].name+", "+hands[i][1].name);
		}
		
	}

	//this function takes an empty Vector of cards, and fills it with 52 cards
	public static void initializeDeck(Vector<Card> deck)
	{
		for (int i=1;i<14;i++)
		{
			deck.add(new Card(i, Suite.CLUBS));
			deck.add(new Card(i, Suite.DIAMONDS));
			deck.add(new Card(i, Suite.SPADES));
			deck.add(new Card(i, Suite.HEARTS));
		}
	}
}
