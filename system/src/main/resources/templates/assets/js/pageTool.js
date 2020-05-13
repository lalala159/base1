//生成分页
//有些参数是可选的，比如lang，若不传有默认值
function initPage(pageNo, pageSize, totalRecords){
    if(!pageNo){
        pageNo = 1;
    }
    var totalPage = Math.ceil(totalRecords/pageSize);
    if(totalRecords){

    }
    kkpager.generPageHtml({
        pno : pageNo,
        //总页码
        total : totalPage,
        //总数据条数
        totalRecords : totalRecords,
        //链接前部
        mode: 'click',//默认值是link，可选link或者click
        click : function(n){
            initData(n,pageSize);
            return false;
        }
    });
}