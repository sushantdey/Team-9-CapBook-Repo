package com.cg.capbook.daoservices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.capbook.beans.Friend;
public interface FriendDAO extends JpaRepository<Friend,Integer>{
	@Query(value="SELECT * FROM Friend WHERE to_User_Id=?2 and from_User_Id=?1",nativeQuery=true)
	public Friend checkFriendship(String fromUserId,String toUserId);
}
