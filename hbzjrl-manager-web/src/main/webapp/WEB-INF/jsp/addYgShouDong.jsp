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
<script>
    $(document).ready(function () {
        var stime = new Date();
        var sday = ("0" + (stime.getDate() + 1)).slice(-2);
        var sday1 = ("0" + stime.getDate()).slice(-2);
        var smonth = ("0" + (stime.getMonth() + 1)).slice(-2);
        var stoday = stime.getFullYear() + "-" + (smonth) + "-" + (sday);

        if (stoday==stime.getFullYear()+'-01-32'){
            stoday=stime.getFullYear()+'-02-01'
        }else if (stime.getFullYear() % 4==0&&stoday==stime.getFullYear()+'-02-30'){
            stoday=stime.getFullYear()+'-03-01'
        } else if (stime.getFullYear() % 4==1&&stoday==stime.getFullYear()+'-02-29'){
            stoday=stime.getFullYear()+'-03-01'
        }else if (stoday==stime.getFullYear()+'-03-32'){
            stoday=stime.getFullYear()+'-04-01'
        }else if (stoday==stime.getFullYear()+'-04-31'){
            stoday=stime.getFullYear()+'-05-01'
        }else if (stoday==stime.getFullYear()+'-05-32'){
            stoday=stime.getFullYear()+'-06-01'
        }else if (stoday==stime.getFullYear()+'-06-31'){
            stoday=stime.getFullYear()+'-07-01'
        }else if (stoday==stime.getFullYear()+'-07-32'){
            stoday=stime.getFullYear()+'-08-01'
        }else if (stoday==stime.getFullYear()+'-08-32'){
            stoday=stime.getFullYear()+'-09-01'
        }else if (stoday==stime.getFullYear()+'-09-31'){
            stoday=stime.getFullYear()+'-10-01'
        }else if (stoday==stime.getFullYear()+'-10-32'){
            stoday=stime.getFullYear()+'-11-01'
        }else if (stoday==stime.getFullYear()+'-11-31'){
            stoday=stime.getFullYear()+'-12-01'
        }else if (stoday==stime.getFullYear()+'-12-32'){
            stoday=(stoday==(stime.getFullYear()+1)+'-01-01')
        }
        $('#goTime').val(stoday);

        var createTimeToday = stime.getFullYear() + "-" + (smonth) + "-" + (sday1);
        $('#createTime').val(createTimeToday);
    })
</script>
<body>
<nav class="menu-wrap">
    <div class="menu">
        <ul>
            <li>
                <a href="/ygShowAll" >
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
           <span style="float: right"><button onClick="window.location.href='/tiaoZhuanYgAddJsp'"
                                              class="btn btn-primary">通过身份证添加</button></span>
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
        left: 40%;
    }

</style>
<div class="add">
    <form action="/addYgShouDong" method="post">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>手动添加员工</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>渠道</td>
                <td><input id="whereHome" name="whereHome" placeholder="" value="张杰人力"/></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input id="name" name="name" placeholder="姓名"/></td>
            </tr>
            <tr>
                <td>身份证号</td>
                <td><input id="sfNumber" name="sfNumber" minlength="15" maxlength="18" placeholder="身份证号18或15位"/></td>
            </tr>
            <tr>
                <td>住址</td>
                <td><input id="address" name="address" placeholder="住址"/></td>
            </tr>
            <tr>
                <td>手机</td>
                <td><input id="phone" name="phone" placeholder="手机号"/></td>
            </tr>
            <%-- 默认取第二天的值--%>
            <tr>
                <td>出发日期</td>
                <td>
                    <input id="goTime" name="goTime" type="date"/>
                </td>
            </tr>
            <tr>
                <td>企业</td>
                <td><input id="factory" name="factory" placeholder="企业名称"/></td>
            </tr>
            <tr>
                <td>合同日期</td>
                <td>
                    <select class="form-select" id="sel1" name="workTime">
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
                <td><input id="byCar" name="byCar" value="自发车"/></td>
            </tr>
            <tr>
                <td>发车补助</td>
                <td><input id="workerCarPrice" name="workerCarPrice" value="0.0"/></td>
            </tr>
            <tr>
                <td>员工单价</td>
                <td><input id="workerPrice" name="workerPrice" placeholder="员工单价"/></td>
            </tr>
            <tr>
                <td>员工备注</td>
                <td><input id="wokerRemarks" name="wokerRemarks" value="无"/></td>
            </tr>
            <tr>
                <td>代理</td>
                <td><input id="whose" name="whose" placeholder="哪个代理" value="直招"/></td>
            </tr>
            <tr>
                <td>代理单价</td>
                <td><input id="whosePrice" name="whosePrice" placeholder="代理单价/总利润" value="0.0"/></td>
            </tr>
            <tr>
                <td>代理备注</td>
                <td><input id="whoseRemarks" name="whoseRemarks" value="无"/></td>
            </tr>
            <tr>
                <td>总价</td>
                <td><input id="totalPrice" name="totalPrice" placeholder="每小时总价/总利润"/></td>
            </tr>
            <tr>
                <td>登记时间</td>
                <td><input id="createTime" name="createTime" type="date"/></td>
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