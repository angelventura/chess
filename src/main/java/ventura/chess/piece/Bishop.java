package ventura.chess.piece;

import ventura.chess.player.Color;

public class Bishop extends GamePiece{

	public static final char SAN='B';
	public static final String ABBREVIATION=Character.toString(SAN);
		
	public Bishop(Color color) {
		super(color,"Bishop",ABBREVIATION);
	}
}
