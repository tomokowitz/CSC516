package students;


        // Use LinkedList class

        import java.util.LinkedList;
        import java.util.ListIterator;

        import java.util.NoSuchElementException;

        import javax.swing.JOptionPane;

        public class okowitzt1
        {
            public static void main(String[] args) 
            {
                LinkedList students = new LinkedList();
                ListIterator li;
                Student current;
                students.add( new GradStudent("Mary", "Poppins", "11", "BS in CS"));
                students.add( new GradStudent("Peter", "Pan", "22", "BS in Math"));
                students.add( new UndergradStudent("Wicked", "Stepmother", "33", 
                                                       "Monroe High"));
                students.add( new UndergradStudent("Prince", "Charming", "44", 
                                                       "Madison High")); 
                li = students.listIterator();
                current = (Student) li.next();
                System.out.println(current);
                String choice;
                choice = JOptionPane.showInputDialog("Enter your choice\n" +
                                                     "Quit\n" +
                                                     "Next\n" +
                                                     "Previous\n" +
                                                     "Add Undergrad Student\n" +
                                                     "Add Grad Student\n" +
                                                     "Remove First\n" + 
                                                     "Remove Last");
                while (! choice.equalsIgnoreCase("Quit")) 
                {
                    try
                    {
                        if (choice.equalsIgnoreCase("Next")) 
                        {
                            current = (Student) li.next();
                            System.out.println(current);
                        }
                        else if (choice.equalsIgnoreCase("Previous")) 
                        {
                            current = (Student) li.previous();
                            System.out.println(current);
                        }
                        else if (choice.equalsIgnoreCase("Remove First")) 
                        {
                            Student gone = (Student)students.removeFirst(); 
                            li = students.listIterator();
                            // restart list iterator if add or remove
                            System.out.println(gone + " removed, Back to Start");
                        }
                        else if (choice.equalsIgnoreCase("Remove Last")) 
                        {
                            Student gone = (Student)students.removeLast();
                            li = students.listIterator();
                            // restart list iterator if add or remove
                            System.out.println(gone + " removed, Back to Start");
                        }
                    }
                    catch (NoSuchElementException e)
                    {
                        System.out.println("No more");
                    }
                    catch (IndexOutOfBoundsException e)
                    {
                        System.out.println("No one available to remove");
                    }
                    if (choice.equalsIgnoreCase("Add Grad Student")) 
                    {
                        GradStudent input = new GradStudent();
                        students.addLast(input);
                        li = students.listIterator();
                        // restart list iterator if add or remove
                        System.out.println(input + " added");
                    }
                    if (choice.equalsIgnoreCase("Add Undergrad Student")) 
                    {
                        UndergradStudent input = new UndergradStudent();
                        students.addLast(input);
                        li = students.listIterator();
                        // restart list iterator if add or remove
                        System.out.println(input + " added");
                    }
                    choice = JOptionPane.showInputDialog("Enter your choice\n" +
                                                         "Quit\n" +
                                                         "Next\n" +
                                                         "Previous\n" +
                                                         "Add Undergrad Student\n" +
                                                         "Add Grad Student\n" +
                                                         "Remove First\n" + 
                                                         "Remove Last");      
                }
            }
            
            
        }
   