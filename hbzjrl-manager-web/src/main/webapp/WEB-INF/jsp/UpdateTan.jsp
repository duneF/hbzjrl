<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 模态框 -->
<div class="modal" id="myModal"  >
    <div class="modal-dialog modal-dialog-scrollable">
        <div class="modal-content">
            <table class="table  text-nowrap" >
                                          <!-- 模态框内容 -->
                <div class="modal-body">
                    <tr>
                        <th><input type="text" id="name" readonly/>ID<input type="text"  id="user_id" readonly/></th>
                    </tr>
                    <tr>
                        <th>渠道&nbsp&nbsp&nbsp&nbsp<input type="text"  id="whereHome"/></th>
                    </tr>
                    <tr>
                        <th>年龄&nbsp&nbsp&nbsp&nbsp<input type="text"  id="age"/></th>
                    </tr>
                    <tr>
                        <th>性别&nbsp&nbsp&nbsp&nbsp<input type="text"  id="sex"/></th><td></td>
                    </tr>
                    <tr>
                        <th>身份证号<input type="text"  id="sfNumber"/></th>
                    </tr>
                    <tr>
                        <th>手机&nbsp&nbsp&nbsp&nbsp<input type="text"  id="phone"/></th>
                    </tr>
                    <tr>
                        <th>出发日期<input type="text"  id="goTime"/></th>
                    </tr>
                    <tr>
                        <th>住址&nbsp&nbsp&nbsp&nbsp<input type="text"  id="address"/></th>
                    </tr>
                    <tr>
                        <th>企业&nbsp&nbsp&nbsp&nbsp<input type="text"  id="factory"/></th>
                    </tr>
                    <tr>
                        <th>合同日期<input type="text"  id="workTime"/></th>
                    </tr>
                    <tr>
                        <th>发车&nbsp&nbsp&nbsp&nbsp<input type="text"  id="byCar"/></th>
                    </tr>
                    <tr>
                        <th>发车补助<input type="text"  id="workerCarPrice"/></th>
                    </tr>
                    <tr>
                        <th>员工单价<input type="text"  id="workerPrice"/></th>
                    </tr>
                    <tr>
                        <th>员工备注<input type="text"  id="wokerRemarks"/></th>
                    </tr>
                    <tr>
                        <th>代理&nbsp&nbsp&nbsp&nbsp<input type="text"  id="whose"/></th>
                    </tr>
                    <tr>
                        <th>代理单价<input type="text"  id="whosePrice"/></th>
                    </tr>
                    <tr>
                        <th>代理备注<input type="text"  id="whoseRemarks"/></th>
                    </tr>
                    <tr>
                        <th>总价&nbsp&nbsp&nbsp&nbsp<input type="text"  id="totalPrice"/></th>
                    </tr>
                    <tr>
                        <th>创建时间<input type="text"  id="createTime" readonly/>更新<input type="text"  id="update" readonly/></th>
                    </tr>
                    <tr>
                        <th>
                            <button type="submit" class="btn btn-primary" style="float:right">更新</button>
                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal" style="float:right">关闭</button>
                        </th>
                    </tr>
                </div>
            </table>
        </div>
    </div>
</div>