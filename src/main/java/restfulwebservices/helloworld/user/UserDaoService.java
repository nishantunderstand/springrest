package restfulwebservices.helloworld.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	static {
		users.add(new User(1, "Adam 1", LocalDate.now().minusYears(30)));
		users.add(new User(2, "Eve 2", LocalDate.now().minusYears(20)));
		users.add(new User(3, "Jim 3", LocalDate.now().minusYears(10)));
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}