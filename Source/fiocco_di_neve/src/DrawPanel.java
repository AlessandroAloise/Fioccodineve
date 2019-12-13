
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.awt.geom.Area;
import java.awt.geom.PathIterator;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2DIOException;
import org.w3c.dom.Document;
import org.w3c.dom.DOMImplementation;

/**
 * Questo programma genera un fiocco di neve.
 *
 * @author Alesassandro Aloise
 * @version 15.11.2019
 */
public class DrawPanel extends javax.swing.JPanel {

    /**
     * Lista dei punti messi.
     */
    private final List<Point> points = new ArrayList<Point>();

    /**
     * Poligono generato dall'utente. colore rosso
     */
    private Polygon polygon = new Polygon();

    /**
     * Poligono del trettangolo. colore biano
     */
    private final Polygon tpolygon = new Polygon();

    /**
     * Poligono renderizazione. colore blu
     */
    private final Polygon rpolygon = new Polygon();

    /**
     * Il colore che ha il poligono generato dall'utente.
     */
    public Color colorePoligono = Color.red;

    /**
     * Flag che gestice la pressione del tsto render.
     */
    public boolean renderTastoFlag = true;

    /**
     * Larghezza vecchia dello schermo. valore di default= 1024.
     */
    public int larghezzaV = 1024;

    /**
     * Altezza vecchia dello schermo. valore di default= 768.
     */
    public int altezzaV = 768;

    /**
     * Larghezza nuova dello schermo.
     */
    public int larghezzaN = 0;

    /**
     * Altezza nuova dello schermo.
     */
    public int altezzaN = 0;

    /**
     * Quando abilitato scatena il disegno del nuovo poligono.
     */
    public boolean renderFlag = false;

    /**
     * Permette o nega l'aggiunta dei punti.
     */
    public boolean clickFlag = true;

    /**
     * Creates new form DrawPanel.
     */
    public DrawPanel() {
        initComponents();
        this.setSize(1024, 768);
    }

    /**
     * Resetta i punti sullo schermo e il cololore dei punti. aggiorna anche il
     * colore del poligono che passa da rosso a grigio.
     */
    public void reset() {
        points.clear();
        colorePoligono = Color.red;
        polygon.reset();
        rpolygon.reset();
        tpolygon.reset();
        renderTastoFlag = false;
        toggleRender();
        repaint();
    }

    /**
     * Rimuove l'ultimo punto messo.
     */
    public void rimuoviPunto() {
        if (points.size() > 3) {
            points.remove(points.size() - 1);
            repaint();
        }
    }

    /**
     * Viene invocato quando viene premuto il tasto render modifica il colore
     * visivo.
     */
    public void toggleRender() {
        if (renderTastoFlag == true) {
            colorePoligono = new Color(96, 96, 96);
            renderFlag = true;
            clickFlag = false;
            renderTastoFlag = false;
        } else {
            rpolygon.reset();
            colorePoligono = Color.red;
            renderFlag = false;
            clickFlag = true;
            renderTastoFlag = true;
        }
        repaint();
    }

    
    public void trasformazioni(Graphics2D g2d ){
        for (int i = 0; i < 6; i++) {
                AffineTransform tr2 = new AffineTransform();
                tr2.scale(0.5, 0.5);
                tr2.translate(1800, 300);
                tr2.rotate(Math.toRadians(60) * i, tpolygon.xpoints[2], tpolygon.ypoints[2]);
                g2d.setTransform(tr2);
                g2d.fillPolygon(rpolygon);

                AffineTransform tr3 = new AffineTransform();
                tr3.scale(-0.5, 0.5);
                tr3.translate((-tpolygon.xpoints[2] * 2) - 1800, 300);
                tr3.rotate(Math.toRadians(60) * i, tpolygon.xpoints[2], tpolygon.ypoints[2]);
                g2d.setTransform(tr3);
                g2d.fillPolygon(rpolygon);

            }
    }
    /**
     * Il paint dell'applicazione.
     *
     * @param g
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //genero tutti gli oggetti grafici
        creazioneTriangolo();
        creazionePoligono();
        creazioneRender();

        //migliora la grafica 
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //colora sfondo di grigio
        g2d.setColor(new Color(96, 96, 96));
        g2d.fillRect(0, 0, getWidth() / 2, getHeight());

        //disegna tirangolo
        g2d.setColor(Color.WHITE);
        g2d.fillPolygon(tpolygon);

        //disegna poligono
        g2d.setColor(colorePoligono);
        if (points.size() > 1) {
            g2d.fillPolygon(polygon);
        }
        //diesgna puntini del poligono
        for (int i = 0; i < points.size(); i++) {
            g2d.setColor(Color.BLACK);
            //TODO correggere centro dei cerchi
            g2d.fillOval(points.get(i).x - 3, points.get(i).y - 3, 6, 6);
        }

        if (renderFlag == true) {
            g2d.setColor(Color.CYAN);
            g2d.fill(rpolygon);
            g2d.setColor(Color.BLACK);
            trasformazioni(g2d);
            repaint();
        } else {
            g2d.setColor(Color.white);
            g2d.fillRect(getWidth() / 2, 0, getWidth() / 2, getHeight());
        }

    }
    /**
     * Questo paint é usato per stampare il fiocco che dopo verrà salvato in svg;
     * @param g 
     */
    public void paintComponentDisegno(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        trasformazioni(g2d);
    }

    /**
     * Questo metodo si occupa di fare i calcoli per il render del nuovo
     * poligono.
     */
    public void creazioneRender() {
        Area aPoligono = new Area(polygon);
        Area aTriangolo = new Area(tpolygon);
        aTriangolo.subtract(aPoligono);
        rpolygon.reset();
        PathIterator iterator = aTriangolo.getPathIterator(null);
        float[] floats = new float[6];
        while (!iterator.isDone()) {
            int type = iterator.currentSegment(floats);
            int x = (int) floats[0];
            int y = (int) floats[1];
            if (type != PathIterator.SEG_CLOSE) {
                rpolygon.addPoint(x, y);
            }
            iterator.next();
        }
    }

    /**
     * Questo metodo si occupa di ressettare il poligono e aggiungere i pounti
     * al poligono
     */
    public void creazionePoligono() {
        polygon.reset();
        for (int i = 0; i < points.size(); i++) {
            polygon.addPoint(points.get(i).x, points.get(i).y);
        }
    }

    /**
     * Metodo che istanzia il poligono triangolo.
     */
    public void creazioneTriangolo() {
        // a
        // b é lunga il doppio di a  
        // h é lungua b per 1,7
        int[] x = new int[3];
        int[] y = new int[3];
        int bordo = getWidth() / 10;
        int a = getWidth() / 4;
        int b = a * 2;
        double h = b * 0.8;
        x[0] = bordo;
        x[1] = bordo + a;
        x[2] = bordo;
        y[0] = (getHeight() / 4);
        y[1] = (getHeight() / 4);
        y[2] = (getHeight() / 4 + (int) h);
        tpolygon.reset();

        for (int i = 0; i < 3; i++) {
            tpolygon.addPoint(x[i], y[i]);
        }
    }

    /**
     * Calcoli ridimensionamento del poligono.
     */
    public void ridimensionamentoP() {
        larghezzaN = this.getWidth();
        altezzaN = this.getHeight();
        int differenzax = 0;
        int differenzay = 0;
        for (int i = 0; i < points.size(); i++) {
            if (larghezzaV > larghezzaN || altezzaV > altezzaN) {
                differenzax = larghezzaN - larghezzaV;
                differenzay = altezzaN - altezzaV;
                points.get(i).x = points.get(i).x + differenzax / 2;
                points.get(i).y = points.get(i).y + differenzay / 2;

            } else {
                differenzax = larghezzaV - larghezzaN;
                differenzay = altezzaV - altezzaN;
                points.get(i).x = points.get(i).x - differenzax / 2;
                points.get(i).y = points.get(i).y - differenzay / 2;
            }
        }
        larghezzaV = larghezzaN;
        altezzaV = altezzaN;
        repaint();
    }

    public void salvaPng(String file, int width) throws IOException {
        int x = 0;
        int y = 0;
        double rapporto = 0;
        if (width == 500) {
            x = 525;
            y = 50;
            rapporto = 0.4;
        } else if (width == 1000) {
            x = 450;
            y = 0;
            rapporto = 0.9;
        }
        BufferedImage png = new BufferedImage(width, width, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = png.createGraphics();
        g2d.setColor(Color.black);
        for (int i = 0; i < 6; i++) {
            AffineTransform trPng = new AffineTransform();
            trPng.scale(rapporto, rapporto);
            trPng.translate(x, y);
            trPng.rotate(Math.toRadians(60) * i, tpolygon.xpoints[2], tpolygon.ypoints[2]);
            g2d.setTransform(trPng);
            g2d.fillPolygon(rpolygon);
            AffineTransform trPng2 = new AffineTransform();
            trPng2.scale(-rapporto, rapporto);
            trPng2.translate((-tpolygon.xpoints[2] * 2) - x, y);
            trPng2.rotate(Math.toRadians(60) * i, tpolygon.xpoints[2], tpolygon.ypoints[2]);
            g2d.setTransform(trPng2);
            g2d.fillPolygon(rpolygon);
        }
        ImageIO.write(png, "PNG", new File(file + ".png"));

    }

    public void serialize(File handle) {
        String path = handle.toString();
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.polygon);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            JOptionPane jop = new JOptionPane();
            jop.showOptionDialog(
                    null,
                    "Cannot write file " + handle + ". Code: tp158",
                    "Error opening file",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    null, null, null);
        }
    }

    public void deSerialize(File handle) {
        String path = handle.toString();
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.polygon = (Polygon) in.readObject();
            if (!this.points.isEmpty()) {
                this.points.clear();
            }
            for (int i = 0; i < this.polygon.npoints; i++) {
                this.points.add(
                        new Point(this.polygon.xpoints[i], this.polygon.ypoints[i]));
            }
            repaint();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException i) {
            JOptionPane jop = new JOptionPane();
            jop.showOptionDialog(
                    null,
                    "Cannot open file " + handle + ". Code: tp190",
                    "Error opening file",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    null, null, null);
        }
    }

    public void generateSVG(String filename) {
        BufferedImage svg = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = svg.createGraphics();
        g2d.setColor(Color.black);
        for (int i = 0; i < 6; i++) {
            AffineTransform trSvg = new AffineTransform();
            trSvg.scale(0.4, 0.4);
            trSvg.translate(525, 50);
            trSvg.rotate(Math.toRadians(60) * i, tpolygon.xpoints[2], tpolygon.ypoints[2]);
            g2d.setTransform(trSvg);
            g2d.fillPolygon(rpolygon);
            AffineTransform trSvg2 = new AffineTransform();
            trSvg2.scale(-0.4, 0.4);
            trSvg2.translate((-tpolygon.xpoints[2] * 2) - 525, 50);
            trSvg2.rotate(Math.toRadians(60) * i, tpolygon.xpoints[2], tpolygon.ypoints[2]);
            g2d.setTransform(trSvg2);
            g2d.fillPolygon(rpolygon);
        }
        DOMImplementation domImpl= GenericDOMImplementation.getDOMImplementation();
        String svgNS = "http://www.w3.org/2000/svg";
        Document document = domImpl.createDocument(svgNS, "svg", null);
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
        this.paintComponentDisegno(svgGenerator);
        try {
            svgGenerator.stream(filename);
        } catch (SVGGraphics2DIOException ex) {
            JOptionPane jop = new JOptionPane();
            jop.showOptionDialog(
                    null,
                    "Graphic error. Code: sf206",
                    "Graphic error",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    null, null, null);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(1024, 768));
        setPreferredSize(new java.awt.Dimension(400, 300));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if (clickFlag == true) {
            if (MouseEvent.BUTTON1 == evt.getButton()) {
                Point p = evt.getPoint();
                if (p.x <= this.getWidth() / 2) {
                    this.points.add(evt.getPoint());
                }
            }
        }
        repaint();
    }//GEN-LAST:event_formMouseReleased

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        ridimensionamentoP();
    }//GEN-LAST:event_formComponentResized

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        ridimensionamentoP();
    }//GEN-LAST:event_formAncestorResized

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
    }//GEN-LAST:event_formMouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
