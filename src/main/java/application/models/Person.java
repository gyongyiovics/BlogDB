package application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Getter
    private String name;
    @Getter
    private boolean isRegistered;
    @Getter
    private long blogId;
}
