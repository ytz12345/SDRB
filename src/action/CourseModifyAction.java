package action;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.opensymphony.xwork2.ActionSupport;
import dao.CourseDao;
import model.Course;
import admin.DBadmin;

/*课程创建Action*/

public class CourseModifyAction extends ActionSupport {
    private Course course;
    private CourseDao courseDao = new CourseDao();

    private int modify_id = 0;//课程ID

    private File newCourseImage;//新的封面
    private String newCourseImageContentType;
    private String newCourseImageFileName;
    public String courseImageModify() throws Exception {
        //得到上传文件在服务器的路径加文件名
        //获得上传的文件
        String courseImageUrl = DBadmin.course_upload_location + newCourseImageFileName;
        File targetFile = new File(courseImageUrl);
        //通过struts2提供的FileUtils类拷贝
        try {
            FileUtils.copyFile(newCourseImage, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String forward = "error";//数据库存数据时出错标记值
        int flag = 0;

        flag = courseDao.modifyCourseImage(courseImageUrl,modify_id);
        if(flag == 1){
            forward = "success";
        }

        return forward;
    }

    private String newCourseName;//新的课程名
    public String courseNameModify() throws Exception {
        String forward = "error";//数据库存数据时出错标记值
        int flag = 0;

        flag = courseDao.modifyCourseName(newCourseName,modify_id);
        if(flag == 1){
            forward = "success";
        }

        return forward;
    }

    private String newCourseIntro;//新的课程介绍
    public String courseIntroModify() throws Exception {
        String forward = "error";//数据库存数据时出错标记值
        int flag = 0;

        flag = courseDao.modifyCourseIntro(newCourseIntro,modify_id);
        if(flag == 1){
            forward = "success";
        }

        return forward;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getModify_id() {
        return modify_id;
    }

    public void setModify_id(int modify_id) {
        this.modify_id = modify_id;
    }

    public File getNewCourseImage() {
        return newCourseImage;
    }

    public void setNewCourseImage(File newCourseImage) {
        this.newCourseImage = newCourseImage;
    }

    public String getNewCourseImageContentType() {
        return newCourseImageContentType;
    }

    public void setNewCourseImageContentType(String newCourseImageContentType) {
        this.newCourseImageContentType = newCourseImageContentType;
    }

    public String getNewCourseImageFileName(){
        return newCourseImageFileName;
    }

    public void setNewCourseImageFileName(String newCourseImageFileName) {
        this.newCourseImageFileName = newCourseImageFileName;
    }

    public String getNewCourseName() {
        return newCourseName;
    }

    public void setNewCourseName(String newCourseName) {
        this.newCourseName = newCourseName;
    }

    public String getNewCourseIntro() {
        return newCourseIntro;
    }

    public void setNewCourseIntro(String newCourseIntro) {
        this.newCourseIntro = newCourseIntro;
    }


}


