package springboot.db.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.db.practice.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
