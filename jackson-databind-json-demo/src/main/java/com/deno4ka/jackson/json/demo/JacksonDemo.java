package com.deno4ka.jackson.json.demo;

import com.deno4ka.jackson.json.demo.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JacksonDemo {

    public static void main( String[] args )
    {
        try {
            System.out.println( "Hello World!" );
            ObjectMapper objectMapper = new ObjectMapper();
            Student student = objectMapper.readValue(new File("jackson-databind-json-demo/src/main/resources/json/sample-lite.json"), Student.class);
            System.out.println("First name = " + student.getFirstName());
            System.out.println("Last name = " + student.getLastName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
