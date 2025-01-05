package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Ajudantes.ModeloBanco;
import BancoDeDados.ConectaBanco;

public class Motorista extends ModeloBanco {
	private String nome, documento, telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public void inserir() {
		String sql = "INSERT INTO motorista(nome, documento, telefone) VALUES (?, ?, ?)";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, this.getNome());
			ps.setString(2, this.getDocumento());
			ps.setString(3, this.getTelefone());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar() {
		String sql = "UPDATE motorista SET nome=?, documento=?, telefone=? WHERE id=?";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, this.getNome());
			ps.setString(2, this.getDocumento());
			ps.setString(3, this.getTelefone());
			ps.setInt(4, this.getId());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar() {
		String sql = "DELETE FROM motorista WHERE id=?";
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
		String sql = "SELECT * FROM motorista";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt("id");
				String nome = rs.getString("nome");
				String documento = rs.getString("documento");
				String telefone = rs.getString("telefone");
				String aux = String.format("Código: %d \nNome: %s \nDocumento: %s \nTelefone: %s", codigo, nome,
						documento, telefone);
				JOptionPane.showMessageDialog(null, aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
