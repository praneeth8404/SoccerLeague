package soccer;

public class Player implements Comparable {
	private String playerName;
	private int goalsScored;
	
	public int compareTo(Object Player) {
		int returnVal=-1;
		if(this.getGoalsScored()<((Player)Player).getGoalsScored()) {
			returnVal=1;
		}else if(this.getGoalsScored()==((Player)Player).getGoalsScored()) {
			returnVal=1;
		}
		return returnVal;
	}
	public void incGoalsScored() {
		this.goalsScored++;
	}

	public int getGoalsScored() {
		return goalsScored;
	}

	public void setGoalsScored(int goalsScored) {
		this.goalsScored = goalsScored;
	}

	public String getPlayerName() {
		return playerName;
	}

	public Player(String playerName) {
		super();
		this.playerName = playerName;
	}
	
	public Player() {
		
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
}
