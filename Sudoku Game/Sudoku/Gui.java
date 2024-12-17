//Enter file contents hereimport java.awt.GridLayout;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Gui extends JFrame{

    /**
     * 
     */
    private static final long serialVersionUID = 0;
    private JTextField f[][]= new JTextField[9][9];
    private JPanel p[][]= new JPanel [3][3];
    private Board bFull = new Board();
    int flag = 0;

    public Gui(){
        super("Sudoku");
        
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                f[i][j]=new JTextField(1);
            }
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                p[i][j]=new JPanel(new GridLayout(3,3));
            }
        }

        setLayout(new GridLayout(3,3,5,5));
       
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){    
                for(int x = 0; x < 3; x++ ){
                    for(int y = 0; y < 3; y++){

                    	p[i][j].add(f[x+i*3][y+j*3]);

                     	
                     	KeyListener keyP = new CheckBoard();
                     	f[x+i*3][y+j*3].addKeyListener(keyP);

                    }
                }
            add(p[i][j]);
            }
        }
    }
        

    
    
    public void setBoard(int[][] board){
    	Random rad = new Random();
    	for(int i = 0; i < 9; i++){
    		for(int j = 0; j < 9; j++){
    			if(flag!=71){
            		if(rad.nextInt(13)%2 == 1){
                       f[i][j].setText(Integer.toString(board[i][j]));
                       flag++;
                    }	
    			}
        	}
    	}
    	flag = 0;
    }
    
    class CheckBoard implements KeyListener{
    	
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int[][] board = new int[9][9];
				
		        for(int i = 0; i < 9; i++){
		            for(int j = 0; j < 9; j++){
		            	if(f[i][j].getText().equals("")){
		            		 board[i][j] = 0;
		            	}
		            	else{
		            		board[i][j] = Integer.parseInt(f[i][j].getText());
		            	}
		            }
		        }
		        
				bFull.setBoard(board);
				//bFull.printBoard();
				if(bFull.isSolved()){
					System.out.print("Ohh Congratulations!!!");
				}
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

		}  
    
}

