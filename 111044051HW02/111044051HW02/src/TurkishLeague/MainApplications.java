package TurkishLeague;

import java.io.IOException;
import java.util.Scanner;

public class MainApplications {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Team deneme=new Team();
		deneme.readData("galatasaray.txt");
		//System.out.println(deneme.getPlayers().get(4).getName());
		//deneme.saveData("a.txt");
		
		TurkishLeague trk= new TurkishLeague();
		
		trk.gameScheudule2();
		//trk.playGame();
		//trk.saveSchedule();
		//trk.saveScoreTables();
		
		Scanner input = new Scanner(System.in);
		String task=new String();
		while(!task.equals("Exit") && trk.getWeek()!=trk.getSchedule().size())
		{
			System.out.println(
					"**************************************************************\n"
					+"         ********************************\n"
					+"                  ************\n"
					+"           Takým eklemek icin addTeam \n"
					+ "          Takým cýkarmak icin removeTeam\n"
					+ "          Oynamak icin play\n"
					+ "          Cýkmak icin exit\n"
					+ "          Oyuncu eklemek icin addplayer\n"
					+ "          Oyuncu cýkarmak icin removePlayer\n"
					+ "          Oyunu kaydetmek icin saveGame\n"
					+ "          Giriniz\n");
			task=input.next();
			// add team
			if(task.equals("addTeam")){
				System.out.println("Bir takim eklemek icin takim bilgilerinin oldugu dosya adini giriniz");
				task=input.next();
				Team newTeam=new Team();
				newTeam.readData(task);
				trk.AddTeam(newTeam);
			}
			//  remove a team
			if(task.equals("removeTeam")){
				System.out.println("Bir takim cýkarmak icin takim ismini giriniz");
				task=input.next();
				trk.removeTeam(task);
			}
			// playing game for one week
			if(task.equals("play"))
			{
				System.out.println(trk.playGame());
			}
			// add a player with entering all informations choice team
			if(task.equals("addPlayer"))
			{
				System.out.println("Eklemek istediginiz takimi seciniz");
				for(int i=0;i<trk.getTeams().size();i++)
				{
					System.out.println(trk.getTeams().get(i).getTeamName());
				}
				String choiceTeam=new String();
				choiceTeam=input.next();
				System.out.println("Eklemek istediginiz oyuncu bilgilerini sýrasýyla enter a basip giriniz\n"
						+ "ahmet 11111111 13.12.1990 Turkiye gibi girniz");
				Person p=new Person();
				String choiceInform=new String();
				choiceInform=input.next();
				p.setName(choiceInform);
				choiceInform=input.next();
				p.setTcNum(choiceInform);
				choiceInform=input.next();
				p.setBirthDate(choiceInform);
				choiceInform=input.next();
				p.setAddress(choiceInform);
				System.out.println("girmiþ oldugnuz bilgiler icin tesekkürler");
				for(int i=0;i<trk.getTeams().size();i++)
				{
					if(trk.getTeams().get(i).getTeamName().equals(choiceTeam))
						trk.getTeams().get(i).addPlayer(p);
				}
			}
			// remove a player who is choice a team
			if(task.equals("removePlayer"))
			{
				System.out.println("cýkarmak istediginiz takimi seciniz");
				for(int i=0;i<trk.getTeams().size();i++)
				{
					System.out.println(trk.getTeams().get(i).getTeamName());
				}
				String choiceTeam=new String();
				choiceTeam=input.next();
				int indexTeam=-1;
				for(int i=0;i<trk.getTeams().size();i++)
				{
					if(trk.getTeams().get(i).getTeamName().equals(choiceTeam))
						indexTeam=i;
				}
				System.out.println("cýkarmak istediginiz oyuncuyu TcNum giriniz");
				choiceTeam=input.next();
				trk.getTeams().get(indexTeam).removePlayer(choiceTeam);
			
			}
			// saving all data
			if(task.equals("saveGame"))
			{
				trk.saveTeams();
				trk.saveSchedule();
				trk.saveScoreTables();
				trk.savePuanDurumu();
			}
		
		}

		if(trk.getWeek()==trk.getSchedule().size())
			System.out.println("League is over");
		
	}

}
