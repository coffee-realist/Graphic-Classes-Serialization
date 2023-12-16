package lab3;

import lab3.graphics.Dot;
import lab3.graphics.Drawable;
import lab3.graphics.Rectangle;
import lab3.test.DrawableGenerator;

import java.io.*;

public class Lab3 {
    public static void main(String[] args) throws IOException {
        Drawable shapes = DrawableGenerator.mixedGroup();
        Dot dot1 = new Dot(3, 3);
        Dot dot2 = new Dot(5, 3);
        Dot dot3 = new Dot(5, 7);
        Dot dot4 = new Dot(3, 7);
        Rectangle rectangle1 = new Rectangle(dot1, dot2, dot3, dot4);
        File file = new File("f.JSON");
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        shapes.toJSON(writer);
        writer.close();
    }
}
