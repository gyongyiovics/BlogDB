package application.helpers;

public class EnumHelper {
    //numbering of the enum elements
    public static <T extends Enum<T>> int getDBIndex(Enum<T> enumToUse) {
        return enumToUse.ordinal() + 1;
    }

    //names of the enum elements
    public static <T extends Enum<T>> String getDBName(Enum<T> enumToUse) {
        return enumToUse.name().toLowerCase();
    }
}
