import java.util.Comparator;

public class StudentComparator implements Comparator
{
    public int compare(Object a, Object b)
    {
      Student s1 = (Student) a;
      Student s2 = (Student) b;  
      String s1Name = s1.getLastName() + " " + s1.getFirstName();
      String s2Name = s2.getLastName() + " " + s2.getFirstName(); 
      return s1Name.compareToIgnoreCase(s2Name);
    }
}
