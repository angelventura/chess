package ventura.chess.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ventura.chess.board.Board;
import ventura.chess.game.Game;

public class PlayedGame {
	public static final Logger Log = LoggerFactory.getLogger(PGNParser.class);

	public final Map<String, String> properties=new ConcurrentHashMap<>();
	public final List<PlayedMove> moves=new ArrayList<>();
	
	PlayedGame(){
		
	}
	
	public void addProperty(String name, String value) {
		if (StringUtils.isEmpty(name)){
			Log.error("Setting blank property name:'"+name+"', value:'"+value+"'");
		} else {
			properties.put(name, value);
		}
	}

	public void addMove(int index, String whiteMove, String blackMove, String comment) {
		PlayedMove move=new PlayedMove(index,
				StringUtils.trim(whiteMove),
				StringUtils.trim(blackMove),
				StringUtils.trim(comment));
			
		moves.add(move);
		
		if (moves.size() != index){
			Log.warn("While adding move number:"+moves.size()+" do not match the move:"+move);
		} else {
			Log.info("Adding:"+move);
		}
		
	}

	@Override
	public String toString(){
		StringBuilder buff=new StringBuilder();
		// [Event "F/S Return Match"];
		
		properties.forEach((k,v) ->{buff.append('[').append(k).append(" \"").append(v).append("\"]\n") ;});

		buff.append("\n");
		
		moves.forEach(m ->{
			buff.append(m.toString()).append("\n");
		});
		
		return buff.toString();
		
	}

	public Game convert(){
		Game ret=new Game();
		
		Board board = Board.setupInitialBoard();
		
		moves.forEach(m ->{
			m.applyMove(board);	
			
		});
		
		return ret;
	}
	
}
