package jd.mo.Hibernate1;

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
        Person me = new Person();
        me.setId(001);
        me.setColor("Red");
        me.setName("Juan");
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Person.class);
        
        
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(me);
        tx.commit();
    }
}
