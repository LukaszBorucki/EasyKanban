package co.borucki.easykanban.dto;

public class UserDTO {
    private long id;
    private String name;
    private String surname;
    private String password;
    private int isBlocked;
    private int permissions;
    private String lastLogin;
    private int possibleLoginTry;
    private int forceChanges;

    public UserDTO() {
    }

    public UserDTO(long id, String name, String surname, String password, int isBlocked, int permissions, String lastLogin, int possibleLoginTry, int forceChanges) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.isBlocked = isBlocked;
        this.permissions = permissions;
        this.lastLogin = lastLogin;
        this.possibleLoginTry = possibleLoginTry;
        this.forceChanges = forceChanges;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int isBlocked() {
        return isBlocked;
    }

    public void setBlocked(int blocked) {
        isBlocked = blocked;
    }

    public int getPermissions() {
        return permissions;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getPossibleLoginTry() {
        return possibleLoginTry;
    }

    public void setPossibleLoginTry(int possibleLoginTry) {
        this.possibleLoginTry = possibleLoginTry;
    }

    public int isForceChanges() {
        return forceChanges;
    }

    public void setForceChanges(int forceChanges) {
        this.forceChanges = forceChanges;
    }
}
