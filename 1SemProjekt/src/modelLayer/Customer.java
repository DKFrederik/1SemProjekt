package modelLayer;
/**
 * This is the Customer class.
 * 
 * @author (Gruppe 3) 
 * @version (a version number or a date)
 */
public class Customer
{
    //Instance Variables    

    private static String firstName; // First name variable
    private static String lastName;// Last name variable
    private static String adress; // Address variable
    private static String phone; // phone variable
    private static String mail; // mail variable
    private static String customerId; //Customer ID variable
    private static boolean isPrivateCustomer; // Type variable

    public static void main(String[] args) {
    	Customer customer1 = new Customer(adress, customerId, firstName, lastName, mail, isPrivateCustomer, phone);
    	System.out.println(customer1);
    }
    
    /**
     * This is the constructor.
     * 
     * @param parameter firstName, lastName, address, phone, mail, type, customerId.
     * @param description The constructor constructs objects to the class Sale.
     */
    public Customer(String firstName, String lastName, String adress, String phone, String mail, boolean isPrivateCustomer, String customerId)
    {
        if(firstName == null) {
            throw new IllegalArgumentException("Firstname == null");
        }
        if(lastName == null) {
            throw new IllegalArgumentException("Lastname == null");
        }
        if(adress == null) {
            throw new IllegalArgumentException("Address == null");
        }
        if(phone == null) {
            throw new IllegalArgumentException("Phone == null");
        }
        if(mail == null) {
            throw new IllegalArgumentException("Mail == null");
        }
        if(customerId == null) {
            throw new IllegalArgumentException("CustomerID == null");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.phone = phone;
        this.mail = mail;
        this.customerId = customerId;
        this.isPrivateCustomer = isPrivateCustomer;  
        if(this.firstName.length() == 0 || this.lastName.length() == 0 || this.adress.length() == 0 || this.phone.length() == 0 || this.customerId.length() == 0){
            throw new IllegalStateException("One of the fields is empty. Please fill out all the information.");
        }
    }
    
    /**
     * These set and get methods will allow us to change our information or find it.
     */
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setAdress(String adress)
    {
        this.adress = adress;
    }
    
    public String getAdress()
    {
        return adress;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setMail(String mail)
    {
        this.mail = mail;
    }
    
    public String getMail()
    {
        return mail;
    }
    
    public void setIsPrivateCustomer(boolean isPrivateCustomer)
    {
        this.isPrivateCustomer = isPrivateCustomer;
    }
    
    public boolean getIsPrivateCustomer()
    {
        return isPrivateCustomer;
    }
    
    public void setCustomerId(String customerId)
    {
        this.customerId = firstName+lastName+customerId;
    }
    
    public String getCustomerId()
    {
        return customerId;
    }
}
 
