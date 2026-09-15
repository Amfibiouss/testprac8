package mytesting.prac8;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
	
	Map <String, UserInfo> db = new HashMap<>();
	
	
	public UserRepository() {
		super();
		db.put("Вася Пупкин", new UserInfo("Вася Пупкин", 18, true));
	}

	UserInfo getUserInfo(String username) {
		return db.get(username);
	}
	
	void addUserInfo(UserInfo info) {
		db.put(info.getUsername(), info);
	}
	
	void voted(String username) {
		UserInfo info = getUserInfo(username);
		info.setVoted(true);
	}
}
