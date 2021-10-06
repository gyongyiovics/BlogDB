package application.models;

public enum RoleName {
    /**
     * a szerepkör lehet: admin / moderator / user
     */
    ADMIN("admin"),
    MODERATOR("moderator"),
    USER("user");

    //TODO: getter for the rolename
    public final String ROLE_NAME;
    RoleName(String roleName) {
        ROLE_NAME = roleName;
    }

}
