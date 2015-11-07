package TurkishLeague;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
//import java.util.Scanner;
import java.util.Vector;

public class Team {


	private String teamName;
	private Vector<Person> players;
	private Person teamPresident;
	private Person manager;
	private int tropyNumber;
	private int score;
	
	
	public Team() {
		super();
		this.tropyNumber=0;
		this.score=0;
		this.players=new Vector<Person>();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		if (teamPresident == null) {
			if (other.teamPresident != null)
				return false;
		} else if (!teamPresident.equals(other.teamPresident))
			return false;
		if (tropyNumber != other.tropyNumber)
			return false;
		return true;
	}

	public Team(String teamName, Vector<Person> players, Person teamPresident,
			Person manager, int tropyNumber) {
		super();
		this.teamName = teamName;
		this.players = players;
		this.teamPresident = teamPresident;
		this.manager = manager;
		this.tropyNumber = tropyNumber;
	}
// getters and setters
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Vector<Person> getPlayers() {
		return players;
	}
	public void setPlayers(Vector<Person> players) {
		this.players = players;
	}
	public Person getTeamPresident() {
		return teamPresident;
	}
	public void setTeamPresident(Person teamPresident) {
		this.teamPresident = teamPresident;
	}
	public Person getManager() {
		return manager;
	}
	public void setManager(Person manager) {
		this.manager = manager;
	}
	public int getTropyNumber() {
		return tropyNumber;
	}
	public void setTropyNumber(int tropyNumber) {
		this.tropyNumber = tropyNumber;
	}
	
	// verilen bir oyuncuyu takimdan cikarir
	public int removePlayer(String personTc)
	{
		for(int i=0;i<this.players.size();i++)
		{
			if(this.players.get(i).getTcNum().equals(personTc)){
				this.players.remove(i);
				return 0;
				
			}

			
		}
		return -1;
		//this.players.remove(this.players.indexOf(player));
		
	}
	// eger takim max capasity e ulasmamýssa bir oyuncu daha ekler 
	// bkz max 15 players
	public void addPlayer(Person player)
	{
		if(this.players.indexOf(player)!=-1)
				System.out.println("already exist");
		else if(this.players.size()>=15)
			System.out.println("you achieved max capasity");
		else
			this.players.add(player);
	}
	
	// 
	public void changeManager(Person manager)
	{
		this.manager=manager;
	}
	public void changePresident(Person President)
	{
		this.teamPresident=President;
	}
	
	// olusturulan dosyadan takimla alakali butun bilgiler okunuyor
	public void readData(String fileName) throws IOException
	{
		// readin file 
	    File file = new File(fileName);
	    FileReader fr = new FileReader(file);
	    BufferedReader br = new BufferedReader(fr);
	    
	    String line;
	    Person temp=new Person();
	    this.players=new Vector<Person>();
	    line = br.readLine();
	    this.teamName=line;
	    line = br.readLine();
	    String[] parts = line.split(" ");
	    // ayrilip
	    temp.setName(parts[0]);
	    temp.setTcNum(parts[1]);
	    temp.setBirthDate(parts[2]);
	    temp.setAddress(parts[3]);
	    this.teamPresident=temp;
	    
	    temp=new Person();
	    line = br.readLine();
	    parts = line.split(" ");
	    temp.setName(parts[0]);
	    temp.setTcNum(parts[1]);
	    temp.setBirthDate(parts[2]);
	    temp.setAddress(parts[3]);
	    this.manager=temp;
	    
	    line = br.readLine();
	    this.tropyNumber=Integer.parseInt(line);
	    line = br.readLine();
	    while(line!=null){
		    
		    parts = line.split(" ");
		    temp=new Person();
		    temp.setName(parts[0]);
		    //System.out.println(parts[0]);
		    temp.setTcNum(parts[1]);
		    temp.setBirthDate(parts[2]);
		    temp.setAddress(parts[3]);
		    this.players.add(temp);
		    line = br.readLine();
	    	
	    }
	    br.close();
	    fr.close();
	}
	
	// takim bilgileri ayni fotmatta dosyaya basiliyor
	public void saveData(String fileName) throws FileNotFoundException, UnsupportedEncodingException
	{
		PrintWriter writer = new PrintWriter(fileName);
		writer.println(this.teamName);
		//System.out.println(this.teamPresident.getName());
		writer.println(this.teamPresident.getName()+" "
				+this.teamPresident.getTcNum()+" "+
				this.teamPresident.getBirthDate()+" "+
				this.teamPresident.getAddress());
		
		writer.println(this.manager.getName()+" "
				+this.manager.getTcNum()+" "+
				this.manager.getBirthDate()+" "+
				this.manager.getAddress());
		writer.println(this.tropyNumber);
		for(int i=0;i<this.players.size();i++)
		{
			writer.println(this.players.get(i).getName()+" "
					+this.players.get(i).getTcNum()+" "+
					this.players.get(i).getBirthDate()+" "+
					this.players.get(i).getAddress());
		}
		writer.close();
	}
	
	// takimlari karsilastirmali bir bicimde stringe cevieiryor
	public String printTeamBetWeen(Team other)
	{
		String temp=new String();
		System.out.println(this.teamName + " vs "+ other.teamName);
		temp+=this.teamName + " vs "+ other.teamName+"\n";
		//System.out.println(this.teamPresident.getName());
		System.out.println("Presidents");
		temp+="Presidents\n";
		
		System.out.println(this.teamPresident.getName()+" vs "+other.teamPresident.getName());
		temp+=this.teamPresident.getName()+" vs "+other.teamPresident.getName();
		
		System.out.println("Managers");
		temp+="Managers\n";
		
		System.out.println(this.manager.getName()+" vs "+ other.manager.getName());
		temp+="The Players\n\n";
		System.out.println("The Players");
		
		System.out.println();
		for(int i=0;i<this.players.size();i++)
		{
			System.out.println(this.players.get(i).getName()+" vs "+ other.players.get(i).getName());
			temp+=this.players.get(i).getName()+" vs "+ other.players.get(i).getName()+"\n";
		}
		return temp;
	}
}
