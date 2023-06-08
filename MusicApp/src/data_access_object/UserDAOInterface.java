package data_access_object;

public interface UserDAOInterface<T> {
	public int login(T user);
	
	public boolean adminLogin(T user);
	
	public int register(T user);
}
