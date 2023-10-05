package vn.sheldon.project_webbook_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.sheldon.project_webbook_backend.entity.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer>{
}
