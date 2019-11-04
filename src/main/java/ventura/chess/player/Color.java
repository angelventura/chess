package ventura.chess.player;

public enum Color {
	WHITE(0,"White"),
	BLACK(1,"Black");
	

	public final int index;
	public final String name;
	
	private Color(int index,String name) {
		this.index=index;
		this.name=name;			
	}
	
	public static final Color getFirst(){
		return WHITE;
	}

	public final boolean isWhite(){
		return index==0;
	}

	public final Color getOponent(){
		if (this.index==0){
			return BLACK;
		} else{
			return WHITE;
		}
	}
	
	@Override
	public String toString(){
		return name;		
	}

}
