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
	    response.setContentType("text/html"); //Задаем формат ответа - HTML, текст
	    PrintWriter out = response.getWriter(); //Получаем объект, позволяющий записать контент в ответ 
	    out.write("<!DOCTYPE html>\n" + // Записываем в ответ HTML код простейшей странички
	       "<html>\n" +
	       "<head><title>A servlet without templates.</title></head>\n" +
	       "<body bgcolor=\"#fdf5e5\">\n" +
	       "<h1>Note:</h1>\n" +
	       "<p>This whole page was created via servlet Direct</p>\n"); 
	    String month = request.getParameter("month");
	    System.out.println(month);
	    if (month != null) {
	    	SimpleDateFormat sdf = new SimpleDateFormat("MMMM", Locale.ENGLISH);
	    	//System.out.println(sdf.format(new Date()));
	    	Calendar calendar = Calendar.getInstance();
	    	try {
				calendar.setTime(sdf.parse(month));
		    	int days = calendar.getMaximum(Calendar.DAY_OF_MONTH);
		    	System.out.println(calendar.get(Calendar.MONTH) + "||" + days);
		    	out.write("<h1>"+ days + "</h1>\n");
			} catch (ParseException e) {
				out.write("<h1>WRONG MONTH'S NAME</h1>\n");
				//e.printStackTrace();
			}
	    	
	    }
	    out.write("</body></html>");
	  }
}
