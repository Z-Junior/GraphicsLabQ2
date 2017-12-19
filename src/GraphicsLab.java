import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GraphicsLab extends JPanel
{
    public static void main(String[] args)
    {
        JFrame f = new JFrame("Lines and more lines");

        f.setSize(980, 630);
        f.add(new GraphicsLab());
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paint(Graphics g)
    {
        int iWidth = 980, iHeight = 630, x1 = 10, y1 = 640, x2 = 990, y2 = 640;

        // Outer box

        g.setColor(randomColor());

        g.drawRect(10, 10, iWidth, iHeight);

        g.setColor(randomColor());

        drawOuter(g);

        // Inner box

        g.setColor(randomColor());

        g.drawRect(220, 180, 560, 290);

        g.setColor(randomColor());

        drawInner(g);
    }

    /**
     * Draws outer box & lines
     * @param g Graphics
     */
    void drawOuter(Graphics g)
    {
        int x1 = 950;
        int y1 = 640;
        int x2 = 10;
        int y2 = 630;

        g.setColor(randomColor());

        while (y2 > 50) // 58 = (630 - x) / 10 --> 50
        {
            g.drawLine(x1, y1, x2, y2);
            y2 -= 10;
            x1 -= 16;
        }

        x1 = 50;
        y1 = 640;
        x2 = 990;
        y2 = 630;

        g.setColor(randomColor());

        while (y2 >= 50) // No change
        {
            g.drawLine(x1, y1, x2, y2);
            y2 -= 10;
            x1 += 16;
        }

        x1 = 50;
        y1 = 10;
        x2 = 990;
        y2 = 20;

        g.setColor(randomColor());

        while (y2 <= 600) // 58 = (x - 20) / 10 --> x = 600
        {
            g.drawLine(x1, y1, x2, y2);
            y2 += 10;
            x1 += 16;
        }

        x1 = 950;
        y1 = 10;
        x2 = 10;
        y2 = 20;

        g.setColor(randomColor());

        while (y2 <= 600) // No change
        {
            g.drawLine(x1, y1, x2, y2);
            y2 += 10;
            x1 -= 16;
        }
    }

    /**
     * Draws inner box & lines
     * @param g Graphics
     */
    void drawInner(Graphics g)
    {
        // Top Left

        int x1 = 760, y1 = 180, x2 = 220, y2 = 185;

        g.setColor(randomColor());

        while (y2 <= 450) // 53 = (x - 185) / 5 --> 450
        {
            g.drawLine(x1, y1, x2, y2);
            y2 += 5;
            x1 -= 10;
        }

        // Top Right

        x1 = 240; // 20 Overage
        y1 = 180; // No Change
        x2 = 780; // 20 Overage
        y2 = 185; // No Change

        g.setColor(randomColor());

        while (y2 <= 450) // 53 = (x - 185) / 5 --> 450
        {
            g.drawLine(x1, y1, x2, y2);
            y2 += 5;
            x1 += 10;
        }

        // Bottom left

        x1 = 760; // No Change
        y1 = 470; // 290 Offset
        x2 = 220; // No Change
        y2 = 465; // 280 Offset

        g.setColor(randomColor());

        while (y2 >= 200) // 53 = (465 - x) / 5 --> 200
        {
            g.drawLine(x1, y1, x2, y2);
            y2 -= 5;
            x1 -= 10;
        }

        // Bottom right

        x1 = 240; // 20 Overage
        y1 = 470; // 290 Offset
        x2 = 780; // No Change
        y2 = 465; // 280 Offset

        g.setColor(randomColor());

        while (y2 >= 200) // 53 = (465 - x) / 5 --> 200
        {
            g.drawLine(x1, y1, x2, y2);
            y2 -= 5;
            x1 += 10;
        }
    }

    /**
     * Generates random color (RGB)
     * @return Color
     */
    public static Color randomColor()
    {
        Random r = new Random();

        return new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
    }
}
