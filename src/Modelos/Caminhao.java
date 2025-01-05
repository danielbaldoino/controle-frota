package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Ajudantes.ModeloBanco;
import BancoDeDados.ConectaBanco;

public class Caminhao extends ModeloBanco {
	private String placa, modelo;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public void inserir() {
		String sql = "INSERT INTO caminhao(placa, modelo) VALUES (?, ?)";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, this.getPlaca());
			ps.setString(2, this.getModelo());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar() {
		String sql = "UPDATE caminhao SET placa=?, modelo=? WHERE id=?";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, this.getPlaca());
			ps.setString(2, this.getModelo());
			ps.setInt(3, this.getId());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar() {
		String sql = "DELETE FROM caminhao WHERE id=?";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, this.getId());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void listar() {
		String sql = "SELECT * FROM caminhao";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt("id");
				String placa = rs.getString("placa");
				String modelo = rs.getString("modelo");
				String aux = String.format("Código: %d \nPlaca: %s \nModelo: %s", codigo, placa, modelo);
				JOptionPane.showMessageDialog(null, aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
