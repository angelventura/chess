package ventura.chess.piece;

import ventura.chess.player.Color;

public class Queen extends GamePiece{

	public static final String ABBREVIATION="Q";
		
	public Queen(Color color) {
		super(color,"Queen",ABBREVIATION);
	}
}
