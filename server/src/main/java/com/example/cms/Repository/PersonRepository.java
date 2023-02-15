package com.example.cms.Repository;
import com.example.cms.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PersonRepository extends JpaRepository<Person, Long> {
    public Person findByNameEquals(String name);
}
