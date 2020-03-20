package ergaf.step.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    public void add_user_should_add_user_to_collection() {
        //given
        UserDao userDao = new UserDao();
        //when
        userDao.addUser(new User("Mark", "Tven"));
        //then
        assertEquals(1, userDao.getAllUsers().size());
    }

    @Test
    public void add_the_same_user_not_increase_size_of_collection() {
        //given
        UserDao userDao = new UserDao();
        //when
        userDao.addUser(new User("Mark", "Tven"));
        userDao.addUser(new User("Mark", "Tven"));
        //then
        assertEquals(1, userDao.getAllUsers().size());
    }

    @Test
    public void clear_users_should_clean_collection() {
        //given
        UserDao userDao = new UserDao();
        //when
        userDao.addUser(new User("Mark", "Tven"));
        userDao.addUser(new User("Mark", "Tven"));
        userDao.clearUsers();
        //then
        assertEquals(0, userDao.getAllUsers().size());
    }
}