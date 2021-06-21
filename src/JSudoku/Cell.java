package JSudoku;

class Cell {
	int value;
	Group row;
	Group column;
	Group grid;
	boolean fixed;
	
	public Cell() {
		value=0;	
		fixed=false;	
	}

	boolean setValue(int value){
		if(row.isDuplicateValueExists(value)||column.isDuplicateValueExists(value)||grid.isDuplicateValueExists(value)){
			return false;
		}
		else{
			this.value=value;
			return true;
		}
	}

	void initialise(int value){
		this.value=value;
	}
	
	int getValue(){
		return(value);
	}
	
	boolean isFixed(){
		return fixed;
	}
	
	void setFixed(boolean fixed){
		this.fixed=fixed;
	}
	
	void assignToRow(Group row){
		this.row=row;
	}
	void assignToColumn(Group column){
		this.column=column;
	}
	void assignToGrid(Group grid){
		this.grid=grid;
	}
}
