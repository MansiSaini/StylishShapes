package com.example.mansisaini.stylishshapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;


public class Circle extends Shape
{
    Paint fill;
    Paint stroke;
    Random random = new Random();


    public Circle(Context context, Paint fill, Paint stroke)
    {
        super(context);
        this.fill = fill;
        this.stroke = stroke;
    }

    @Override
    String getShapeType()
    {
        return "Circle";
    }
    @Override
    public void onDraw(Canvas canvas)
    {
        int x = random.nextInt(getWidth());
        int y = random.nextInt(getHeight());
        int radius = random.nextInt(200);

        canvas.drawCircle(x, y, radius, fill);
        canvas.drawCircle(x, y, radius, stroke);
    }
}

