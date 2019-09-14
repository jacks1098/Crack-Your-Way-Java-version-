<%
	if(session.getAttribute("user")==null) 
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
%>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
      
    <title>Winner</title>

   
</head>
<body>      
        <div class="float-right display-4"> <span>Welcome,<%=session.getAttribute("user") %></span> </div>
         <div class="card-body">
         <%
         	Integer count = (Integer) session.getAttribute("qcount");
         	if(count>=21)
         	{
         %>
         <div class="text-center display-1"> <p class="text-success">Congratulations...</p> </div>
         <%
         	}
         	else
         	{
         %>   
           <div class="text-center display-1"> <p class="text-danger">Cheater...</p> </div>   
          <%
         	}          
          %> 
            <!-- Replace this image link with actual image link -->
            <img class="img-fluid" src="./image/testwinner.png" alt="Sample test Winner"> 
            
            <!-- actual image link 
         <img class="img-fluid" src="./image/winner.png" alt="Winner Winner Chicken Dinner"> 
            -->    
</div>
</body>
</html>