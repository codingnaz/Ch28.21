package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by SAimon22 on 12/3/2017.
 */
public class ColoredCircle {
    ColoredCircle(){}
    ColoredCircle(double x,double y, int r,Color c){
        Circle newCirele= new Circle(x,y, r,c );
        setCircle(newCirele);
        setColorOfCircle(c);

    }
    public Color getColorOfCircle() {
        return colorOfCircle;
    }

    public void setColorOfCircle(Color colorOfCircle) {
        this.colorOfCircle = colorOfCircle;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    Color colorOfCircle;
    Circle circle;
}
