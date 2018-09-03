package com.ushan.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.ushan.entity.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations="classpath:application-test.properties")
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TestEntityManager testEntityManager;
	
	@Test
	public void test() {
		User savedUser = testEntityManager.persistAndFlush(new User("Ushan","Nandhan",32));
		User userFromDB = userRepository.findByUserId(savedUser.getUserId());
		assertThat(userFromDB.getFirstName()).isEqualTo(savedUser.getFirstName());
	}

}
