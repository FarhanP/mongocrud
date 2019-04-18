package com.mindtree.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mindtree.ClientService.ClientService;
import com.mindtree.model.Student;

@Controller
public class AppController 
{
	@Autowired
	ClientService clientservice;
	
	@RequestMapping(value="/welcome")
	public ModelAndView showWelcome()
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("welcome");
		return model;
		
	}
	
	@RequestMapping(value="/form")
	public ModelAndView showform()
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("form");
		return model;
	}
	
	
	@RequestMapping(value="/submitted")
	public ModelAndView submit(@ModelAttribute Student student) throws JsonParseException, JsonMappingException, IOException
	{
		ModelAndView model = new ModelAndView();
		ClientService.createStudent(student);
		model.setViewName("submitted");
		return model;
	}
	
	@RequestMapping(value="/allStudent")
	public ModelAndView display() throws JsonProcessingException
	{
		ModelAndView model = new ModelAndView();
		List<Student> lists=ClientService.displayStudent();
		model.addObject("list",lists);
		model.setViewName("allStudent");
		return model;
	}
	
	@RequestMapping(value="/updateName")
	public ModelAndView update()
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("updateName");
		return model;
	}
	
	@RequestMapping(value="/updated")
	public ModelAndView updated(@RequestParam String studentName,@ModelAttribute Student upstudent) throws IOException
	{
		ModelAndView model = new ModelAndView();
		model.addObject(ClientService.updateStudent(studentName, upstudent));
		model.addObject("updated","success..");
		model.setViewName("updated");
		return model;
	}
	

	@RequestMapping(value="/deleteName")
	public ModelAndView delete()
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("deleteName");
		return model;
	}
	

	@RequestMapping(value="/deleted")
	public ModelAndView deleted(String studentName)
	{
		ModelAndView model = new ModelAndView();
		model.addObject(ClientService.deleteStudent(studentName));
		model.addObject("deleted","success...");
		model.setViewName("deleted");
		return model;
	}
	
}
