
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.awt.geom.Area;
import java.awt.geom.PathIterator;

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
    private List<Point> points = new ArrayList<Point>();

    public Point[] arraypunti = new Point[1];

    /**
     * Poligono generato dall'utente. colore rosso
     */
    private Polygon polygon = new Polygon();

    /**
     * Poligono del trettangolo. colore biano
     */
    private Polygon tpolygon = new Polygon();

    /**
     * Poligono renderizazione. colore giallo
     */
    private Polygon rpolygon = new Polygon();

    private Polygon afpoligono = new Polygon();

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
        rpolygon.reset();

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
            colorePoligono = Color.gray;
            renderFlag = true;
            clickFlag = false;
            renderTastoFlag = false;
        } else {
            colorePoligono = Color.red;
            renderFlag = false;
            clickFlag = true;
            renderTastoFlag = true;
        }
        repaint();
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
        g2d.setColor(Color.gray);
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
            g2d.setColor(Color.YELLOW);
            g2d.fill(rpolygon);
        }
        g2d.setColor(Color.PINK);
        AffineTransform transform = new AffineTransform();
        transform.rotate(Math.toRadians(90), rpolygon.xpoints[0], rpolygon.ypoints[0]);
        Shape transformed = transform.createTransformedShape(rpolygon);
        g2d.fill(transformed);

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
                points.get(i).x = points.get(i).x + differenzax / 4;
                points.get(i).y = points.get(i).y + differenzay / 4;

            } else {
                differenzax = larghezzaV - larghezzaN;
                differenzay = altezzaV - altezzaN;
                points.get(i).x = points.get(i).x - differenzax / 4;
                points.get(i).y = points.get(i).y - differenzay / 4;
            }
        }
        larghezzaV = larghezzaN;
        altezzaV = altezzaN;
        repaint();
    }


    public void getPolygon(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            afpoligono.addPoint((points[i].x), (points[i].y));
        }
    }

    public Point[] convertToArray(List<Point> list) {
        Point[] array = new Point[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if (clickFlag == true) {
            if (MouseEvent.BUTTON1 == evt.getButton()) {
                Point p = evt.getPoint();
                if (p.x < getWidth() / 2) {
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
        if (MouseEvent.BUTTON3 == evt.getButton()) {
            for (int i = 0; i < points.size(); i++) {
                if (evt.getPoint().x >= points.get(i).x - 20 || evt.getPoint().x <= points.get(i).x + 20
                        && evt.getPoint().y >= points.get(i).y - 20 || evt.getPoint().y <= points.get(i).y + 20) {
                }
            }
        }
    }//GEN-LAST:event_formMouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
