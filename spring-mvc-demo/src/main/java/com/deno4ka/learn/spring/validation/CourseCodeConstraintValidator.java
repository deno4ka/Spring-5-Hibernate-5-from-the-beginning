package com.deno4ka.learn.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

   private String coursePrefix;

   public void initialize(CourseCode theCourseCode) {
      this.coursePrefix = theCourseCode.value();
   }

   public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
      return theCode.startsWith(coursePrefix);
   }

}
