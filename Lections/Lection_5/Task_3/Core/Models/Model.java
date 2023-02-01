package Lections.Lection_5.Task_3.Core.Models;

import Lections.Lection_5.Task_3.Mathematics.CalculateArea.Calculate;
import Lections.Lection_5.Task_3.Mathematics.Shapes.Canvas;
import Lections.Lection_5.Task_3.Mathematics.Shapes.Shape;

public class Model {
    Shape panel;
    Calculate calc;

    public Model(Calculate c, String canvasName) {
        panel = new Canvas(canvasName);//"Без имени (2).jpg");
        calc = c;
    }

    public void append(Shape shape) {
        panel.shapes.add(shape);
    }

    public double area() {
        return calc.visit(panel);
    }

    public String show() {
        return panel.toString();
    }

}
