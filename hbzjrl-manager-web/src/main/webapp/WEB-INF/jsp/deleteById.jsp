<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 模态框 -->
<div class="modal fade" id="myModalDelById">
    <div class="modal-dialog modal-dialog-scrollable">
        <div class="modal-content">
            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">确认要删除</h4>
            </div>
                      <!-- 模态框内容 -->
            <div class="modal-body">
                <input type="text" id="user_id1" name="user_id" placeholder="ID"/>
                <h1> <input type="text" id="name2" name="name" placeholder="姓名"/></h1>
            </div>
            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-bs-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-danger" style="float:right">确认删除</button>
            </div>
        </div>
    </div>
</div>