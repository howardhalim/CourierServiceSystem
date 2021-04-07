package courierservicesystem;
public class staff extends User implements Comparable<staff> {
    private String name, id,username,password,phone,email,address,status;

    
    public staff(String name,String id,String phone,String email,String address){
        super(name,address,phone,email);
        this.id = id;
    }
    public staff(String name, String id, String username, String password, String phone, String email, String address, String status) {
        super(name,address,phone,email);
        this.id = id;
        this.username = username;
        this.password = password;
       
        this.status = status;
    }

 

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

  

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    @Override
//    public String toString(){
//        return name+"\n"+id+"\n"+username+"\n"+password+"\n"+phone+"\n"+email+"\n"+address+"\n"+status;
//    }

    @Override
    public int compareTo(staff t) {
        int res = id.compareTo(t.id);
        return (res);
    }
    
}


