package ventura.chess.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ventura.chess.board.ApplicationException;
import ventura.chess.move.EndGameMove;

public class PGNParser {
	public static final Logger Log = LoggerFactory.getLogger(PGNParser.class);
	

	public static List<PlayedGame> parseMultipleGameFile(File file) throws ApplicationException {
		if (file == null) {
			throw new ApplicationException("Passed file is null");
		} else {
			String fileName=file.getAbsolutePath();
			
			if (file.isDirectory()){
				throw new ApplicationException("Passed file: '"+fileName+"' is a directory");				
			} else if (!file.canRead()){
				throw new ApplicationException("Can NOT read passed file: '"+fileName+"'");				
			}
			
			try {
				Scanner scanner = new Scanner(file);
				List <PlayedGame> ret=new ArrayList<PlayedGame>();
				try {
					PlayedGame currentGame=new PlayedGame();
					
					StringBuilder movesLines=new StringBuilder();
					boolean readingHeader=true;
					
					while (scanner.hasNextLine()) {
						String line=scanner.nextLine();
		
						if (StringUtils.isNotBlank(line)){
							String trimLine=StringUtils.trim(line);
							
							if (trimLine.startsWith("[")){
								if (readingHeader) {
									readProperty(currentGame,trimLine);
								} else {
									readMoves(currentGame,movesLines.toString());
									movesLines.setLength(0);
									ret.add(currentGame);
									
									Log.info(currentGame.toString());				

									currentGame=new PlayedGame();
									readingHeader=true;
								}
							} else {			
								readingHeader=false;
//								scanner.useDelimiter("\\Z");
//								String next = scanner.next();
//								readMoves(ret,trimLine+' '+next);

								movesLines.append(' ').append(line);
							}
							
							
						}
					}

					// reads the last part...
					readMoves(currentGame,movesLines.toString());
					ret.add(currentGame);
					
					return ret;
				}finally {
					scanner.close();
				}
			}catch (FileNotFoundException e) {
				throw new ApplicationException("reading file: "+fileName,e);
			}
		}
		
	}
	
	public static PlayedGame parseSingleGameFile(File file) throws ApplicationException{
		if (file == null) {
			throw new ApplicationException("Passed file is null");
		} else {
			String fileName=file.getAbsolutePath();
			
			if (file.isDirectory()){
				throw new ApplicationException("Passed file: '"+fileName+"' is a directory");				
			} else if (!file.canRead()){
				throw new ApplicationException("Can NOT read passed file: '"+fileName+"'");				
			}
			
			try {
				Scanner scanner = new Scanner(file);
				try {
					PlayedGame ret=new PlayedGame();

//					do {
//						
//						if(scanner.hasNext(PROPERTY_PATTERN)){
//							String line=scanner.next(PROPERTY_PATTERN);
//							readProperty(ret,line);
//						}
//						
//						if(scanner.hasNext(MOVE_PATTERN)){
//							String line=scanner.next(MOVE_PATTERN);
//							readMoves(ret,line);
//						}	
//						
//						
//						if(scanner.hasNext()){
//							String token=scanner.next();
//							Log.info("Ignored Text:"+token);
//							
//							break;
//						}
//						
//					} while (true);
					
//					while(scanner.hasNext(PROPERTY_PATTERN)){
//						String line=scanner.next();
//						readProperty(ret,line);
//					}
//					
//					while(scanner.hasNext(MOVE_PATTERN)){
//						String line=scanner.next();
//						readMoves(ret,line);
//					}
					
//					boolean parsingMoves=false;
					
					while (scanner.hasNextLine()) {
						String line=scanner.nextLine();
		
						if (StringUtils.isNotBlank(line)){
							String trimLine=StringUtils.trim(line);
							
							if (trimLine.startsWith("[")){
								readProperty(ret,trimLine);
							} else {								
								scanner.useDelimiter("\\Z");
								String next = scanner.next();
								readMoves(ret,trimLine+' '+next);

							}
						}
					}
					
					return ret;
				}finally {
					scanner.close();
				}
			}catch (FileNotFoundException e) {
				throw new ApplicationException("reading file: "+fileName,e);
			}
		}
		
	}

	

	// private static final String MOVE_REGEX = "(\\d+)\\.\\s(\\w+[1-8])(\\s\\w+[1-8])\\s(\\{(.*)\\})?";
	// there are some spetial moves like O-O, 1/2-1/2, O-O-O, etc ...
	private static final String MOVE_REGEX = "(\\d+)\\.\\s?(\\S+)(\\s+\\S+)(\\s+\\{(.*)\\})?(\\s)?";
	private static final Pattern MOVE_PATTERN = Pattern.compile(MOVE_REGEX);

	private static void readMoves(PlayedGame ret, String line) throws ApplicationException {
		// Now create matcher object.
		Matcher m = MOVE_PATTERN.matcher(line);

		int lastPosition=0;

		while (m.find()) {
			lastPosition=m.end();


			try {
				String strnum=m.group(1);// <= number

				int index=Integer.parseInt(strnum);
				
				String whiteMove=m.group(2);// <= white move
				String blackMove=m.group(3);// <= black move
			
				String comment=m.group(5);// <= Comment
				
				ret.addMove(index,whiteMove,blackMove,comment);

			}catch(Exception e){
				throw new ApplicationException("While reading line:'"+line+"'",e);
			}
			
			// Log.info("IGNORE: " + m.group(0));
			// Log.info("Index: " + m.group(1));// <= number
			// Log.info("White : " + m.group(2));// <= white move
			// Log.info("Black: " + m.group(3));// <= black move
			// Log.info("IGNORE: " + m.group(4));// <= IGNORE
			// Log.info("Comment: " + m.group(5));// <= Comment
	    }
		
//		int index=m.end();
		
		if (lastPosition<line.length()) {
			String sanEndMove=line.substring(lastPosition, line.length());
			
			// http://tutorials.jenkov.com/java-regex/matcher.html#find-start-end-methods
			// ESTE ES EL FINAL 1-0 0-1 1/2-1/2 PONERLO
			// Log.info(endS);
			
			EndGameMove endMove = EndGameMove.getFromSAN(sanEndMove, null);
			ret.setEnd(endMove);
			
		}
//		read the end 1-0 0-1 etc ..line.
//		Log.info("End:"+m.hitEnd());
//		m.
//		
//		String lst=m.group();
//		Log.info(lst);
		
	}
	
//	private static final String PROPERTY_REGEX = "^\\[(.+)\"(.+)\"\\]$";
	private static final String PROPERTY_REGEX = "^\\[(.+)\\s\"(.+)\"\\]$";
	private static final Pattern PROPERTY_PATTERN = Pattern.compile(PROPERTY_REGEX);

	private static void readProperty(PlayedGame playedGame, String line) {
		
		// Now create matcher object.
		Matcher m = PROPERTY_PATTERN.matcher(line);
		      
		if (m.find()){
			String name=m.group(1);
			String value=m.group(2);
			
			playedGame.addProperty(name,value);
		    
		} else {
			Log.error("Line does not math a property: '"+line+"'");
		}

		
	}

	
	
}
