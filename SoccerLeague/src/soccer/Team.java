package soccer;

public class Team {
	private String teamName;
	private Player[] playerArray;
	private int pointsTotal;
	private int goalsTotal;
	public int getGoalsTotal() {
		return goalsTotal;
	}
	public void setGoalsTotal(int goalsTotal) {
		this.goalsTotal = goalsTotal;
	}
	public int getPointsTotal() {
		return pointsTotal;
	}
	public void setPointsTotal(int pointsTotal) {
		this.pointsTotal = pointsTotal;
	}
	public void incPointsTotal(int pointsTotal) {
		this.pointsTotal+=pointsTotal;
	}
	
	public void incGoalsTotal(int goalsTotal) {
		this.goalsTotal+=goalsTotal;
	}
	public String getTeamName() {
		return teamName;
	}
	public Team(String teamName, Player[] playerArray) {
		super();
		this.teamName = teamName;
		this.playerArray = playerArray;
	}
	
	public Team() {
		
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Player[] getPlayerArray() {
		return playerArray;
	}
	public void setPlayerArray(Player[] playerArray) {
		this.playerArray = playerArray;
	}
}
 