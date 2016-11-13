<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Load Datatable</title>
</head>
<body>
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
			<li class="page number1">1</li>
			<li class="page number2">2</li>
			<li class="page number3">3</li>
			<li class="page number4">4</li>
		</ul>
		
	</div>
	<!-- <input type="button" onclick="loadData();" value="hhhhhhhhhhhh" /> -->
</body>

<script type="text/javascript">
	function loadData() {
		var xmlhttp = getXMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			console.log("==aakakakaka=11111==" + this.responseText)
			if (this.readyState == 4 && this.status == 200) {
				console.log("==aakakakaka=2222==" + this.responseText);

				obj = JSON.parse(this.responseText);
				loadDataTable(obj);
				console.log("value: " + obj[1].productId);
			}
		};
		xmlhttp.open("GET", "DataServer", true);
		xmlhttp.send();
	}

	function loadDataTable(obj) {
		var table = document.getElementById("idTable");
		obj.forEach(function(object) {
			var tr = document.createElement('tr');
			tr.innerHTML = '<td>' + object.productId + '</td>' + '<td>'
					+ object.imageLink + '</td>' + '<td>' + object.price
					+ '</td>' + '<td>' + object.productName + '</td>' + '<td>'
					+ object.quantity + '</td>';
			table.appendChild(tr);
		});
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