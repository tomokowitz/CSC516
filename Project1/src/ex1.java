// ex1.java
// array of Object

public class ex1 
{
    public static void main(String[] args) 
    {
        Student[] studentArray = new Student[4];
        studentArray[0] = new GradStudent("Mary", "Poppins", "11", "BS in CS");
        studentArray[1] = new GradStudent("Peter", "Pan", "22", "BS in Math");
        studentArray[2] = new UndergradStudent("Wicked", "Stepmother", "33", 
                                               "Monroe High");
        studentArray[3] = new UndergradStudent("Prince", "Charming", "44", 
                                               "Madison High"); 
        for (int i = 0; i < studentArray.length; i++) 
        {
            System.out.println(studentArray[i]); // automatic call to toString()
        }
    }
}
