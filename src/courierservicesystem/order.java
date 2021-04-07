package courierservicesystem;
public class order implements Comparable<order> {
    String orderId,reciever, address, rating,feedback,status;
    staff assignstaff;
    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }
    customer mycustomer;

    public order(){
        
    }
    public order(String orderId,String reciever, String address, staff assignstaff, customer mycustomer) {
        this.orderId = orderId;
        this.reciever = reciever;
        this.address = address;
        this.assignstaff = assignstaff;
        this.mycustomer = mycustomer;
    }

    public order(String orderId, String reciever, String address, String rating, String feedback,String status, staff assignstaff, customer mycustomer) {
        this.orderId = orderId;
        this.reciever = reciever;
        this.address = address;
        this.rating = rating;
        this.feedback = feedback;
        this.assignstaff = assignstaff;
        this.status = status;
        this.mycustomer = mycustomer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

 

    public void setMycustomer(customer mycustomer) {
        this.mycustomer = mycustomer;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getAddress() {
        return address;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public staff getAssignstaff() {
        return assignstaff;
    }

    public void setAssignstaff(staff assignstaff) {
        this.assignstaff = assignstaff;
    }


    public customer getMycustomer() {
        return mycustomer;
    }

    @Override
    public int compareTo(order t) {
        int res = orderId.compareTo(t.orderId);
        return res;
    }
    
    
    
    
}
