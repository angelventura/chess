package ventura.chess.piece;

import ventura.chess.player.Color;

public class Bishop extends GamePiece{

	public static final String ABBREVIATION="B";
		
	public Bishop(Color color) {
		super(color,"Bishop",ABBREVIATION);
	}
}
