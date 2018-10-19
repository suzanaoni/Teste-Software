package com.fatec.sce.sce.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

public class FabricaDeConexoes {
	
	String url = "jdbc:mysql://localhost:3306/biblioteca";
	String driver = "com.mysql.jdbc.Driver";
	String usuario = "root";
	String senha = "alunofatec";

	public FabricaDeConexoes(ConfiguraDB configura) {
		this.url = configura.getUrl();
		this.driver = configura.getDriver();
		this.usuario = configura.getUsuario();
		this.senha = configura.getSenha();
	}

	public FabricaDeConexoes() {
	}

	public Connection getConnection() {
		try {
			Class.forName(driver);
			return (Connection) DriverManager.getConnection(url, usuario, senha);
		} catch (CommunicationsException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
