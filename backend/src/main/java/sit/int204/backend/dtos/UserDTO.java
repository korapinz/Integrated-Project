package sit.int204.backend.dtos;

import lombok.Getter;
import lombok.Setter;
import sit.int204.backend.entities.UserRoleEnum;

@Getter
@Setter
public class UserDTO {
    private String username;
    private String name;
    private String email;
    private UserRoleEnum role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email != null ? email.trim() : "";
    }
}
