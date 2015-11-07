package TurkishLeague;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class TeamTest {

	@Test
	public void testAddPlayer() {
		Team t=new Team();
		Person p= new Person();
		t.addPlayer(p);
		assertEquals(1,t.getPlayers().size());
		
	}

	@Test
	public void testRemove() {
		Team t=new Team();
		Person p= new Person();
		t.addPlayer(p);
		System.out.println("Enter a player unique tc for remove");
		Scanner input = new Scanner(System.in);
		String task=new String();
		
		task=input.next();
		
		if(t.removePlayer(task)==0){
			System.out.println("Successufly removing");
			assertEquals(0,t.getPlayers().size());
		}
			
	}



}
