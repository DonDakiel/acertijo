package acertijo;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;

public class Acertijo extends JFrame {
    private BufferedImage imagenFondo;
    private Clip clip; 

    public Acertijo() {
        try {            
            imagenFondo = ImageIO.read(new File("C:\\Users\\ESTUDIANTE\\Documents\\NetBeansProjects\\acertijo\\archivos\\images.jfif"));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 600); 
            setLocationRelativeTo(null); 


            
            cargarSonido("C:\\Users\\ESTUDIANTE\\Documents\\NetBeansProjects\\acertijo\\archivos\\sonidotos.wav");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarSonido(String ruta) {
        try {
            
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(ruta));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);            
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void detenerSonido() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Acertijo ventana = new Acertijo();
            ventana.setVisible(true);
        });
    }
}
