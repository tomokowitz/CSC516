package okowitz1;


import javax.swing.JOptionPane;

public class UndergradStudent extends Student
{
    private String highschool;
    
    public UndergradStudent() 
    {
        super();
        highschool = JOptionPane.showInputDialog("Enter high school");       
    }
    
    public UndergradStudent(String firstName, String lastName, String SID,
                       String highschool) 
    {
        super(firstName, lastName, SID);
        this.highschool = highschool;
    }
    
    public String toString() 
    {
        return super.toString() + " from " + highschool;
    }
}

