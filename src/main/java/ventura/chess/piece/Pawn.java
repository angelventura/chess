package ventura.chess.piece;

import ventura.chess.player.Color;

public class Pawn extends GamePiece{

	public static final String ABBREVIATION="P";
		
	public Pawn(Color color) {
		super(color,"Pawn",ABBREVIATION);
	}
}
