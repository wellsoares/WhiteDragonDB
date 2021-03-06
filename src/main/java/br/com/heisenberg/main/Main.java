package br.com.heisenberg.main;

import br.com.heisenberg.conf.HibernateUtil;
import br.com.heisenberg.model.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author well
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        insertUser();
        findAllUser();
    }

    public static void insertUser() {
        User user = new User();

        user.setId(1);
        user.setName("Anderson");
        user.setLastName("Sant Ana");
        user.setPassword("12345");
        user.setCpf("38971455888");
        user.setEmail("WEWE@SSS");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(user);
        session.getTransaction().commit();

        session.close();

    }

    public static void findAllUser() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query hql = session.createQuery("FROM User");

        List<User> users = hql.list();

        session.getTransaction().commit();

        System.out.println(users);

        session.close();

    }
}
