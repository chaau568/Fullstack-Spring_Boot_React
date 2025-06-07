package learn_basic.to_do_list.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_data")
public class UserEntity {
    @Id
    private String id;
    private String username;
    private String password;
    private boolean completed;

    public UserEntity() {}

    public UserEntity(String username, String password, boolean completed) {
        this.username = username;
        this.password = password;
        this.completed = completed;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }
}
