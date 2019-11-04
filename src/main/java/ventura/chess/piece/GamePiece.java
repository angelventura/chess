package ventura.chess.piece;

import ventura.chess.player.Color;

public class GamePiece extends Piece {

	public final Color color;
	
	public GamePiece(Color color,String name,String abbreviation){
		super(name,abbreviation);
		
		this.color=color;
	}
	
	@Override
	public String toString(){
		return color.toString()+' '+name;		
	}

}
