package TurkishLeague;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class TurkishLeagueTest {


	@Test
	public void test1() throws IOException {
		TurkishLeague test=new TurkishLeague();
		Team team= new Team();
		// no parameter constructor reads files automaticly so size is 4
		int size=test.getTeams().size();
		
		
		assertEquals(size,test.getTeams().size());
		
		test.AddTeam(team);
		assertEquals(team,test.getTeams().get(size));
		
		Team team2=new Team();
		test.AddTeam(team2);
		assertEquals(team,test.getTeams().get(size+1));
		
		System.out.println("Enter a team unique name");
		Scanner input = new Scanner(System.in);
		String task=new String();
		
		task=input.next();
		
		if(test.removeTeam(task)==0){
			assertEquals(size+1,test.getTeams().size());
		}
		
		
	
		
	}


	@Test
	public void testPlayGame() throws IOException {
		
		// no parameter constructor reads file automaticly so size is 4
		TurkishLeague test=new TurkishLeague();
		test.gameScheudule2();
		test.playGame();
		// one play is plaYÝNG game for one week so weeks number is 1
		System.out.println(test.getWeek());
		assertEquals(1,test.getWeek());
		
		
	}


	@Test
	public void testGameSchedule() throws IOException {
		// testing add and remove schdule
		TurkishLeague test=new TurkishLeague();
		GameDay newDay=new GameDay();
		test.addSchedule(newDay);
		assertEquals(1,test.getSchedule().size());
		
		test.removeSchedule(newDay);
		assertEquals(0,test.getSchedule().size());
		
		
	}
	
	@Test
	public void testRead() throws IOException {
		
		// okumalar constuctor da otomatik yapildigi icin boþ olmamasi yertlidir
		TurkishLeague test=new TurkishLeague();
		assertNotNull(test.getTeams());
		
		
		
	}


}
