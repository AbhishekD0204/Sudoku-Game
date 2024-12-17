/********* TESTER *********/

public class Tester
{
	public static void main(String[] args)
	{
		int[][] base = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
						{4, 5, 6, 7, 8, 9, 1, 2, 3},
						{7, 8, 9, 1, 2, 3, 4, 5, 6},
						{2, 3, 4, 5, 6, 7, 8, 9, 1},
						{5, 6, 7, 8, 9, 1, 2, 3, 4},
						{8, 9, 1, 2, 3, 4, 5, 6, 7},
						{3, 4, 5, 6, 7, 8, 9, 1, 2},
						{6, 7, 8, 9, 1, 2, 3, 4, 5},
						{9, 1, 2, 3, 4, 5, 6, 7, 8}};
		Generator g = new Generator();
		
		try {
			Board b = new Board(base);
			for(int i = 0; i < 100000; i++)
			{
				g.generate();
				b.setBoard(g.getBoard());
				if(!b.isSolved()) System.out.println("OHOHOH");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
