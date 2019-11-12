package ventura.chess.piece;

import ventura.chess.player.Color;

public class GamePiece extends Piece {

	public final Color color;
	
	public GamePiece(Color color,String name,String abbreviation){
		super(name,abbreviation);
		
		this.color=color;
	}
	
	@Override
	public String toString(){
		return color.toString()+' '+name;		
	}


	public static String getAbbrevFromSAN(char pieceSan,String defaultValue) {
		switch (pieceSan) {
		case King.SAN:
			return King.ABBREVIATION;
//			break;
		case Queen.SAN:
			return Queen.ABBREVIATION;
//			break;
		case Bishop.SAN:
			return Bishop.ABBREVIATION;
//			break;
		case Knight.SAN:
			return Knight.ABBREVIATION;
//			break;
		case Rook.SAN:
			return Rook.ABBREVIATION;
//			break;
		default:
			return defaultValue;
//			break;
		}
		
	}
}
