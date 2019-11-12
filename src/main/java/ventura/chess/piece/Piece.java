package ventura.chess.piece;

public class Piece {

	public final String name;
	public final String abbreviation;

	public Piece(String name,String abbreviation){
		this.name=name;
		this.abbreviation=abbreviation;
	}
	

	@Override
	public String toString(){
		return name;		
	}

	
////	K (king), Q (queen), R (rook), B (bishop), and N (knight). The pawn is given an empty abbreviation in SAN movetext, but in other contexts the abbreviation P i
//	public static addPiece(String abbreviation){
//		
//	}
}
