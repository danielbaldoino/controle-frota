package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Ajudantes.ModeloBanco;
import BancoDeDados.ConectaBanco;

public class Empresa extends ModeloBanco {
	private String nome, documento, endereco;

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public void inserir() {
		String sql = "INSERT INTO empresa(nome, documento, endereco) VALUES (?, ?, ?)";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, this.getNome());
			ps.setString(2, this.getDocumento());
			ps.setString(3, this.getEndereco());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar() {
		String sql = "UPDATE empresa SET nome=?, documento=?, endereco=? WHERE id=?";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, this.getNome());
			ps.setString(2, this.getDocumento());
			ps.setString(3, this.getEndereco());
			ps.setInt(4, this.getId());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar() {
		String sql = "DELETE FROM empresa WHERE id=?";
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
		String sql = "SELECT * FROM empresa";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt("id");
				String nome = rs.getString("nome");
				String documento = rs.getString("documento");
				String endereco = rs.getString("endereco");
				String aux = String.format("Código: %d \nNome: %s \nDocumento: %s \nEndereço: %s", codigo, nome,
						documento, endereco);
				JOptionPane.showMessageDialog(null, aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
