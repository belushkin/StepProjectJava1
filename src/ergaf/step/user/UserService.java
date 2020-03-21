package ergaf.step.user;

import ergaf.step.flight.Flight;
import ergaf.step.io.FileWorker;

import java.util.ArrayList;
import java.util.Arrays;

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

    public int getNextId() {
        int id = userDao.getAllUsers().
                stream().
                mapToInt(User::getId).
                reduce((first,second) -> second).orElse(0);

        return id + 1;
    }

    public User getUserById(int id) {
        return userDao.
                getAllUsers().
                stream().
                filter(user -> user.getId() == id).
                findFirst().
                orElse(null);
    }

    public User getUserByFirstNameAndLastName(String firstname, String lastname) {
        return userDao.
                getAllUsers().
                stream().
                filter(user -> user.getFirstName().equals(firstname) && user.getLastName().equals(lastname)).
                findFirst().
                orElse(null);
    }

    public ArrayList<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User addUser(User user) {
        return userDao.addUser(user.setId(getNextId()));
    }

    public int count() {
        return userDao.getAllUsers().size();
    }

    public void saveData(ArrayList<User> users){
        FileWorker.serialize(filename, users);
    }

    public ArrayList<User> prepareData() {
        return FileWorker.deserialize(filename);
    }

    public void loadData(ArrayList<User> users){
        userDao.loadData(users);
    }

}
