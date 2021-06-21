package JSudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.InternalFrameAdapter;

public class SudokuFrame extends JInternalFrame implements ActionListener,KeyListener {
	
	JButton cells[][]=new JButton[9][9];
	JButton solve;	
	JButton active;
	JButton clear;
	JButton help;
	HelpFrame hf;
	Color activeCellColor;
	public SudokuFrame() {
		
            setClosable(true);
		for(int i=0;i<9;i++)
		  for(int j=0;j<9;j++){
		    cells[i][j]=new JButton("");
		    cells[i][j].addActionListener(this);
		    cells[i][j].addKeyListener(this);
		    int gridbox=i/3*3 + j/3;
		    if(gridbox%2==0)
			cells[i][j].setBackground(new Color(240,240,220)); 
		    else
			cells[i][j].setBackground(new Color(200,200,200));			
		  }

		hf = new HelpFrame();
		hf.setVisible(false);

		solve=new JButton("SOLVE");
		solve.addActionListener(this);
		solve.setPreferredSize(new Dimension(150,30));
		solve.setHorizontalAlignment(SwingConstants.CENTER);
		solve.setBackground(new Color(200,200,200));

		help=new JButton("HELP");
		help.addActionListener(this);
		help.setPreferredSize(new Dimension(150,30));
		help.setHorizontalAlignment(SwingConstants.CENTER);
		help.setBackground(new Color(200,200,200));

		clear=new JButton("CLEAR");
		clear.addActionListener(this);
		clear.setPreferredSize(new Dimension(150,30));
		clear.setHorizontalAlignment(SwingConstants.CENTER);
		clear.setBackground(new Color(200,200,200));
		
		active=cells[0][0];
		activeCellColor=active.getBackground();
		active.setBackground(new Color(100,100,150));
		addInternalFrameListener(new InternalFrameAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setResizable(false); 

		setTitle("SUDOKU");  
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(520, 500);
		int w = getSize().width;
		int h = getSize().height;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;
		setLocation(x, y);
		
		initialise();
		setVisible(true);
	}

	void initialise(){
		JLabel title=new JLabel("SUDOKU PROBLEM SOLVER",SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 25));
		title.setForeground(new Color(100,100,150));
		

		title.setPreferredSize(new Dimension(200,80));
		BorderLayout main = new BorderLayout();	
		this.setLayout(main);
		
		FlowLayout buttonsLayout = new FlowLayout(FlowLayout.CENTER);	
		Panel buttonsPanel=new Panel();
		buttonsPanel.setLayout(buttonsLayout);
		buttonsPanel.add(solve);
		buttonsPanel.add(clear);
		buttonsPanel.add(help);

		GridLayout sudokugrid = new GridLayout(10,9);	
		Panel gridPanel=new Panel();
		gridPanel.setLayout(sudokugrid);
		for(int i=0;i<9;i++)
		  for(int j=0;j<9;j++){
		    gridPanel.add(cells[i][j]);
		  }
		
		this.add(title,BorderLayout.NORTH);
		this.add(gridPanel,BorderLayout.CENTER);
		this.add(buttonsPanel,BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		JButton cell;
		cell=(JButton)e.getSource();
		if(cell==solve){
			solveSudoku();
			solve.setEnabled(false);
			solve.setBackground(new Color(240,240,240));
		}
		else if(cell==clear){
			clearSudoku();
			solve.setEnabled(true);
			solve.setBackground(new Color(200,200,200));
		}
		else if(cell==help){
			if(hf.isVisible()==false)
				hf.setVisible(true);
			else{
				hf.setVisible(false);
				hf.setVisible(true);
			}	
				
		}
		else{
			active.setBackground(activeCellColor);
			activeCellColor=cell.getBackground();
			cell.setBackground(new Color(100,100,150));
			active=cell;
		}
	}
		
	public void keyTyped(KeyEvent e) {

	}
 
	public void keyPressed(KeyEvent e) {
		char ch=(char)e.getKeyCode();
		if(solve.isEnabled()){
		if(ch>='1' && ch<='9'){
			active.setForeground(new Color(184,134,11));
			active.setText(Character.toString(ch));
		}
		else if (ch=='0')
			active.setText("");
		}
	}
    
	public void keyReleased(KeyEvent e) {
	
	}	
	
	void solveSudoku(){
	   	Sudoku s= new Sudoku();
		int value;
		for(int i=0;i<9;i++)
		  for(int j=0;j<9;j++){
			
			String text=cells[i][j].getText();
			if(text!=""){
				value=Integer.parseInt(text);
				s.setCell(i,j,value);
			}
			
		  }
		s.gotoNextCell();
		s.solveNextCell();
		for(int i=0;i<9;i++)
		  for(int j=0;j<9;j++){
			value=s.getCell(i,j);
			if(s.isFixed(i,j))			
				cells[i][j].setForeground(new Color(184,134,11));
			else
				cells[i][j].setForeground(new Color(0,0,0));
				
			cells[i][j].setText(value+"");
		  }		
	}
	
	void clearSudoku(){
		for(int i=0;i<9;i++)
		  for(int j=0;j<9;j++){
			cells[i][j].setText("");
		  }
	}
}


class HelpFrame extends JFrame{
	HelpFrame(){
		super("Help");
		String msg="<HTML><h4>SUDOKU PROBLEM SOLVER</h4><BR>To enter a value choose any cell by mouse click.<BR>Enter any number (1 to 9) .<BR>0 to delete/clear.<BR>Click SOLVE to solve the sudoku problem you have entered.<BR>Click CLEAR to clear all cells.<BR><BR>* Please enter a valid problem to get result since the program is not  checking for it.</HTML>";

		JLabel help = new JLabel(msg,JLabel.CENTER);
		add(help);
		setResizable(false); 

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(320, 300);
		int w = getSize().width;
		int h = getSize().height;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;
		setLocation(x, y);

		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}
}
