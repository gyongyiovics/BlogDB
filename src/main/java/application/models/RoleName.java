package application.models;

public enum RoleName {
    /**
     * a szerepkör lehet: admin / moderator / user
     */
    ADMIN,
    MODERATOR,
    USER,
    UNREGISTERED;

    /*public final String ROLE_NAME;
    RoleName(String roleName) {
        ROLE_NAME = roleName;
    }
    */
    public int getDBIndex() {
        return ordinal() + 1;
    }

}
