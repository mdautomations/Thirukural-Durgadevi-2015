package com.spring;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.mortbay.log.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.Entry;
import javax.jdo.Query;
import com.spring.PMF;
import com.google.appengine.labs.repackaged.org.json.JSONException;

@SuppressWarnings("serial")
@Controller

public class SpringServlet {
		private static final ServletResponse response = null;

@RequestMapping(value="/",method=RequestMethod.GET)	
public String userdefined(HttpServletRequest req, HttpServletResponse resp) throws IOException 
{
	return "index";
}
@RequestMapping(value="/admin",method=RequestMethod.GET)	
public String search(HttpServletRequest req, HttpServletResponse resp) throws IOException 
{
	return "home";
}
@RequestMapping(value="/doctors",method=RequestMethod.GET)	
public String doctor(HttpServletRequest req, HttpServletResponse resp) throws IOException 
{
	return "doctor";
}

@RequestMapping(value="/redirect",method=RequestMethod.GET)	
public String redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException 
{
	return "redirectpatient";
}
@RequestMapping(value="/main",method=RequestMethod.GET)	
public String main(HttpServletRequest req, HttpServletResponse resp) throws IOException 
{
	return "admin";
}

@RequestMapping(value="/registeration",method=RequestMethod.POST)
public void registeration(@RequestParam(value="age",required=false)int age,@RequestParam(value="special",required=false)String special,@RequestParam(value="patientID",required=false)String patientID,@RequestParam(value="sessionNam",required=false)String sessionNam,@RequestParam(value="password",required=false)String password,@RequestParam(value="sessionName",required=false)String sessionName,@RequestParam(value="location",required=false)String location,@RequestParam(value="country", required=false) String country,@RequestParam(value="zip", required=false) String zip,@RequestParam(value="blood", required=false) String blood,@RequestParam(value="problem", required=false) String problem,@RequestParam(value="doctor", required=false) String doctor,@RequestParam(value="date", required=false) String date,@RequestParam(value="weight", required=false) String weight,@RequestParam(value="pressure", required=false) String pressure,@RequestParam(value="surgery", required=false) String surgery,HttpServletResponse response,HttpSession session)throws IOException, JSONException
{
	System.out.println(" location  " +location);
	System.out.println(" country :: " +country);
	System.out.println(" zip :: " +zip);
	System.out.println(" blood :: " +blood);
	System.out.println(" problem  " +problem);
	System.out.println(" doctor :: " +doctor);
	System.out.println(" date :: " +date);
	System.out.println(" weight :: " +weight);
	System.out.println(" patientID :: " +patientID);
	System.out.println(" pressure :: " +pressure);
	System.out.println(" surgery :: " +surgery);
	DateFormat dateFormat   = 	new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	PersistenceManager  pm         = PMF.get().getPersistenceManager();
		 try
			{
			    Entry enter =  new Entry();
				UUID uniqueKey	= UUID.randomUUID();
				enter.setemail(sessionName);
				enter.setname(sessionNam);
				enter.setage(age);
				enter.setKey(uniqueKey.toString());
				enter.setLocation(location);
				enter.setCountry(country);
				enter.setZip(zip);
				enter.setBlood(blood);
				enter.setpatientID(patientID);
				enter.setProblem(problem);
				enter.setDoctor(doctor);
				enter.setDate(date);
				enter.setSpecial(special);
				enter.setpassword(password);
				enter.setWeight(weight);
				enter.setPressure(pressure);
				enter.setSurgery(surgery);
				pm.currentTransaction().begin();
				pm.makePersistent(enter);
				pm.currentTransaction().commit();
				session.setAttribute("name", sessionName);
			}
			catch(Exception e)
			{
				e.getStackTrace();
				System.out.println("the exception is this :: "+e);
			}
		 	finally
			{
				pm.close();
			}
			
	 }
@RequestMapping(value="/checkentry",method=RequestMethod.POST)
public @ResponseBody String checkentry(HttpServletResponse response,HttpServletRequest request,HttpSession session)throws IOException, JSONException
{
	System.out.println("the visit comes here");
	PersistenceManager  pm         = PMF.get().getPersistenceManager();
	Entry enter =  new Entry();
	String keyword			=   request.getParameter("searchmail");
	String password			=   request.getParameter("password");
//	session.setAttribute("name", keyword);
	System.out.println("name is this:: "+keyword);
	System.out.println("password is this:: "+password);
	Query queryUserDetails1 =	pm.newQuery(Entry.class," email == '"+keyword+"' && password == '"+password+"'");
//	Query queryUserDetails1 =pm.newQuery(Entry.class," emailsignup == '"+emailsignup+"' && password == '"+password+"'");
	  List<Entry> usersInfo1 = (List<Entry>)queryUserDetails1.execute();
	  System.out.println("list count is :: "+usersInfo1.size());
	  if(usersInfo1.size()!=0)
	  {
		  return "success";
	  }
	  else
	  {
		  return "failure";
	  }
}
@RequestMapping(value="/patientID",method=RequestMethod.POST)
public @ResponseBody String patient(HttpServletResponse response,HttpServletRequest request,HttpSession session)throws IOException, JSONException
{
	System.out.println("visitng this mining controller");
	String name = "";
	PersistenceManager pm			= null;
	Query queryUserDetails			= null;
	List<Entry> usersInfo			= null;
	String status					=	"";
	try
	{
		pm			= PMF.get().getPersistenceManager();
		HashMap<String, Entry> tableEntry = new HashMap<String,Entry>();
		queryUserDetails					= 	pm.newQuery(Entry.class);
		usersInfo							= 	(List<Entry>) queryUserDetails.execute();
		for(Entry value:usersInfo)
		{
			tableEntry.put(value.getKey().toString(),value);
		}
		status								= new ObjectMapper().writeValueAsString(tableEntry);
	}
	catch (Exception e)
	{
		System.out.println("THE EXCEPTION ARISED IN DATATABLE"+e);
	}
	return status;
}
@RequestMapping(value="/addsearch",method=RequestMethod.POST)
public @ResponseBody String addsearch(HttpServletResponse response,HttpServletRequest request,HttpSession session)throws IOException, JSONException
{
	return null;
//	String username 		= "";
//	String keyword			= "" ;
//	PersistenceManager  pm  = PMF.get().getPersistenceManager();
//	Boolean status			= false;
//	try
//	{
//		username		=  (String) session.getAttribute("name");
//		keyword			=  request.getParameter("searchterm");
//		System.out.println("the username is this ::"+username);
//		System.out.println("the username is this ::"+keyword);
//	    Search search	=  new Search();
//		UUID uniqueKey	=  UUID.randomUUID();
//		search.setname(username);
//		search.setkey(uniqueKey.toString());
//		search.searchedTerm(keyword);
//		pm.currentTransaction().begin();
//		pm.makePersistent(search);
//		pm.currentTransaction().commit();
//		status			= true;
//	}
//	catch(Exception e)
//	{
//		e.getStackTrace();
//		System.out.println("the exception is this :: "+e);
//	}
// 	finally
//	{
//		pm.close();
////		session.invalidate();
//	}
//	return "success";
}
	
@RequestMapping(value="/dataURL",method=RequestMethod.POST)
public @ResponseBody String search(HttpServletResponse response,HttpServletRequest request,HttpSession session)throws IOException, JSONException
{
	String name						= "";
	String status					= "";
	String keyword			= "" ;
	PersistenceManager pm			= null;
	Query queryUserDetails			= null;
	List<Entry> usersInfo			= null;
	try
	{
		keyword			=  request.getParameter("searchterm");
		pm			= PMF.get().getPersistenceManager();
		HashMap<String, Entry> tableEntry = new HashMap<String,Entry>();
		queryUserDetails					= 	pm.newQuery(Entry.class,"patientID == '"+keyword+"'");
		usersInfo							= 	(List<Entry>) queryUserDetails.execute();
		
		for(Entry value:usersInfo)
		{
			tableEntry.put(value.getKey().toString(),value);
		}
		status								= new ObjectMapper().writeValueAsString(tableEntry);
	}
	catch(Exception e)
	{
		System.out.println("THE EXCEPTION ARISED IN DATATABLE"+e);
	}
	finally
	{
		//session.invalidate();
	}
	return status;
}
@RequestMapping(value="/doctorszone",method=RequestMethod.POST)
public @ResponseBody String doctorszone(HttpServletResponse response,HttpServletRequest request,HttpSession session)throws IOException, JSONException
{
	System.out.println("visitng this ");
	String name = "";
	PersistenceManager pm			= null;
	Query queryUserDetails			= null;
	List<Entry> usersInfo			= null;
	String status					=	"";
	try
	{
		name = (String) session.getAttribute("name");
		pm			= PMF.get().getPersistenceManager();
		HashMap<String, Entry> tableEntry = new HashMap<String,Entry>();
		queryUserDetails					= 	pm.newQuery(Entry.class,"name == '"+name+"'");
		usersInfo							= 	(List<Entry>) queryUserDetails.execute();
		for(Entry value:usersInfo)
		{
			tableEntry.put(value.getKey().toString(),value);
		}
		status								= new ObjectMapper().writeValueAsString(tableEntry);
	}
	catch (Exception e)
	{
		System.out.println("THE EXCEPTION ARISED IN DATATABLE"+e);
	}
	
	return status;
}
@RequestMapping(value="/miningData",method=RequestMethod.POST)
public @ResponseBody String miningData(HttpServletResponse response,HttpServletRequest request,HttpSession session)throws IOException, JSONException
{
	System.out.println("visitng this mining controller");
	String name = "";
	PersistenceManager pm			= null;
	Query queryUserDetails			= null;
	List<Entry> usersInfo			= null;
	String status					=	"";
	try
	{
		pm			= PMF.get().getPersistenceManager();
		HashMap<String, Entry> tableEntry = new HashMap<String,Entry>();
		queryUserDetails					= 	pm.newQuery(Entry.class);
		usersInfo							= 	(List<Entry>) queryUserDetails.execute();
		for(Entry value:usersInfo)
		{
			tableEntry.put(value.getKey().toString(),value);
		}
		status								= new ObjectMapper().writeValueAsString(tableEntry);
	}
	catch (Exception e)
	{
		System.out.println("THE EXCEPTION ARISED IN DATATABLE"+e);
	}
	return status;
}
@RequestMapping(value="/doctordata",method=RequestMethod.POST)
public @ResponseBody String doctordata(HttpServletResponse response,HttpServletRequest request,HttpSession session)throws IOException, JSONException
{
	System.out.println("visitng this mining controller");
	String name = "";
	PersistenceManager pm			= null;
	Query queryUserDetails			= null;
	List<Entry1> usersInfo			= null;
	String status					=	"";
	try
	{
		pm			= PMF.get().getPersistenceManager();
		HashMap<String, Entry1> tableEntry = new HashMap<String,Entry1>();
		queryUserDetails					= 	pm.newQuery(Entry1.class);
		usersInfo							= 	(List<Entry1>) queryUserDetails.execute();
		for(Entry1 value:usersInfo)
		{
			tableEntry.put(value.getkey().toString(),value);
		}
		status								= new ObjectMapper().writeValueAsString(tableEntry);
	}
	catch (Exception e)
	{
		System.out.println("THE EXCEPTION ARISED IN DATATABLE"+e);
	}
	return status;
}
@RequestMapping(value="/medicineData",method=RequestMethod.POST)
public @ResponseBody String medicineData(HttpServletResponse response,HttpServletRequest request,HttpSession session)throws IOException, JSONException
{
	System.out.println("visitng this mining controller");
	String name = "";
	PersistenceManager pm			= null;
	Query queryUserDetails			= null;
	List<medicine> usersInfo			= null;
	String status					=	"";
	try
	{
		pm			= PMF.get().getPersistenceManager();
		HashMap<String, medicine> tableEntry = new HashMap<String,medicine>();
		queryUserDetails					= 	pm.newQuery(medicine.class);
		usersInfo							= 	(List<medicine>) queryUserDetails.execute();
		for(medicine value:usersInfo)
		{
			tableEntry.put(value.getkey().toString(),value);
		}
		status								= new ObjectMapper().writeValueAsString(tableEntry);
	}
	catch (Exception e)
	{
		System.out.println("THE EXCEPTION ARISED IN DATATABLE"+e);
	}
	return status;
}
@RequestMapping(value="/medicineinsert",method=RequestMethod.POST)
public void medicineinsert(
		@RequestParam(value="Medicinename",required=false)String Medicinename,
		@RequestParam(value="Medicineid",required=false)String Medicineid,
		@RequestParam(value="composition",required=false)String composition,
		@RequestParam(value="expiry",required=false)String expiry,
		@RequestParam(value="quantity",required=false)String quantity,HttpServletResponse response,HttpSession session)throws IOException, JSONException
{
	
	PersistenceManager  pm         = PMF.get().getPersistenceManager();
		 try
			{
			    medicine enter =  new medicine();
				UUID uniqueKey	= UUID.randomUUID();
				enter.setkey(uniqueKey.toString());
				enter.setmedicinename(Medicinename);
				enter.setmedicineid(Medicineid);
				enter.setcomposition(composition);
				enter.setquantity(quantity);
				enter.setexpiry(expiry);
				pm.currentTransaction().begin();
				pm.makePersistent(enter);
				pm.currentTransaction().commit();
			}
			catch(Exception e)
			{
				e.getStackTrace();
				System.out.println("the exception is this :: "+e);
			}
		 	finally
			{
				pm.close();
			}
			
	 }
@RequestMapping(value="/doctorinsert",method=RequestMethod.POST)
public void doctorinsert(
		@RequestParam(value="doctoremail",required=false)String doctoremail,
		@RequestParam(value="doctorid",required=false)String doctorID,
		@RequestParam(value="doctorname",required=false)String doctorname,
		@RequestParam(value="address",required=false)String address,
		@RequestParam(value="specialization",required=false)String specialization,HttpServletResponse response,HttpSession session)throws IOException, JSONException
{
	
	PersistenceManager  pm         = PMF.get().getPersistenceManager();
		 try
			{
			    Entry1 enter =  new Entry1();
				UUID uniqueKey	= UUID.randomUUID();
				enter.setkey(uniqueKey.toString());
				enter.setdoctoremail(doctoremail);
				enter.setdoctorID(doctorID);
				enter.setdoctorname(doctorname);
				enter.setLocation(address);
				enter.setspecialization(specialization);
				pm.currentTransaction().begin();
				pm.makePersistent(enter);
				pm.currentTransaction().commit();
			}
			catch(Exception e)
			{
				e.getStackTrace();
				System.out.println("the exception is this :: "+e);
			}
		 	finally
			{
				pm.close();
			}
			
	 }

}

