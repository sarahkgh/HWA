package com.qa.hwa.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.hwa.domain.Course;
import com.qa.hwa.repo.CourseRepo;
//
//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
//@DataJpaTest
public class CourseServiceTest {

	@Autowired
	private CourseService service;

	@MockBean
	private CourseRepo repo;

	@Test
	public void createTest() {
		Course input = new Course("Project Management", "This course is all the basics of project management. Beginner to Professional!");
		Course output = new Course(1l, "Project Management", "This course is all the basics of project management. Beginner to Professional!");

		Mockito.when(this.repo.save(input)).thenReturn(output);
//		System.out.println(this.service.create(input));
		assertEquals(output, this.service.create(input));
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
		
	}
	
	@Test
	public void getAllTest() {
		List<Course> output = new ArrayList<>();
		output.add(new Course("Project Management", "This course is all the basics of project management. Beginner to Professional!"));
		
		Mockito.when(this.repo.findAll()).thenReturn(output);
		assertEquals(output, this.service.getAll());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();	}

}
