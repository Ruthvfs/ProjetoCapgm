package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modo.Task;
import util.ConectionFactory;

public class TaskController {
	
	public void save(Task task) {
		
		String sql ="INSERT INTO tasks (idProject,name,description,completed,notes,deadline,createdAt,updatedAt)"
				+ " VALUES (?,?,?,?,?,?,?,?)";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = ConectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, task.getIdProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setBoolean(4, task.isCompleted());
			statement.setString(5, task.getNotes());
			statement.setDate(6, new Date (task.getDeadline().getTime()));
			statement.setDate(7, new Date(task.getCreatedAt().getTime()));
			statement.setDate(8, new Date (task.getUpdatedAt().getTime()));
			statement.execute();
		} catch (Exception ex) {
			throw new RuntimeException("Erro ao salvar tarefa"+ ex.getMessage(), ex);
		}finally {
			ConectionFactory.closeConnection(connection, statement);
			
		}
	}
	
	public void update(Task task) {
		
		String sql = "UPDATE tasks SET "
				+ " idProject = ?,"
				+ " name = ?, "
				+ " description = ?,"
				+ " notes = ?,"
				+ " completed = ?, "
				+ " deadline = ?,"
				+ " createdAt = ?,"
				+ " updateAt = ?,"
				+ " WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
//			Estabelecendo uma conexão com o banco de dados
			
			connection = ConectionFactory.getConnection();
			
//			Preparando a query
			statement = connection.prepareStatement(sql);
			
//			setando os valores do statament
			statement.setInt(1, task.getIdProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setString(4, task.getNotes());
			statement.setBoolean(5, task.isCompleted());
			statement.setDate(6, new Date (task.getDeadline().getTime()));
			statement.setDate(7, new Date (task.getCreatedAt().getTime()));
			statement.setDate(8, new Date (task.getUpdatedAt().getTime()));
			statement.setInt(9, task.getId());
//			executando a query
			statement.execute();
		} catch (Exception ex) {
			throw new RuntimeException("Erro ao atualizar a tarefa"+ ex.getMessage(), ex);
		}
		
	}
	
	public void removeByid(int taskId) throws SQLException {
		
		String sql = "DELETE FROM tasks WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
//			criaçaõ da conexão com o banco de dados
			connection= ConectionFactory.getConnection();
			
//			preparando a query
			statement = connection.prepareStatement(sql);
			
//			setando os valores
			statement.setInt(1, taskId);
			
//			executando a query
			statement.execute();
			
		} catch (Exception ex) {
			throw new RuntimeException("Erro ao deletar a tarefa"+ ex.getMessage(), ex);
		} finally {
			ConectionFactory.closeConnection(connection, statement);
		}
		
	}
	public List<Task> getAll(int idProject){
	  
		String sql= "SELECT * FROM tasks WHERE idProject = ?";
		
		Connection connection= null;
		PreparedStatement statement=null;
		ResultSet resultSet = null;
//		lista de tarefas que sera desenvolvida quando a chamada do metodo acontecer
		List<Task> tasks = new ArrayList<Task>();
		
		try {
//			 criaçaõ da conexão
			connection = ConectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			
//			setando o valor que corresponde ao filtro de busca 
			statement.setInt(1, idProject);
			
//			valor retornado pela execução da query
			resultSet=statement.executeQuery();
			
//			enquanto houver valores a serem percorridos no meu resultSet
			while(resultSet.next()) {
				
				Task task = new Task();
				task.setId(resultSet.getInt("id"));
				task.setIdProject(resultSet.getInt("idProject"));
				task.setName(resultSet.getString("name"));
				task.setDescription(resultSet.getString("description"));
				task.setNotes(resultSet.getString("notes"));
				task.setCompleted(resultSet.getBoolean("completed"));
				task.setDeadline(resultSet.getDate("deadline"));
				task.setCreatedAt(resultSet.getDate("createdAt"));
				task.setUpdatedAt(resultSet.getDate("updatedAt"));
				
				tasks.add(task);
			}
		}catch (Exception ex){
			throw new RuntimeException("Erro ao inserir a tarefa"+ ex.getMessage(), ex);
		}finally {
			ConectionFactory.closeConnection(connection, statement,resultSet);
		}
//	lista de tarefas que foi criada e carregada do banco de dados
		return tasks;
	}
	
	

}
