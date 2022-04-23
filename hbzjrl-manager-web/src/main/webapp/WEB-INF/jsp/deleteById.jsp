<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 模态框 -->
<div class="modal fade" id="myModalDelete">
    <div class="modal-dialog modal-dialog-scrollable">
        <div class="modal-content">
            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">确认要删除</h4>
            </div>
                      <!-- 模态框内容 -->
            <div class="modal-body">
                 <h1> <input type="text" id="name" placeholder="姓名"/></h1>
                <table  class="table  text-nowrap" >
                    <tr>
                        <th>
                            <input type="text" id="user_id" placeholder="ID"/>
                        </th>
                    </tr>
                </table>
            </div>
            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-bs-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-danger" style="float:right">确认删除</button>
            </div>
        </div>
    </div>
</div>