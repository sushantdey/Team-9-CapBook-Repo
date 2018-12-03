package com.cg.capbook.daoservices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.capbook.beans.Profile;
@Qualifier("JpaRepository")
public interface ProfileDAO extends JpaRepository<Profile, String>{

}
