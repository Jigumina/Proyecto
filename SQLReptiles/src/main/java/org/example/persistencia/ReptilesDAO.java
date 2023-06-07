package org.example.persistencia;

import org.example.ConexionSingleton;
import org.example.modelo.Reptiles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReptilesDAO implements InterfazDAO {

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO Reptiles(Grupo,Nombre,Habitat,Alimentacion,URL) VALUES(?,?,?,?,?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.get_instance("Reptilesdb.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((Reptiles) obj).getGrupo());
        pstm.setString(2, ((Reptiles) obj).getNombre());
        pstm.setString(3, ((Reptiles) obj).getHabitat());
        pstm.setString(4, ((Reptiles) obj).getAlimentacion());
        pstm.setString(5, ((Reptiles) obj).getURL());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE Reptiles SET Grupo = ?, Nombre = ?, Habitat = ?, Alimentacion = ?, URL = ? WHERE ID = ?";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.get_instance("Reptilesdb.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setInt(6, ((Reptiles) obj).getID());
        pstm.setString(1, ((Reptiles) obj).getGrupo());
        pstm.setString(2, ((Reptiles) obj).getNombre());
        pstm.setString(3, ((Reptiles) obj).getHabitat());
        pstm.setString(4, ((Reptiles) obj).getAlimentacion());
        pstm.setString(5, ((Reptiles) obj).getURL());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(Object obj) throws SQLException {
        String sqlDelete = "DELETE FROM Reptiles WHERE ID = ? ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.get_instance("Reptilesdb.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, ((Reptiles) obj).getID());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM Reptiles";
        ArrayList<Reptiles> resultado = new ArrayList<>();

        Statement stm = ConexionSingleton.get_instance("Reptilesdb.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            resultado.add(new Reptiles(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6)));

        }
        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM Reptiles  WHERE id = ? ;";
        Reptiles reptiles = null;
        PreparedStatement pstm = ConexionSingleton.get_instance("Reptilesdb.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            reptiles = new Reptiles(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
        }
        return reptiles;
    }
}
