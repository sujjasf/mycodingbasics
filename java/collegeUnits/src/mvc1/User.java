package mvc1;

public class User {
    private String un;
    private String ps;

    public User(String username, String password) {
        this.un = username;
        this.ps = password;
    }

    public String getUsername(){
        return un;
    }

    public String getPassword(){
        return ps;
    }

    public boolean validate() {
        // simple validation checks
        return un.equals("admin")&&ps.equals("password");
    }
}
