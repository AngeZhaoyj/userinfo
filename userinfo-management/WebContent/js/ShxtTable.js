var ShxtTable = function(){
	var $table;
	
	return {
		refresh: function(){
			$table.bootstrapTable('refresh');
		},
		remove:function(id){
			$table.bootstrapTable('remove', {
	            field: 'id',
	            values: [id]
			});
		},
		init: function(t, o){
			$table = t;
			
			/******************************【基本】****************************************************/
			
			//[true] 设置为 true 会有隔行变色效果
			if(o.striped == undefined) o.striped = true; 
			
			
			/******************************【数据请求】****************************************************/
			if(o.method == undefined) o.method =  "post";//['get']服务器数据的请求方式 'get' or 'post'
			if(o.contentType == undefined) o.contentType = "application/x-www-form-urlencoded; charset=UTF-8";//['application/json']发送到服务器的数据编码类型
			
			/*****************************【显示】*****************************************************/
			//['-'] 当数据为 undefined 时显示的字符
			if(o.undefinedText == undefined) o.undefinedText = ""; 
			
			/****************************【分页】******************************************************/
			//[false] 设置为 true 会在表格底部显示分页条
			if(o.pagination == undefined) o.pagination = true; 
			
			//[10] 如果设置了分页，页面数据条数
			if(o.pageSize == undefined) o.pageSize = 5; 
			/*Array [10, 25, 50, 100, All]如果设置了分页，设置可供选择的页面数据条数。
			设置为All 则显示所有记录。*/
			if(o.pageList == undefined) o.pageList = [5, 10, 25, 50, 100, 'All']; 
			//[false] 是否显示数据条数(分页显示) 选择框
			if(o.showPaginationSwitch == undefined) o.showPaginationSwitch = true; 
			
			/*****************************【搜索】*****************************************************/
			//[false]是否启用搜索框
			if(o.search == undefined) o.search = true; 
			//[false]是否显示 内容列下拉框
			if(o.showColumns == undefined) o.showColumns = true; 
			//卡片切换按钮
			if(o.showToggle == undefined) o.showToggle = true; 
			
			$table.bootstrapTable(o);
		}
	};
}();
