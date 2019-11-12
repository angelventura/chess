package ventura.chess.piece;

import ventura.chess.player.Color;

public class King extends GamePiece{

	public static final char SAN='K';
	public static final String ABBREVIATION=Character.toString(SAN);
		
	public King(Color color) {
		super(color,"King",ABBREVIATION);
	}
}
