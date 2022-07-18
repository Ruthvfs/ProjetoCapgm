package main;

import controller.Project;
import controller.ProjectController;
import controller.TaskController;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modo.project;
import modo.Task;
import util.ConectionFactory;

public class Main {

	public static void main(String[] args) {
		
		ProjectController projectController= new ProjectController();
		Project project = Project();
		project.setId();
		project.setName("Projeto teste");
		project.setDescription("description");
		projectController.update(project);
		
		List<Project> projects = projectController.getAll();
		System.out.println("Total de projetos= "+ projects.size());
		
		projectController.removeByid(0);
		
		TaskController taskController = new TaskController();
		
		Task task = new Task();
		task.setIdProject(0);
		task.setName("Criar as telas da aplicação");
		task.setDescription("Devem ser criadas telas para os cadastros");
		task.setNotes("Sem notas");
		task.setCompleted(false);
		task.setDeadline(new Date());
		
		taskController.save(task);
		
		task.setName("Alterar telas da aplicação");
		taskController.update(task);
		List<Task> tasks=taskController.getAll(0);
		System.out.println("Total de tarefas= " + tasks.size());
	}

	private static Project Project() {
		// TODO Auto-generated method stub
		return null;
	}

	
	}

	


