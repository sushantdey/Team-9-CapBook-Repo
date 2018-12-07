package com.cg.capbook.boot;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.capbook.beans.Message;
import com.cg.capbook.beans.Page;
import com.cg.capbook.beans.Post;
import com.cg.capbook.beans.Profile;
import com.cg.capbook.daoservices.MessageDAO;
import com.cg.capbook.daoservices.ProfileDAO;
import com.cg.capbook.exceptions.EmailAlreadyUsedException;
import com.cg.capbook.exceptions.InvalidEmailIdException;
import com.cg.capbook.exceptions.InvalidPasswordException;
import com.cg.capbook.exceptions.NoUserFoundException;
import com.cg.capbook.services.CapBookServices;
import com.cg.capbook.services.CapBookServicesImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CapBookServicesImplTest {
	@TestSubject
	CapBookServices capBookServices = new CapBookServicesImpl();
	@MockBean
	MessageDAO mockMessageDAO;
	@MockBean
	ProfileDAO mockProfileDAO;
	Profile profile1,profile2;
	Page page1,page2;
	Post post1,post2,post3;
	Message message1,message2,message3,message4;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		/*mockProfileDAO = EasyMock.createMock(ProfileDAO.class);
		capBookServices = new CapBookServicesImpl(mockProfileDAO);
		mockMessageDAO = EasyMock.createMock(MessageDAO.class);
		capBookServices = new CapBookServicesImpl(mockMessageDAO);*/
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		/*capBookServices=null;
		mockProfileDAO=null;
		mockMessageDAO=null;*/
	}
	@Before
	public void setUp() throws Exception {
		profile1 = new Profile("sushant@gmail.com", "sushant@123", "Sushant", "Dey", "15/04/1996", "male", "Jamshedpur", "07/12/2018", "7004308409", "abc", "abc", null, "none", "Pune", "sr. analyst", "B.Tech", "single", null, null);
		profile1 = new Profile("somnath@gmail.com", "somnath@123", "Somnath", "Dey", "15/04/1995", "male", "Bokaro", "07/12/2018", "7004308409", "abc", "abc", null, "none", "Pune", "sr. analyst", "B.Tech", "single", null, null);
		/*Map<String, Profile> profiles = new LinkedHashMap<>();
		profiles.put(profile1.getEmailId(), profile1);
		profiles.put(profile2.getEmailId(), profile2);
		List<Profile> profileList = new ArrayList<>(profiles.values());
		
		EasyMock.expect(mockProfileDAO.findAll()).andReturn(profileList);
		EasyMock.replay(mockProfileDAO);*/
		
			
	}
	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testRegisterUser() throws EmailAlreadyUsedException {
		/*EasyMock.expect(mockProfileDAO.findById(EasyMock.isA(String.class)).isPresent()).andReturn(true);
		EasyMock.replay(mockProfileDAO);
		assertEquals(true,capBookServices.registerUser(profile1));*/
	}
	@Test
	public void testLoginUser() throws InvalidEmailIdException, InvalidPasswordException {
		profile1 = new Profile("sushant@gmail.com", "sushant@123", "Sushant", "Dey", "15/04/996", "male", "Jamshedpur", "07/12/2018", "7004308409", "abc", "abc", null, "none", "Pune", "sr. analyst", "B.Tech", "single", null, null);
		Mockito.when(mockProfileDAO.findById(Mockito.anyString())).thenReturn(Optional.of(profile1));
		assertThat(capBookServices.loginUser(profile1)).isEqualTo(profile1);
	}
	@Test
	public void editProfile() throws InvalidEmailIdException {
		
	}
	@Test
	public void searchAllUsersByName() throws  NoUserFoundException{
		
	}
	@Test
	public void friendRequest() {
		
	}
	@Test
	public void sendMessage() {
		
	}
	@Test
	public void viewSentMessages() {
		
	}
	@Test
	public void viewReceivedMessages() {
		
	}
}
