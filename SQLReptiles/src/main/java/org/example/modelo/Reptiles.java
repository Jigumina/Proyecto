package org.example.modelo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.net.MalformedURLException;
import java.net.URL;

public class Reptiles {
    private int ID;
    private String grupo;
    private String nombre;
    private String habitat;
    private String alimentacion;
    private String URL;

    public Reptiles() {
    }

    public Reptiles(int ID, String grupo, String nombre, String habitat, String alimentacion, String URL) {
        this.ID = ID;
        this.grupo = grupo;
        this.nombre = nombre;
        this.habitat = habitat;
        this.alimentacion = alimentacion;
        this.URL = URL;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "Reptiles{" +
                "ID=" + ID +
                ", grupo='" + grupo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", habitat='" + habitat + '\'' +
                ", alimentacion='" + alimentacion + '\'' +
                ", URL='" + URL + '\'' +
                '}';

    }

    public ImageIcon getImagen() throws MalformedURLException {
        URL url = new URL(this.URL);
        try {
            Image imagen = ImageIO.read(url);
        } catch (Exception e) {
            System.out.println("No se encontró el url");

        }

        return new ImageIcon(url);

    }
}
