package sample;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Random;

public class Controller {
    @FXML
    public Pane panee;

    public ArrayList<ColoredCircle> circlelist= new ArrayList<ColoredCircle>();
    public ArrayList<Color> colorlist= new ArrayList<Color>();

    public Color getColor(){

        double r =  Math.random() ;
        double g = Math.random() ;
        double b = Math.random() ;

        Color randomColor = new Color(r, g, b,1);
        while (colorlist.contains(randomColor)){
            double red =  Math.random() ;
            double green = Math.random() ;
            double blue = Math.random() ;

             randomColor = new Color(red, green, blue,1);
        }

        colorlist.add(randomColor);
        return randomColor;

    }
    public boolean isOverlaps( double x1, double y1,double x2, double y2, int r){
        double distance = Math.pow((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2), 0.5);

        if(distance<=(r+r)){

            return true;
        }else
            
            return false;
    }


    public void createCircle(double x,double y, int r){
         Color newColor=getColor();
        for(int i=0; i<circlelist.size(); i++){
            if(isOverlaps(circlelist.get(i).getCircle().getCenterX(),circlelist.get(i).getCircle().getCenterY(),x,y,r)){

                Circle newCirele= new Circle(x,y, r,circlelist.get(i).getColorOfCircle() );//
                ColoredCircle newColoredCircle= new ColoredCircle(x,y, r,circlelist.get(i).getColorOfCircle());
                circlelist.add(newColoredCircle);

                panee.getChildren().add(newCirele);
                return;
            }

        }

        Circle newCirele= new Circle(x,y, r, newColor); /////////////////////////////
        ColoredCircle newColoredCircle= new ColoredCircle(x,y, r, newColor);
        circlelist.add(newColoredCircle);
        panee.getChildren().add(newCirele);




    }

    public void mouseClicked(MouseEvent e) {
        double x=  e.getX();
        double y=  e.getY();
        createCircle(x,y,10);
    }
}
