package com.cg.capbook.daoservices;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.capbook.beans.Post;
public interface PostDAO extends JpaRepository<Post, Integer>{
}
