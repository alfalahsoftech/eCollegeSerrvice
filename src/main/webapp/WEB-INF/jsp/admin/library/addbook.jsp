<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/style/theme/images/back.png" var="backurl" />
<c:url value="/style/theme/images/admission_page_logo.jpg"
	var="StudentAddLogo" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/style/datepicks" var="datepicks" />
<spring:url value="/img" var="img_url" />
<spring:url value="/css" var="css_url" />

<script src="${datepicks}/jquery.plugin.js"></script>
<script src="${datepicks}/jquery.datepick.js"></script>
<script src="/js/jquery.js"></script>
<script src="/style/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="${css_url}/admission.css">
<link rel="stylesheet" type="text/css" href="${css_url}/bootstrap/bootstrap.min.css">
<link href="${datepicks}/jquery.datepick.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${css_url}/setting.css">
<link rel="stylesheet" type="text/css" href="${css_url}/setting.css">
<style>
.popup 
{
	display: none;
	background-color: white;
	border: 1px solid lightgray;
	width: 400px;
	height: 100px;
	border-radius: 6px;
	margin: auto;
	z-index: 1;
	position: fixed;
	display: block;
	top: 152px;
	left: 200px;
	padding: 40px;
}
</style>
<script type="text/javascript">
	var count = 0;
	var flag = 0;
	function getsubjectList() {

		var classId = $('#classId').val();
		alert("class Id is " + classId);

		$.ajax({
			type : "post",
			url : 'getSubjectList.html',
			data : {
				'classId' : classId,

			},
			success : function(data, status) {

				var obj = JSON.parse(data);
				alert("list is " + obj.toSource());

			},
			error : function(e) {
				alert('Error: ' + e);
			}

		});
	}

	function getSubmition() {

		var value = $('#classId').val();
		var subjectName = $('#subjectName').val();
		var bookName = $('#bookName').val();
		var quantity = $('#quantity').val();

		if (value == 0) {

			$('#error').empty();
			$('#error').append("Fill the required Fields*");

			$('#classId').css("border", "1px solid red");
			flag = 1;
		}
		if (subjectName == '') {
			$('#error').empty();
			$('#error').append("Fill the required Fields *");

			$('#subjectName').css("border", "1px solid red");
			flag = 1;

		}
		if (bookName == '') {
			$('#error').empty();
			$('#error').append("Fill the required Fields *");

			$('#bookName').css("border", "1px solid red");
			flag = 1;

		}
		if (quantity == '') {
			$('#error').empty();
			$('#error').append("Fill the required Fields*");

			$('#quantity').css("border", "1px solid red");
			flag = 1;

		}

		if (flag == 0) {

			$('#formID').submit();

		}

	}

	function setIsbn() {

		var quantity = $('#quantity').val();
		var content = '<table style="margin-left: 2px;">';
		content += '<tr><td>Enter ISBN No. for books :</td></tr>';
		var totalRow;
		var row;
		totalRow = quantity / 4;
		for (var i = 0; i < Math.floor((quantity / 4)); i++) {
			content += '<tr>'
			for (var j = 0; j < 4; j++) {
				content += '<td style="padding:5px;"><input type="text" name="isbnList['+count+'].isbnNo" id="quantity" style="width: 235px;" /></td>';
				count++;
			}
			content += '</tr>'
		}
		content += '<tr>'
		for (var k = 0; k < (quantity % 4); k++) {

			content += '<td style="padding:5px;"><input type="text"  name="isbnList['+count+'].isbnNo"    id="quantity" style="width: 200px; height:35px" /></td>';
			count++;
		}
		content += '</tr>'
		content += '</table>';
		$('#isbn').empty();
		$('#isbn').append(content);

	}

	function getClear() {
		$("#msg").empty();
		$("#failedmsg").hide();
		$("#classId").val('');
		$("#sectionId").val('');
		$("#subjectName").val('');
	}
	function closePopup() {
		$('#popup').hide();
	}
</script>
<div id="content_wrapper">
	<div id="side_bar">

		<div id="sidebar_news_area"></div>
	</div>
	<div id="content">
		<div id="content-header">
			<img alt="Show_settings" src="${img_url}/book1.jpg"
				style="width: 80px; height: 66px;">
			<h1>Add Book</h1>
			<h3>Manage library Books</h3>
			<div id="app-back-button">
				<a href="home"><img alt="Back" border="0"
					src="${img_url}/home.png"
					style="margin-top: -6px; height: 40px; width: 40px;"></a> <a
					href="#" onclick="javascript:location.reload(true);"><img
					alt="Back" border="0" src="${img_url}/refresh.png"
					style="margin-top: -6px; height: 40px; width: 40px;"></a> <a
					href="#" onclick="history.back(); return false;"><img
					alt="Back" border="0" src="${img_url}/back.png"
					style="margin-top: -6px; height: 40px; width: 40px;"></a>
			</div>
		</div>
		<div class="panel panel-default">
  <div class="panel-body">A Basic Panel</div>
  <div class="panel-footer">Panel Footer</div>
</div>
		<div align="center" id="error" style="color: red; margin-top: 16px;"></div>
		<div id="page-yield" >
           
			<f:form action="addBook.html" id="validate" method="POST" name="myForm" commandName="LibraryDTO">
				<table  style="width: 100%; height: 100px; margin-left: 15px; margin-top: 11px;">
					<tr>
						<td >Class Name:<span
							style="color: red;">*</span>
							<br>
							<f:select path="classId" id="classId" required="required"
								style="width: 300px; height:35px">
								<option selected="selected" value="0" title="">--
									Select Class --</option>
								<c:forEach var="list" items="${list}" varStatus="loop">
									<option value="${list.classId}" data-original-title="" title="">
										${list.className}</option>
								</c:forEach>
							</f:select></td>
					
						<td>Subject Name :<span style="color: red;">*</span>
						<br> 
						<f:input id="subjectName" path="subjectName" 
								class="validate[required]"
								style="width: 300px; height:35px" />
						</td>
						<td>
						</td>
					</tr>
					<tr>
						<td>Book Name : <span style="color: red;">*</span>
						<br>
						<f:input id="bookName" path="bookName"
								class="validate[required]"
								style="width: 300px; height:35px" /></td>
					
						<td>Book Author : <span style="color: red;">*</span>
						<br>
						<f:input id="bookAuthor" path="bookAuthor"
								class="validate[required]"
								style="width: 300px; height:35px" />
						</td>
						<td>
						</td>
					</tr>
					<tr>
						<td>Book Publisher : <span style="color: red;">*</span>
						<br>
						<f:input id="bookPublisher" path="bookPublisher"
								class="validate[required]"
								style="width: 300px; height:35px" />
					   </td>
					
						<td colspan="2" width="100%">
						Book Copyright : <span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						Edition Number : <span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<br>
						<f:input id="bookCopyright" path="bookCopyright"
								class="validate[required]"
								style="width: 150px; height:35px" />
					    
						<f:input id="bookEditionNumber" path="bookEditionNumber"
								class="validate[required]"
								style="width: 150px; height:35px" />
						</td>
					 </tr>
					<tr> 
					  <td> 
					      Number of Page: <span style="color: red;">*</span>
						
						<f:input id="totalBookPage" path="totalBookPage"
								class="validate[required]"
								style="width: 150px; height:35px" />
					  
					   </td>
					</tr>
					<tr>
						<td >
						  Name of Library: <span style="color: red;">*</span>
						<br>
						<f:input id="libraryName" path="libraryName"
								class="validate[required]"
								style="width: 300px; height:35px" />
					    </td>
						<td>
						
						Shelf No: <span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						Quantity :<span style="color: red;">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<br>
						<f:input id="shelfNo" path="shelfNo"
								class="validate[required]"
								style="width: 150px; height:35px" />
					   
						<f:input path="quantity" id="quantity"
								class="validate[required]" style="width: 150px;height:35px" />
					  
					</td>
					</tr>
					<tr>
						<td></td>
						<td style="width: 200px;"><button style="float: left;"
								class="btn btn-primary" id="addisbn" type="button"
								style="float: left; margin-left: 12px;" onclick="setIsbn();">Add
								ISBN NO.</button>

							<button style="float: left; margin-left: 21px;"
								class="btn btn-success" id="submitbutton" type="submit">Submit</button></td>
					</tr>
				</table>
				<div class="separator"></div>
				<f:hidden path="active" value="true" />
				<div id="isbn"
					style="width: 1000px; margin-left: 0px; height: 123px;"></div>
			</f:form>
            </div>
	</div>

	<div class="extender"></div>
</div>

