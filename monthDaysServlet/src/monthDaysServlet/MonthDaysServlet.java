package monthDaysServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MonthDaysServlet extends HttpServlet {
	@Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html"); 
	    PrintWriter out = response.getWriter(); 
	    out.write("<!DOCTYPE html>\n" + 
	       "<html>\n" +
	       "<head><title>A for counting days for specified month</title></head>\n" +
	       "<body bgcolor=\"#fdf5e5\">\n" +
	       "<h1>Days:</h1>\n"); 
	    String month = request.getParameter("month");
	    System.out.println(month);
	    if (month != null) { 
	    	SimpleDateFormat sdf = new SimpleDateFormat("MMMM", Locale.ENGLISH);  
	    	Calendar calendar = Calendar.getInstance();
	    	try {
				calendar.setTime(sdf.parse(month));
		    	int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		    	System.out.println(calendar.get(Calendar.MONTH) + "||" + days);
		    	out.write("<p>"+ days + "</p>\n");
			} catch (ParseException e) {
				out.write("<p>WRONG MONTH'S NAME</p>\n");
				
			}
	    	
	    }
	    out.write("</body></html>");
	  }
}
