package ventura.chess.move;

import ventura.chess.piece.Piece;
import ventura.chess.player.Color;

public abstract class Move {
	
	public final Color color;
	public final boolean check;
	public final boolean checkMate;

	public Piece capture;

	Move(Color color, boolean check, boolean checkMate){
		this.color=color;
		this.check=check;
		this.checkMate=checkMate;
	}
}
