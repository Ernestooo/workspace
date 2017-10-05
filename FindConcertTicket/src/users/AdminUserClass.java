package users;
/**
 * @author Ivan Domingues 49948 || Tiago Matias 50751
 */

public class AdminUserClass extends UserClass implements AdminUser {

	public AdminUserClass(String email, String password) {
		super(email, password);
		// TODO Auto-generated constructor stub
	}

	public String getType(){
		return ADMIN;
	}
	
}
