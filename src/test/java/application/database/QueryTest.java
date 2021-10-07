package application.database;

import application.models.RoleName;
import application.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QueryTest {

    Query queryDB = new Query();
 /*   @Test
    void userListByName() {
        Query query = new Query();
        List<User> expected = new ArrayList<>();

        User user = new User();
        user.setId(3);
        user.setUserName("Gizi@123");
        user.setPassWord("pw");
        user.setUsersRole(RoleName.UNREGISTERED);

        System.out.println(user.getUserName());

        expected.add(user);
        String name1 = expected.get(0).getUserName();
        System.out.println(name1);

        *//*List<User> actual = query.userListByName("'Gizi@123'");
        String name1 = expected.get(0).getUserName();
        String name2 = actual.get(0).getUserName();

        Assertions.assertEquals(name1, name2);*//*

        //System.out.println(compare(expected, actual));

        *//*
        * Gizi@123, pw, UNREGISTERED
         *//*
    }*/

    //similar User test can be used here
    @Test
    void userListByRole() {
    }

    @Test
    void blogsById() {
        List<String> textList = new ArrayList<>();
        textList.add("HelloBello");
        textList.add("Schedule");
        try {

            //Assertions.assertTrue(compareText(textList, query.blogsById("user_id", 1)));
            Assertions.assertEquals(textList.get(0), queryDB.blogsById("user_id", 1).get(0));

        } catch (NullPointerException e) {
            System.out.println("???");
            e.printStackTrace();
        }


        //Process finished with exit code 255
    }

    @Test
    void noteTextsById() {
    }

    @Test
    void commentTexts() {
    }

    public boolean compareUser(List<User> list1, List<User> list2) {
        if(list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).getUserName().equals(list2.get(i).getUserName())) {
                return false;
            }
        }

        return true;
    }

    public boolean compareText(List<String> list1, List<String> list2) {
        if(list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }

        return true;
    }

}