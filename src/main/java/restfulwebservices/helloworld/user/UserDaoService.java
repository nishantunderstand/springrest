package restfulwebservices.helloworld.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

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
		

	public List<User> findAll (){
		return users;
	}


	// Find One 
	public User findOne(int id) {
	    for (User user : users) {
	        if (user.getId() == id) {
	            return user;
	        }
	    }
	    return null; // User not found
	}
	
	
	/*
	 * public void DeleteById (int id) {
	 * for(Iterator<User> iterator = users.iterator();iterator.hasNext();) {
	 * User user = iterator.next();
	 * if(user.getId()==id) {
	 * iterator.remove();
	 * return; // Why this return is Important
	 * }
	 * }
	 * //throw new UserNotFoundException("id :"+id);
	 * }
	 */
		
	public User save(User user) {
		user.setId(++userCount);
		users.add(user); 
		// Adding User to users
		return user;
	}
}
