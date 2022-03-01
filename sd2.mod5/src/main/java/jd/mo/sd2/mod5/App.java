package jd.mo.sd2.mod5;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ToDoList tdl = new ToDoList();
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
         
        int x;
        System.out.println("Making List");
        do{
            tdl.showMenu();
            x = s1.nextInt();
            switch(x){
                case 1:
                    System.out.println("Add");
                    tdl.addItem(s2.nextLine());
                    break;
                case 2: 
                    System.out.println("Delete");
                    tdl.deleteItem();
                    break;
                case 3:
                    System.out.println("View");
                    tdl.display();
                    break;
                default :
                    break;
            }
        }while(x != 0);
        
        // Hibernate stuff
        Configuration con = new Configuration().configure().addAnnotatedClass(ToDoList.class);
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        session.save(tdl);
        
        t.commit();
    }
}
