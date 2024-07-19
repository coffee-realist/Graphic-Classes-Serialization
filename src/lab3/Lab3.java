package lab3;

import lab3.graphics.Dot;
import lab3.graphics.Drawable;
import lab3.graphics.Geogroup;
import lab3.graphics.Rectangle;
import lab3.test.DrawableGenerator;

import java.io.*;

import static lab3.JSONParser.deserializeShapes;
import static lab3.graphics.Drawable.readBinary;

public class Lab3 {
    public static void main(String[] args) throws IOException {
        Drawable shapes = DrawableGenerator.mixedGroup();
        Dot dot1 = new Dot(3, 3);
        Dot dot2 = new Dot(5, 3);
        Dot dot3 = new Dot(5, 7);
        Dot dot4 = new Dot(3, 7);
        Rectangle rectangle1 = new Rectangle(dot1, dot2, dot3, dot4);
        File file_json = new File("f.JSON");
        File file_bin = new File("f.bin");
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_json)));
        try (FileOutputStream fos = new FileOutputStream(file_bin)) {
            shapes.toBinary(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        shapes.toJSON(writer);
        writer.close();
        Drawable geogroup = new Geogroup();
        try (FileInputStream input = new FileInputStream(file_json)) {
            geogroup = deserializeShapes(input);
        }
        try (FileInputStream input = new FileInputStream(file_bin)) {
            geogroup = readBinary(input);
        }
        System.out.println(geogroup);
    }
}
