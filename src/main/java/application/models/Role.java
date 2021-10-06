package application.models;

public class Role {
    private RoleName roleName;
    private boolean canReadData;
    private boolean canModifyData;
    private boolean canReadNote;
    private boolean canModifyNote;
    private boolean canDeleteNote;
    private boolean canWriteComment;

    public Role(RoleName roleName,
                boolean canReadData,
                boolean canModifyData,
                boolean canReadNote,
                boolean canModifyNote,
                boolean canDeleteNote,
                boolean canWriteComment) {
        this.roleName = roleName;
        this.canReadData = canReadData;
        this.canModifyData = canModifyData;
        this.canReadNote = canReadNote;
        this.canModifyNote = canModifyNote;
        this.canDeleteNote = canDeleteNote;
        this.canWriteComment = canWriteComment;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public boolean isCanReadData() {
        return canReadData;
    }

    public boolean isCanModifyData() {
        return canModifyData;
    }

    public boolean isCanReadNote() {
        return canReadNote;
    }

    public boolean isCanModifyNote() {
        return canModifyNote;
    }

    public boolean isCanDeleteNote() {
        return canDeleteNote;
    }

    public boolean isCanWriteComment() {
        return canWriteComment;
    }
}
