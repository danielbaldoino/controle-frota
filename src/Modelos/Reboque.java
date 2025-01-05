package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Ajudantes.ModeloBanco;
import BancoDeDados.ConectaBanco;

public class Reboque extends ModeloBanco {
	private String placa;
	private int pesoLimite;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getPesoLimite() {
		return pesoLimite;
	}

	public void setPesoLimite(int pesoLimite) {
		this.pesoLimite = pesoLimite;
	}

	@Override
	public void inserir() {
		String sql = "INSERT INTO reboque(placa, pesolimite) VALUES (?, ?)";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, this.getPlaca());
			ps.setInt(2, this.getPesoLimite());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar() {
		String sql = "UPDATE reboque SET placa=?, pesolimite=? WHERE id=?";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, this.getPlaca());
			ps.setInt(2, this.getPesoLimite());
			ps.setInt(3, this.getId());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar() {
		String sql = "DELETE FROM reboque WHERE id=?";
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
		String sql = "SELECT * FROM reboque";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt("id");
				String placa = rs.getString("placa");
				int pesolimite = rs.getInt("pesolimite");
				String aux = String.format("Código: %d \nPlaca: %s \nPeso Limite: %s", codigo, placa, pesolimite);
				JOptionPane.showMessageDialog(null, aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
