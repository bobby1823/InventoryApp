<%@page import="java.util.ArrayList"%>
<%@page import="com.service.DBManager"%>
<%@page import="com.service.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Your Approval Status</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="menu">
		<ul>
			<li><a href="deptHome.jsp">Home</a>&nbsp;&nbsp;</li>
			<li><a href="addItem.jsp">Add</a>&nbsp;&nbsp;</li>
			<li><a href="approvalStatus.jsp">Approval Status</a>&nbsp;&nbsp;</li>
			<li><a href="logout.jsp">Logout</a>&nbsp;&nbsp;</li>
		</ul>
	</div>
	<div class="productsTable">
		<table style="border: 1px solid #000000;" border="1" align="center">
			<tr style="background-color: #315FA5;">
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">&nbsp;S.No.</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Product Id</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Store Id</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Dept Id</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Product Name</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Vendor</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">MRP</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Batch Number</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Batch Date</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Quantity</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Request Type</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Status</span></strong></td>
				<td colspan="2" style="text-align: center;"><strong><span
						style="color: #ffffff;">Approve/Deny</span></strong></td>
			</tr>

			<%
				ArrayList<Item> items = DBManager.getAllItems();
				int i = 1;
				for (Item item : items) {
			%>
			<tr style="background-color: #fefef5;">
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp; <%=i%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getProductId()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getStoreId()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getDeptId()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getProductName()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getVendor()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getMrp()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getBatchNum()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getBatchDate()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getQuantity()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getQuantity()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getQuantity()%></span></strong></td>
				<%
					if ("a".equals("a")) {
				%>
				<td style="text-align: center; background-color: #4CAF50;"><strong><span
						style="color: #000000;">&nbsp;<a href=""><img
								src="./images/approveIcon.png" title="Approve"></a></span></strong></td>
				<td style="text-align: center; background-color: #b90a2d;"><strong><span
						style="color: #000000;">&nbsp;<a href=""><img
								src="./images/denyIcon.png" title="Deny"></a></span></strong></td>
				<%
					}
				%>
			</tr>
			<%
				i++;
				}
			%>
		</table>
	</div>
</body>
</html>