package okowitz1;


import javax.swing.JOptionPane;

public class GradStudent extends Student
{
    private String undergradDegree;
    
    public GradStudent() 
    {
        super();
        undergradDegree = JOptionPane.showInputDialog("Enter degree");
    }
    
    public GradStudent(String firstName, String lastName, String SID,
                       String undergradDegree) 
    {
        super(firstName, lastName, SID);
        this.undergradDegree = undergradDegree;
    }
    
    public String toString() 
    {
        return super.toString() + " with degree of " + undergradDegree;
    }
}
