import java.util.*;

public class probb {

	// Directions for toggles.
	final public static int[] Dx = {0,-1,0,0,1};
	final public static int[] Dy = {0,0,-1,1,0};

	// Dimensions for problem.
	final public static int Rows = 3;
	final public static int Columns = 3;

	public static void main(String[] args) {

		// Pre-process each solution - based on input directions, this is a one-to-one mapping,
		// no need to run Breadth-first search.
		int[] sol = new int[1<<(Rows*Columns)];
		for (int i=0; i<(1<<(Rows*Columns)); i++)
			sol[state(i)] = Integer.bitCount(i);

		// Process each case.
		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();
		for (int loop=0; loop<numCases; loop++) {

			// Read in grid.
			String s = stdin.next();
			for (int i=0; i<Rows-1; i++)
				s = s + stdin.next();

			// Output solution after conversion to bit mask 
			System.out.println(sol[convert(s)]);
		}
	}

	// Returns binary value of s.
	public static int convert(String s) {

		int val = 0;

		// Go through each bit.
		for (int i=0; i<s.length(); i++) {

			// This always happens.
			val = (val << 1);

			// Just for bits that are on.
			if (s.charAt(i) == '*')
				val += 1;
		}

		return val;
	}

	public static int state(int bits) {

		int cur = 0;

		// Go through each bit that's on and flip each corresponding spot.
		for (int i=0; (1<<i)<=bits; i++)
			if ((bits & (1<<i)) != 0)
				cur = cur ^ flip(i);
		return cur;
	}

	public static int flip(int bit) {

		// Find bit.
		int myrows = bit/Columns;
		int mycolumns = bit%Columns;

		int res = 0;

		// Go through each spot, and add in mask for each one that's inbounds.
		for (int i=0; i<Dx.length; i++)
			if (inbounds(myrows+Dx[i], mycolumns+Dy[i]))
				res += (1 << (Columns*(myrows+Dx[i]) + mycolumns+Dy[i]));

		return res;
	}

	public static boolean inbounds(int myrows, int mycolumns) {
		return myrows >= 0 && myrows < Rows && mycolumns >= 0 && mycolumns < Columns;
	}
}