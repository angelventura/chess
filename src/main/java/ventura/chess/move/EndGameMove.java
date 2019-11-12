package ventura.chess.move;

import org.apache.commons.lang3.StringUtils;

import ventura.chess.player.Color;

public class EndGameMove /* extends Move*/{
	
	private static final int WHITE_WIN = 0;
	private static final int BLACK_WIN = 1;
	private static final int DRAW = 2;
	
	private static final String SAN_WHITE_WIN = "1-0";
	private static final String SAN_BLACK_WIN = "0-1";
	private static final String SAN_DRAW = "1/2-1/2";
	
	private final int status;
	
	private EndGameMove(int status/*,Color color*/){
		// super(color);
		this.status=status;
	}

	public boolean isWhiteWinner(){
		return (status==WHITE_WIN);
	}
	
	public boolean isBlackWinner(){
		return (status==BLACK_WIN);
	}
	
	public boolean isDraw(){
		return (status==DRAW);
	}
	
	public static EndGameMove winner(Color color){
		if (color.isWhite()){
			return whiteWin();
		} else {
			return blackWin();
		}
	}

	public static EndGameMove whiteWin(){
		return new EndGameMove(WHITE_WIN);
	}

	public static EndGameMove blackWin(){
		return new EndGameMove(BLACK_WIN);
	}

	public static EndGameMove draw(){
		return new EndGameMove(DRAW);
	}

	@Override
	public String toString(){
		if (WHITE_WIN == status){
			return SAN_WHITE_WIN;
		} else if (BLACK_WIN == status){
			return SAN_BLACK_WIN;
		} else if (DRAW == status){
			return SAN_DRAW;
		} else {
			return "N/A";			
		}			
	}
	
	public static EndGameMove getFromSAN(String san,EndGameMove defaultValue){
		if (StringUtils.isBlank(san)){
			return defaultValue;
		} else if (SAN_WHITE_WIN.equals(san)){
			return whiteWin();
		} else if (SAN_BLACK_WIN.equals(san)){
			return blackWin();
		} else if (SAN_DRAW.equals(san)){
			return draw();
		} else {
			return defaultValue;
		}
	}
}
