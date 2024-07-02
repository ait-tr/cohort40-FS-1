package group40;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExample {
    public static void main(String[] args) {
        // настройка конфигурации Hibernate

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // создаем сотрудника

        Employee employee = new Employee("John","IT");

        // сохранить сотрудника в базу данных

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();
        session.close();

        // чтение сотрудника из базы данных

        session = sessionFactory.openSession();
        Employee readEmployeeFromDb = session.get(Employee.class,1);
        System.out.println("Received employee: " + readEmployeeFromDb);
        session.close();

    }
}
