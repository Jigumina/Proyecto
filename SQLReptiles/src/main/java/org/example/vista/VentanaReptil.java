package org.example.vista;

import org.example.modelo.Reptiles;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class VentanaReptil extends JFrame {
    private JLabel lblid;
    private JLabel lblGrupo;
    private JLabel lblNombre;
    private JLabel lblHabitat;
    private JLabel lblAlimentacion;
    private JLabel lblURL;
    private JLabel lblidMod;
    private JLabel lblGrupoMod;
    private JLabel lblNombreMod;
    private JLabel lblHabitatMod;
    private JLabel lblAlimentacionMod;
    private JLabel lblURLMod;
    private JLabel lblImagenRep;

    private JTextField txtid;
    private JTextField txtGrupo;
    private JTextField txtNombre;
    private JTextField txtHabitat;
    private JTextField txtAlimentacion;
    private JTextField txtURL;
    private JTextField txtidMod;
    private JTextField txtGrupoMod;
    private JTextField txtNombreMod;
    private JTextField txtHabitatMod;
    private JTextField txtAlimentacionMod;
    private JTextField txtURLMod;

    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JButton btnImagen;
    private JTable tblTabla;
    private JScrollPane ScrollPane;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    public VentanaReptil(String title) throws HeadlessException {
        super(title);
        this.setSize(800, 800);
        layout = new GridLayout(2, 2);
        this.getContentPane().setLayout(layout);


        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(163, 229, 158));
        lblid = new JLabel("ID:");
        lblGrupo = new JLabel("Grupo:");
        lblNombre = new JLabel("Nombre cientifico:");
        lblHabitat = new JLabel(" Habitat:");
        lblAlimentacion = new JLabel("Alimentacion:");
        lblURL = new JLabel("Imagen(URL):");
        txtid = new JTextField(5);
        txtid.setText("0");
        txtid.setEnabled(false);
        txtGrupo = new JTextField(10);
        txtNombre = new JTextField(20);
        txtHabitat = new JTextField(10);
        txtAlimentacion = new JTextField(10);
        txtURL = new JTextField(30);
        btnAgregar = new JButton("Agregar");

        panel1.add(lblid);
        panel1.add(txtid);

        panel1.add(lblGrupo);
        panel1.add(txtGrupo);

        panel1.add(lblNombre);
        panel1.add(txtNombre);

        panel1.add(lblHabitat);
        panel1.add(txtHabitat);

        panel1.add(lblAlimentacion);
        panel1.add(txtAlimentacion);

        panel1.add(lblURL);
        panel1.add(txtURL);

        panel1.add(btnAgregar);


        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(101, 166, 96));
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        tblTabla = new JTable();
        ScrollPane = new JScrollPane(tblTabla);
        panel2.add(ScrollPane);


        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(101, 166, 96));
        panel3.setLayout(new FlowLayout());
        lblImagenRep = new JLabel("");
        panel3.add(lblImagenRep);


        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(163, 229, 158));
        lblidMod = new JLabel("ID");
        lblNombreMod = new JLabel("Nombre cientifico:");
        btnDelete = new JButton("Eliminar");
        btnUpdate = new JButton("Modificar");
        lblGrupoMod = new JLabel("Grupo:");
        lblHabitatMod = new JLabel(" Habitat:");
        lblAlimentacionMod = new JLabel("Alimentacion:");
        lblURLMod = new JLabel("Imagen(URL):");
        txtidMod = new JTextField(5);
        txtGrupoMod = new JTextField(10);
        txtNombreMod = new JTextField(20);
        txtHabitatMod = new JTextField(10);
        txtAlimentacionMod = new JTextField(10);
        txtURLMod = new JTextField(30);

        panel4.add(lblidMod);
        panel4.add(txtidMod);

        panel4.add(lblGrupoMod);
        panel4.add(txtGrupoMod);

        panel4.add(lblNombreMod);
        panel4.add(txtNombreMod);

        panel4.add(lblHabitatMod);
        panel4.add(txtHabitatMod);

        panel4.add(lblAlimentacionMod);
        panel4.add(txtAlimentacionMod);

        panel4.add(lblURLMod);
        panel4.add(txtURLMod);

        panel4.add(btnUpdate);
        panel4.add(btnDelete);


        this.getContentPane().add(panel1, 0);
        this.getContentPane().add(panel2, 1);
        this.getContentPane().add(panel3, 2);
        this.getContentPane().add(panel4, 3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public JLabel getLblid() {
        return lblid;
    }

    public void setLblid(JLabel lblid) {
        this.lblid = lblid;
    }

    public JLabel getLblGrupo() {
        return lblGrupo;
    }

    public void setLblGrupo(JLabel lblGrupo) {
        this.lblGrupo = lblGrupo;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblHabitat() {
        return lblHabitat;
    }

    public void setLblHabitat(JLabel lblHabitat) {
        this.lblHabitat = lblHabitat;
    }

    public JLabel getLblAlimentacion() {
        return lblAlimentacion;
    }

    public void setLblAlimentacion(JLabel lblAlimentacion) {
        this.lblAlimentacion = lblAlimentacion;
    }

    public JLabel getLblURL() {
        return lblURL;
    }

    public void setLblURL(JLabel lblURL) {
        this.lblURL = lblURL;
    }

    public JTextField getTxtid() {
        return txtid;
    }

    public void setTxtid(JTextField txtid) {
        this.txtid = txtid;
    }

    public JTextField getTxtGrupo() {
        return txtGrupo;
    }

    public void setTxtGrupo(JTextField txtGrupo) {
        this.txtGrupo = txtGrupo;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtHabitat() {
        return txtHabitat;
    }

    public void setTxtHabitat(JTextField txtHabitat) {
        this.txtHabitat = txtHabitat;
    }

    public JTextField getTxtAlimentacion() {
        return txtAlimentacion;
    }

    public void setTxtAlimentacion(JTextField txtAlimentacion) {
        this.txtAlimentacion = txtAlimentacion;
    }

    public JTextField getTxtURL() {
        return txtURL;
    }

    public void setTxtURL(JTextField txtURL) {
        this.txtURL = txtURL;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JTable getTblTabla() {
        return tblTabla;
    }

    public void setTblTabla(JTable tblTabla) {
        this.tblTabla = tblTabla;
    }

    public JScrollPane getScrollPane() {
        return ScrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        ScrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(JButton btnUpdate) {
        this.btnUpdate = btnUpdate;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }


    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JLabel getLblImagenRep() {
        return lblImagenRep;
    }

    public void setLblImagenRep(JLabel lblImagenRep) {
        this.lblImagenRep = lblImagenRep;
    }

    public JLabel getLblidMod() {
        return lblidMod;
    }

    public void setLblidMod(JLabel lblidMod) {
        this.lblidMod = lblidMod;
    }

    public JLabel getLblGrupoMod() {
        return lblGrupoMod;
    }

    public void setLblGrupoMod(JLabel lblGrupoMod) {
        this.lblGrupoMod = lblGrupoMod;
    }

    public JLabel getLblNombreMod() {
        return lblNombreMod;
    }

    public void setLblNombreMod(JLabel lblNombreMod) {
        this.lblNombreMod = lblNombreMod;
    }

    public JLabel getLblHabitatMod() {
        return lblHabitatMod;
    }

    public void setLblHabitatMod(JLabel lblHabitatMod) {
        this.lblHabitatMod = lblHabitatMod;
    }

    public JLabel getLblAlimentacionMod() {
        return lblAlimentacionMod;
    }

    public void setLblAlimentacionMod(JLabel lblAlimentacionMod) {
        this.lblAlimentacionMod = lblAlimentacionMod;
    }

    public JLabel getLblURLMod() {
        return lblURLMod;
    }

    public void setLblURLMod(JLabel lblURLMod) {
        this.lblURLMod = lblURLMod;
    }

    public JTextField getTxtidMod() {
        return txtidMod;
    }

    public void setTxtidMod(JTextField txtidMod) {
        this.txtidMod = txtidMod;
    }

    public JTextField getTxtGrupoMod() {
        return txtGrupoMod;
    }

    public void setTxtGrupoMod(JTextField txtGrupoMod) {
        this.txtGrupoMod = txtGrupoMod;
    }

    public JTextField getTxtNombreMod() {
        return txtNombreMod;
    }

    public void setTxtNombreMod(JTextField txtNombreMod) {
        this.txtNombreMod = txtNombreMod;
    }

    public JTextField getTxtHabitatMod() {
        return txtHabitatMod;
    }

    public void setTxtHabitatMod(JTextField txtHabitatMod) {
        this.txtHabitatMod = txtHabitatMod;
    }

    public JTextField getTxtAlimentacionMod() {
        return txtAlimentacionMod;
    }

    public void setTxtAlimentacionMod(JTextField txtAlimentacionMod) {
        this.txtAlimentacionMod = txtAlimentacionMod;
    }

    public JTextField getTxtURLMod() {
        return txtURLMod;
    }

    public void setTxtURLMod(JTextField txtURLMod) {
        this.txtURLMod = txtURLMod;
    }

    public void limpiar() {
        txtGrupo.setText("");
        txtNombre.setText("");
        txtHabitat.setText("");
        txtAlimentacion.setText("");
        txtURL.setText("");

    }

    public void limpiarmod() {
        txtidMod.setText("");
        txtGrupoMod.setText("");
        txtNombreMod.setText("");
        txtHabitatMod.setText("");
        txtAlimentacionMod.setText("");
        txtURLMod.setText("");
    }
}
