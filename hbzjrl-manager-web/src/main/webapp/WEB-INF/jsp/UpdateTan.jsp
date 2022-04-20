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
                        <th><input type="text" id="name" name="name" placeholder="姓名"/>ID<input type="text"  id="user_id" name="user_id" readonly/></th>
                    </tr>
                    <tr>
                        <th>渠道&nbsp&nbsp&nbsp&nbsp<input type="text"  id="whereHome" name="whereHome" placeholder="渠道"/></th>
                    </tr>
                    <tr>
                        <th>年龄&nbsp&nbsp&nbsp&nbsp<input type="text"  id="age" name="age" placeholder="16"/></th>
                    </tr>
                    <tr>
                        <th>性别&nbsp&nbsp&nbsp&nbsp<input type="text"  id="sex" name="sex" placeholder="男"/></th><td></td>
                    </tr>
                    <tr>
                        <th>身份证号<input type="text"  id="sfNumber" name="sfNumber" placeholder="410"/></th>
                    </tr>
                    <tr>
                        <th>手机&nbsp&nbsp&nbsp&nbsp<input type="text"  id="phone" name="phone" placeholder="138"/></th>
                    </tr>
                    <tr>
                        <th>出发日期<input type="text"  id="goTime" name="goTime" placeholder="2022-2-1"/></th>
                    </tr>
                    <tr>
                        <th>住址&nbsp&nbsp&nbsp&nbsp<input type="text"  id="address" name="address" placeholder="住址"/></th>
                    </tr>
                    <tr>
                        <th>企业&nbsp&nbsp&nbsp&nbsp<input type="text"  id="factory" name="factory" placeholder="企业"/></th>
                    </tr>
                    <tr>
                        <th>合同日期<input type="text"  id="workTime" name="workTime" placeholder="合同日期"/></th>
                    </tr>
                    <tr>
                        <th>发车&nbsp&nbsp&nbsp&nbsp<input type="text"  id="byCar" name="byCar" placeholder="自发车"/></th>
                    </tr>
                    <tr>
                        <th>发车补助<input type="text"  id="workerCarPrice" name="workerCarPrice" placeholder="0.0"/></th>
                    </tr>
                    <tr>
                        <th>员工单价<input type="text"  id="workerPrice" name="workerPrice" placeholder="0.0"/></th>
                    </tr>
                    <tr>
                        <th>员工备注<input type="text"  id="wokerRemarks" name="wokerRemarks" placeholder="员工备注"/></th>
                    </tr>
                    <tr>
                        <th>代理&nbsp&nbsp&nbsp&nbsp<input type="text"  id="whose" name="whose" placeholder="代理"/></th>
                    </tr>
                    <tr>
                        <th>代理单价<input type="text"  id="whosePrice" name="whosePrice" placeholder="0.0"/></th>
                    </tr>
                    <tr>
                        <th>代理备注<input type="text"  id="whoseRemarks" name="whoseRemarks" placeholder="代理备注"/></th>
                    </tr>
                    <tr>
                        <th>总价&nbsp&nbsp&nbsp&nbsp<input type="text"  id="totalPrice" name="totalPrice" placeholder="0.0"/></th>
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