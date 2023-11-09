

package utility;

import java.util.ArrayList;
import java.util.StringTokenizer;

import soccer.Player;

/**
 *
 * @author Administrator
 */
public class PlayerDatabase {
	String authorList =  
			"Agatha Christie," + 
			"Alan Patton," +
			"Alexander Solzhenitsyn," +
			"Arthur Conan Doyle," +
			"Anthony Trollope," +
			"Baroness Orczy," +          
			"Brendan Behan," +      
			"Brian Moore," +
			"Boris Pasternik," +
			"Charles Dickens," +    
			"Charlotte Bronte," +
			"Dorothy Parker," +
			"Emile Zola," +
			"Frank O'Connor," +        
			"Geoffrey Chaucer," +
			"George Eliot," +
			"G. K. Chesterton," +
			"Graham Green," +
			"Henry James," +
			"James Joyce," +        
			"J. M. Synge," + 
			"J. R. Tolkien," +
			"Jane Austin," +
			"Leo Tolstoy," +
			"Liam O'Flaherty," +
			"Marcel Proust," +
			"Mark Twain," +
			"Oscar Wilde," +
			"O. Henry," +
			"Samuel Beckett," +
			"Sean O'Casey," +
			"William Shakespeare," +        
			"William Makepeace Thackeray," +
			"W. B. Yeats," +
			"Wilkie Collins";
	 private ArrayList <Player> players;
	 
	public PlayerDatabase() {
		StringTokenizer authorTokens=new StringTokenizer(authorList,",");
		players=new ArrayList();
		while(authorTokens.hasMoreTokens()) {
		players.add(new Player(authorTokens.nextToken()));
		}
		
	}
	
	public Player[] playerArray(int numberOfPlayers) {
		Player[] playerList=new Player[numberOfPlayers]; 
		for(int i=0;i<playerList.length;i++) {
			int playerNumber=(int) (Math.random()*players.size());
			playerList[i]=players.get(playerNumber);
			players.remove(playerNumber);
		}
		return playerList;
	}
   
    
    
    /* Practice 11-2. Add Constructor here */
    
    /* Practice 11-2. Add getTeam() method here */
        
}