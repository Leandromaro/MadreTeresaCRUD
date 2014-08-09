/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author aguidici
 */
public class UtilGraficos
{
    public static ImageIcon getIconoCuadrado(int width,int height,Color color)
    {
     Rectangle2D rect=new Rectangle2D.Float(0, 0, width-1, height-1);

     BufferedImage imagen=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
     Graphics2D g2=imagen.createGraphics();

     g2.setColor(color);
     g2.fill(rect);

     return new ImageIcon(imagen);
    }

}
