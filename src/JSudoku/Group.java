package JSudoku;

class Group {
	Cell cells[]=new Cell[9];

	public Group() {

	}

	void registerCell(Cell cell,int index){
		cells[index]=cell;
	}
	
	boolean isDuplicateValueExists(int value){
		for(int i=0;i<9;i++){
			if(cells[i].getValue()==value)
				return true;
		}
		return false;
	}

	void display(){
		for(int i=0;i<9;i++){
			System.out.print(cells[i].getValue()+" ");
		}	
		System.out.println("\n");
	}
}
