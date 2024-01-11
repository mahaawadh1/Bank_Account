
public class User {
    private String password;
    private bankaccount account;

    public User(String username, String password) {
        this.password = password;
        this.account = null;
    }

    public void updateAccountDetails(String newUsername, String newPassword) {
        this.password = newPassword;
    }

    public String getPassword() {
        return password;
    }

    public bankaccount getAccount() {
        return account;
    }

    public void setAccount(bankaccount account) {
        this.account = account;
    }

}
