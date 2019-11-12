package ventura.chess.move;

import ventura.chess.player.Color;

public class QueenSideCastling extends Move {
	public static final String SAN="O-O-O";

	public QueenSideCastling(Color color, boolean check, boolean checkMate){
		super(color,check,checkMate);
	}
}
