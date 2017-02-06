package com.example.mansisaini.stylishshapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Vector;

public class MainActivity extends AppCompatActivity
{
    public Button rect;
    public Button circ;
    public Button clear;
    public RelativeLayout Rlayout;
    public TextView textView;
    public Button style;

    //holds the shapes
    Vector<Shape> myVector = new Vector<>();

    public int style_num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rect = (Button)findViewById(R.id.rect);
        circ = (Button)findViewById(R.id.circ);
        clear = (Button)findViewById(R.id.clear);
        Rlayout = (RelativeLayout)findViewById(R.id.Relayout1);
        style = (Button)findViewById(R.id.style);

        //Rectangle Button"
        rect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //what happens when the rect button is clicked:
                adjustShapeAlpha();
                ShapeFactory first_shape = AbstractShapeFactory.getShapeFactory(style_num);
                Shape rectangle = first_shape.getRectangle(v.getContext());

                myVector.add(rectangle);
                Rlayout.addView(rectangle);
                updateShapeCount();
            }
        });

        //Circle Button:
        circ.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //what happens when the circ button is pressed.
                adjustShapeAlpha();
                ShapeFactory second_shape = AbstractShapeFactory.getShapeFactory(style_num);
                Shape circle = second_shape.getCircle(v.getContext());

                myVector.add(circle);
                Rlayout.addView(circle);
                updateShapeCount();
            }
        });

        //Clear Button:
        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //what happens when the clear button is clicked
                myVector.clear();
                Rlayout.removeAllViews();
                updateShapeCount();
            }
        });

        //Style Button:
        style.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                //what happens when the style button is clicked
                style_num++;
                //when style goes to 4, it resets back to 1
                if(style_num > 4)
                {
                    style_num = 1;
                }
                updateShapeCount();
            }
        });
    }

    void adjustShapeAlpha ()
    {
        for (Shape shape : myVector)
        {
            shape.setShapeAlpha(shape.getShapeAlpha() - 0.077f);

            if(shape.getShapeAlpha() < 0.1f)
            {
                shape.removeShape();
            }
        }
    }

    void updateShapeCount ()
    {
        int total_rectangles = 0;
        int total_circles = 0;

        textView = (TextView) findViewById(R.id.textView);

        for (Shape shape : myVector)
        {
            if(shape.getShapeType().equalsIgnoreCase("Rectangle"))
            {
                total_rectangles++;
                if (shape.getShapeAlpha() < 0.1f)
                {
                    total_rectangles--;
                }
            }
            else if (shape.getShapeType().equalsIgnoreCase("Circle"))
            {
                total_circles++;
                if (shape.getShapeAlpha() < 0.1f)
                {
                    total_circles--;
                }
            }
        }
        textView.setText("Rectangles: " + total_rectangles + " "+ "||" + " " + "Circles: " + total_circles + " " + "||" + " " + "Style: " + style_num);
    }
}

