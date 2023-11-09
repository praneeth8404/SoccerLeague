package soccer;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Game {
	private Team homeTeam;
	private Team awayTeam;
	private Goal[] goals;
	private int homeTeamGoals=0;
	private int awayTeamGoals=0;
	private LocalDateTime theDateTime;
	
	
	public void playGame() {
		ArrayList<Goal> eventList=new ArrayList();
		Goal currentEvent;
		for(int i=0;i<=90;i++) {
			if(Math.random()>0.95) {
//				System.out.println(i);
				currentEvent=new Goal();
				currentEvent.setTheTeam(Math.random()>0.5?homeTeam:awayTeam);
				currentEvent.setThePlayer(currentEvent.getTheTeam().getPlayerArray()[(int) (Math.random()*currentEvent.getTheTeam().getPlayerArray().length)]);
				currentEvent.setTheTime(i);
				eventList.add(currentEvent);
			}
			this.goals=new Goal[eventList.size()];
			eventList.toArray(goals);
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
		for(Goal goal:this.goals) {
			if(goal.getTheTeam()==homeTeam) {
				homeTeamGoals++;
				homeTeam.incGoalsTotal(1);
			}else {
				awayTeamGoals++;
				awayTeam.incGoalsTotal(1);
			}
			
			result.append(goal.getThePlayer().getPlayerName()+" has scored a goal for "+goal.getTheTeam().getTeamName()+" at "+goal.getTheTime()+"\n");
			
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

	public Goal[] getGoals() {
		return goals;
	}
	
	public LocalDateTime getTheDateTime() {
		
		return this.theDateTime;
	}
	
	public void setTheDateTime(LocalDateTime theDateTime) {
		this.theDateTime=theDateTime;
	}
	public void setGoals(Goal[] goals) {
		this.goals = goals;
	}
}
