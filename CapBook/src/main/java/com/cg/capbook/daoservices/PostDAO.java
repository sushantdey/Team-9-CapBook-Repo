package com.cg.capbook.daoservices;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.cg.capbook.beans.Post;
public interface PostDAO extends JpaRepository<Post, Integer>{
	@Modifying
	@Transactional
	@Query(value="SELECT * FROM Post WHERE email_Id LIKE ?1",nativeQuery=true)
	List<Post> findAllByEmail(String emailId);
}
