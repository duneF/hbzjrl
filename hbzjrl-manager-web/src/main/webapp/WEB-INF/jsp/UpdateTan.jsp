<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- 模态框 -->
<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <table class="table  text-nowrap" >
                <thead>
                <!-- 模态框头部 -->
                <div class="modal-header">
<%--                    <h4 class="modal-title"><input type="text"  readonly  id="name"  disabled="disabled"></h4>--%>
                    <h4 class="modal-title"><input type="text"  readonly  id="name"/></h4>

                    </label>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                </thead>
                <!-- 模态框内容 -->
                <div class="modal-body">
                    <tr>
                        <td> ID <input type="text"  id="user_id" readonly /></td>
                    </tr>
                    <tr>
                        <td> 渠道<input type="text"  id="whereHome"/>
                        </td>
                    </tr>
                    <tr>
                        <td>年龄<input type="text"  id="age"/></td>
                    </tr>
                    <tr>
                        <td>性别<input type="text"  id="sex"/></td><td></td>
                    </tr>
                    <tr>
                        <td> 身份证号<input type="text"  id="sfNumber"/></td>
                    </tr>
                    <tr>
                        <td> 手机<input type="text"  id="phone"/></td>
                    </tr>
                    <tr>
                        <td> 出发日期<input type="text"  id="goTime"/></td>
                    </tr>
                    <tr>
                        <td> 住址<input type="text"  id="address"/></td>
                    </tr>
                    <tr>
                        <td> 企业<input type="text"  id="factory"/></td>
                    </tr>
                    <tr>
                        <td> 合同日期<input type="text"  id="workTime"/></td>
                    </tr>
                    <tr>
                        <td> 发车<input type="text"  id="byCar"/></td>
                    </tr>
                    <tr>
                        <td> 发车补助<input type="text"  id="workerCarPrice"/></td>
                    </tr>
                    <tr>
                        <td> 员工单价<input type="text"  id="workerPrice"/></td>
                    </tr>
                    <tr>
                        <td> 员工备注<input type="text"  id="wokerRemarks"/></td>
                    </tr>
                    <tr>
                        <td> 代理<input type="text"  id="whose"/></td>
                    </tr>
                    <tr>
                        <td> 代理单价<input type="text"  id="whosePrice"/></td>
                    </tr>
                    <tr>
                        <td> 代理备注<input type="text"  id="whoseRemarks"/></td>
                    </tr>
                    <tr>
                        <td> 总价<input type="text"  id="totalPrice"/></td>
                    </tr>
                    <tr>
                        <td> 创建时间<input type="text"  id="createTime"/>更新<input type="text"  id="update"/></td>
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