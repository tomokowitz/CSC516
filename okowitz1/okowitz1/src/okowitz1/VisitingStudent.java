package okowitz1;

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
        return super.toString() +  " with First language: " + this.nativeLanguage  +
               " Country: " + this.country;
    }
    
   // public String getLanguage() {
   //     return nativeLanguage;
   // }

   // public String getCountry() {
   //     return country;
    //}


}


