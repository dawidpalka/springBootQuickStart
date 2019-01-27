package pl.dawidpalka.springbootquickstart.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dawidpalka.springbootquickstart.topic.Topic;

import java.util.List;

@RestController
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        return this.courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id) {
        return this.courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        this.courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        this.courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id) {
        this.courseService.deleteCourse(id);
    }
}
