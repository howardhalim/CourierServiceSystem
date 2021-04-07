package courierservicesystem;
public class customer extends User {
    
    private String id,username,password;
    public customer(String name, String id,String username,String password,String email,String phone, String address) {
        super(name,address,phone,email);
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public customer(String name, String id, String email, String phone, String address) {
        super(name, address, phone, email);
        this.id = id;
    }
       public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
        
}
