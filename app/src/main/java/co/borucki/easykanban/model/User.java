package co.borucki.easykanban.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "user")
public class User {
    @DatabaseField(columnName = "id", id = true)
    private long id;
    @DatabaseField(columnName = "user_name")
    private String name;
    @DatabaseField(columnName = "user_surname")
    private String surname;
    @DatabaseField(columnName = "user_password")
    private String password;
    @DatabaseField(columnName = "user_is_blocked")
    private boolean isBlocked;
    @DatabaseField(columnName = "user_permission")
    private int permissions;
    @DatabaseField(columnName = "last_login")
    private String lastLogin;
    @DatabaseField(columnName = "login_try")
    private int possibleLoginTry;

    public User() {
    }

    public User(long id, String name, String surname, String password, boolean isBlocked, int permissions, String lastLogin, int possibleLoginTry) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.isBlocked = isBlocked;
        this.permissions = permissions;
        this.lastLogin = lastLogin;
        this.possibleLoginTry = possibleLoginTry;
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

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
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

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
