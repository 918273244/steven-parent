import java.util.List;

/**
 * Created by Steven on 2017/4/17.
 */
public interface UserService {
    public User findByUsername(String username);

    public int saveUser(String username, String password, String role);

    public List<User> userList();
}
