package servletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


/**
 * Servlet implementation class Servlet
 */
@WebServlet(description = "This is a sample servlet", urlPatterns = { "/Servlet" })
@MultipartConfig
public class Servlet extends HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;
	private List<Students> studentData;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		studentData= new ArrayList<Students>();
		studentData.add(new Students(50,"Adam"));
		studentData.add(new Students(40,"Hawa"));
	
		JSONObject json = new JSONObject();
		JSONArray List= new JSONArray();
		
		
		for (Students tampung:studentData){
			List.add("name : "+tampung.getName()+","+"id :"+tampung.getId());
		}
		
		json.put("message", "Hello From Server");
		json.put("data", List);
		
		response.getWriter().write(json.toJSONString());
	}
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String user=request.getParameter("searchTerm");
		
		PrintWriter pw=response.getWriter();
		pw.println("You are looking for : "+user);
		List<Students> hasilFilter= studentData.stream().filter(student->student.getName().equals(user)).collect(Collectors.toList());
		
		JSONObject json= new JSONObject();
		JSONArray List=new JSONArray();
		
		for (Students tampung:hasilFilter){
			List.add("name : "+tampung.getName()+","+"id :"+tampung.getId());
		}
		json.put("data", List);
		response.getWriter().write(json.toJSONString());
	}
	

}
