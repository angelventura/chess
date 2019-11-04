package ventura.chess.piece;

import ventura.chess.player.Color;

public class King extends GamePiece{

	public static final String ABBREVIATION="K";
		
	public King(Color color) {
		super(color,"King",ABBREVIATION);
	}
}
