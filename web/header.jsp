<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<head>
    <meta charset="utf-8">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://?ile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function isValidate(form) {
            var username=document.getElementById("username").value;
            var userpass=document.getElementById("userpassword").value;
            var userpass1=document.getElementById("userpass1").value;
            user.Identity=$('input:radio[name="Identity"]:checked').val();
            if(userpass != userpass1){
                alert("两次输入的密码不一致，请重新输入！");
                return false;
            }else if(userpass.length<=0 || username.length<=0) {
                alert("用户名以及密码不能为空，请重新输入！");
                return false;
            }else{
                return true;
            }

        }</script>
</head>
<div class="top-header-bar">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12 col-lg-6 d-none d-md-flex flex-wrap justify-content-center justify-content-lg-start mb-3 mb-lg-0">
                    <div class="header-bar-email d-flex align-items-center">
                        <a href="admin-login.jsp"><i class="fa fa-apple"></i></a>
                    </div><!-- .header-bar-email -->

                    <div class="header-bar-text lg-flex align-items-center">
                        <p><i class="fa fa-phone"></i>111-2222-3333 </p>
                    </div><!-- .header-bar-text -->
                </div><!-- .col -->

                <div class="col-12 col-lg-6 d-flex flex-wrap justify-content-center justify-content-lg-end align-items-center">
                    <div class="header-bar-search">
                        <form action="selectCourse" class="flex align-items-stretch" method="post">
                            <input type="search" placeholder="What would you like to learn?" name="str">
                            <button type="submit" class="flex justify-content-center align-items-center"><i class="fa fa-search"></i></button>
                        </form>
                    </div><!-- .header-bar-search -->

                    <div class="header-bar-menu">
                        <s:if test="#session.user == null">
                            <ul class="flex justify-content-center align-items-center py-2 pt-md-0">
                                <li><a href="#" data-toggle="modal" data-target="#myModal">Login</a></li>
                                <div class="modal fade" id="myModal">
                                    <div class="modal-dialog modal-sm">
                                        <div class="modal-content">
                                            <!-- 模态框头部 -->
                                            <div class="modal-header">
                                                <h2 class="modal-title">请登录</h2>
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            </div>
                                            <!-- 模态框主体 -->
                                            <div class="modal-body">
                                                <div id="form-login">
                                                    <form action="logincheck" method="post">

                                                        <label class="login-lable">用户名：</label>
                                                        <div class="input-group input-group-sm">
                                                            <input type="text" class="form-control" name="user.User_Name" placeholder="Username">
                                                        </div>
                                                        <br />
                                                        <label class="login-lable">密码：</label>
                                                        <div class="input-group input-group-sm">
                                                            <input type="password" class="form-control" name="user.User_Password" placeholder="Password">
                                                        </div>
                                                        <br />
                                                        <div class="modal-footer">
                                                            <input class="btn btn-primary" id="login-btn" type="submit" value="登录">
                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                                        </div>
                                                    </form>
                                                </div><!-- #form-login -->
                                            </div>

                                        </div>
                                    </div>
                                </div>
<%--                                <li><a href="register.jsp">Register</a></li>--%>
<%--                                <li><a href="register.jsp">Register</a></li>--%>
                                <li><a href="#" data-toggle="modal" data-target="#myModal2">Register</a></li>
                                <!-- 模态框 -->
                                <div class="modal fade" id="myModal2">
                                    <div class="modal-dialog modal-sm">
                                        <div class="modal-content">
                                            <!-- 模态框头部 -->
                                            <div class="modal-header">
                                                <h2 class="modal-title">请注册</h2>
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            </div>
                                            <!-- 模态框主体 -->
                                            <div class="modal-body">
                                                <div id="form-register">
                                                    <form action="register" name="register" method="post" onsubmit="return isValidate()" >
                                                        <label class="register-lable">用户名：</label>
                                                        <div class="input-group input-group-sm">
                                                            <input type="text" class="form-control" name="user.User_Name" id="username" placeholder="Username">
                                                        </div>
                                                        <br />
                                                        <label class="register-lable">设置密码：</label>
                                                        <div class="input-group input-group-sm">
                                                            <input type="password" class="form-control" name="user.User_Password" id="userpassword" placeholder="Password">
                                                        </div>
                                                        <br />
                                                        <label class="register-lable">确认密码：</label>
                                                        <div class="input-group input-group-sm">
                                                            <input type="password" class="form-control" name="userpass1" id="userpass1" placeholder="Password">
                                                        </div>
                                                        <br />

                                                        <label class="radio-inline"><input type="radio" name="user.User_Identity" value="1" checked>学生&nbsp&nbsp&nbsp</label>
                                                        <label class="radio-inline"><input type="radio" name="user.User_Identity" value="2">教师</label>

                                                        <div class="modal-footer">
                                                            <input class="btn btn-primary" id="register-btn" type="submit" value="注册">

                                                            <input class="btn btn-secondary" id="reset-btn" type="reset" value="重置">
                                                        </div>

                                                    </form>
                                                </div><!-- #form-login -->
                                            </div><!-- .hero-content-wrap -->
                                        </div>
                                    </div>
                                </div>

                            </ul>
                        </s:if>
                        <s:else>
                            <ul class="flex justify-content-center align-items-center py-2 pt-md-0">
                                <li>Welcome!</li>
                                <li><a href=getcourselist?u2_id=<s:property value="#session.user.User_id"/>><s:property value="#session.user.User_Name"/></a></li>
                            </ul>
                        </s:else>
                    </div><!-- .header-bar-menu -->
                </div><!-- .col -->
            </div><!-- .row -->
        </div><!-- .container-fluid -->
    </div><!-- .top-header-bar -->

