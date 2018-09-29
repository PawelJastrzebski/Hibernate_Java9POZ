package hibernate;

import dto.Dog;
import dto.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


//
//        Person person = new Person();
//        person.setAge(919);
//        person.setName("sidAAA");
//        person.setSurname("sidsurnameAAA");
//        person.setIdperson(199);
//
//        em.persist(person);
//

        List<Person> idperson = em.createQuery("from Person p where p.idperson = :idperson").setParameter("idperson", 99).getResultList();
//
//
        for (Person p : idperson ) {
            for (Dog dog : p.getDogs()) {
                System.out.println(dog);
            }

        }


//        Person person1 = (Person) session.createQuery("FROM Person WHERE idperson = 99").getSingleResult();
//        System.out.println(person1.getName());


//
//        String person2 = (String) session.createQuery("SELECT surname FROM Person WHERE idperson = 99").getSingleResult();
//        System.out.println(person2);
//        session.getTransaction().commit();

        em.getTransaction().commit();
        em.close();

}
}