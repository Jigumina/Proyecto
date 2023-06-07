package org.example.controlador;

import org.example.modelo.Reptiles;
import org.example.modelo.Tabla;
import org.example.vista.VentanaReptil;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

public class ControladorTabla extends MouseAdapter {
    private VentanaReptil view;
    private Tabla modelo;

    public ControladorTabla(VentanaReptil view) {
        this.view = view;
        modelo = new Tabla();
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnUpdate().addMouseListener(this);
        this.view.getBtnDelete().addMouseListener(this);
        this.view.getTblTabla().addMouseListener(this);
        this.view.getBtnCargar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getBtnCargar()) {
            modelo.cargarDatos();
            this.view.getTblTabla().setModel(modelo);
        }
        if (e.getSource() == this.view.getBtnAgregar()) {
            Reptiles reptiles = new Reptiles();
            reptiles.setID(Integer.parseInt(this.view.getTxtid().getText()));
            reptiles.setGrupo(this.view.getTxtGrupo().getText());
            reptiles.setNombre(this.view.getTxtNombre().getText());
            reptiles.setHabitat(this.view.getTxtHabitat().getText());
            reptiles.setAlimentacion(this.view.getTxtAlimentacion().getText());
            reptiles.setURL(this.view.getTxtURL().getText());
            if (modelo.agregar(reptiles)) {
                JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblTabla().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos. Por favor revise su conexion",
                        "Error al insertar", JOptionPane.ERROR_MESSAGE);

            }
            this.view.getTxtGrupo().setText("");
            this.view.getTxtNombre().setText("");
            this.view.getTxtHabitat().setText("");
            this.view.getTxtAlimentacion().setText("");
            this.view.getTxtURL().setText("");
        }


        if (e.getSource() == this.view.getBtnUpdate()) {
            Reptiles reptiles = new Reptiles();
            reptiles.setGrupo(this.view.getTxtGrupoMod().getText());
            reptiles.setNombre(this.view.getTxtNombreMod().getText());
            reptiles.setHabitat(this.view.getTxtHabitatMod().getText());
            reptiles.setAlimentacion(this.view.getTxtAlimentacionMod().getText());
            reptiles.setID(Integer.parseInt(this.view.getTxtidMod().getText()));
            reptiles.setURL(this.view.getTxtURLMod().getText());
            if (modelo.updateRep(reptiles)) {
                this.view.getTblTabla().updateUI();
                JOptionPane.showMessageDialog(view, "Se modifico correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo modificar. Por favor introduzca un id valido",
                        "Error al modificar", JOptionPane.ERROR_MESSAGE);

            }
            this.view.getTxtidMod().setText("");
            this.view.getTxtGrupoMod().setText("");
            this.view.getTxtNombreMod().setText("");
            this.view.getTxtHabitatMod().setText("");
            this.view.getTxtAlimentacionMod().setText("");
            this.view.getTxtURLMod().setText("");
        }

        if (e.getSource() == view.getBtnDelete()) {
            this.view.getTblTabla().updateUI();
            Reptiles reptiles = new Reptiles();
            reptiles.setID(Integer.parseInt(this.view.getTxtidMod().getText()));
            if (modelo.DeleteRep(reptiles)) {
                JOptionPane.showMessageDialog(view, "Se elimino correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblTabla().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo eliminar. Por favor revise si el id es correcto",
                        "Error al eliminar", JOptionPane.ERROR_MESSAGE);

            }
            this.view.getTxtidMod().setText("");
            this.view.getTxtGrupoMod().setText("");
            this.view.getTxtNombreMod().setText("");
            this.view.getTxtHabitatMod().setText("");
            this.view.getTxtAlimentacionMod().setText("");
            this.view.getTxtURLMod().setText("");
        }
        if (e.getSource() == view.getTblTabla()) {
            if (e.getSource() == view.getTblTabla()) {
                int index = this.view.getTblTabla().getSelectedRow();
                Reptiles tmp = modelo.getRepIndex(index);
                try {
                    this.view.getLblImagenRep().setIcon(tmp.getImagen());
                    if (true) {
                        JOptionPane.showMessageDialog(null, "La imagen se esta mostrando");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se puede cargar la imagen");

                    }

                } catch (MalformedURLException mfue) {
                }


            }
        }
    }
}