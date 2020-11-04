//Java imports
package lib.models;

public class  User{

    private String user;
    private int idCard;
    private String range;
    private String password;
    private int celNumber;
    private String email;
    private String homeAdress;
    private String name;

    public User(String user, int idCard, String range, String contraseña, 
            int celNumber, String email, String homeAdress, String name){
        this.user = user;
        this.idCard = idCard;
        this.range = range;
        this.password = contraseña;
        this.celNumber = celNumber;
        this.email = email;
        this.homeAdress = homeAdress;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCelNumber() {
        return celNumber;
    }

    public void setCelNumber(int celNumber) {
        this.celNumber = celNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAdress() {
        return homeAdress;
    }

    public void setHomeAdress(String homeAdress) {
        this.homeAdress = homeAdress;
    }

}
