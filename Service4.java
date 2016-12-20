        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null)
        {
            request.setAttribute("redirect", "Service4");
            request.getRequestDispatcher("Login")
                    .forward(request, response);
        }
        else
        {
            if(session.getAttribute("username") == null)
            {
                request.setAttribute("redirect", "Service4");
                request.getRequestDispatcher("Login")
                        .forward(request, response);
            }
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Welcome</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Welcome to RPISE " 
                        +session.getAttribute("username")+
                        "</h2>");
            out.println("<ol>");
            out.println("<li> This is Service4 </li>");
            out.println("</ol>");
            out.println("<a href='Welcome' style='padding:20px'> 
            Back </a>");
            out.println("<a href='Logout' style='padding:20px'> 
            Logout </a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
