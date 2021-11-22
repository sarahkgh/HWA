package com.qa.hwa.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "This coursename has already been taken")
		
		public class CourseNameTakenException extends EntityNotFoundException {

}
