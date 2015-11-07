package TurkishLeague;

public class GameDay{

	private Team team1;
	private Team team2;
	private String machtDate;
	private String score;
	
	public GameDay() {
		super();
		this.machtDate = "Not yet";
		this.score ="Not Yet";
		
		// TODO Auto-generated constructor stub
	}
	public GameDay(Team team1, Team team2, String machtDate, String score) {
		super();
		this.team1 = team1;
		this.team2 = team2;
		this.machtDate = machtDate;
		this.score = score;
		
	}
	
	@Override
	public String toString() {
		return "GameDay [team1=" + team1 + ", team2=" + team2 + ", machtDate="
				+ machtDate + ", score=" + score + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameDay other = (GameDay) obj;
		if (machtDate == null) {
			if (other.machtDate != null)
				return false;
		} else if (!machtDate.equals(other.machtDate))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (team1 == null) {
			if (other.team1 != null)
				return false;
		} else if (!team1.equals(other.team1))
			return false;
		if (team2 == null) {
			if (other.team2 != null)
				return false;
		} else if (!team2.equals(other.team2))
			return false;
		return true;
	}
	public Team getTeam1() {
		return team1;
	}
	public void setTeam1(Team team1) {
		this.team1 = team1;
	}
	public Team getTeam2() {
		return team2;
	}
	public void setTeam2(Team team2) {
		this.team2 = team2;
	}
	public String getMachtDate() {
		return machtDate;
	}
	public void setMachtDate(String machtDate) {
		this.machtDate = machtDate;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
}
