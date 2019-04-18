package com.mindtree.ClientService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.model.Student;

@Service
public class ClientService 
{
	public static void createStudent(Student student) throws JsonParseException, JsonMappingException, IOException
	
	{
		Client client=ClientBuilder.newClient();
		ObjectMapper map= new ObjectMapper();
		List<Student> stud=null;
		String json=map.writeValueAsString(student);
		System.out.println(json);
		client.target("http://localhost:8080/create").request().post(Entity.entity(json, javax.ws.rs.core.MediaType.APPLICATION_JSON));
	}
		
		
	
	
	public static List<Student> displayStudent() throws JsonProcessingException
	{
		Client client=ClientBuilder.newClient();
		ObjectMapper map= new ObjectMapper();
		List<Student> stud=new ArrayList();
		Response response=client.target("http://localhost:8080/getAll").request().get();
		try{
			if(response!=null && response.getStatus()==200)
			{
				String json=response.readEntity(String.class);
				System.out.println(json);
				stud=map.readValue(json, new TypeReference<List<Student>>(){});
				
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return stud;
		
	}




	public static String updateStudent(String studentName, Student student) throws IOException {

		Client client=ClientBuilder.newClient();
		ObjectMapper map= new ObjectMapper();
		String json=map.writeValueAsString(student);
		client.target("http://localhost:8080/update/"+studentName+"").request().put(Entity.entity(json, javax.ws.rs.core.MediaType.APPLICATION_JSON));
		return "updated..";
		


	
 }




	public  static String deleteStudent(String studentName) 
	{

		Client client=ClientBuilder.newClient();
		ObjectMapper map= new ObjectMapper();

		client.target("http://localhost:8080/delete/"+studentName+"").request().delete();
		return "deleted..";
	
	}
}