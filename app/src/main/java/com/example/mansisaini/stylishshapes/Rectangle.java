package com.example.mansisaini.stylishshapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.Toast;

import java.util.Random;

public class Rectangle extends Shape
{
    Paint fill;
    Paint stroke;
    Random random = new Random();


    public Rectangle(Context context, Paint fill, Paint stroke)
    {
        super(context);
        this.fill = fill;
        this.stroke = stroke;
    }

    @Override
    String getShapeType()
    {
        return "Rectangle";
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        int left = random.nextInt(getWidth());
        int top = random.nextInt(getHeight());
        int right = random.nextInt(getWidth()-left)+left;
        int bottom = random.nextInt(getHeight()-top)+top;
        canvas.drawRect(left, top, right, bottom, fill);
        canvas.drawRect(left, top, right, bottom, stroke);
    }
}

