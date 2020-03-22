package ergaf.step.user;

import java.util.ArrayList;

public class UserController {

    private UserService userService;

    private User currentUser;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User getUserById(int id) {
        return userService.getUserById(id);
    }

    public User getUserByLoginAndPassword(String login, String password) {
        return userService.getUserByLoginAndPassword(login, password);
    }

    public User getUserByFirstNameAndLastName(String firstname, String lastname) {
        return userService.getUserByFirstNameAndLastName(firstname, lastname);
    }

    public int count() {
        return userService.count();
    }

    public User addUser(User user) {
        return userService.addUser(user);
    }

    public void saveData(ArrayList<User> users){
        userService.saveData(users);
    }

    public void loadData(){
        userService.loadData(
                userService.prepareData()
        );
    }

    public ArrayList<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean unlinkData() {
        return userService.unlinkData();
    }

    public void clearUsers() {
        userService.clearUsers();
    }
}
