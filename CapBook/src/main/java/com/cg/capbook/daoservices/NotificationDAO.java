package com.cg.capbook.daoservices;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.capbook.beans.Notification;
public interface NotificationDAO extends JpaRepository<Notification,Integer>{
	@Query(value="SELECT * FROM Notification WHERE email_Id=?1 AND seen_Status=?2",nativeQuery=true)
	public List<Notification> getNotifications(String emailId,Boolean seenStatus);
}
