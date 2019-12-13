
# Fiocco di neve | Diario di lavoro
##### [Alessandro Aloise]
### [CPT Trevano], [13.12.19]

## Lavori svolti


|Orario        |Lavoro svolto                                 |
|--------------|----------------------------------------------|
|10:05 - 11:35 |programmazione                                |
|13:15 - 16:10 |programmazione                                |
|16:10 - 16:30 |Diario                                        |

ho agginto la generazione del fiocco di neve, ho messo il savataggio in svg,png, e dei punti che si basa direttamente sull'oggetto.


##  Problemi riscontrati e soluzioni adottate
probma riscontrato con la generazione del svg risolto creando un altro paintcompnent dove genero solo il fiocco di neve. vedi codice sotto. 

 ```java
 public void paintComponentDisegno(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.black);
    trasformazioni(g2d);
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
  ```



##  Punto della situazione rispetto alla pianificazione
in orario

## Programma di massima per la prossima giornata di lavoro
ultimi ritocchi
