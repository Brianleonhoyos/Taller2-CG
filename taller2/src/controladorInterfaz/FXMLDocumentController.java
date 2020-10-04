/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorInterfaz;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import modelo.Archivo;
import modelo.Punto2D;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Brian León Hoyos
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Canvas canvas;
    @FXML
    private MenuBar menubar;

    private GraphicsContext lienzo;
    @FXML
    private Button btnrombo;
    @FXML
    private Button btnpentagono;
    @FXML
    private Button btnHexagono;
    @FXML
    private Button btnHeptagono;
    @FXML
    private Button btnOctagono;
    @FXML
    private Button btnPacman;
    @FXML
    private Button btnRectangulo;

    HashMap<String, LinkedList<Punto2D>> mapFiguras;
    LinkedList<Punto2D> listapuntosFigura;

    @FXML
    private void guardarArchivo(ActionEvent event) {

        boolean t = Archivo.guardarArchivoXML(mapFiguras);
        if (t) {
            JOptionPane.showMessageDialog(null, "Archivo Creado con exito");
        } else {
            JOptionPane.showMessageDialog(null, "Archivo No Creado");
        }
    }

    @FXML
    private void leerArchivo(ActionEvent event) {

        HashMap<String, LinkedList<Punto2D>> mapF = Archivo.leerArchivo();

        Iterator<Map.Entry<String, LinkedList<Punto2D>>> entries = mapF.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<String, LinkedList<Punto2D>> elemento = entries.next();
            double[] coordenadasx = new double[elemento.getValue().size()];
            double[] coordenadasy = new double[elemento.getValue().size()];

            for (int i = 0; i < elemento.getValue().size(); i++) {
                Punto2D punto = elemento.getValue().get(i);
                coordenadasx[i] = punto.getX();
                coordenadasy[i] = punto.getY();
            }
            lienzo.setLineWidth(3);
            lienzo.setStroke(Color.DARKMAGENTA);
            lienzo.strokePolygon(coordenadasx, coordenadasy, elemento.getValue().size());

        }
    }

    @FXML
    private void guardarimagen(ActionEvent event) {

    }

    private void colocarImagenBotones() {
        URL linkRombo = getClass().getResource("/img/rombo.png");
        URL linkPentagono = getClass().getResource("/img/pentagon.png");
        URL linkHexagono = getClass().getResource("/img/hexagon.png");
        URL linkHeptagono = getClass().getResource("/img/heptagono.png");
        URL linkOctagono = getClass().getResource("/img/octagon.png");
        URL linkPacman = getClass().getResource("/img/Pacman.png");
        URL linkRectangulo = getClass().getResource("/img/rectangulo.png");

        Image imagenRombo = new Image(linkRombo.toString(), 60, 60, false, true);
        Image imagenPentagono = new Image(linkPentagono.toString(), 60, 60, false, true);
        Image imagenHexagono = new Image(linkHexagono.toString(), 60, 60, false, true);
        Image imagenHeptagono = new Image(linkHeptagono.toString(), 60, 60, false, true);
        Image imagenOctagono = new Image(linkOctagono.toString(), 60, 60, false, true);
        Image imagenPacman = new Image(linkPacman.toString(), 60, 60, false, true);
        Image imagenRectangulo = new Image(linkRectangulo.toString(), 75, 75, false, true);

        btnrombo.setGraphic((new ImageView(imagenRombo)));
        btnpentagono.setGraphic((new ImageView(imagenPentagono)));
        btnHexagono.setGraphic((new ImageView(imagenHexagono)));
        btnHeptagono.setGraphic((new ImageView(imagenHeptagono)));
        btnOctagono.setGraphic((new ImageView(imagenOctagono)));
        btnPacman.setGraphic((new ImageView(imagenPacman)));
        btnRectangulo.setGraphic((new ImageView(imagenRectangulo)));
    }
    
    @FXML
    private void crearRombo(ActionEvent event) {
        listapuntosFigura = new LinkedList<>();
        double[] coordenadasx = {229, 166, 229, 292};
        double[] coordenadasy = {90, 155, 220, 155};

        lienzo.setLineWidth(3);
        lienzo.setStroke(Color.DARKCYAN);
        lienzo.strokePolygon(coordenadasx, coordenadasy, 4);

        for (int i = 0; i < coordenadasy.length; i++) {
            listapuntosFigura.add(new Punto2D(coordenadasx[i], coordenadasy[i]));

        }
        mapFiguras.put("Rombo", listapuntosFigura);
    }
    
     @FXML
    private void crerPentagono(ActionEvent event) {
        listapuntosFigura = new LinkedList<>();
        double[] coordenadasx = {230, 166, 189, 269,292};
        double[] coordenadasy = {111, 155, 228, 228,155};

        lienzo.setLineWidth(3);
        lienzo.setStroke(Color.DARKCYAN);
        lienzo.strokePolygon(coordenadasx, coordenadasy, 5);

        for (int i = 0; i < coordenadasy.length; i++) {
            listapuntosFigura.add(new Punto2D(coordenadasx[i], coordenadasy[i]));

        }
        mapFiguras.put("Pentagono", listapuntosFigura);
    }
    
   @FXML
    private void crearHexagono(ActionEvent event) {
        
        listapuntosFigura = new LinkedList<>();
        double[] coordenadasx = {200, 400, 450, 400, 200, 150};
        double[] coordenadasy = {50, 50, 150, 250, 250, 150};

        lienzo.setLineWidth(3);
        lienzo.setStroke(Color.DARKCYAN);
        lienzo.strokePolygon(coordenadasx, coordenadasy, 6);

        for (int i = 0; i < coordenadasy.length; i++) {
            listapuntosFigura.add(new Punto2D(coordenadasx[i], coordenadasy[i]));

        }
        mapFiguras.put("Hexagono", listapuntosFigura);
    }
    
    @FXML
    private void crearHeptagono(ActionEvent event) {
        
        listapuntosFigura = new LinkedList<>();
        double[] coordenadasx = {135,101, 73, 96, 169 , 198,168};
        double[] coordenadasy = {243,261, 291, 334, 334, 291,261};

        lienzo.setLineWidth(3);
        lienzo.setStroke(Color.DARKCYAN);
        lienzo.strokePolygon(coordenadasx, coordenadasy, 7);

        for (int i = 0; i < coordenadasy.length; i++) {
            listapuntosFigura.add(new Punto2D(coordenadasx[i], coordenadasy[i]));

        }
        mapFiguras.put("Heptagono", listapuntosFigura);
    }
    
    @FXML
    private void crearOctagono(MouseEvent event) {
        
        listapuntosFigura = new LinkedList<>();
        double[] coordenadasx = {135,101, 73, 96, 169 , 198,168};
        double[] coordenadasy = {243,261, 291, 334, 334, 291,261};

        lienzo.setLineWidth(3);
        lienzo.setStroke(Color.DARKCYAN);
        lienzo.strokePolygon(coordenadasx, coordenadasy, 8);

        for (int i = 0; i < coordenadasy.length; i++) {
            listapuntosFigura.add(new Punto2D(coordenadasx[i], coordenadasy[i]));

        }
        mapFiguras.put("Octagono", listapuntosFigura);
    }
    
    @FXML
    private void crearPacman(ActionEvent event) {
        
        listapuntosFigura = new LinkedList<>();
        double[] coordenadasx = {135,101, 73, 96, 169 , 198,168};
        double[] coordenadasy = {243,261, 291, 334, 334, 291,261};

        lienzo.setLineWidth(3);
        lienzo.setStroke(Color.DARKCYAN);
        lienzo.strokePolygon(coordenadasx, coordenadasy, 8);

        for (int i = 0; i < coordenadasy.length; i++) {
            listapuntosFigura.add(new Punto2D(coordenadasx[i], coordenadasy[i]));

        }
        mapFiguras.put("Pacman", listapuntosFigura);
    }
    
    @FXML
    private void crearRectangulo(ActionEvent event) {
        
        listapuntosFigura = new LinkedList<>();
        double[] coordenadasx = {135,101, 73, 96};
        double[] coordenadasy = {243,261, 291, 334};

        lienzo.setLineWidth(3);
        lienzo.setStroke(Color.DARKCYAN);
        lienzo.strokePolygon(coordenadasx, coordenadasy, 4);

        for (int i = 0; i < coordenadasy.length; i++) {
            listapuntosFigura.add(new Punto2D(coordenadasx[i], coordenadasy[i]));

        }
        mapFiguras.put("Rectangulo", listapuntosFigura);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lienzo = canvas.getGraphicsContext2D();
        double w = canvas.getWidth();
        double h = canvas.getHeight();
        lienzo.setLineWidth(3);
        lienzo.setStroke(Color.BLUEVIOLET);
        lienzo.strokeRect(0, 0, w, h);
        mapFiguras = new HashMap<>();

        colocarImagenBotones();
        btnrombo.setDisable(false);
        btnpentagono.setDisable(false);
        btnHexagono.setDisable(false);
        btnHeptagono.setDisable(false);
        btnOctagono.setDisable(false);
        btnPacman.setDisable(false);
        btnRectangulo.setDisable(false);
    }

}
