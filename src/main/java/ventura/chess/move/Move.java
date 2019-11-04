package ventura.chess.move;

import ventura.chess.piece.Piece;
import ventura.chess.player.Color;

public abstract class Move {
	public final Color color;

	public Piece capture;

	Move(Color color){
		this.color=color;
	}
}
