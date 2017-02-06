package com.example.mansisaini.stylishshapes;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by mansisaini on 7/10/16.
 */
public class AbstractShapeFactory
{
    public static ShapeFactory getShapeFactory (int style)
    {
         Paint paint_fill = new Paint();
         Paint paint_stroke = new Paint();

        if (style == 1)
        {
            //the fill color:
            paint_fill.setStyle(Paint.Style.FILL);
            paint_fill.setColor(Color.GREEN);

            //the border color:
            paint_stroke.setStyle(Paint.Style.STROKE);
            paint_stroke.setColor(Color.CYAN);
            paint_stroke.setStrokeWidth(15);

        }
        else if (style == 2)
        {
            //the fill color:
            paint_fill.setStyle(Paint.Style.FILL);
            paint_fill.setColor(Color.RED);

            //the border color:
            paint_stroke.setStyle(Paint.Style.STROKE);
            paint_stroke.setColor(Color.DKGRAY);
            paint_stroke.setStrokeWidth(15);

        }
        else if (style == 3)
        {
            //the fill color:
            paint_fill.setStyle(Paint.Style.FILL);
            paint_fill.setColor(Color.BLUE);

            //the border color:
            paint_stroke.setStyle(Paint.Style.STROKE);
            paint_stroke.setColor(Color.YELLOW);
            paint_stroke.setStrokeWidth(15);

        }
        else if (style == 4)
        {
            //the fill color:
            paint_fill.setStyle(Paint.Style.FILL);
            paint_fill.setColor(Color.CYAN);

            //the border color:
            paint_stroke.setStyle(Paint.Style.STROKE);
            paint_stroke.setColor(Color.MAGENTA);
            paint_stroke.setStrokeWidth(15);
        }

        return new ShapeFactory(paint_fill, paint_stroke);
    }
}
