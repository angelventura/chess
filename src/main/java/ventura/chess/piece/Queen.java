package ventura.chess.piece;

import ventura.chess.player.Color;

public class Queen extends GamePiece{

	public static final char SAN='Q';
	public static final String ABBREVIATION=Character.toString(SAN);
		
	public Queen(Color color) {
		super(color,"Queen",ABBREVIATION);
	}
}
