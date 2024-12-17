
public class Main {

	public static void main(String[] args) {
		
		
		Gui userInterface = new Gui();
		userInterface.setSize(300, 300);
		userInterface.setVisible(true);

		Generator g = new Generator();
		try {
			g.generate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		g.printBoard();
		userInterface.setBoard(g.getBoard());
	}

}
