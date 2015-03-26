package modelLayer;

/**
 * Person class.
 * 
 * @author Alex, Minh, Frederik, Claus og Nichlas 
 * @version (a version number or a date)
 */
public class Person
{
    private String firstName; // First name variable
    private String lastName; // Last name variable
    private String address; // Adress variable
    private String phone; // phone variable
    private String mail; // mail variable

    public Person(String firstName, String lastName, String address, String phone)
    {
        if(firstName == null) {
            throw new IllegalArgumentException("Firstname == null");
        }
        if(lastName == null) {
            throw new IllegalArgumentException("Lastname == null");
        }
        if(address == null) {
            throw new IllegalArgumentException("Address == null");
        }
        if(phone == null) {
            throw new IllegalArgumentException("Phone == null");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
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

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
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
}