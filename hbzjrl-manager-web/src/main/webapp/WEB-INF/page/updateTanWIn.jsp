<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

    alert( document.getElementById('user_id').value());
</script>
<!-- 模态框 -->
<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <table class="table">
                <thead>
                <!-- 模态框头部 -->
                <div class="modal-header">
                    <h4 class="modal-title">user_id</h4>
                    <input type="text" readonly class="form-control-plaintext text-danger" value="${ygPojo.name}" >

                    </label>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                </thead>
                <!-- 模态框内容 -->
                <div class="modal-body">
                    <tr>
                        <td> ID</td>${ygPojo.user_id}
                    </tr>
                    <tr>
                        <td> 渠道
                        </td>
                    </tr>
                    <tr>
                        <td> 姓名</td>
                    </tr>
                    <tr>
                        <td>年龄</td>
                    </tr>
                    <tr>
                        <td>性别</td>
                    </tr>
                    <tr>
                        <td> 身份证号</td>
                    </tr>
                    <tr>
                        <td> 手机</td>
                    </tr>
                    <tr>
                        <td> 出发日期</td>
                    </tr>
                    <tr>
                        <td> 住址</td>
                    </tr>
                    <tr>
                        <td> 企业</td>
                    </tr>
                    <tr>
                        <td> 合同日期</td>
                    </tr>
                    <tr>
                        <td> 发车</td>
                    </tr>
                    <tr>
                        <td> 发车补助</td>
                    </tr>
                    <tr>
                        <td> 员工单价</td>
                    </tr>
                    <tr>
                        <td> 员工备注</td>
                    </tr>
                    <tr>
                        <td> 代理</td>
                    </tr>
                    <tr>
                        <td> 代理单价</td>
                    </tr>
                    <tr>
                        <td> 代理备注</td>
                    </tr>
                    <tr>
                        <td> 总价</td>
                    </tr>
                </div>
                <tr>
                    <td>   <!-- 模态框底部 -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">关闭</button>
                            <button type="submit" class="btn btn-primary">更新</button>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>