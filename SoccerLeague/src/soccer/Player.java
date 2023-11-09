package soccer;

public class Player {
	private String playerName;

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
