package net.ausiasmarch.bean;

import com.google.gson.annotations.Expose;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TipoUsuarioBean implements BeanInterface {

    @Expose
    private Integer id;
    @Expose
    private String descripcion;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public TipoUsuarioBean fill(ResultSet oResultSet) throws SQLException {
        this.setId(oResultSet.getInt("id"));
        this.setDescripcion(oResultSet.getString("descripcion"));
        return this;
    }

    @Override
    public PreparedStatement orderSQL(List<String> orden, PreparedStatement oPreparedStatement, int i) throws SQLException {
        if (orden.get((i - 1)).equalsIgnoreCase("id")) {
            oPreparedStatement.setInt(i, 1);
        } else if (orden.get((i - 1)).equalsIgnoreCase("descripcion")) {
            oPreparedStatement.setInt(i, 2);
        }
        return oPreparedStatement;
    }

    @Override
    public String getField4Insert() throws SQLException {
        return "INSERT INTO tipo_usuario (descripcion) VALUES(?)";
    }

    @Override
    public int setField4Insert(PreparedStatement oPreparedStatement) throws SQLException {
        oPreparedStatement.setString(1, this.getDescripcion());
        int iResult = oPreparedStatement.executeUpdate();
        return iResult;
    }

    @Override
    public String getField4Update() throws SQLException {
        return "UPDATE tipo_usuario SET (cantidad,producto_id,factura_id) VALUES(?,?,?) WHERE id=?";
    }

    @Override
    public int setField4Update(PreparedStatement oPreparedStatement) throws SQLException {
        oPreparedStatement.setString(1, this.getDescripcion());
        int iResult = oPreparedStatement.executeUpdate();
        return iResult;
    }
}
