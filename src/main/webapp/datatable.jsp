<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Load Datatable</title>

</head>
<body>
	<style>
	.setcolor{
		background: cadetblue;
	}
li.page {
	padding: 0 10px;
}

ul.list-number {
	display: inline-flex;
	list-style: none;
}

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
	<table id="idTable">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<div id="paging-number">
		<ul class="list-number">
			<li class="page number1"><a href="/1">1</a></li>
			<li class="page number2"><a href="/2">2</a></li>
			<li class="page number3"><a href="/3">3</a></li>
			<li class="page number4"><a href="/4">4</a></li>
		</ul>

	</div>
	<!-- <input type="button" onclick="loadData();" value="hhhhhhhhhhhh" /> -->
</body>

<script type="text/javascript">
	function loadPageNumber() {
		var xmlhttp = getXMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			console.log("==aakakakaka=11111==" + this.responseText)
			if (this.readyState == 4 && this.status == 200) {
				console.log("==aakakakaka=2222==" + this.responseText);

				obj = JSON.parse(this.responseText);
				loadDataTable(obj);
			}
		};
		xmlhttp.open("GET", "PagingServlet", true);
		xmlhttp.send();
	}

	$(document).ready(function() {
		loadPageNumber();
	});

	function loadData() {
		var xmlhttp = getXMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			console.log("==aakakakaka=11111==" + this.responseText)
			if (this.readyState == 4 && this.status == 200) {
				console.log("==aakakakaka=2222==" + this.responseText);

				obj = JSON.parse(this.responseText);
				loadDataTable(obj);
			}
		};
		xmlhttp.open("GET", "DataServer", true);
		xmlhttp.send();
	}

	function loadDataTable(obj) {
		var table = document.getElementById("idTable");
		//delete rows
		while(table.rows.length > 0) {
			  table.deleteRow(0);
			}
		var prods = obj.products;
		var pageNumber = obj.pageNumber;
		console.log("prods: "+ prods);
		console.log("pageNumber: "+ pageNumber);
		//load new data
		prods.forEach(function(object) {
			var tr = document.createElement('tr');
			tr.innerHTML = '<td>' + object.productId + '</td>' + '<td>'
					+ object.imageLink + '</td>' + '<td>' + object.price
					+ '</td>' + '<td>' + object.productName + '</td>' + '<td>'
					+ object.quantity + '</td>';
			table.appendChild(tr);
		});
		var div = document.getElementById("paging-number");
		div.innerHTML = '';
		var ul = document.createElement("ul");
		ul.className = "list-number";
		for(var i = 1; i <= pageNumber; i++){
			var li = document.createElement('li');
			li.className = "page class" + i;
			li.innerHTML = '<a href="javascript:showData('+i+');">'+i+'</a>';
			ul.appendChild(li);
		}
		div.appendChild(ul);
	}
	
	function loadDataTable1(obj){
		var table = document.getElementById("idTable");
		//delete rows
		while(table.rows.length > 0) {
			  table.deleteRow(0);
			}
		obj.forEach(function(object) {
			var tr = document.createElement('tr');
			tr.innerHTML = '<td>' + object.productId + '</td>' + '<td>'
					+ object.imageLink + '</td>' + '<td>' + object.price
					+ '</td>' + '<td>' + object.productName + '</td>' + '<td>'
					+ object.quantity + '</td>';
			table.appendChild(tr);
		});
	}
	
	function showData(i){
		//page class2
		/* var list = document.getElementsByTagName("li"); */
		 /* list.forEach(function(li) {
			if(li.classList.contains("setcolor") != 0){
				li.className= "";
				li.className= "page";
			}
		})  */
		/* for(var i =0; i < list.length; i++){
			if(document.getElementsByTagName("li")[0].classList.contains("setcolor") != 0){
				document.getElementsByTagName("li")[0].className= "";
				document.getElementsByTagName("li")[0].className= "page class"+(i + 1);
			}
		}
		 var strClass = "class"+i;
		var liClass = document.getElementsByClassName(strClass);
		var oldClass = liClass[0].className;
		liClass[0].className ="setcolor "+oldClass; */
		var xmlhttp = getXMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			console.log("==aakakakaka=11111==" + this.responseText)
			if (this.readyState == 4 && this.status == 200) {
				console.log("==aakakakaka=2222==" + this.responseText);

				obj = JSON.parse(this.responseText);
				loadDataTable1(obj);
			}
		};
		xmlhttp.open("GET", "DataServer?pageNumber="+i+"", true);
		xmlhttp.send();
	}
	function getXMLHttpRequest() {
		var xmlHttpReq = false;
		//Tạo đối tượng dùng cho trình duyệt khác IE
		if (window.XMLHttpRequest) {
			xmlHttpReq = new XMLHttpRequest();
		} else if (window.ActiveXObject) { //Tạo đối tượng dùng cho trình duyệt IE
			try {
				//Tạo đối tượng dùng cho trình duyệt khác IE MỚI
				xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (exp1) {
				try {
					//Tạo đối tượng dùng cho trình duyệt khác IE CŨ
					xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (exp2) {
					xmlHttpReq = false;
				}
			}
		}
		return xmlHttpReq;
	}
</script>

</html>