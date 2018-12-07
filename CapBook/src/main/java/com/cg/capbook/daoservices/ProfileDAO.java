package com.cg.capbook.daoservices;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.capbook.beans.Profile;
@Qualifier("JpaRepository")
public interface ProfileDAO extends JpaRepository<Profile, String>{
	@Modifying
	@Transactional
	@Query(value="UPDATE Profile SET current_City=?1,highest_Education=?2,relationship_Status=?3,user_Bio=?4,work_Place=?5 WHERE email_Id=?6",nativeQuery=true)
	public int editProfile(String currentCity,String highestEducation,String relationshipStatus,String userBio,String workPlace,String emailId);
	@Modifying
	@Transactional
	@Query(value="SELECT * FROM Profile WHERE LOWER(First_Name) LIKE ?1",nativeQuery=true)
	public List<Profile> searchAllUserByName(String userName);
	@Modifying
	@Transactional
	@Query(value="UPDATE Profile SET password=?1 WHERE email_Id=?2",nativeQuery=true)
	public void changePassword(String newPassword,String emailId);
}
