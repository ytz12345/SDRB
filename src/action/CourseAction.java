package action;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
//import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.CourseDao;
import model.Course;
import admin.DBadmin;

import java.util.ArrayList;
import java.util.List;

/*课程创建Action*/

public class CourseAction extends ActionSupport {
    private Course course;
    private CourseDao courseDao = new CourseDao();
    private File courseImage;
    private String courseImageContentType;
    private String courseImageFileName;

    public String courseCreate() throws Exception {
        //得到上传文件在服务器的路径加文件名
        //String target = ServletActionContext.getServletContext().getRealPath("/upload"+ courseImageFileName);
        //获得上传的文件
        String courseImageUrl = DBadmin.course_upload_location + courseImageFileName;
        File targetFile = new File(courseImageUrl);
        //通过struts2提供的FileUtils类拷贝
        try {
            FileUtils.copyFile(courseImage, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String forward = "error";//数据库存数据时出错标记值
        int flag = 0;

        flag = courseDao.save(course, courseImageUrl);
            if(flag == 1) {
                forward = "success";//成功注册标记值
            }

            return forward;
    }

    public List<Course> coursesList;
    public void setList(List<Course> list) {
        this.coursesList = list;
    }
    public List<Course> getList() {
        return coursesList;
    }

    public String coursesDisplay() throws Exception {
        String forward = "failure";

        List<Course> templist=new ArrayList<Course>();

        try {
            templist = courseDao.displayCourses();
            this.setList(templist);
            forward = "success";
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return forward;
    }

    private int c_id = 0;

    public String coursePass() throws Exception {
        String forward = "failure";
        int flag = 0;

        flag = courseDao.passCourse(c_id);
        if(flag == 1){
            forward = "success";
        }
        return forward;
    }

    public String courseDontPass() throws Exception {
        String forward = "failure";
        int flag = 0;

        flag = courseDao.dontPassCourse(c_id);
        if(flag == 1){
            forward = "success";
        }
        return forward;
    }

    public String courseDelete() throws Exception {
        String forward = "failure";
        int flag = 0;

        flag = courseDao.deleteCourse(c_id);
        if(flag == 1){
            forward = "success";
        }
        return forward;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getC_id() {
        return c_id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public File getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(File courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseImageContentType() {
        return courseImageContentType;
    }

    public void setCourseImageContentType(String courseImageContentType) {
        this.courseImageContentType = courseImageContentType;
    }

    public String getCourseImageFileName(){
        return courseImageFileName;
    }

    public void setCourseImageFileName(String courseImageFileName) {
        this.courseImageFileName = courseImageFileName;
    }


}


