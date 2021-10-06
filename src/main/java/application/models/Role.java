package application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Role {
    @Getter
    private RoleName roleName;
    @Getter
    private boolean canReadData;
    @Getter
    private boolean canModifyData;
    @Getter
    private boolean canReadNote;
    @Getter
    private boolean canModifyNote;
    @Getter
    private boolean canDeleteNote;
    @Getter
    private boolean canWriteComment;

}
