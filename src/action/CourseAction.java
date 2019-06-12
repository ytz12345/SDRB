package action;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
//import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.CourseDao;
import model.Course;
import admin.DBadmin;

/*课程创建Action*/

public class CourseAction extends ActionSupport {
    private Course course;
    private CourseDao courseDao = new CourseDao();
    private int course_id = 0;//用以获取当前课程ID
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
        Course course2 = (courseDao.find(course));
        if(course2 != null) {
            forward = "erroe_user";//课程名已被占用标记值
        }else {
            flag = courseDao.save(course, courseImageUrl);
            if(flag == 1) {
                forward = "success";//成功注册标记值
            }
        }
        return forward;
    }

    private String coursePass() throws Exception {
        String forward = "error";
        int flag = 0;

        flag = courseDao.passCourse(course_id);
        if(flag == 1){
            forward = "success";
        }
        return forward;
    }

    private String courseDelete() throws Exception {
        String forward = "error";
        int flag = 0;

        flag = courseDao.deleteCourse(course_id);
        if(flag == 1){
            forward = "success";
        }
        return forward;
    }

    public int getCourseId() {
        return course_id;
    }

    public void setCourseId(int course_id) {
        this.course_id = course_id;
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


