package ru.geekbrains.security.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.security.entities.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
}
