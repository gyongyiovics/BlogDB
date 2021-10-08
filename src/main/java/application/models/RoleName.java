package application.models;

public enum RoleName {
    ADMIN,
    MODERATOR,
    USER,
    UNREGISTERED;

    public int getDBIndex() {
        return ordinal() + 1;
    }

}
