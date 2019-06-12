<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>课程管理</title>

    <!-- Required meta tags -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- FontAwesome CSS -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- ElegantFonts CSS -->
    <link rel="stylesheet" href="css/elegant-fonts.css">

    <!-- themify-icons CSS -->
    <link rel="stylesheet" href="css/themify-icons.css">

    <!-- Swiper CSS -->
    <link rel="stylesheet" href="css/swiper.min.css">

    <!-- Styles -->
    <link rel="stylesheet" href="style.css">

    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $("#course-img-modify").change(function () {
                var fil = this.files;
                console.log(fil.length);
                for (var i = 0; i < fil.length; i++) {
                    console.log(fil[i]);
                    console.log('--------------------------');
                    reads(fil[i]);
                }
            });
        });

        function reads(fil){
            var reader = new FileReader();
            reader.readAsDataURL(fil);
            reader.onload = function(){
                $('#c-img').attr('src',reader.result);
            };
        }

        function resetImg(){
            $('#c-img').attr('src','#');
        }
    </script>
</head>
<body class="single-courses-page">
<div class="page-header">
    <header class="site-header">

        <%@ include file="header.jsp" %>

        <div class="nav-bar">
            <div class="container">
                <div class="row">
                    <div class="col-9 col-lg-3">
                        <div class="site-branding">
                            <h1 class="site-title"><a href="index.jsp" rel="home">Sdr<span>b</span></a></h1>
                        </div><!-- .site-branding -->
                    </div><!-- .col -->

                    <div class="col-3 col-lg-9 flex justify-content-end align-content-center">
                        <nav class="site-navigation flex justify-content-end align-items-center">
                            <ul class="flex flex-column flex-lg-row justify-content-lg-end align-content-center">
                                <li><a href="index.jsp">Home</a></li>
                                <li><a href="about.jsp">About</a></li>
                                <li><a href="courses.jsp">Courses</a></li>
                                <li><a href="https://weibo.com/u/5966988917?is_all=1">weibo</a></li>
                            </ul>

                            <div class="hamburger-menu d-lg-none">
                                <span></span>
                                <span></span>
                                <span></span>
                                <span></span>
                            </div><!-- .hamburger-menu -->

                            <div class="header-bar-cart">
                                <a href="#" class="flex justify-content-center align-items-center"><span aria-hidden="true" class="icon_bag_alt"></span></a>
                            </div><!-- .header-bar-search -->
                        </nav><!-- .site-navigation -->
                    </div><!-- .col -->
                </div><!-- .row -->
            </div><!-- .container -->
        </div><!-- .nav-bar -->
    </header><!-- .site-header -->

    <div class="page-header-overlay">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <header class="entry-header">
                        <h1 class="entry-title">The Unreal Engine Developer Course Learn C++ & Make Games</h1><!-- 课程名称 -->
                        <div class="ratings flex justify-content-center align-items-center">
                            <a href="#" data-toggle="modal" data-target="#modifyCourseName"><span style="color: white">更改课程名</span></a>
                        </div>
                        <!-- 课程名修改框 -->
                        <div class="modal fade" style="margin-top: 10%" id="modifyCourseName">
                            <div class="modal-dialog">
                                <div class="modal-content">

                                    <!-- 模态框头部 -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">修改课程名</h4>
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>

                                    <!-- 模态框主体 -->
                                    <div class="modal-body">
                                        <form action="#" method="post" role="form">
                                            <div class="form-group">
                                                <input type="text" class="form-control" placeholder="输入新的课程名">
                                            </div>
                                            <div class="form-group">
                                                <button class='col-sm-2' type="submit" class="btn btn-default" style="background-color: #19c880; color: white;">更改</button>
                                                <button class='col-sm-2' type="reset" class="btn btn-default" style="background-color: white; color: #19c880">重置</button>
                                            </div>
                                        </form>
                                    </div>

                                    <!-- 模态框底部 -->
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </header><!-- .entry-header -->
                </div><!-- .col -->
            </div><!-- .row -->
        </div><!-- .container -->
    </div><!-- .page-header-overlay -->
</div><!-- .page-header -->

<div class="container">
    <div class="row">
        <div class="col-12 offset-lg-1 col-lg-10">
            <div class="featured-image">
                <img src="images/single-course-featured-img.jpg" alt=""><!-- 课程封面 -->

                <div class="course-cost">Free</div>
            </div>
        </div><!-- .col -->
    </div><!-- .row -->

    <div class="row">
        <div class="col-12 offset-lg-1 col-lg-1"></div><!-- .col -->
        <div class="col-12 col-lg-8">
            <div class="single-course-wrap">
                <div class="course-info flex flex-wrap align-items-center">
                    <div class="course-author flex flex-wrap align-items-center mt-3">
                        <img src="images/course-author.jpg" alt="">

                        <div class="author-wrap">
                            <label class="m-0">Teacher</label>
                            <div class="author-name"><a href="#">Ms. Lara Croft</a></div><!-- 教师姓名 -->
                        </div><!-- .author-wrap -->
                    </div><!-- .course-author -->

                    <div class="course-students mt-3">
                        <label class="m-0">Student</label>
                        <div class="author-name"><a href="#">26 (REGISTERED)</a></div><!-- 学生人数 -->
                    </div><!-- .course-students -->

                    <div class="buy-course mt-3">
                        <a class="btn" href="#" data-toggle="modal" data-target="#modifyCourseImage">更改封面</a>
                    </div><!-- .buy-course -->
                    <!-- 封面更改-模态框 -->
                    <div class="modal fade" style="margin-top: 10%" id="modifyCourseImage">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <!-- 模态框头部 -->
                                <div class="modal-header">
                                    <h4 class="modal-title">修改课程封面</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>

                                <!-- 模态框主体 -->
                                <div class="modal-body">
                                    <form action="#" method="post" role="form" enctype="multipart/form-data" >
                                        <div class="form-group">
                                            <input type="file" name="courseImage" id="course-img-modify"/>
                                        </div>
                                        <div class="form-group">
                                            <img class="col-sm-6" id="c-img" src="#">
                                        </div>
                                        <div class="form-group">
                                            <button class='col-sm-2' type="submit" class="btn btn-default" style="background-color: #19c880; color: white;">更改</button>
                                            <button class='col-sm-2' type="reset" onclick="resetImg()" class="btn btn-default" style="background-color: white; color: #19c880">重置</button>
                                        </div>
                                    </form>
                                </div>

                                <!-- 模态框底部 -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                </div>

                            </div>
                        </div>
                </div><!-- .course-info -->

                <div class="single-course-cont-section">
                    <a href="#" data-toggle="modal" data-target="#modifyCourseIntro"><h2>课程介绍</h2></a>

                    <p>面向领域实践1的课程介绍</p><!-- 课程介绍 -->

                    <div class="single-course-accordion-cont mt-3">
                        <header class="entry-header flex flex-wrap justify-content-between align-items-center">
                            <h2>章节管理</h2>
                            <div>
                                <a href="#" data-toggle="modal" data-target="#addChapter"><span>添加章节</span></a>
                            </div>
                        </header><!-- .entry-header -->

                        <div class="modal fade" style="margin-top: 8%" id="addChapter">
                            <div class="modal-dialog">
                                <div class="modal-content">

                                    <!-- 模态框头部 -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">添加章节</h4>
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>

                                    <!-- 模态框主体 -->
                                    <div class="modal-body">
                                        <form action="#" method="post" enctype="multipart/form-data" role="form">
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">章节名称</label>
                                                <div class="col-sm-8">
                                                    <input type="text" name="#" class="form-control" placeholder="请输入课程名称">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label" style="padding-top: 15px">视频</label>
                                                <div class="col-sm-6">
                                                    <input type="file" name="#"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label" style="padding-top: 15px">课件</label>
                                                <div class="col-sm-6">
                                                    <input type="file" name="#"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                    <button class='col-sm-2' type="submit" class="btn btn-default" style="background-color: #19c880; color: white;">添加</button>
                                                    <button class='col-sm-2' type="reset" class="btn btn-default" style="background-color: white; color: #19c880">重置</button>
                                            </div>
                                        </form>
                                    </div>

                                    <!-- 模态框底部 -->
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                    </div>

                                </div>
                            </div>
                        </div>

                        <div class="entry-contents">
                            <div class="accordion-wrap type-accordion">
                                <h3 class="entry-title flex flex-wrap justify-content-between align-items-lg-center active">
                                    <span class="arrow-r"><i class="fa fa-plus"></i><i class="fa fa-minus"></i></span>
                                    <span class="lecture-group-title">章节1</span>
                                </h3>

                                <div class="entry-content">
                                    <ul class="p-0 m-0">
                                        <li class="flex flex-column flex-lg-row align-items-lg-center">
                                            <span class="lecture-title"><a href="#">视频</a></span>
                                            <span class="lectures-preview"></span>
                                            <span>
                                                <a href="#"><button class="btn btn-default" style="cursor:pointer; background-color: #19c880; color: white">更改</button></a>
                                                <a href="#"><button class="btn btn-default" style="cursor:pointer; border-style: solid;border-color: #19c880;margin-left: 5px; background-color: white; color: #19c880">删除</button></a>
                                            </span>
                                        </li>
                                        <li class="flex flex-column flex-lg-row align-items-lg-center">
                                            <span class="lecture-title"><a href="#">课件</a></span>
                                            <span class="lectures-preview"></span>
                                            <span>
                                                <a href="#"><button class="btn btn-default" style="cursor:pointer; background-color: #19c880; color: white">更改</button></a>
                                                <a href="#"><button class="btn btn-default" style="cursor:pointer; border-style: solid;border-color: #19c880;margin-left: 5px; background-color: white; color: #19c880">删除</button></a>
                                            </span>
                                        </li>
                                    </ul>
                                </div>

                                <h3 class="entry-title flex flex-wrap justify-content-between align-items-lg-center active">
                                    <span class="arrow-r"><i class="fa fa-plus"></i><i class="fa fa-minus"></i></span>
                                    <span class="lecture-group-title">章节2</span>
                                </h3>

                                <div class="entry-content">
                                    <ul class="p-0 m-0">
                                        <li class="flex flex-column flex-lg-row align-items-lg-center">
                                            <span class="lecture-title"><a href="#">视频</a></span>
                                            <span class="lectures-preview"></span>
                                            <span>
                                                <a href="#"><button class="btn btn-default" style="cursor:pointer; background-color: #19c880; color: white">更改</button></a>
                                                <a href="#"><button class="btn btn-default" style="cursor:pointer; border-style: solid;border-color: #19c880;margin-left: 5px; background-color: white; color: #19c880">删除</button></a>
                                            </span>
                                        </li>
                                        <li class="flex flex-column flex-lg-row align-items-lg-center">
                                            <span class="lecture-title"><a href="#">课件</a></span>
                                            <span class="lectures-preview"></span>
                                            <span>
                                                <a href="#"><button class="btn btn-default" style="cursor:pointer; background-color: #19c880; color: white">更改</button></a>
                                                <a href="#"><button class="btn btn-default" style="cursor:pointer; border-style: solid;border-color: #19c880;margin-left: 5px; background-color: white; color: #19c880">删除</button></a>
                                            </span>
                                        </li>
                                    </ul>
                                </div>
                                <h3 class="entry-title flex flex-wrap justify-content-between align-items-lg-center active">
                                    <span class="arrow-r"><i class="fa fa-plus"></i><i class="fa fa-minus"></i></span>
                                    <span class="lecture-group-title">章节3</span>
                                </h3>

                                <div class="entry-content">
                                    <ul class="p-0 m-0">
                                        <li class="flex flex-column flex-lg-row align-items-lg-center">
                                            <span class="lecture-title"><a href="#">视频</a></span>
                                            <span class="lectures-preview"></span>
                                            <span>
                                                <a href="#"><button class="btn btn-default" style="cursor:pointer; background-color: #19c880; color: white">更改</button></a>
                                                <a href="#"><button class="btn btn-default" style="cursor:pointer; border-style: solid;border-color: #19c880;margin-left: 5px; background-color: white; color: #19c880">删除</button></a>
                                            </span>
                                        </li>
                                        <li class="flex flex-column flex-lg-row align-items-lg-center">
                                            <span class="lecture-title"><a href="#">课件</a></span>
                                            <span class="lectures-preview"></span>
                                            <span>
                                                <a href="#"><button class="btn btn-default" style="cursor:pointer; background-color: #19c880; color: white">更改</button></a>
                                                <a href="#"><button class="btn btn-default" style="cursor:pointer; border-style: solid;border-color: #19c880;margin-left: 5px; background-color: white; color: #19c880">删除</button></a>
                                            </span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div><!-- .entry-contents -->
                    </div><!-- .single-course-accordion-cont  -->

                    <!-- 课程介绍修改框 -->
                    <div class="modal fade" style="margin-top: 15%" id="modifyCourseIntro">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <!-- 模态框头部 -->
                                <div class="modal-header">
                                    <h4 class="modal-title">修改课程介绍</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>

                                <!-- 模态框主体 -->
                                <div class="modal-body">
                                    <form action="#" method="post" role="form">
                                        <div class="form-group">
                                            <textarea class="form-control" rows="3" placeholder="输入新的课程介绍"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <button class='col-sm-2' type="submit" class="btn btn-default" style="background-color: #19c880; color: white;">更改</button>
                                            <button class='col-sm-2' type="reset" class="btn btn-default" style="background-color: white; color: #19c880">重置</button>
                                        </div>
                                    </form>
                                </div>

                                <!-- 模态框底部 -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                </div>

                            </div>
                        </div>
                    </div>


                <%@ include file="footer.jsp" %>

                    <script type='text/javascript' src='js/jquery.js'></script>
                    <script type='text/javascript' src='js/swiper.min.js'></script>
                    <script type='text/javascript' src='js/masonry.pkgd.min.js'></script>
                    <script type='text/javascript' src='js/jquery.collapsible.min.js'></script>
                    <script type='text/javascript' src='js/custom.js'></script>

</body>
</html>