package ventura.chess.parser;
import java.io.File;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class PGNParserTest extends TestCase{
	
	public static final Logger Log = LoggerFactory.getLogger(PGNParserTest.class);

//	@Test
//	public void testImportSingleGameFile() throws Exception {
//		try {
//			File file=new File("src/test/resources/game.pgn");
//			
//			PlayedGame parseFile = PGNParser.parseSingleGameFile(file);
//
//			Log.info(parseFile.toString());
//			
//		}catch (Exception e) {
//			Log.error("",e);
//			
//			throw e;
//		}
//	}

	@Test
	public void testImportMultipleGameFile() throws Exception {
		try {
			File file=new File("src/test/resources/KingBase2019-A80-A99.pgn");
			
			List<PlayedGame> list = PGNParser.parseMultipleGameFile(file);

			list.forEach(g ->{
				Log.info(g.toString());				
			});
			
		}catch (Exception e) {
			Log.error("",e);
			
			throw e;
		}
	}
	
	

//	@Test
//	public void testRegularExpProp() throws Exception {
//		try {
//			String line="[Event \"F/S Return Match\"]";
//			
//		    String PROPERTY_PATTERN = "^\\[(.+)\"(.+)\"\\]$";
//		    Pattern r = Pattern.compile(PROPERTY_PATTERN);
//
//		      // Now create matcher object.
//		      Matcher m = r.matcher(line);
//		      
//		      if (m.find()){
//		          Log.info("Found value: " + m.group(0) );
//		          Log.info("Found value: " + m.group(1) );
//		          Log.info("Found value: " + m.group(2) );
//		          
//		      } else {
//		          Log.error("Does not match");
//		          TestCase.assertTrue(false);
//		      }
//		    
//			
//		}catch (Exception e) {
//			Log.error("",e);
//			
//			throw e;
//		}
//	}
//	
//	@Test
//	public void testRegularExpMove() throws Exception {
//		try {
//			String line="1. e4 e5 2. Nf3 Nc6 3. Bb5 a6 {This opening is called the Ruy Lopez.}";
//			// String line="3. Bb5 a6 {This opening is called the Ruy Lopez.}";
//			
////			(\\d+)\\.\\s(\\w+[1-8])
//		    //String PROPERTY_PATTERN = "(\\d+)\\.\\s(\\w[1-8])\\s([\\w][1-8])(\\s{(.*)})*";
//			String PROPERTY_PATTERN = "(\\d+)\\.\\s(\\w+[1-8])(\\s\\w+[1-8])\\s(\\{(.*)\\})?";
//		    Pattern r = Pattern.compile(PROPERTY_PATTERN);
//
//		      // Now create matcher object.
//		      Matcher m = r.matcher(line);
//		  
//		      while (m.find()){
//		          Log.info("IGNORE: " + m.group(0) ); 
//		          Log.info("Index: " + m.group(1) );// <= number
//		          Log.info("White : " + m.group(2) );// <= white move
//		          Log.info("Black: " + m.group(3) );// <= black move
//		          Log.info("IGNORE: " + m.group(4) );// <= IGNORE
//		          Log.info("Comment: " + m.group(5) );// <= Comment
//		      }
//		      
////		      if (m.find()){
////		          Log.info("Found value: " + m.group(0) ); 
////		          Log.info("Found value: " + m.group(1) );// <= number
////		          Log.info("Found value: " + m.group(2) );// <= white move
////		          Log.info("Found value: " + m.group(3) );// <= black move
////		          Log.info("Found value: " + m.group(4) );// <= IGNORE
////		          Log.info("Found value: " + m.group(5) );// <= Comment
////		          
////		      } else {
////		          Log.error("Does not match");
////		          TestCase.assertTrue(false);
////		      }
//		    
//			
//		}catch (Exception e) {
//			Log.error("",e);
//			
//			throw e;
//		}
//	}

	
//	@Test
//	public void testSANMove() throws Exception {
//		try {
//			String moves[]={"e4","Nf3","Nxe4","fxe4","Qg8+","Rg1+","Qff3#"};
//
//			
//			String PROPERTY_PATTERN = "^([KQBNR])?([abcdefgh])?([12345678])?(x)?([abcdefgh][12345678])(\\+)?(#)?$";
//		    Pattern r = Pattern.compile(PROPERTY_PATTERN);
//
//		    for (String move:moves){
//		      // Now create matcher object.
//		      Matcher m = r.matcher(move);
//		  
//		      if (m.find()){
//		          // Log.info("IGNORE: " + m.group(0) ); 
//		          Log.info("Move:"+move+
//						   ", Piece: " + m.group(1) +
//						   ", File : " + m.group(2) +
//						   ", Rank : " + m.group(3) +
//						   ", Capture : " + m.group(4) +
//						   ", Final Position : " + m.group(5)+
//						   ", Check : " + m.group(6)+
//						   ", CheckMate : " + m.group(7)
//						   );// <= white move
//				  
//				  
////		          Log.info("Black: " + m.group(3) );// <= black move
////		          Log.info("IGNORE: " + m.group(4) );// <= IGNORE
////		          Log.info("Comment: " + m.group(5) );// <= Comment
//		      } else {
//		    	  Log.error("FAILS:"+move);
//		      }
//		      
//		    }			
//		}catch (Exception e) {
//			Log.error("",e);
//			
//			throw e;
//		}
//	}
	
	
}
