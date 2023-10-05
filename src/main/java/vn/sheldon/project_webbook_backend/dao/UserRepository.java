package vn.sheldon.project_webbook_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.sheldon.project_webbook_backend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
