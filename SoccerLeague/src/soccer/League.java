package soccer;
	
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import utility.PlayerDatabase;

public class League {

	public static void main(String[] args) {
		
		Team[] theTeams=createTeam("The Robins,The Crows,The Swallows",3);
		Game[] theGames=createGame(theTeams);
		System.out.println(League.getLeagueAnnouncement(theGames));
	
		StringBuilder decider=new StringBuilder();
		for(Game currGame:theGames) {
		currGame.playGame();
		System.out.println(currGame.getDescription());
		
		}
		Arrays.sort(theTeams);
		for(Team currTeam:theTeams) {
			System.out.println(currTeam.getTeamName()+":"+currTeam.getPointsTotal()+":"+currTeam.getGoalsTotal());
		}
		
		Team currBestTeam=League.DecideWinner(theTeams);
		League.showBestPlayers(theTeams);
		System.out.println(currBestTeam.getTeamName()+"  has won the kurnool League marvellously");
		
	}
	
	public static void showBestPlayers(Team[] teams) {
		ArrayList<Player> thePlayers=new ArrayList();
		Player player=new Player();
		for(Team team:teams) {
		thePlayers.addAll(Arrays.asList(team.getPlayerArray()));	
		}
		Collections.sort(thePlayers);
//		for(Player currPlayer:thePlayers) {
//			System.out.println(currPlayer.getPlayerName()+":"+currPlayer.getGoalsScored());
//		}

		System.out.println("Player of the Tournament : "+thePlayers.get(0).getPlayerName());
	}
	
	public static Team[] createTeam(String teamNames,int teamSize) {
		StringTokenizer teamTokens=new StringTokenizer(teamNames,",");
		Team[] theTeams=new Team[teamTokens.countTokens()];
		PlayerDatabase playerDB=new PlayerDatabase();
		
		for(int i=0;i<theTeams.length;i++) {
			theTeams[i]=new Team(teamTokens.nextToken(),playerDB.playerArray(teamSize));
		}
		
		return theTeams;
	}
	public static Game[] createGame(Team[] team) {
		ArrayList<Game> games=new ArrayList();
		int daysInBetween=0;
		for(Team homeTeam:team) {
			for(Team awayTeam:team) {
				if(homeTeam!=awayTeam) {
				 	daysInBetween+=3;
					games.add(new Game(homeTeam,awayTeam,LocalDateTime.now().plusDays(daysInBetween)));
				}
			}
		}
		return (Game[]) games.toArray(new Game[1]); 
	}
	
	public static String getLeagueAnnouncement(Game[] game) {
		Period thePeriod=Period.between(game[0].getTheDateTime().toLocalDate(), game[game.length-1].getTheDateTime().toLocalDate());
		return "The league lasts for "+thePeriod.getMonths()+" Month(s)  "+thePeriod.getDays()+" Day(s)\n";
	}
	
	public static Team DecideWinner(Team teams[]) {
		
		Team winner = teams[0];	
//		for(Team team:teams ) {
//			winner=team.getPointsTotal()>winner.getPointsTotal()?team:winner;
//		}
		return winner;		
	}

}
 