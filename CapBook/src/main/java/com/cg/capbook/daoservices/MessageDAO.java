package com.cg.capbook.daoservices;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.capbook.beans.Message;
public interface MessageDAO extends JpaRepository<Message,Integer>{
	@Query(value="SELECT * FROM Message WHERE sender_Email_Id=?1",nativeQuery=true)
	List<Message> findMessagesBySender(String emailId);
	@Query(value="SELECT * FROM Message WHERE receiver_Email_Id=?1",nativeQuery=true)
	List<Message> findMessagesByReceiver(String emailId);
}
