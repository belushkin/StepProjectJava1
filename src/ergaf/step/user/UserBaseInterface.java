package ergaf.step.user;

import java.util.ArrayList;

public interface UserBaseInterface {
    public ArrayList<User> getAllUsers();
    public void addUser(User user);
    public void clearUsers();
    public void loadData(ArrayList<User> users);
}
