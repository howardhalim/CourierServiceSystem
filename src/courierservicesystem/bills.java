
package courierservicesystem;

public class bills {
    String Status;
    customer cusname;
    order orderid;
    staff staffname;

    public bills(String Status, order orderid, staff staffname,customer cusname) {
        this.Status = Status;
        this.cusname = cusname;
        this.orderid = orderid;
        this.staffname = staffname;
    }

    public bills() {
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public customer getCusname() {
        return cusname;
    }

    public void setCusname(customer cusname) {
        this.cusname = cusname;
    }

    public order getOrderid() {
        return orderid;
    }

    public void setOrderid(order orderid) {
        this.orderid = orderid;
    }

    public staff getStaffname() {
        return staffname;
    }

    public void setStaffname(staff staffname) {
        this.staffname = staffname;
    }
}
