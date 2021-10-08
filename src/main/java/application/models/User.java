package application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class User extends Person {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private String passWord;
    @Getter
    @Setter
    private RoleName usersRole;

}
