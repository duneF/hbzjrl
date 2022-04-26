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
<body>
<nav class="menu-wrap">
    <div class="menu">
        <ul>
            <li>
                <a href="">
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
        <div class="container  d-flex flex-wrap justify-content-center">
            <div class="row">
                <form class="well form-search" action="/ygFindByQuDao">
                    <input name="whereHome" type="search" class="input-medium search-query" placeholder="按渠道查询">
                    <button class="btn btn-primary" type="submit"><i class="icon-search"></i>渠道</button>
                </form>
            </div>
            <div class="row">
                <form class="well form-search" action="/ygFindByName" method="post">
                    <input name="name" type="search" class="input-medium search-query" placeholder="按姓名查询">
                    <button class="btn btn-primary" type="submit"><i class="icon-search"></i>姓名</button>
                </form>
            </div>
            <div class="text-end">
                <form class="well form-search" action="/ygFIndByPhone">
                    <input name="phoneToString" type="search" class="input-medium search-query" placeholder="按手机查询">
                    <button class="btn btn-primary" type="submit"><i class="icon-search"></i>手机</button>
                </form>
            </div>
            <div class="text-end">
                <form class="well form-search" action="ygFIndByAddress">
                    <input name="address" type="search" class="input-medium search-query" placeholder="按地址查询">
                    <button class="btn btn-primary" type="submit"><i class="icon-search"></i>地址</button>
                </form>
            </div>
            <div class="text-end">
                <form class="well form-search" action="ygFindByQiYe">
                    <input name="factory" type="search" class="input-medium search-query" placeholder="按企业查询">
                    <button class="btn btn-primary" type="submit"><i class="icon-search"></i>企业</button>
                </form>
            </div>
            &nbsp;<span style="float: right"><button onClick="window.location.href='/tiaoZhuanYgAddJsp'" class="btn btn-success">添加</button></span>
        </div>
    </div>
</header>
<div id="ygListDiv">
    <table class="table  table-hover table-striped table-bordered text-nowrap col-sm table-sm " id="ygList"
           title="员工列表">

        <tr>
            <th data-options="field:'ck',checkbox:true"></th>
            <th>ID</th>
            <th>渠道</th>
            <th>手机</th>
            <th>出发日期</th>
            <th>企业</th>
            <th>合同日期</th>
            <th>发车</th>
            <th>发车补助</th>
            <th>员工单价</th>
            <th>员工备注</th>
            <th>代理</th>
            <th>代理单价</th>
            <th>代理备注</th>
            <th>总价</th>
            <th data-options="align:'center'">创建日期</th>
        </tr>
    </table>
</div>
<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">身份证正面照片:</label>
    <div class="col-sm-10">
        <input type="hidden" name="img"  id="photoUrl"/>
        <input type="file" name="logoFile" id="logoFile" οnchange="setImg(this);">
        <span><img id="photourlShow" src="" width="300" height="197"/></span>
    </div>
</div>
<script>
    //用于进行图片上传，返回地址
    function setImg(obj){undefined
        var f=$(obj).val();
        alert(f);
        console.log(obj);
        if(f == null || f ==undefined || f == ''){undefined
            return false;
        }
        if(!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f))
        {undefined
            alert("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
            $(obj).val('');
            return false;
        }
        var data = new FormData();
        console.log(data);
        $.each($(obj)[0].files,function(i,file){undefined
            data.append('file', file);
        });
        console.log(data);
        $.ajax({undefined
            type: "POST",
            url: GLOBAL_INFO.WEBURL_PREFIX+"business/uploadImg.xhtml",
            data: data,
            cache: false,
            contentType: false,    //不可缺
            processData: false,    //不可缺
            dataType:"json",
            success: function(ret) {undefined
                console.log(ret);
                if(ret.code==0){undefined
                    $("#photoUrl").val(ret.result.url);//将地址存储好
                    $("#photourlShow").attr("src",ret.result.url);//显示图片
                    alertOk(ret.message);
                }else{undefined
                    alertError(ret.message);
                    $("#url").val("");
                    $(obj).val('');
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {undefined
                alert("上传失败，请检查网络后重试");
            }
        });
    }
</script>
</body>
</html>