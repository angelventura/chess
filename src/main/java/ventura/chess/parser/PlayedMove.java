package ventura.chess.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ventura.chess.board.ApplicationException;
import ventura.chess.board.Board;
import ventura.chess.move.EndGameMove;
import ventura.chess.move.KingSideCastling;
import ventura.chess.move.Move;
import ventura.chess.move.QueenSideCastling;
import ventura.chess.piece.GamePiece;
import ventura.chess.player.Color;

public class PlayedMove {

	public static final Logger Log = LoggerFactory.getLogger(PlayedMove.class);

	
	private final int index;
	private final String whiteMove;
	private final String blackMove;
	private final String comment;
		
	private PlayedMove(int index,
					   String whiteMove,
					   String blackMove,
					   String comment) {		
		this.index=index;
		this.whiteMove=whiteMove;
		this.blackMove=blackMove;
		this.comment=comment;		
	}
	
	static public PlayedMove getPlayedMove(int index,
										   String whiteMove,
										   String blackMove,
										   String comment) throws ApplicationException {
		
		PlayedMove ret=new PlayedMove(index, whiteMove, blackMove, comment);

		// Testing
		getMove(index,Color.WHITE,whiteMove,null);
		getMove(index,Color.BLACK,whiteMove,null);
		return ret;
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

	
	public static Move getMove(int index,Color color,String san,Board board) throws ApplicationException{

		// https://en.wikipedia.org/wiki/Algebraic_notation_(chess)
		
		if (StringUtils.isBlank(san)){
			throw new ApplicationException("San code is empty in move:"+index+", color:"+color);
		}
		if (color == null){
			throw new ApplicationException("Color is null on move:"+index+", color:"+color+", san:"+san);
		}


		Matcher m = KING_SIDE_PATTERN.matcher(san);
		if (m.find()){
			String check=m.group(2);
			String checkMate=m.group(3);
			
			return new QueenSideCastling(color,(check!=null),(checkMate!=null));
		}

		m = QUEEN_SIDE_PATTERN.matcher(san);
		if (m.find()){
			String check=m.group(2);
			String checkMate=m.group(3);

			return new KingSideCastling(color,(check!=null),(checkMate!=null));
		}

		
//		if (QueenSideCastling.SAN.equals(san)){
//			return new QueenSideCastling(color);
//		} else if (KingSideCastling.SAN.equals(san)){
//			return new KingSideCastling(color);
//		}
		
//		Move ret=EndGameMove.getFromSAN(san, null);
//		if (ret!=null){
//			return ret;
//		}
		
		char pieceSan=san.charAt(0);
		
		String pieceAbrev=GamePiece.getAbbrevFromSAN(pieceSan,null);
		
		return getStandardMove(index, color, san, board);		
	}

	private static final String QUEEN_SIDE_CASTLING = 
			"^"+
			"(O-O-O)"+
			"(\\+)?"+
			"(#)?"+
			"$";
	private static final Pattern QUEEN_SIDE_PATTERN = Pattern.compile(QUEEN_SIDE_CASTLING);

	private static final String KING_SIDE_CASTLING = 
			"^"+
			"(O-O)"+
			"(\\+)?"+
			"(#)?"+
			"$";
	private static final Pattern KING_SIDE_PATTERN = Pattern.compile(KING_SIDE_CASTLING);

	
	private static final String PROPERTY_PATTERN = 
			"^"+
			"([KQBNR])?"+
			"([abcdefgh])?"+
			"([12345678])?"+
			"(x)?"+
			"([abcdefgh][12345678])"+
			"(=[KQBNRP])?"+
			"(\\+)?"+
			"(#)?"+
			"$";
	
	private static final Pattern PATTERN = Pattern.compile(PROPERTY_PATTERN);

	public static Move getStandardMove(int index,Color color,String move,Board board) throws ApplicationException{
		Matcher m = PATTERN.matcher(move);
		  
	      if (m.find()){
	          // Log.info("IGNORE: " + m.group(0) ); 
	          Log.info("Move:"+move+
					   ", Piece: " + m.group(1) +
					   ", File : " + m.group(2) +
					   ", Rank : " + m.group(3) +
					   ", Capture : " + m.group(4) +
					   ", Final Position : " + m.group(5)+
					   ", Check : " + m.group(6)+
					   ", CheckMate : " + m.group(7) +
					   ", Promotion : " + m.group(8)
					   
					   );// <= white move
	          
	          return null;
	      } else {
	    	  throw new ApplicationException("Unkow move:"+index+", color:"+color+", san:"+move);
	      }			  
	}
	
}
