import java.util.*;

public class Generator {
	// Developed using http://arxiv.org/abs/1201.0749 ideas.
	private int[][] _base = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
				{4, 5, 6, 7, 8, 9, 1, 2, 3},
				{7, 8, 9, 1, 2, 3, 4, 5, 6},
				{2, 3, 4, 5, 6, 7, 8, 9, 1},
				{5, 6, 7, 8, 9, 1, 2, 3, 4},
				{8, 9, 1, 2, 3, 4, 5, 6, 7},
				{3, 4, 5, 6, 7, 8, 9, 1, 2},
				{6, 7, 8, 9, 1, 2, 3, 4, 5},
				{9, 1, 2, 3, 4, 5, 6, 7, 8}};
	private int[][] _board;
	
	public Generator()
	{
		this._board = this._base;
	}
	
	public int[][] getBase()
	{ return this._base; }
	
	public void setBase(int[][] newBase)
	{ this._base = newBase; }
	
	public int[][] getBoard()
	{
		return this._board;
	}
	
	public void printBoard()
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
				System.out.print(this._board[i][j] + " ");
			System.out.println("");
		}
	}
	
	/* Generate a new sudoku board. */
	public void generate() throws Exception
	{
		Random rand = new Random();
		int numero = rand.nextInt(9), nSwap = rand.nextInt(901)+200;
		
		while(nSwap-- > 0)
		{
			numero = rand.nextInt(9);
			if(numero%3 == 0)
				generalSwap(numero, numero+1, nSwap);
			else if(numero%3 == 1)
				generalSwap(numero, numero+1, nSwap);
			else
				generalSwap(numero, numero-1, nSwap);
		}
	}
	
	/* I created this function just to make the function generate simpler to understand. */
	protected void generalSwap(int index1, int index2, int nSwap)
	{
		if(nSwap%2==0) swap(index1, index2, false);
		else swap(index1, index2, true);
	}
	
	/* Function that swaps the lines (or columns) index1, index2. */
	protected void swap(int index1, int index2, boolean column)
	{
		int[] temp=null;
		if(column)
		{
			temp = new int[9];
			for(int i = 0; i < 9; i++)
				temp[i] = this._board[i][index1];
			for(int i = 0; i < 9; i++)
				this._board[i][index1] = this._board[i][index2];
			for(int i = 0; i < 9; i++)
				this._board[i][index2] = temp[i];
		}
		else
		{
			temp = this._board[index1];
			this._board[index1] = this._board[index2];
			this._board[index2] = temp;
		}
	}

	/* Functions that returns if a column of the board has a certain value. */
	protected boolean columnHasValue(int index, int value) throws Exception
	{
		if(index < 0 || index > 8) throw new Exception("Index out of range.");
		
		for(int i = 0; i < 9; i++)
			if(this._board[i][index]==value) return true;
		return false;
	}
	
	/* Functions that returns if a line of the board has a certain value. */
	protected boolean lineHasValue(int index, int value) throws Exception
	{
		if(index < 0 || index > 8) throw new Exception("Index out of range.");
		
		for(int i = 0; i < 9; i++)
			if(this._board[index][i]==value) return true;
		return false;
	}
}
