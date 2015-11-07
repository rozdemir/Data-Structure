package TurkishLeague;

public class Person {


	private String Name;
	private String TcNum;
	private String BirthDate;
	private String Address;
	
	public Person() {
		super();
		Name = "Unknown";
		TcNum ="Unknown";
		BirthDate = "1900";
		Address = "Unknown";
		// TODO Auto-generated constructor stub
	}
	public Person(String name, String tcNum, String birthDate, String address) {
		super();
		Name = name;
		TcNum = tcNum;
		BirthDate = birthDate;
		Address = address;
	}

	@Override
	public String toString() {
		return "Person [Name=" + Name + ", TcNum=" + TcNum + ", BirthDate="
				+ BirthDate + ", Address=" + Address + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (Address == null) {
			if (other.Address != null)
				return false;
		} else if (!Address.equals(other.Address))
			return false;
		if (BirthDate != other.BirthDate)
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (TcNum == null) {
			if (other.TcNum != null)
				return false;
		} else if (!TcNum.equals(other.TcNum))
			return false;
		return true;
	}
	
	//Setters and getters
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTcNum() {
		return TcNum;
	}

	public void setTcNum(String tcNum) {
		TcNum = tcNum;
	}
	public String getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
}
