package vn.sheldon.project_webbook_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.sheldon.project_webbook_backend.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
