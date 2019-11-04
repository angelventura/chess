package ventura.chess.parser;

import ventura.chess.board.Board;

public class PlayedMove {

	private final int index;
	private final String whiteMove;
	private final String blackMove;
	private final String comment;
		
	public PlayedMove(int index,
					  String whiteMove,
					  String blackMove,
					  String comment) {
		
		this.index=index;
		this.whiteMove=whiteMove;
		this.blackMove=blackMove;
		this.comment=comment;
		
	}

	@Override
	public String toString(){
		return Integer.toString(index)+". "+whiteMove+' '+blackMove+
				((comment==null)?"":" {"+comment+"}");		
	}

	public void applyMove(Board board) {
		// For the white
		
		// and the black
		
	}

}
