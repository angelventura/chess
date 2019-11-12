package ventura.chess.piece;

import ventura.chess.player.Color;

public class Rook extends GamePiece{

	public static final char SAN='R';
	public static final String ABBREVIATION=Character.toString(SAN);
		
	public Rook(Color color) {
		super(color,"Rook",ABBREVIATION);
	}
}
