<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>张杰人力内部后台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/stvle.css">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css" rel="stylesheet"/>
    <script type="text/javascript" src="https://cdn.staticfile.org/jquery/3.6.0/jquery.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>
</head>
<script type="text/javascript">
    $(document).ready(function () {
        var time = new Date();
        var day = ("0" + (time.getDate() + 1)).slice(-2);
        var month = ("0" + (time.getMonth() + 1)).slice(-2);
        var today = time.getFullYear() + "-" + (month) + "-" + (day);
        $('#date_info').val(today);
    });

    $(function(){
        //图片被点击后拉起文件选择框
        $('#imgBtn').click(function(){
            $('#currImg').click();
        });
        //选取文件后回显当前显示图片
        $('#currImg').change(function(e){
            //当前选择的文件
            var currImg = e.target.files[0];
            //生成一个图片路径(使用URL.createObjectURL将选择的图片生成一个路径)
            var imgSrc = URL.createObjectURL(currImg);
            //更换原图片路径，回显图片
            $('#imgBtn').attr('src',imgSrc);
        });
    })
</script>
<body>
<nav class="menu-wrap">
    <div class="menu">
        <ul>
            <li>
                <a href="/ygShowAll">
                    <i class="fa fa-home fa-lg"></i>
                    <span class="nav-text">首页</span>
                </a>
            </li>
            <li>
                <a href="">
                    <i class="fa fa-user fa-lg"></i>
                    <span class="nav-text">登录</span>
                </a>
            </li>
            <li>
                <a href=" ">
                    <i class="fa fa-envelope-o fa-lg"></i>
                    <span class="nav-text">联系</span>
                </a>
            </li>
            <li>
                <a href=" ">
                    <i class="fa fa-heart-o fa-lg"></i>
                    <span class="nav-text">收藏</span>
                </a>
            </li>
            <li></li>
            <li></li>
            <li>
                <span class="nav-text"><h1>共${count}人</h1></span>
            </li>
            <%-- 吗不够再加li--%>
        </ul>
    </div>
</nav>
<header>
    <div class="px-3 py-2 border-bottom mb-3">
        <div>
           <span style="float: right">
               <button onClick="window.location.href='/tiaoZhuanYgAddShouDong'"
                       class="btn btn-primary">手动添加员工信息</button>
           </span>
        </div>
    </div>
</header>
<style type="text/css">
    body {
        background: #ced4da;
    }

    * {
        margin: 0;
        padding: 0;
    }

    div.add {
        /*width: 100px;*/
        /*height: 100px;*/
        position: fixed;
        top: 6%;
        left: 60%;
    }
    div.addHuiXian{
        position: fixed;
        top: 6%;
        left: 20%;
    }
</style>
<div class="addHuiXian">
        <!-- 文件选择框 默认关闭 点击图片后调出 -->
        <input type="file" name="currImg" id="currImg" style="display: none;"/>
</div>
<div class="add">
    <form>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>身份证添加员工</th>

            </tr>
            </thead>
            <tbody>
            <tr>
                <td colspan="2">
                    <div class="addHuiXian">
                        <!-- 把图片当作按钮，点击后调出文件选择框 -->
                        <img id="imgBtn" src="img/2.jpg"  width="500px" height="auto" style="margin-top:1vh ;"  >
                    </div>

                </td>
</tr>
<tr>
    <td>渠道</td>
    <td><input name="" id="" value="张杰人力"/></td>
</tr>
<tr>
    <td>手机</td>
    <td><input name="" id="" placeholder="手机号"/></td>
</tr>
<%-- 默认取第二天的值--%>
<tr>
    <td>出发日期</td>
    <td>
        <input name="" id="date_info" type="date"/>
    </td>
</tr>
<tr>
    <td>企业</td>
    <td><input name="" id="" placeholder="工厂名字"/></td>
</tr>
<tr>
    <td>合同日期</td>
    <td>
        <select>
            <option value="长期">长期</option>
            <option value="1个月">1个月</option>
            <option value="2个月">2个月</option>
            <option selected="selected" value="3个月">3个月</option>
            <option value="6个月">6个月</option>
            <option value="15天">15天</option>
        </select>
    </td>
</tr>
<tr>
    <td>发车</td>
    <td><input name="" id="" value="自发出"/></td>
</tr>
<tr>
    <td>发车补助</td>
    <td><input name="" id="" value="0.0"/></td>
</tr>
<tr>
    <td>员工单价</td>
    <td><input name="" id="" placeholder="员工单价"/></td>
</tr>
<tr>
    <td>员工备注</td>
    <td><input name="" id="" value="无"/></td>
</tr>
<tr>
    <td>代理</td>
    <td><input name="" id="" placeholder="哪个代理" value="直招"/></td>
</tr>
<tr>
    <td>代理单价</td>
    <td><input name="" id="" placeholder="代理单价/总利润"/></td>
</tr>
<tr>
    <td>代理备注</td>
    <td><input name="" id="" value="无"/></td>
</tr>
<tr>
    <td>总价</td>
    <td><input name="" id="" placeholder="输入总价/总利润"/></td>
</tr>
</tbody>

<tfoot>
<th>
    <button type="reset" id="reset" class="btn btn-sm btn-danger" style="float: left">重写</button>
</th>
<th>
    <button type="submit" class="btn btn-success" style="float:right">提交</button>
</th>
</tfoot>
</table>

</form>
</div>
</body>
</html>