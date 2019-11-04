package ventura.chess.player;

public class GamePlayer extends Player{

	public final Color color;
	
	public GamePlayer(Color color,String name){
		super(name);
		
		this.color=color;
	}
	
}
