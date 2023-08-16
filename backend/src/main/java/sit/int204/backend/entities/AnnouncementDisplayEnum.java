package sit.int204.backend.entities;

public enum AnnouncementDisplayEnum {
    Y("Y"),
    N("N");

    private String value;

    AnnouncementDisplayEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
