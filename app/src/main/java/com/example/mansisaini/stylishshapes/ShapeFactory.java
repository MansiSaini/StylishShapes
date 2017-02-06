package com.example.mansisaini.stylishshapes;

import android.content.Context;
import android.graphics.Paint;

public class ShapeFactory extends AbstractShapeFactory
{
    Paint fill;
    Paint stroke;

    public ShapeFactory(Paint fill, Paint stroke)
    {
       this.fill = fill;
        this.stroke = stroke;
    }

    public Shape getRectangle (Context context)
    {
        return new Rectangle(context, fill, stroke);
    }

    public Shape getCircle (Context context)
    {
        return new Circle(context, fill, stroke);
    }
}

