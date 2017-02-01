package students;
import javax.swing.JOptionPane;

public class VisitingStudent extends Student
{

    private String nativeLanguage;
    private String country;
    
    public VisitingStudent()
    {
        super();
        this.nativeLanguage = JOptionPane.showInputDialog("Enter language");
        this.country = JOptionPane.showInputDialog("Enter country of origin");
    }
    public VisitingStudent(String firstName, String lastName, String SID, String language, String country )
    {
        super(firstName, lastName, SID);
        this.nativeLanguage = language;
        this.country = country;
       
    }
    
    
    public String toString() 
    {
        return "Name: " + this.getFirstName() + " " + this.getLastName() +
               " SID: " + this.getSID() + " First language: " + this.getLanguage()  +
               " Country: " + this.getCountry();
    }
    
    public String getLanguage() 
    {
        return nativeLanguage;
    }
    
    public String getCountry() 
    {
        return country;
    }
        }
    
    
}


