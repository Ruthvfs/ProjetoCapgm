package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modo.project;
import util.ConectionFactory;

public class ProjectController {

	public void save(Project project) {
		
		String sql="INSERT INTO projects(name,description, createdAt,updatedAt) "
				+ "VALUES(? ,? ,? ,? )";
		
		Connection connection=null;
		PreparedStatement statement= null;
		
		
		try {
			connection = ConectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date (project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
			statement.execute();
		}catch(SQLException ex) {
			throw new RuntimeException("Erro ao salvar project"+ ex.getMessage(),ex);
			
		}finally {
			ConectionFactory.closeConnection(connection, statement);
		}
						
	}
	
	public void update(Project project) {
		
		String sql = "UPDATE projects SET name=?, description=?,createdAt=?, updatedAt=?, WHERE id=?";
		
		Connection connection=null;
		PreparedStatement statement= null;
		
		try {
			connection= ConectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1,project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
			statement.setInt(5, project.getId());
			statement.execute();
		}catch(SQLException ex) {
			throw new RuntimeException("Erro ao atualizar o projeto",ex);
		} finally {
			ConectionFactory.closeConnection(connection, statement);
		}
	}
	public  List <Project> getAll(){
		
		String sql= "SELECT * FROM projects";
		
		List<Project> projects = new ArrayList<>();
		
		Connection connection= null;
		PreparedStatement statement = null;
		
		ResultSet resultSet=null;
		
		List<Project> projects1;
		try {
			connection= ConectionFactory.getConnection();
			statement= connection.prepareStatement(sql);
			
			resultSet= statement.executeQuery();
			
			while (resultSet.next()) {
				
				modo.project project =new project();
				
				project.setId(resultSet.getInt("id"));
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setCreatedAt(resultSet.getDate("createdAt"));
				project.setUpdatedAt(resultSet.getDate("updatedAt"));
				projects.add(project);
			}
		}catch (SQLException ex) {
			throw new RuntimeException("Erro ao buscar os projetos", ex);
		} finally {
			ConectionFactory.closeConnection(connection, statement, resultSet);
		}
		return projects1;
	}
	
	public void removeByid(int idProject) {
		
		String sql = "DELETE FROM projects WHERE id= ?";
		
		Connection connection=null;
		PreparedStatement statement=null;
		
		try {
			connection= ConectionFactory.getConnection();
			statement= connection.prepareStatement(sql);
			statement.setInt(1, idProject);
			statement.execute();
		}catch (SQLException ex) {
			throw new RuntimeException("Erro ao deletar o projeto",ex);
		}finally {
			ConectionFactory.closeConnection(connection, statement);
		}
	}
}

