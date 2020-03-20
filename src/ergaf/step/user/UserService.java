package ergaf.step.user;

import java.util.ArrayList;

public class UserService {

    private UserDao userDao;

    private String filename = "users.data";

    public UserService(UserDao userDao, String filename) {
        this.userDao = userDao;
        this.filename = filename;
    }

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public ArrayList<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
