var initTableFun = function (id, columns) {
    //先销毁表格
    $('#' + id).bootstrapTable('destroy');
    //初始化表格,动态从服务器加载数据
    $("#" + id).bootstrapTable({
        method: 'post', // 使用get请求到服务器获取数据
        url: "/zh/user/getAllUserDatas",
        //contentType: "application/json;charset=UTF-8",
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        //ajax:"ajaxRequest",
        //dataType:"json",
        columns: columns,
        sortName: "id",
        //rowStyle:{css:{'background-color': '#02161e','border':'#505050 0.05px solid'}},
        sortOrder: "asc",
        idField: "name",//指定主键列
        striped: false, // 表格显示条纹
        pagination: true, // 启动分页
        pageSize: 15, // 每页显示的记录数
        pageNumber: 1, // 当前第几页
        pageList: [15, 20, 25], // 记录数可选列表
        search: false, // 是否启用查询  客户端搜索，不会进服务端
        showColumns: false, // 显示下拉框勾选要显示的列
        showRefresh: false, // 显示刷新按钮
        clickToSelect: false,// 点击选中
        detailView: false,//是否显示父子表
        sidePagination: "server", // 表示服务端请求
        // 设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
        // 设置为limit可以获取limit, offset, search, sort, order
        queryParamsType: "undefined",
        uniqueId: "id",//指示每行的唯一标识符
        smartDisplay: false,
        formatLoadingMessage: function () {
            return "请稍等，正在加载中...";
        },
        onLoadSuccess: function () {//加载成功时执行

        },
        onExpandRow: function (index, row, $detail) {//点击显示查询子数据
        },
        onLoadError: function () {//加载失败时执行
        },
        onDblClickRow: function (row, $element) {

        }
    });
}
var columns = [
    {
        field: '',
        title: '',
        align: 'center',
        valign: 'middle',
        checkbox:true
    },
    {
        field: 'num',
        title: '序号',
        align: 'center',
        searchable: false,
        formatter: function (value, row, index) {
            var pageSize = $('#userTable').bootstrapTable('getOptions').pageSize;
            var pageNumber = $('#userTable').bootstrapTable('getOptions').pageNumber;
            return pageSize * (pageNumber - 1) + index + 1;
        }
    },
    {
        field: 'id',
        title: 'ID',
        align: 'center',
        valign: 'middle',
        visible: true,
    }, {
        field: 'name',
        title: '姓名',
        align: 'center',
        valign: 'middle',
    },{
        field: 'gender',
        title: '性别',
        align: 'center',
        valign: 'middle',
    },{
        field: 'age',
        title: '年龄',
        align: 'center',
        valign: 'middle',
    },{
        field: 'address',
        title: '地址',
        align: 'center',
        valign: 'middle',
    },{
        field: 'qq',
        title: 'qq号码',
        align: 'center',

    },{
        field: 'email',
        title: '邮箱',
        align: 'center',

    }, {
        field: 'button',
        title: '操作',
        align: 'center',

        searchable: true,
        formatter: "",

    }
];
initTableFun("userTable",columns);
// function aaa() {
//     window.location.href='../user/建筑用电数据.xls'
// }

function aaa() {
    // let URL ='zh/user/download' //下载地址
    // downLoad(URL ,'建筑用电数据.xls')
    window.location.href='download';
}

function downLoad(content,fileName){
    var aEle = document.createElement("a");// 创建a标签
    // blob = new Blob([content]);
    aEle.download = fileName;// 设置下载文件的文件名
    //aEle.href = URL.createObjectUrl(blob);
    aEle.href = content;// content为后台返回的下载地址
    aEle.click();// 设置点击事件

}