package JSudoku;

class Sudoku{
	Cell cells[][]  =new Cell[9][9];
	Group rows[]    =new Group[9];
	Group columns[] =new Group[9];
	Group grids[]   =new Group[9];

	int rowIndex;
	int columnIndex;
	
	public Sudoku(){
	
		rowIndex=0;
		columnIndex=-1;

		for(int i=0;i<9;i++)
		  for(int j=0;j<9;j++){
		    cells[i][j]=new Cell();	
		  }
	
		for(int i=0;i<9;i++){
		  rows[i]=new Group();
		}

		for(int i=0;i<9;i++){
		  columns[i]=new Group();
		}

		for(int i=0;i<9;i++){
		  grids[i]=new Group();
		}
		
		for(int i=0;i<9;i++)
		  for(int j=0;j<9;j++){
			rows[i].registerCell(cells[i][j],j);
			cells[i][j].assignToRow(rows[i]);			

			columns[i].registerCell(cells[j][i],j);
			cells[i][j].assignToColumn(columns[j]);			

			int gridrow=i/3*3 + j/3;
			int gridcol=i%3*3 + j%3;
			
			grids[i].registerCell(cells[gridrow][gridcol],j);						
			cells[gridrow][gridcol].assignToGrid(grids[i]);
		  }		
	}
	
	void gotoNextCell(){
		do{
			if(rowIndex==8 && columnIndex==8){
				rowIndex=8;
				columnIndex=-1;
				return;
			}
			else if(columnIndex==8){
				rowIndex=rowIndex+1;
				columnIndex=0;
			}else{
				columnIndex=columnIndex+1;
			}
		}while(cells[rowIndex][columnIndex].isFixed()==true);
	}	

	void gotoPreviousCell(){
		do{
			if(rowIndex==0 && columnIndex==0){
				rowIndex=0;
				columnIndex=-1;
				return;
			}
			else if(columnIndex==0){
				rowIndex=rowIndex-1;
				columnIndex=8;
			}else{
				columnIndex=columnIndex-1;
			}
		}while(cells[rowIndex][columnIndex].isFixed()==true);		
	}	
	
	boolean solveNextCell(){

		int value=0;
		boolean solved=false;

		while(solved==false&&value<9){
			value=value+1;
	
			if(cells[rowIndex][columnIndex].setValue(value)==false)
				continue;

			gotoNextCell();	
			if(columnIndex!=-1)			
				solved=solveNextCell();	
			else
				solved=true;
		}
		
		if(solved==false){
			cells[rowIndex][columnIndex].initialise(0);
			gotoPreviousCell();
		}

		return solved;
	}

	void setCell(int i,int j,int value){
		cells[i][j].setValue(value);
		cells[i][j].setFixed(true);
	}
	
	int getCell(int i,int j){
		return(cells[i][j].getValue());
	}	
	
	void display(){
		for(int i=0;i<9;i++){
			rows[i].display();
		}	
	}

	boolean isFixed(int i,int j){
		return cells[i][j].isFixed();
	}
}

