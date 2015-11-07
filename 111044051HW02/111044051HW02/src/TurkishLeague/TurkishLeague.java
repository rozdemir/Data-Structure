package TurkishLeague;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

public class TurkishLeague {

	private Person president;
	private Person vicePresident;
	private Vector<Team> teams = new Vector<Team>();
	
	// haftalik mac programi
	private GameDay weeklySchedule;
	
	// tum mac programi
	private Vector<GameDay> schedule = new Vector<GameDay>();
	
	// score tables
	private Vector<String> scoreTables = new Vector<String>();
	// oyananan hafta
	private int week;
	private int year;
	
	public TurkishLeague(Person president, Person vicePresident,
			Vector<Team> teams, GameDay weeklySchedule,
			Vector<GameDay> schedule, Vector<String> scoreTables,int week,int year) {
		super();
		this.president = president;
		this.vicePresident = vicePresident;
		this.teams = teams;
		this.weeklySchedule = weeklySchedule;
		this.schedule = schedule;
		this.scoreTables = scoreTables;
		this.year=year;
		this.week=week;
	}
	public TurkishLeague() throws IOException {
		super();
		week=0;
		year=2015;
		Team temp=new Team();
		temp.readData("galatasaray.txt");
		this.AddTeam(temp);
		
		Team temp2=new Team();
		temp2.readData("fenerbahce.txt");
		this.AddTeam(temp2);
		
		Team temp3=new Team();
		temp3.readData("realmadrid.txt");
		this.AddTeam(temp3);
		
		Team temp4=new Team();
		temp4.readData("barcelona.txt");
		this.AddTeam(temp4);
		
		Team temp5=new Team();
		temp5.readData("besiktas.txt");
		this.AddTeam(temp5);
		
		Team temp6=new Team();
		temp6.readData("trabzon.txt");
		this.AddTeam(temp6);
		
		Team temp7=new Team();
		temp7.readData("chelsea.txt");
		this.AddTeam(temp7);
		
		
		
	}
// getters and setters
	
	public Person getPresident() {
		return president;
	}
	public void setPresident(Person president) {
		this.president = president;
	}
	public Person getVicePresident() {
		return vicePresident;
	}
	public void setVicePresident(Person vicePresident) {
		this.vicePresident = vicePresident;
	}
	
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public Vector<Team> getTeams() {
		return teams;
	}
	public void setTeams(Vector<Team> teams) {
		this.teams = teams;
	}
	public GameDay getWeeklySchedule() {
		return weeklySchedule;
	}
	public void setWeeklySchedule(GameDay weeklySchedule) {
		this.weeklySchedule = weeklySchedule;
	}
	public Vector<GameDay> getSchedule() {
		return schedule;
	}
	public void setSchedule(Vector<GameDay> schedule) {
		this.schedule = schedule;
	}

	public Vector<String> getScoreTables() {
		return scoreTables;
	}
	public void setScoreTables(Vector<String> scoreTables) {
		this.scoreTables = scoreTables;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TurkishLeague other = (TurkishLeague) obj;
		if (president == null) {
			if (other.president != null)
				return false;
		} else if (!president.equals(other.president))
			return false;
		if (schedule == null) {
			if (other.schedule != null)
				return false;
		} else if (!schedule.equals(other.schedule))
			return false;
		if (scoreTables == null) {
			if (other.scoreTables != null)
				return false;
		} else if (!scoreTables.equals(other.scoreTables))
			return false;
		if (teams == null) {
			if (other.teams != null)
				return false;
		} else if (!teams.equals(other.teams))
			return false;
		if (vicePresident == null) {
			if (other.vicePresident != null)
				return false;
		} else if (!vicePresident.equals(other.vicePresident))
			return false;
		if (weeklySchedule == null) {
			if (other.weeklySchedule != null)
				return false;
		} else if (!weeklySchedule.equals(other.weeklySchedule))
			return false;
		return true;
	}
	
	
	// en yuksek puani alani sampiyon olarak donduruyor
	public Team getChampion()
	{
		int tempScore=0;
		Team championTeam=new Team();
		for(int j=0;j<this.getTeams().size();j++)
		{
			if(this.teams.get(j).getScore()>tempScore){
				tempScore=this.teams.get(j).getScore();
				championTeam=this.teams.get(j);
			}
		}
		return championTeam;
	}
	// mac takvimini alip random score ureterek maclar oynanýyor
	public String playGame(){
		String temp=null;
		String allThing=new String();
		int i=week;
		
		// son haftaya gelinmisse ligi bitiriyor
		if(i==this.schedule.size()){
			System.out.println("league is over");
			allThing+="League is over\n";
			Team champion= new Team();
			champion=this.getChampion();
			int indexChampion=this.teams.indexOf(this.getChampion());
			champion.setTropyNumber(champion.getTropyNumber()+1);
			//allThing+="The Champion of the seasons = " + this.getChampion().getTeamName();
			
			allThing+=this.returnPuanDurumu();
			
			//System.out.println(this.returnPuanDurumu());
		}
		else
		{
		//for(int i=0;i<this.schedule.size();i++){
			this.weeklySchedule=this.schedule.get(i);
			allThing+=this.weeklySchedule.getTeam1().printTeamBetWeen(this.weeklySchedule.getTeam2());
			System.out.println("Macth date = "+ this.weeklySchedule.getMachtDate());
			allThing+="Macth date = "+ this.weeklySchedule.getMachtDate()+"\n";
			
			int score1= (int) (0 + (Math.random() * (10 - 0)));
			int score2= (int) (0 + (Math.random() * (10 - 0)));
			temp= new String();
			temp+=this.weeklySchedule.getTeam1().getTeamName();
			temp+=" : "+score1+ "  vs  " + score2+" : ";
			temp+=this.weeklySchedule.getTeam2().getTeamName();
			temp+="  ";
			temp+=this.weeklySchedule.getMachtDate();
			
			
			// üc puanli lig sistemi
			
			if(score1>score2)
				this.teams.get(this.teams.indexOf(this.weeklySchedule.getTeam1())).setScore
					(this.teams.get(this.teams.indexOf(this.weeklySchedule.getTeam1())).getScore()+3);
			else if(score2>score1)
				this.teams.get(this.teams.indexOf(this.weeklySchedule.getTeam2())).setScore
					(this.teams.get(this.teams.indexOf(this.weeklySchedule.getTeam2())).getScore()+3);
			else
			{
				this.teams.get(this.teams.indexOf(this.weeklySchedule.getTeam2())).setScore
				(this.teams.get(this.teams.indexOf(this.weeklySchedule.getTeam2())).getScore()+1);
				this.teams.get(this.teams.indexOf(this.weeklySchedule.getTeam1())).setScore
				(this.teams.get(this.teams.indexOf(this.weeklySchedule.getTeam1())).getScore()+1);
				
			}
			this.scoreTables.add(temp);
			
			allThing+=temp+"\n";
			System.out.println(temp);
			System.out.println();
			this.week++;
		}
			return allThing;
			
		//}
		//System.out.println(this.scoreTables.get(2));
		
	}
	
	// lige bir mac takvimi ekler
	public void addSchedule(GameDay newMacth)
	{
		this.schedule.add(newMacth);
	}
	// verilen bir takvimi cikarir
	public void removeSchedule(GameDay macth)
	{
		this.schedule.remove(this.schedule.indexOf(macth));
	}
	// ligden bir takim cikarir ismini alir 
	// bulamazsa -1 dondurur
	public int removeTeam(String teamName){
		
		for(int i=0;i<this.teams.size();i++)
		{
			if(this.teams.get(i).getTeamName().equals(teamName)){
				this.teams.remove(i);
				return 0;	
			}
		}
		return -1;
		//this.teams.remove(this.teams.indexOf(team));
		
	}
	// lige bir takim ekler
	public void AddTeam(Team team){
		this.teams.add(team);
	}
	public void changePresident(Person president){
		this.president=president;
	}
	
	
	//bir bastan bir sondan takim alarak oyun takvimi olusturdum
	//maclar bir hafta arayla ayný gun
	
	public void gameSchedule()
	{
		int day=21;
		int month=2;
		int year=this.year;
		int oldDay=14;
		GameDay temp=new GameDay();
		//System.out.println(this.teams.size());
		//System.out.println(this.teams.get(0).getTeamName());
		// karisik bir fixktur hazirlaniyor
		// toplam mac sayisi
		int[][] fix = null;
		for(int i=0;i<this.teams.size();i++)
		{
			for(int j=0;j<this.teams.size();j++)
			{
				if(i==j && j<this.teams.size()-1)
					j++;
				fix[i][j]=j+1;
					
			}
			
		}

		
		
	}
	public void gameScheudule2()
	{

	
		int weekNum=0;
		schedule= new Vector<GameDay>();
		//schedule=new Vector<GameDay>(this.teams.size()*(this.teams.size()-1));
		//schedule.setSize(this.teams.size()*(this.teams.size()-1));
		for(int i=0;i<this.teams.size();i++)
		{
			int day=21;
			int month=2;
			int year=this.year;
			int oldDay=14;
			
			int k=i;
			for(int j=0;j<this.teams.size();j++)
			{
			
				 GameDay temp=new GameDay();
				 
				if(i==j && j<this.teams.size()-1)
					j++;
				day=day%30;
				month=month%12;
				oldDay=oldDay%30;
				temp.setTeam1(this.getTeams().get(i));
				temp.setTeam2(this.getTeams().get(j));
				temp.setMachtDate((day)+"."+(month)+"."+year+"\n");
				day+=7;
				oldDay+=7;
				if(day<oldDay)
					month++;
				schedule.add(temp);
				//schedule.set(k,temp);
				//k+=teams.size()-1;
			
				
			
			}
			
		}
	}
	//tum puan durumunu birinciden sonuncuya kadar bir string halinde donduruyor
	public String returnPuanDurumu()
	{
		// 
		Vector<Team> temp = new Vector<Team>();
		String tables= new String();
		temp=this.teams;
		int score=0;
		int index=0;
		int j=1;
		while(temp.size()!=0){
			score=0;
			//System.out.println(temp.size());
			index=0;
			for(int i=0;i<temp.size();i++)
			{
				//System.out.println("patladi2");
				if(temp.get(i).getScore()>score){
					index=i;
					score=temp.get(i).getScore();
				}
			}
			//System.out.println(index);
			tables+=j+". "+temp.get(index).getTeamName()+" " + temp.get(index).getScore()+
					"  Thropyies "+temp.get(index).getTropyNumber()+"\n";
			//System.out.println("patladi3");
			temp.remove(index);
			j++;
			
		}
		return tables;
		
	}
	
	// score tables i file a basiyor
	public void saveScoreTables() throws FileNotFoundException, UnsupportedEncodingException
	{
		PrintWriter writer = new PrintWriter(this.getYear()+"-"+ (this.getYear()+1) +" Season ScoreTables.txt");
		
		for(int i=0;i<this.scoreTables.size();i++)
		{
			writer.println(this.scoreTables.get(i));
			//System.out.println(this.scoreTables.get(i));
		}
		writer.close();
	}
	
	// mac takvimini dosyaya basiyor
	public void saveSchedule() throws FileNotFoundException, UnsupportedEncodingException
	{
		PrintWriter writer = new PrintWriter(this.getYear()+"-"+(this.getYear()+1) +" Season Schedules.txt");
		
		for(int i=0;i<this.schedule.size();i++)
		{
			//writer.println(this.schedule.get(i).toString());
			writer.println(this.schedule.get(i).getTeam1().getTeamName()
					+" vs " + this.schedule.get(i).getTeam2().getTeamName()
					+"   Match date  "+ this.schedule.get(i).getMachtDate());
			/*System.out.println(this.schedule.get(i).getTeam1().getTeamName()
					+" vs " + this.schedule.get(i).getTeam2().getTeamName()
					+" date "+ this.schedule.get(i).getMachtDate());*/
		}
		writer.close();
	}
	
	
	public void saveTeams() throws IOException, UnsupportedEncodingException
	{
		// saving data on file which has name with teamName.txt
		String fileName= new String();
		for(int i=0;i<this.getTeams().size();i++)
		{
			fileName=this.getTeams().get(i).getTeamName()+".txt";
			this.teams.get(i).saveData(fileName);
		}
	}
	public void savePuanDurumu() throws IOException, UnsupportedEncodingException
	{
		PrintWriter writer = new PrintWriter(this.getYear()+"-"+ (this.getYear()+1) +"Puan Durumu.txt");
		writer.println(this.returnPuanDurumu());
		writer.close();
	}
	
	
}
