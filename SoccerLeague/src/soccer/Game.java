package soccer;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Game {
	private Team homeTeam;
	private Team awayTeam;
	private GameEvent[] gameEvents;
	private int homeTeamGoals=0;
	private int awayTeamGoals=0;
	private LocalDateTime theDateTime;
	
	
	public void playGame() {
		ArrayList<GameEvent> eventList=new ArrayList();
		GameEvent currEvent;
		for(int i=0;i<=90;i++) {
			if(Math.random()>0.95) {
//				System.out.println(i);
				currEvent=(Math.random()>0.6)?new Goal():new Possession();
				currEvent.setTheTeam(Math.random()>0.5?homeTeam:awayTeam);
				currEvent.setThePlayer(currEvent.getTheTeam().getPlayerArray()[(int) (Math.random()*currEvent.getTheTeam().getPlayerArray().length)]);
				currEvent.setTheTime(i);
				eventList.add(currEvent);
			}
			this.gameEvents=new GameEvent[eventList.size()];
			eventList.toArray(gameEvents);
		}
	}
	
	public Game(Team homeTeam, Team awayTeam, LocalDateTime theDateTime) {
		
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.theDateTime=theDateTime;
	}

	public String getDescription() {
		
		int homeTeamPoints=0;
		int awayTeamPoints=0;
		StringBuilder result=new StringBuilder();
		result.append(homeTeam.getTeamName()+" Vs "+awayTeam.getTeamName()+"\n"+"Date "+this.theDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE)+"\n");
		for(GameEvent GameEvent:this.gameEvents) {
			if(GameEvent.getTheTeam()==homeTeam) {
				homeTeamGoals++;
				homeTeam.incGoalsTotal(1);
			}else {
				awayTeamGoals++;
				awayTeam.incGoalsTotal(1);
			}
			
			result.append(GameEvent.getThePlayer().getPlayerName()+" has scored a for "+GameEvent+" "+GameEvent.getTheTeam().getTeamName()+" at "+GameEvent.getTheTime()+"\n");
			
		}
		if(homeTeamGoals==awayTeamGoals) {
			homeTeam.incPointsTotal(1);
			awayTeam.incPointsTotal(1);
			result.append("Match Drawn ( "+homeTeamGoals+" - "+awayTeamGoals+" )\n");
		}else if(homeTeamGoals>awayTeamGoals) {
			homeTeam.incPointsTotal(2);
			
			result.append(homeTeam.getTeamName()+" won ( " +homeTeamGoals+" - "+awayTeamGoals+" )\n");
		}else {
			awayTeam.incPointsTotal(2);
			result.append(awayTeam.getTeamName()+" won ( "+homeTeamGoals+" - "+awayTeamGoals+" )\n");
		}
		return result.toString();
		
	}
	
	public Team DecideWinner() {
		Team winner = null;
		
		if(homeTeam.getPointsTotal()>awayTeam.getPointsTotal()) {
			winner=homeTeam;
		}else if(homeTeam.getPointsTotal()<awayTeam.getPointsTotal()){
			winner=awayTeam;
		}else {
			if(homeTeam.getGoalsTotal()>awayTeam.getGoalsTotal()) {
				winner=homeTeam;
			}else {
				winner=awayTeam;
			}
		}
		return winner;		
	}

		
	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public GameEvent[] getEvents() {
		return gameEvents;
	}
	
	public LocalDateTime getTheDateTime() {
		
		return this.theDateTime;
	}
	
	public void setTheDateTime(LocalDateTime theDateTime) {
		this.theDateTime=theDateTime;
	}
	public void setEvents(GameEvent[] gameEvents) {
		this.gameEvents = gameEvents;
	}
}
