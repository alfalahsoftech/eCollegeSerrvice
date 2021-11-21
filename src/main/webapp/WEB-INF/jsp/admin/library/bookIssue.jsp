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


<link href="${datepicks}/jquery.datepick.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${css_url}/setting.css">

<script src="${datepicks}/jquery.plugin.js"></script>
<script src="${datepicks}/jquery.datepick.js"></script>

<script type="text/javascript">
	$(document).ready(function() 
	{
		$('#issue_book').hide();
	})
	/*                                                    get section                             */
	function getSectionList(id)
	{
		$.ajax({
			type : "post",
			url : 'getsectionlist/' + id,
			success : function(data, status) 
			{
				$("#sectionId").empty();
				var j = JSON.parse(data);
				var content = '<option value="">Select Section</option>';
				for (var i = 0; i < j.length; i++) {
					content += '<option value='+j[i].sectionId+'>'
							+ j[i].sectionName + '</option>';
				}
				$("#sectionId").append(content);
				getsubjectList(id);
			},
			error : function(e) 
			{

			}
		});
	}
	function getStudentList() 
	{
		var sessionId = $('#sessionId').val();
		var classId = $('#classId').val();
		var sectionId = $('#sectionId').val();
		if (sessionId == '' || classId == '' || sectionId == '')
		{
			alert("Fill Above Data First. Please!!");
		} 
		else 
		{
			$.ajax({
				type : "post",
				url : 'get-student-list',
				data : {
					'classId' : classId,
					'sectionId' : sectionId,
					'sessionId' : sessionId,
				},
				success : function(data, status) {
					$("#studentId").empty();
					var j = JSON.parse(data);
					var content = '<option value="">Select Student</option>';
					for (var i = 0; i < j.length; i++) {
						content += '<option value='+j[i].admissionNo+'>'
								+ j[i].firstName + '</option>';
					}
					$("#studentId").append(content);

				},
				error : function(e) {

				}
			});
		}
	}

	function getStudentDatabyId(studentId)
	{
		$.ajax({
			type : 'post',
			url : 'get-studentdatabyId',
			data : 
			{
				'studentId' : studentId,
			},
			success : function(data, status) 
			{
				var j = JSON.parse(data);
				if (j.length == 0) 
				{

				} 
				else
				{
					$("#classId").val(j.classId);
					$("#sectionId").val(j.sectionId);
					getStudentFeeDetails(j.admissionNo);
					getIssuedBookToStudent(studentId);
				}

			},

			error : function(data, status) {

			}
		});

	}

	function getStudentdetails(id) {
		$("#issueBook").empty();
		$.ajax({
					type : "post",
					url : 'getstudentsdata/' + id,
					success : function(data, status) {
						$("#Student").empty();
						var j = JSON.parse(data);
						var st = '';
						st = '<div  id="box" style="width: 800px; padding:0px; margin:0px">';
						st += '<table class="table table-bordered table-primary"><thead><tr><th colspan="6" class="head blue"><h4 style="text-align:center; padding:0px; margin:0px"> Student Details</h4></th></tr></thead><tbody><tr><th><span><font size="2"><b>Name :</b></th><td colspan="3" ><span><font size="2">'
								+ j.firstName+ '\t'+ j.middleName+ '\t'+ j.lastName
								+ '</font></span></td><td rowspan="5">Image privous</td></tr><tr><th><span><font size="2"><b>Father Name:</font></span></b></th><td style="width: 369px;"colspan="3"><span><font size="2">'
								+ j.fatherName
								+ '</font></span></td><tr><tr><th><span><font size="2"><b>Class:</font></span></b></th><td ><span><font size="2">'
								+ j.className
								+ '</font></span></td><th style="width: 79px;"><span><font size="2"><b>Section:</font></span></b></th><td style="width: 140px;"><span><font size="2">'
								+ j.sectionName
								+ '</font></span></td></tr><tr><th><span><font size="2"><b>Mobile No:</font></span></b></th><td colspan="3"><span><font size="2">'
								+ j.mobile
								+ '</font></span></td></tr></tbody></table></div>';
						$("#studentDetails").empty();	
						$("#studentDetails").append(st);
						$("#studentIdno").val(''+id);
					    getIssuedBookToStudent(id);

					},
					error : function(e) {

					}
				});
	}

	function getIssuedBookToStudent(studentId) {
		$("#issueBook").empty();
		$
				.ajax({
					type : "post",
					url : 'getIssuedBookByStudentId.html',
					data : 
					{
						'studentId' : studentId
					},
					success : function(data, status) {

						var j = JSON.parse(data);
                        var st='';
						if (j == 0) {
							 st = '<div class="failedmsg">No Previous Details found</div>';
						} 
						else
						{
						    st =''
							+ '\n<div class="block" style="width:800px;">'
							+ '<table class="table table-bordered table-primary" ><thead><tr><th colspan="5" class="head blue"><h4 style="text-align:center; padding:0px; margin:0px"> Issued Books Details</h4></th></tr><tr><th>Book</th><th>Issue Date</th><th>Subject</th><th>ISBN</th></tr></thead><tbody>';
							for (var i = 0; i < j.length; i++)
							{
								        st += '<tr><td>' + j[i].bookName + '</td>'
										+ '<td>' + j[i].issueDate + '</td>'
										+ '<td>' + j[i].subjectName + '</td>'
										+ '<td>' + j[i].isbn + '</td>'
										+ '</tr>';
							}
							st += '</tbody></table></div>';
						}

						$("#issueBook").append(st);

					},
					error : function(e) {
						alert('Error: ' + e);
					}

				});

	}
	
	function getStudentFeeDetails(id) {

		var sessionId = $('#sessionId').val();
		var classId = $('#classId').val();
		var sectionId = $('#sectionId').val();
		$("#studentAdmissionNo").val(id);

		if (classId == '' || sectionId == '') {
			alert("Fill Above Data First. Please!!");
		} else {
			$
					.ajax({
						type : "get",
						url : 'get-student-fee-payment-details',
						data : {
							'studentAdmissionNo' : id,
							'sessionId' : sessionId,
						},
						success : function(data, status) {
							var obj = JSON.parse(data);

							var studentDetails = '<div style="text-align: center; height: 33px; background-color: rgb(238, 238, 238); color: rgb(0, 136, 204); border: 1px solid lightgray; border-top-left-radius: 10px; border-top-right-radius: 10px; margin-top: 3px; width: 710px;">'
									+ obj.StudentDTO.fullName
									+ '<input type="hidden" id="fullName" value="'+obj.StudentDTO.fullName+'"></div><div class="row-fluid"  style="border: 1px solid lightgray; height: 113px; border-bottom-left-radius: 10px; border-bottom-right-radius: 10px;"><div class="span6">';
							studentDetails += '<div class="block"><div class="data-fluid"><div class="row-form"><div class="span5">Mobile No :</div>';
							studentDetails += '<div class="span7">'
									+ obj.StudentDTO.mobile
									+ '</div></div></div><div class="data-fluid"><div class="row-form">';
							studentDetails += '<div class="span5">Roll No :</div><div class="span7">'
									+ obj.StudentDTO.rollno
									+ '</div></div></div></div></div>';
							studentDetails += '<div class="span6"><div class="block"><div class="data-fluid"><div class="row-form" style="padding-top: 0px;">';
							studentDetails += '<div class="span3" style="width: 138px; height: 113px;float:right">'
									+ '<img src="${img}/studentImages/'+obj.StudentDTO.imageName+'"'
									+'style="width: 127px; height: 113px;">'
									+ '</div></div></div></div>';
							$("#studentDetails").append(studentDetails);

						},
						error : function(e) {

						}
					});
		}
	}

	function getsubjectList() {

		var classId = $('#classId').val();
		classId1 = classId;
		$.ajax({
			type : "post",
			url : 'getSubjectList.html',
			data : {
				'classId' : classId,

			},
			success : function(data, status) {

				var j = JSON.parse(data);
				var content = '<option value="">Select Subject</option>';
				for (var i = 0; i < j.length; i++) {
					content += '<option value='+j[i].subjectName+'>'
							+ j[i].subjectName + '</option>';
				}
				$("#subjectId").append(content);

			},
			error : function(e) {
				alert('Error: ' + e);
			}

		});
	}
	function issueBookToStudent(BookName, SubjectName, admissionNo, bookId) {
	
		
		var classId = $('#classId').val();

		$.ajax({
			type : "post",
			url : 'issueBookToStudent.html',
			data : {
				'BookName' : BookName,
				'SubjectName' : SubjectName,
				'admissionNo' : admissionNo,
				'classId' : classId,
				'bookId' : bookId,

			},
			success : function(data, status) {

				var j = JSON.parse(data);
				
				

			},
			error : function(e) {
				alert('Error: ' + e);
			}

		});

	}
	function newIssueBook(bookName, bookId, admissionNo, isbnNo,subjectName) {
		
		$('#issue_book').hide();
		var classId = $('#classId').val();

		$.ajax({
			type : "post",
			url : 'newIssueBook.html',
			data : {
				'bookName' : bookName,
				'bookId' : bookId,
				'admissionNo' : admissionNo,
				'classId' : classId,
				'isbnNo' : isbnNo,
				'classId':classId,
				'subjectName':subjectName,

			},
			success : function(data, status) {
				alert("a");
				$('#issue_book').dialog('destroy');
				getIssuedBookToStudent(admissionNo);
				getBookBySubjectIdAndClassId(subjectName);

			},
			error : function(e) {
				alert('Error: ' + e);
			}

		});

	}
	
	

	function viewBooksDetails(bookName, bookId, admissioNo) {
		
		$('#issue_book_table tbody').empty();
		$('#issue_book').dialog({
			autoOpen : false,
			resizeable : false,
			title : 'Issue Book',
			modal : true,
			
			width : 700,
			positon : 'centre'
		});
		$
				.ajax({
					type : "post",
					url : 'viewSameBooks',
					data : {
						'bookName' : bookName,
						'bookId' : bookId,
						'admissioNo' : admissioNo,

					},
					success : function(data, status) {

						var j = JSON.parse(data);

						for (var i = 0; i < j.length; i++) {
							var st = '';
							st += '<tr><td>'
									+ j[i].bookName
									+ '</td>'
									+ '<td>'
									+ j[i].subjectName
									+ '</td>'
									+ '<td>'
									+ j[i].isbn
									+ '</td>'
									+ '<td><a class="btn" type="submit" style="float: right; margin-right:0px;" href=javascript:newIssueBook("'
									+ j[i].bookName + '",' +bookId
									+ ',' + admissioNo+','
									+'"'
									+ j[i].isbn
									+'","'+j[i].subjectName+'")>Issue</a></td>'
									+ '</tr>';
							$('#issue_book_table tbody').append(st);

						}
						st += '</tbody></table></div></div>';
						
						$('#viewDetailsForIssue').empty();
						$('#viewDetailsForIssue').append(st);
						$('#viewDetailsForIssue').show();
						

					},
					error : function(e) {
						alert('Error: ' + e);
					}

				});

		$('#issue_book').dialog('open');
	}

	function getBookBySubjectIdAndClassId(subjectId)
	{
		$('#subjectDetailsDiv').remove();
		var admissionNo = $("#studentId").val();
		var subjectName = $("#subjectId").val();
		var classId = $('#classId').val();
		$
				.ajax({
					type : "post",
					url : 'getSubjectDetails.html',
					data : {
						'subjectName' : subjectName,
						'classId1' : classId

					},
					success : function(data, status) {

						var j = JSON.parse(data);

						var st = st
								+ '<div><div class="widget-body"  style="padding: 10px 0px 0px;"><div class="separator"></div><div class="btn-group" style="width: 400px;">'
								+ '</div><div class="block"  style="width: 462px;"><div class="head blue" style="width: 462px; margin-top: 66px;"><h4 style="text-align:center">Previous Issued Books</h4></div>'
								+ '<table class="table table-bordered table-primary"><thead><tr><th>Book</th><th>Quantity</th><th>Remanning Qty</th><th>Action</th></tr></thead><tbody>';
						for (var i = 0; i < j.length; i++) {
							if (j[i].remainingQuantity > 0) {
								st += '<tr><td>'
										+ j[i].bookName
										+ '</td>'
										+ '<td>'
										+ j[i].quantity
										+ '</td>'
										+ '<td>'
										+ j[i].remainingQuantity
										+ '</td>'
										+ '<td><a class="btn" type="submit" style="float: right; margin-right:0px;" href=javascript:viewBooksDetails("'
										+ j[i].bookName + '",'
										+ j[i].libraryBookId + ','
										+ admissionNo + ')>view</a></td>'
										+ '</tr>';
							}
						}
						st += '</tbody></table></div></div>';

						$('#subjectDetailsDiv').remove();
						$('#subjectDetailsDiv').append(st);
						$('#subjectDetailsDiv').show();

					},
					error : function(e) {
						alert('Error: ' + e);
					}

				});
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
			<h1>Issue Book</h1>
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
        <div align="left" id="error" style="color: red; margin-top: 16px;"></div>
		<div id="page-yield">
				<table  class="table-condensed">
				<thead>
				   <tr>
					<th colspan="5">Fill Data to be Issue Book</th>
					</tr>
				</thead>
				<tbody>
					<tr>
					<td>Session:<br>
						<select name="sessionId" onchange="getClear();"
							class="validate[required]" id="sessionId"
							style="width: 190px; ">
							<c:forEach var="list" items="${sessionList}">
								<option value="${list.sessionId}">${list.sessionDuration}</option>
							</c:forEach>
						</select>
					</td>
				     <td>Class:<br>
					
						<select name="classId" onchange="getSectionList(this.value);"
							class="validate[required]" id="classId"
							style="width: 190px;">
							<option value="">Select a Class</option>
							<c:forEach var="list" items="${classList}">
								<option value="${list.classId}">${list.className}</option>
							</c:forEach>

						</select>
				</td>
				
				<td>
				Section:<br>
						<select name="sectionId" onchange="getStudentList();"
							class="validate[required]" id="sectionId"
							style="width: 190px;">
							<option value="">Select a Section</option>
						</select>
					</td>
				<td>
				
				  Student:<br>
					<select name="studentId" onchange="getStudentdetails(this.value)"
							class="validate[required]" id="studentId"
							style="width: 190px;">
						</select>
				</td>	
			</tr>
			</tbody>
		</table>
		<br>
		<f:form action="newIssueBook.html" id="validate" method="POST" name="myForm" commandName="issueBookDTO">
         <table class="table-condensed table-primary" style="width: 50%;">
         <thead>
         <tr><th colspan="2" class="success">Fill Required Field </th></tr></thead>
         <tbody>
           <tr>
           <td>Student Id
                  <br>
                  <input type="text" name="studentId" id="studentIdno" style="width: 190px; ">
			</td>
			
            <td>Book Id 
              <br>
                  <input type="text"  name="issueBookId" id="issueBookId" style="width: 190px; ">
            </td> 
             <td>Isbn no
                  <br>
                  <input type="text" name="isbn" id="isbn" style="width: 190px; ">
			</td>
			</tr>
			
			
           </tbody>
           <tfoot>
           <tr>
           <td>
                <button type="submit">Issue</button> <button type="reset">Cancel</button>
           </td>
           </tr>
           </tfoot>
          </table>
          </f:form>
          <br>
          <br>
          <table><tr><td> <div id="studentDetails" style=""></div></td></tr></table>
            <div style="width:300px;">
               <div id="subjectDetailsDiv" class="block" style="display: none;"></div>
            </div>
            <div style="width:300px;">
			  <div id="issueBook" style=""></div>
			  <div id="subDetails"></div>
		   </div>
			<div  id="viewDetailsForIssue" style="margin-bottom: 0px;"></div>
			<input type="hidden" id="studentAdmissionNo" name="studentAdmissionNo">
		    <input type="hidden" id="neededMonthId">
		    <input type="hidden" id="paidAmountInWords" name="paidAmountInWord">
			<div class="separator"></div>
		
	</div>
</div>
</div>

<div id="issue_book">
	<table class="table table-bordered table-primary" id="issue_book_table">
		<thead>
			<tr>
				<th>Book</th>
				<th>Subject</th>
				<th>ISBN No.</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>

</div>

