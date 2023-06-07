package org.example.modelo;

import com.sun.jdi.Value;
import org.example.persistencia.ReptilesDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.nio.channels.ScatteringByteChannel;
import java.sql.SQLException;
import java.util.ArrayList;

public class Tabla implements TableModel {
    public static final int COLUMN = 6;
    private ArrayList<Reptiles> datos;
    private ReptilesDAO ldao;

    public Tabla() {
        ldao = new ReptilesDAO();
        datos = new ArrayList<>();
    }

    public Tabla(ArrayList<Reptiles> datos) {
        this.datos = datos;
        ldao = new ReptilesDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Grupo";
            case 2:
                return "Nombre cientifico";
            case 3:
                return "Habitat";
            case 4:
                return "Alimentacion";
            case 5:
                return "URL";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;

            case 3:
                return String.class;

            case 4:
                return String.class;

            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reptiles tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getID();
            case 1:
                return tmp.getGrupo();
            case 2:
                return tmp.getNombre();
            case 3:
                return tmp.getHabitat();
            case 4:
                return tmp.getAlimentacion();
            case 5:
                return tmp.getURL();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                //datos.get(rowIndex).setID((int) aValue);
                break;
            case 1:
                datos.get(rowIndex).setGrupo((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setNombre((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setHabitat((String) aValue);
                break;
            case 4:
                datos.get(rowIndex).setAlimentacion((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setURL((String) aValue);
                break;
            default:
                System.out.println("No se modifica nada");

        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void cargarDatos() {
        try {
            datos = ldao.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }

    }

    public boolean agregar(Reptiles reptiles) {
        boolean result = false;
        try {
            if (ldao.insertar(reptiles)) {
                datos.add(reptiles);
                result = true;
            } else {
                result = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return result;
    }

    public Reptiles indexRep(int index) {
        if (index >= 0 && index < datos.size()) {
            return datos.get(index);
        } else {
            return null;
        }
    }

    public boolean updateRep(Reptiles reptiles) {
        boolean result = false;
        try {
            if (ldao.update(reptiles)) {
                result = true;
            } else {
                result = false;
            }

        } catch (SQLException sqle) {

            System.out.println(sqle.getMessage());
        }
        return result;
    }

    public boolean DeleteRep(Reptiles reptiles) {
        boolean result = false;
        try {
            if (ldao.delete(reptiles)) {
                result = true;
            } else {
                result = false;
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());

        }
        return result;
    }

    public Reptiles getRepIndex(int index) {
        if (index >= 0 && index < datos.size()) {
            return datos.get(index);
        } else {
            return null;
        }
    }
}
