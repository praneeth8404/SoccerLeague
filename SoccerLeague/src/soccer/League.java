package soccer;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.StringTokenizer;

import utility.PlayerDatabase;

public class League {

	public static void main(String[] args) {
		
		Team[] theTeams=createTeam("The Robins,The Crows,The Swallows",3);
		Game[] theGames=createGame(theTeams);
		System.out.println(League.getLeagueAnnouncement(theGames));
		Team currBestTeam = theTeams[0];
		StringBuilder decider=new StringBuilder();
		for(Game currGame:theGames) {
		currGame.playGame();
		System.out.println(currGame.getDescription());
		currBestTeam=currGame.DecideWinner();
		}
		
		
		System.out.println(currBestTeam.getTeamName()+" has won the kurnool League");
		
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
		return "The league lasts for "+thePeriod.getMonths()+" Month(s)  "+thePeriod.getDays()+" Day(s)";
	}

}
 