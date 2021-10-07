package application.database;

public enum Table {
    BLOG_SCHEMA(4),
    BLOG_TABLE(4),
    BLOG_TO_USER(3),
    COMMENT_TABLE(4),
    NOTE_TABLE(6),
    PERSON_TABLE(3),
    ROLE_TABLE(7),
    USER_TABLE(4);


    public final int COL_NUM;
    Table(int colNum) {
        COL_NUM = colNum;
    }

}
