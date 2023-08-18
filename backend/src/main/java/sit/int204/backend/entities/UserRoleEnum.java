package sit.int204.backend.entities;

public enum UserRoleEnum {
    admin("admin"),
    announcer("announcer");

    private String value;

    UserRoleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static UserRoleEnum getDefault() {
        return announcer;
    }
}
