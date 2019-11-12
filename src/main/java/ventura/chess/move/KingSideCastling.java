package ventura.chess.move;

import ventura.chess.player.Color;

public class KingSideCastling extends Move {
	public static final String SAN="O-O";
	
	public KingSideCastling(Color color, boolean check, boolean checkMate){
		super(color,check,checkMate);
	}
	
}