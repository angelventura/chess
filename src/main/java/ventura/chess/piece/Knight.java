package ventura.chess.piece;

import ventura.chess.player.Color;

public class Knight extends GamePiece{

	public static final char SAN='N';
	public static final String ABBREVIATION=Character.toString(SAN);
		
	public Knight(Color color) {
		super(color,"Knight",ABBREVIATION);
	}
}
