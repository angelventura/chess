package ventura.chess.board;

import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import ventura.chess.piece.Bishop;
import ventura.chess.piece.GamePiece;
import ventura.chess.piece.King;
import ventura.chess.piece.Knight;
import ventura.chess.piece.Pawn;
import ventura.chess.piece.Queen;
import ventura.chess.piece.Rook;
import ventura.chess.player.Color;

public class Board {

	static public final Board setupInitialBoard(){
		Board board=new Board();
				
		board.addNew(new Pawn(Color.WHITE),new Position(Position.A,2) );
		board.addNew(new Pawn(Color.WHITE),new Position(Position.B,2) );
		board.addNew(new Pawn(Color.WHITE),new Position(Position.C,2) );
		board.addNew(new Pawn(Color.WHITE),new Position(Position.D,2) );
		board.addNew(new Pawn(Color.WHITE),new Position(Position.E,2) );
		board.addNew(new Pawn(Color.WHITE),new Position(Position.F,2) );
		board.addNew(new Pawn(Color.WHITE),new Position(Position.G,2) );
		
		board.addNew(new Rook(Color.WHITE),new Position(Position.A,1) );
		board.addNew(new Knight(Color.WHITE),new Position(Position.B,1) );
		board.addNew(new Bishop(Color.WHITE),new Position(Position.C,1) );
		board.addNew(new Queen(Color.WHITE),new Position(Position.D,1) );
		board.addNew(new King(Color.WHITE),new Position(Position.E,1) );
		board.addNew(new Bishop(Color.WHITE),new Position(Position.F,1) );
		board.addNew(new Rook(Color.WHITE),new Position(Position.G,1) );
		
		
		board.addNew(new Pawn(Color.BLACK),new Position(Position.A,7) );
		board.addNew(new Pawn(Color.BLACK),new Position(Position.B,7) );
		board.addNew(new Pawn(Color.BLACK),new Position(Position.C,7) );
		board.addNew(new Pawn(Color.BLACK),new Position(Position.D,7) );
		board.addNew(new Pawn(Color.BLACK),new Position(Position.E,7) );
		board.addNew(new Pawn(Color.BLACK),new Position(Position.F,7) );
		board.addNew(new Pawn(Color.BLACK),new Position(Position.G,7) );

		board.addNew(new Rook(Color.BLACK),new Position(Position.A,8) );
		board.addNew(new Knight(Color.BLACK),new Position(Position.B,8) );
		board.addNew(new Bishop(Color.BLACK),new Position(Position.C,8) );
		board.addNew(new Queen(Color.BLACK),new Position(Position.D,8) );
		board.addNew(new King(Color.BLACK),new Position(Position.E,8) );
		board.addNew(new Bishop(Color.BLACK),new Position(Position.F,8) );
		board.addNew(new Rook(Color.BLACK),new Position(Position.G,8) );
		
		return board;
	}

	private GamePiece board[]=new GamePiece[8*8];
	private Object playerPieces[]={
			new ArrayListValuedHashMap<String,GamePiece>(16),
			new ArrayListValuedHashMap<String,GamePiece>(16)
	};
	
	private Board(){
		
	}
	
	private ArrayListValuedHashMap<String,GamePiece> get(GamePiece piece) {
		return get(piece.color);
	}
	
	@SuppressWarnings("unchecked")
	private ArrayListValuedHashMap<String,GamePiece> get(Color color) {
		return (ArrayListValuedHashMap<String,GamePiece>)playerPieces[color.index]; 
	}
	
	private void addNew(GamePiece piece, Position pos) {
		board[pos.index]=piece;
		
		get(piece).put(piece.abbreviation, piece);
	}
	
}
