package ex2;

public class UserRepository {
	
	private User[] db = new User[100];
	private int position = 0;
	
	public void insert(User user) {
		db[position] = user;
		position++;
	}
	
	public User getUserById(String userId) {
		for(int i=0; i<position; i++) {
			User user = db[i];
			if(user.getId().equals(userId)) {
				return user;
			}
		}
		return null;
	}
}
