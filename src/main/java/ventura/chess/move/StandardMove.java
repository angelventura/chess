package ventura.chess.move;

import javax.swing.text.Position;

import ventura.chess.piece.Piece;
import ventura.chess.player.Color;

public class StandardMove extends Move {
	
	public final Piece piece;

	public final Position i;
	public final Position f;
	
	StandardMove(Color color,Piece piece,Position i,Position f, boolean check, boolean checkMate){
		super(color,check,checkMate);
		
		this.i=i;
		this.f=f;
		this.piece=piece;
		
	}
}
