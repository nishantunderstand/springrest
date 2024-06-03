package restfulwebservices.helloworld.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

/**
	By Creating we are mapping this Class to User
	Why are we using User Data Type , Are we run out of Data Type ?
	No, If we use Object , Java is rich in Collection , Collection Works on Object Data Type
	We can Apply Functional Programming on this.
	Like Lambda Function
 */

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
		
	static {
		users.add(new User(1, "Adam 1", LocalDate.now().minusYears(30)));
		users.add(new User(2, "Eve 2", LocalDate.now().minusYears(20)));
		users.add(new User(3, "Jim 3", LocalDate.now().minusYears(10)));
		users.add(new User(4, "Aman 4", LocalDate.now().minusYears(10)));
		users.add(new User(5, "Jim 3", LocalDate.now().minusYears(10)));
		users.add(new User(6, "Aman 4", LocalDate.now().minusYears(10)));
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
	    return null; 
	    // User not found, If I return then it is an issue , But null is not an issue,WHY ?
	}
	
	
	
	public void DeleteById (int id) {
	    for(Iterator<User> iterator = users.iterator();iterator.hasNext();) {
	    	User user = iterator.next();
	    	if(user.getId()==id) {
	    		iterator.remove();
	    		return; 
	    		// Why this return is Important
	    	}
	    }
	    throw new UserNotFoundException("id :"+id);
	}
		
	
	public User save(User user)	{ 
		user.setId(user.getId()); 
		users.add(user);
		return user; 
	}
	//  Adding User to users return user; 
	
	
	
	}
	 

