package application.module;

import application.models.Note;
import application.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetDataFromSomewhere {
    //TODO: put into a map as key: userName, value: List of Notes

    private Map<User, List<Note>> getUserData(String userName) {
        Map<User, List<Note>> getNotesByUser = new HashMap<>();
        User user = new User();
        List<Note> noteList = user.getNotes();

        if(userName.equals(user.getUserName()))
            getNotesByUser.put(user, noteList);

        return getNotesByUser;
    }
}
