package com.cg.capbook.daoservices;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.capbook.beans.Friend;
public interface FriendDAO extends JpaRepository<Friend,Integer>{
	@Query(value="SELECT * FROM Friend WHERE to_User_Id=?2 AND from_User_Id=?1",nativeQuery=true)
	public Friend checkFriendship(String fromUserId,String toUserId);
	
	@Query(value="SELECT * FROM Friend WHERE to_User_Id=?1 AND friendship_Status=?2",nativeQuery=true)
	public List<Friend> viewFriendRequests(String sessionEmailId,boolean friendshipStatus);
}
