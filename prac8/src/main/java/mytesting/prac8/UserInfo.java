package mytesting.prac8;

import java.util.Objects;

public class UserInfo {
	private String username;
	
	private int age;
	
	private boolean voted;

	public UserInfo(String username, int age, boolean voted) {
		super();
		this.username = username;
		this.age = age;
		this.voted = voted;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, username, voted);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		return age == other.age && Objects.equals(username, other.username) && voted == other.voted;
	}

	public UserInfo() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isVoted() {
		return voted;
	}

	public void setVoted(boolean voted) {
		this.voted = voted;
	}
}
