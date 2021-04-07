package courierservicesystem;

public interface IDtoObject {
    static staff staffidtostaff(String id){
        staff me = new staff("","","","","");
        
        boolean found = false;
        for(int i=0;i<CourierServiceSystem.allstaff.size();i++){
            staff x = CourierServiceSystem.allstaff.get(i);
            if(x.getId().equals(id)){
                me = x;
                found = true;
                break;
            }
        }
        return me;
        
    }
    static customer customeridtocustomer(String id){
        customer me = new customer("","","","","");
        boolean found =false;
        for(int i=0;i<CourierServiceSystem.allcustomer.size();i++){
            customer x = CourierServiceSystem.allcustomer.get(i);
            if(x.getId().equals(id)){
                me = x;
                found = true;
                break;
            }
        }
        return me;
    }
    static order orderidtoorder(String id){
        order me = new order();
        boolean found = false;
        for(int i=0;i<CourierServiceSystem.allorder.size();i++){
            order x = CourierServiceSystem.allorder.get(i);
            if(x.getOrderId().equals(id)){
                me = x;
                found = true;
                break;
            }
        }
        return me;
        
    }
}
