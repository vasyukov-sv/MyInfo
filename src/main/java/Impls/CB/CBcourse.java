package Impls.CB;

import java.util.Collection;

/**
 * Created by sbt-vasyukov-sv on 01.02.2017.
 * CBcourse conveyor
 */
public class CBcourse implements Interface.CBcourse {
    private Collection<Course> courseList;

    public CBcourse(Collection<Course> courseList) {
        this.courseList = courseList;
    }

    public CBcourse() {
    }

    public void setCourseList(Collection<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String get() {
        String courseString = null;
        for (Course course : courseList){
            course.load();
            courseString+= course.toString();
        }
        return courseString;
    }
}