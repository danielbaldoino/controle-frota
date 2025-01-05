package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Ajudantes.ModeloBanco;
import BancoDeDados.ConectaBanco;

public class Viagem extends ModeloBanco {
	private int motoristaId, caminhaoId, reboqueId, empresaOrigemId, empresaDestinoId;
	private String dataPartida, dataChegada, carga;

	public int getMotoristaId() {
		return motoristaId;
	}

	public void setMotoristaId(int motoristaId) {
		this.motoristaId = motoristaId;
	}

	public int getCaminhaoId() {
		return caminhaoId;
	}

	public void setCaminhaoId(int caminhaoId) {
		this.caminhaoId = caminhaoId;
	}

	public int getReboqueId() {
		return reboqueId;
	}

	public void setReboqueId(int reboqueId) {
		this.reboqueId = reboqueId;
	}

	public int getEmpresaOrigemId() {
		return empresaOrigemId;
	}

	public void setEmpresaOrigemId(int empresaOrigemId) {
		this.empresaOrigemId = empresaOrigemId;
	}

	public int getEmpresaDestinoId() {
		return empresaDestinoId;
	}

	public void setEmpresaDestinoId(int empresaDestinoId) {
		this.empresaDestinoId = empresaDestinoId;
	}

	public String getDataPartida() {
		return dataPartida;
	}

	public void setDataPartida(String dataPartida) {
		this.dataPartida = dataPartida;
	}

	public String getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(String dataChegada) {
		this.dataChegada = dataChegada;
	}

	public String getCarga() {
		return carga;
	}

	public void setCarga(String carga) {
		this.carga = carga;
	}

	@Override
	public void inserir() {
		String sql = "INSERT INTO viagem(motoristaid, caminhaoid, reboqueid, empresaorigemid, empresadestinoid, datapartida, datachegada, carga) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, this.getMotoristaId());
			ps.setInt(2, this.getCaminhaoId());
			ps.setInt(3, this.getReboqueId());
			ps.setInt(4, this.getEmpresaOrigemId());
			ps.setInt(5, this.getEmpresaDestinoId());
			ps.setString(6, this.getDataPartida());
			ps.setString(7, this.getDataChegada());
			ps.setString(8, this.getCarga());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar() {
		String sql = "UPDATE viagem SET motoristaid=?, caminhaoid=?, reboqueid=?, empresaorigemid=?, empresadestinoid=?, datapartida=?, datachegada=?, carga=? WHERE id=?";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, this.getMotoristaId());
			ps.setInt(2, this.getCaminhaoId());
			ps.setInt(3, this.getReboqueId());
			ps.setInt(4, this.getEmpresaOrigemId());
			ps.setInt(5, this.getEmpresaDestinoId());
			ps.setString(6, this.getDataPartida());
			ps.setString(7, this.getDataChegada());
			ps.setString(8, this.getCarga());
			ps.setInt(9, this.getId());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar() {
		String sql = "DELETE FROM viagem WHERE id=?";
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
		String sql = "SELECT v.id, m.nome as motorista, c.placa as caminhao, r.placa as reboque, e.nome as origem, ed.nome as destino, v.datapartida, v.datachegada, v.carga FROM viagem v, motorista m, caminhao c, reboque r, empresa e, empresa ed WHERE v.motoristaid = m.id AND v.caminhaoid = c.id AND v.reboqueid = r.id AND v.empresaorigemid = e.id AND v.empresadestinoid = ed.id";
		ConectaBanco factory = new ConectaBanco();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt("id");
				String motorista = rs.getString("motorista");
				String caminhao = rs.getString("caminhao");
				String reboque = rs.getString("reboque");
				String origem = rs.getString("origem");
				String destino = rs.getString("destino");
				String datapartida = rs.getString("datapartida");
				String datachegada = rs.getString("datachegada");
				String carga = rs.getString("carga");
				String aux = String.format(
						"Código: %d, \nMotorista: %s \nCaminhão: %s \nReboque: %s \nOrigem: %s \nDestino: %s \nData Partida: %s \nData Chegada: %s \nCarga: %s",
						codigo, motorista, caminhao, reboque, origem, destino, datapartida, datachegada, carga);
				JOptionPane.showMessageDialog(null, aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
