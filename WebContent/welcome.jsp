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
        
    <title>Crack Your Way</title>

</head>
<body>

       <%
        String url = (String) session.getAttribute("qid")+".png";
       
       %>
       
        <div class="float-right display-4"> <span>Welcome,<%=session.getAttribute("user") %></span> </div>
         <div class="card-body">
         <div class="text-center display-1"> <span> Q:<%=session.getAttribute("qcount") %></span> </div>
        
         <!-- For testing only , replace this with Actual image link below -->
         <img class="img-fluid" src="./image/test.png" alt="<%=session.getAttribute("qid")%>" >
         
         <!--  Actual image link   
         <img class="img-fluid" src="./image/<%=url %>" alt="<%=session.getAttribute("qid")%>">
          -->   
 			<br/><br/>
                    <form method="post"  action="./process">
                        <div class="input-group form-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fas fa-key"></i></span>
                            </div>
                            <input type="password" name="code" class="form-control" placeholder="Codeword">
                        </div>
        
                        <div class="form-group">
                        <div class="text-center">    <input type="submit" name="btn" value="Submit" class="btn btn-outline-danger btn-sx login_btn"> </div>
                        </div>
        
                    </form>
                </div>
</body>
</html>