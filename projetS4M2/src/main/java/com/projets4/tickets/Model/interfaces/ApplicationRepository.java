package com.projets4.tickets.Model.interfaces;

import com.projets4.tickets.Model.Classes.ApplicationP;
import com.projets4.tickets.Model.Classes.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This is an Interface.
// No need Annotation here.
public interface ApplicationRepository extends CrudRepository<ApplicationP, Long> {

    @Query("select a from ApplicationP a where a.responsable = ?1")
    List<ApplicationP> findAllByManager(User manager); // Long: Type of Customere ID.
    //Customer findByEmpNo(String empNo);

    //List<Customer> findByFullNameLike(String name);
    //List<Customer> findByHireDateGreaterThan(Date hireDate);

    //@Query("SELECT coalesce(max(e.id), 0) FROM Customer e")
    //Long getMaxId();
}
