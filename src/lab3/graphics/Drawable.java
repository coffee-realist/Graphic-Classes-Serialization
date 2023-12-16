package lab3.graphics;

import java.io.Writer;
import java.util.Objects;

abstract public class Drawable {
    abstract public void draw();
    abstract public Drawable move(double delta_x, double delta_y);
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drawable drawable)) return false;
        return equals(drawable);
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }
    abstract public void to_binary(Writer writer);
}
