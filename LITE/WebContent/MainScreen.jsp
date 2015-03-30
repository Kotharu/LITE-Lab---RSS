<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="org.json.simple.JSONObject"%>
<head lang="en">

    <link data-require="bootstrap@*" data-semver="3.3.1" rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
    <link data-require="bootstrap-css@*" data-semver="3.3.1" rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
    <script data-require="bootstrap@*" data-semver="3.3.1" src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href=css/style.css />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>RSS</title>
</head>
<body>
	<form action="RequestHandler" method=post>
		<marquee>
			<h1>RSS</h1>
		</marquee>
		<section>
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a href="#"> MS&T LITE LAB </a></li>
				<li><a href="#">News Project</a></li>
				<li><a href="#">Research project</a></li>
				<li><a href="#">Family Project</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
		</div>
		</section>

		<div class="MainContainer">
			<div>
				<h1 name="mainStatement">The ebola virus is not a threat to the
					city of Rolla, MO</h1>
				<input type="hidden" name="main_stmnt_hidden"
					value="The ebola virus is not a threat to the city of Rolla, MO ">
				<div class="textBoxFieldContainer">
					<div class="row">
						<div class="col-lg-6">
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="    Agree Because ..." name="textfield1">
								<span class="input-group-btn">
									<button class="btn btn-primary" type="submit"
										name="Agree_button" ">
										Post</button>
									<input type="button" onclick="addRow('Agree_table')"/>
								</span>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="    Disagree Because ..." name="textfield2">
								<span class="input-group-btn">
									<button class="btn btn-primary" type="submit"
										name="DisAgree_button">
										Post</button>
										<input type="button" onclick="addRow('DisAgree_table')"/>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="OptionsContainer1">
					<table id="Agree_table">
						<tbody>
							<tr>
								<td>
									<p>The United States has a much more advanced health care
										system than Africa.</p>
								</td>
								<td><span> <input type="image"
										src="http://web.mst.edu/~nar365/RSS/RSS/index_files/u46_normal.png" />0
								</span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="OptionsContainer2">
					<table id="DisAgree_table">
						<tbody>
							<tr>
								<td><a href="">There are cases of people who have the
										virus already in the US.</a></td>
								<td><input type="image"
									src="http://web.mst.edu/~nar365/RSS/RSS/index_files/u46_normal.png" />
									<td>
            
									<td>
            						<p>0</p>
            						</td>
        					</tr>
						</tbody>
      			   </table>
      </div>
    </div>
</div>

   <script language="javascript">
     
   function addRow(tableID)
   {
	   //document.forms[0].submit();
	     
	   var fromdb = '<%= request.getAttribute("objkey") %>';    /* retrieve json from request attribute */
	   var tableset = eval('(' + fromdb + ')');
	   var count = Object.keys(tableset).length;
	   //alert(fromdb)  ;      // display complete json
	   //alert(count);
	   var table = document.getElementById(tableID);
	   var rowCount = table.rows.length;
	   for(var i=0;i<rowCount;i++)
	   {
	   table.deleteRow(i);rowCount--;i--;
		}
	
	   for (var key in tableset) {
		   
		   
		   if (tableset.hasOwnProperty(key)) 
		   {
		     //alert(key + " -> " + tableset[key]);						
						var rowCount = table.rows.length;
						var row = table.insertRow(rowCount);
						var cell1 = row.insertCell(0);
						var element1 = document.createElement('a');
						element1.appendChild(document
								.createTextNode(key));
						element1.href = "https://www.youtube.com/watch?v=nIrLsg_DkIE";
						cell1.appendChild(element1);
						var cell2 = row.insertCell(1);
						var element2 = document.createElement("input");
						element2.type = "image";
						element2.src = "http://web.mst.edu/~nar365/RSS/RSS/index_files/u46_normal.png";
						cell2.appendChild(element2);
						var cell3 = row.insertCell(2);
						var element3 = document.createElement("P");
						element3.appendChild(document.createTextNode(tableset[key]));
						cell3.appendChild(element3);
		   }
					
	   }
	}
	
	</script>
	
	</form>
</body>
</html>