package ventura.chess.board;

/**
 * The position of one piece in a board.
 * https://en.wikipedia.org/wiki/Algebraic_notation_(chess)
 *
 *
 * Each square of the chessboard is identified by a unique coordinate pair—a
 * letter and a number. The vertical columns of squares, called files, are
 * labeled a through h from White's left (the queenside) to right (the
 * kingside). The horizontal rows of squares, called ranks, are numbered 1 to 8
 * starting from White's side of the board. Thus each square has a unique
 * identification of file letter followed by rank number. (For example, White's
 * king starts the game on square e1; Black's knight on b8 can move to open
 * squares a6 or c6.)
 */
public class Position {

	// FILES
	public static final int A = 1;
	public static final int B = 2;
	public static final int C = 3;
	public static final int D = 4;
	public static final int E = 5;
	public static final int F = 6;
	public static final int G = 7;
	public static final int H = 8;

	public final int file;
	public final int rank;
	public final int index;
	
	public Position(int file, int rank) {
		this.file=file;
		this.rank=rank;
		this.index=(8*this.file)+this.rank;
	}

//	public int index() {
//		return (8*this.file)+this.rank;
//	}

}
