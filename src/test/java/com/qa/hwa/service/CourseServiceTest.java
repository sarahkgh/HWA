package com.qa.hwa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.hwa.domain.Course;
import com.qa.hwa.domain.User;
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
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();	
		}
	
	@Test
	public void getOneTest() {
		Long courseId = 1L;
		Course course = new Course(1l, "Project Management", "This course is all the basics of project management. Beginner to Professional!");
		Course output = new Course(1l, "Project Management", "This course is all the basics of project management. Beginner to Professional!");

		Mockito.when(this.repo.findById(courseId)).thenReturn(Optional.of(output));

		assertEquals(output, this.service.getById(courseId));
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);

	}
	
	@Test
	public void updateTest() {
		Long courseId = 1L;
		
		Course oldCourse = new Course(1l, "Project Management", "This course is all the basics of project management. Beginner to Professional!");
		Course newCourse = new Course(2l, "Time Management", "This course is all on time management for dummies!");
		
		Mockito.when(this.repo.findById(courseId)).thenReturn(Optional.of(oldCourse));
		Mockito.when(this.repo.saveAndFlush(oldCourse)).thenReturn(newCourse);
		
	assertEquals(oldCourse, this.service.update(courseId, newCourse));
	Mockito.verify(this.repo, Mockito.times(1)).findById(courseId);
	Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(oldCourse);
	
	}
	
	@Test
	public void deleteTest() {
		Long courseId = 1l;
		boolean deleted = true;
		
		Mockito.when(this.service.delete(courseId)).thenReturn(deleted);
		assertEquals(deleted, this.repo.existsById(courseId));
	}

}
