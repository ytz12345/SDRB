package action;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
//import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import admin.DBadmin;

import dao.ChapterDao;
import model.Chapter;

import java.util.ArrayList;
import java.util.List;


public class ChapterAction extends ActionSupport {
    private Chapter chapter;
    private ChapterDao chapterDao = new ChapterDao();
    private File chapterVideo;
    private String chapterVideoContentType;
    private String chapterVideoFileName;

    private int add_id;

    public String chapterAdd() throws Exception {
        //得到上传文件在服务器的路径加文件名
        //String target = ServletActionContext.getServletContext().getRealPath("/upload"+ courseImageFileName);
        //获得上传的文件
        String chapterUrl = DBadmin.video_upload_location + chapterVideoFileName;
        File targetFile = new File(chapterUrl);
        //通过struts2提供的FileUtils类拷贝
        try {
            FileUtils.copyFile(chapterVideo, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String forward = "failure";
        int flag = 0;

        String videoData = "/SDRB_war_exploded/upload/videos/" + chapterVideoFileName;
        flag = chapterDao.save(chapter, videoData, add_id);
        if(flag == 1) {
            this.setCur_id(add_id);
            forward = "success";//成功注册标记值
        }

        return forward;
    }

    public int cur_id = 0;

    public int getCur_id() {
        return cur_id;
    }

    public void setCur_id(int cur_id) {
        this.cur_id = cur_id;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapterVideo(File chapterVideo) {
        this.chapterVideo = chapterVideo;
    }

    public File getChapterVideo() {
        return chapterVideo;
    }

    public void setChapterVideoContentType(String chapterVideoContentType) {
        this.chapterVideoContentType = chapterVideoContentType;
    }

    public String getChapterVideoContentType() {
        return chapterVideoContentType;
    }

    public void setChapterVideoFileName(String chapterVideoFileName) {
        this.chapterVideoFileName = chapterVideoFileName;
    }

    public String getChapterVideoFileName() {
        return chapterVideoFileName;
    }

    public void setAdd_id(int add_id) {
        this.add_id = add_id;
    }

    public int getAdd_id() {
        return add_id;
    }
}


