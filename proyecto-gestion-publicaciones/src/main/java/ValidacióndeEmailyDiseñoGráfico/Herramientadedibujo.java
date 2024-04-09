package ValidacióndeEmailyDiseñoGráfico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Herramientadedibujo extends JPanel {
    private Point startPoint;
    private Point endPoint;
    private Shape currentShape;

    public Herramientadedibujo() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endPoint = e.getPoint();
                if (currentShape == null) {
                    return;
                }
                repaint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endPoint = e.getPoint();
                repaint();
            }
        });
    }

    public void setShape(String shapeType) {
        switch (shapeType) {
            case "line":
                currentShape = createLine();
                break;
            case "circle":
                currentShape = createCircle();
                break;
            case "rectangle":
                currentShape = createRectangle();
                break;
            default:
                throw new IllegalArgumentException("Invalid shape type: " + shapeType);
        }
    }

    private Shape createLine() {
        return new Line2D.Double(startPoint, endPoint);
    }

    private Shape createCircle() {
        int width = Math.abs(endPoint.x - startPoint.x);
        int height = Math.abs(endPoint.y - startPoint.y);
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);
        return new Ellipse2D.Double(x, y, width, height);
    }

    private Shape createRectangle() {
        int width = Math.abs(endPoint.x - startPoint.x);
        int height = Math.abs(endPoint.y - startPoint.y);
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);
        return new Rectangle(x, y, width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        if (currentShape != null) {
            g2d.draw(currentShape);
        }
        g2d.dispose();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Herramienta de Dibujo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Herramientadedibujo(), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
