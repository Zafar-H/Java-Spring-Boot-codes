package com.courseservices.CourseCatalog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CatalogController {

    @RequestMapping("/")
    public String getCatalogHome() {
        String courseAppMessage = "";
        String courseAppURL = "http://localhost:8080/";

        RestTemplate restTemplate = new RestTemplate();
        courseAppMessage = restTemplate.getForObject(courseAppURL,String.class);

        return ("Welcome to zafar's Courses"+courseAppMessage);
    }

    @RequestMapping("/catalog")
    public String getCatalog() {
        String courses = "";
        String courseAppURL = "http://localhost:8080/courses";

        RestTemplate restTemplate = new RestTemplate();
        courses = restTemplate.getForObject(courseAppURL,String.class);

        return ("zafar's Courses"+courses);
    }

    @RequestMapping("/catalogcourse")
    public String getSpecificCourse() {
        Course course = new Course();
        String courseAppURL = "http://localhost:8080/courses/2";

        RestTemplate restTemplate = new RestTemplate();
        course = restTemplate.getForObject(courseAppURL,Course.class);

        return ("zafar's 2nd Course is " +course.getCoursename()+ " And the lecturer will be "+course.getAuthor());
    }
}
