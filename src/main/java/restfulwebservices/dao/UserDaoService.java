package restfulwebservices.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import restfulwebservices.model.User;
/**
 * Jun 21, 2025,2:44:36 PM
 * Applying Functional Programming 
 * Java-8 Feature
 */
@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();

	private static int userCount = 0;
			
	static {
		users.add(new User(++userCount, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "Eve", LocalDate.now().minusYears(20)));
		users.add(new User(++userCount, "Jim", LocalDate.now().minusYears(10)));
		users.add(new User(++userCount, "Aman", LocalDate.now().minusYears(10)));
	}

	// CRUD
	// Create
	// Read 1] One 2] All
	// Update 1] One 2] All
	// Delete 1] One 2] All

	// Create
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}

	// Read One
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
	}

	// Read All
	public List<User> findAll (){
		return users;
	}

	// Delete
	public void DeleteById(int id) {
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return; // Why this return is Important
			}
		}
		// throw new UserNotFoundException("id :"+id);
	}


	
}
