package com.projets4.tickets.Model.interfaces;

import com.projets4.tickets.Model.Classes.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This is an Interface.
// No need Annotation here.
public interface UserRepository extends CrudRepository<User, Long> { // Long: Type of Customere ID.
    //Customer findByEmpNo(String empNo);

    //List<Customer> findByFullNameLike(String name);
    //List<Customer> findByHireDateGreaterThan(Date hireDate);

    //@Query("SELECT coalesce(max(e.id), 0) FROM Customer e")
    //Long getMaxId();


    @Query("select u from User u where u.login = ?1 and u.password = ?2")
    List<User> findByLoginAndPassword(String login, String password);

    @Query("select u from User u where u.isAgent = true and (u.responsable = ?1 or u.responsable is null)")
    List<User> findAllAgentsByManager(User manager);

    @Query("select u from User u where u.login = ?1")
    List<User> findByLogin(String login);

    @Query("select u from User u where u.isAgent = true")
    List<User> findAllAgents();

    @Query("select u from User u where u.isManager = true")
    List<User> findAllManager();

    @Query("select u from User u where u.isAdmin = true")
    List<User> findAllAdmin();


}
