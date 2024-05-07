package restfulwebservices.helloworld.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * By Creating we are mapping this Class to User
	Why are we using User Data Type , Are we run out of Data Type ?
	No, If we use Object , Java is rich in Collection , Collection Works on Object Data Type
 */
@Component
public class UserDaoService {
	
	
	private static List<User> users = new ArrayList<>();
	// Approach 1 For Managing Count 
		//private static int userCount = 3;
		private static int userCount = 0;
		
	
	static {
		users.add(new User(++userCount, "Adam11111", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "Adam Kumar2222", LocalDate.now().minusYears(20)));
		users.add(new User(++userCount, "Adam Srivastav3333", LocalDate.now().minusYears(10)));
	}

		
	// public List<User> findAll()
	public List<User> findAll (){
		return users;
	}
	// public User save(User user)
	// public User findOne(int id)
	
	// Apply Functional Programming on this
	// Why are we not using List<User>
	
	public User findOne(int id) {
	    for (User user : users) {
	        if (user.getId() == id) {
	            return user;
	        }
	    }
	    return null; // User not found
	}

	
	public void DeleteById (int id) {
	    for(Iterator<User> iterator = users.iterator();iterator.hasNext();) {
	    	User user = iterator.next();
	    	if(user.getId()==id) {
	    		iterator.remove();
	    		return; // Why this return is Important
	    	}
	    }
	    throw new UserNotFoundException("id :"+id);
	}

	
	
	public User save(User user) {
		user.setId(++userCount);
		users.add(user); // Adding User to users
		return user;
	}
}
