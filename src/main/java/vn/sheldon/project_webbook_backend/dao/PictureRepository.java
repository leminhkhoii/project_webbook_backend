package vn.sheldon.project_webbook_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.sheldon.project_webbook_backend.entity.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {
}
