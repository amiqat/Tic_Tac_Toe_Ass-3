package com.example.ameen.tictactoe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    int player = 1;
    Button[][] board = new Button[3][3];
    String msg = "";
    TextView disp;
    DrawView drawView;

    private static void disable(ViewGroup layout) {
        layout.setEnabled(false);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof ViewGroup) {
                disable((ViewGroup) child);
            } else {
                child.setEnabled(false);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        board[0][0] = (Button) findViewById(R.id.zero);
        board[0][1] = (Button) findViewById(R.id.one);
        board[0][2] = (Button) findViewById(R.id.two);
        board[1][0] = (Button) findViewById(R.id.three);
        board[1][1] = (Button) findViewById(R.id.four);
        board[1][2] = (Button) findViewById(R.id.five);
        board[2][0] = (Button) findViewById(R.id.six);
        board[2][1] = (Button) findViewById(R.id.seven);
        board[2][2] = (Button) findViewById(R.id.eight);
        disp = (TextView) findViewById(R.id.display);

        drawView = (DrawView) findViewById(R.id.draw);

        Canvas canvas = new Canvas();


        drawView.draw(canvas);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.action_exit:
                this.finish();
                return true;
            case R.id.action_new:
                finish();
                startActivity(getIntent());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    public void set(View v) {
        Button b = (Button) findViewById(v.getId());
        if (!isGameOver()) {
            if (b.getText().length() < 1) {
                if (player == 0) {
                    b.setText("x");
                    player = 1;
                } else {
                    b.setText("o");
                    player = 0;
                }
            }
        }
        if (isGameOver()) {
            if (isWin())
                disp.setText(msg);
            else
                disp.setText("Draw");
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    board[i][j].setEnabled(false);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Play Again")
                    .setTitle("Did you want play again");

            // set neutral button: Exit the app message

            builder.setNeutralButton("Yes", new DialogInterface.OnClickListener() {


                public void onClick(DialogInterface dialog, int id) {

                    // go to a new activity of the app
                    finish();
                    startActivity(getIntent());


                }
            });
            builder.setNegativeButton("Exit the app", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    // exit the app and go to the HOME
                    MainActivity.this.finish();
                }
            });


            AlertDialog dialog = builder.create();
            dialog.show();

        }


    }

    public boolean isWin() {
        if (((board[0][0].getText().toString().equals(board[0][1].getText().toString()) && board[0][1].getText().toString().equals(board[0][2].getText().toString())) && board[0][0].getText().toString().equalsIgnoreCase("x")) ||
                ((board[1][0].getText().toString().equals(board[1][1].getText().toString()) && board[1][1].getText().toString().equals(board[1][2].getText().toString())) && board[1][0].getText().toString().equalsIgnoreCase("x")) ||
                ((board[2][0].getText().toString().equals(board[2][1].getText().toString()) && board[2][1].getText().toString().equals(board[2][2].getText().toString())) && board[2][0].getText().toString().equalsIgnoreCase("x")) ||
                ((board[0][0].getText().toString().equals(board[1][0].getText().toString()) && board[1][0].getText().toString().equals(board[2][0].getText().toString())) && board[0][0].getText().toString().equalsIgnoreCase("x")) ||
                ((board[0][1].getText().toString().equals(board[1][1].getText().toString()) && board[1][1].getText().toString().equals(board[2][1].getText().toString())) && board[0][1].getText().toString().equalsIgnoreCase("x")) ||
                ((board[0][2].getText().toString().equals(board[1][2].getText().toString()) && board[1][2].getText().toString().equals(board[2][2].getText().toString())) && board[0][2].getText().toString().equalsIgnoreCase("x")) ||
                ((board[0][0].getText().toString().equals(board[1][1].getText().toString()) && board[1][1].getText().toString().equals(board[2][2].getText().toString())) && board[0][0].getText().toString().equalsIgnoreCase("x")) ||
                ((board[0][2].getText().toString().equals(board[1][1].getText().toString()) && board[1][1].getText().toString().equals(board[2][0].getText().toString())) && board[0][2].getText().toString().equalsIgnoreCase("x"))) {

            msg = "X wins";

            return true;

        } else if (((board[0][0].getText().toString().equals(board[0][1].getText().toString()) && board[0][1].getText().toString().equals(board[0][2].getText().toString())) && board[0][0].getText().toString().equalsIgnoreCase("o")) ||
                ((board[1][0].getText().toString().equals(board[1][1].getText().toString()) && board[1][1].getText().toString().equals(board[1][2].getText().toString())) && board[1][0].getText().toString().equalsIgnoreCase("o")) ||
                ((board[2][0].getText().toString().equals(board[2][1].getText().toString()) && board[2][1].getText().toString().equals(board[2][2].getText().toString())) && board[2][0].getText().toString().equalsIgnoreCase("o")) ||
                ((board[0][0].getText().toString().equals(board[1][0].getText().toString()) && board[1][0].getText().toString().equals(board[2][0].getText().toString())) && board[0][0].getText().toString().equalsIgnoreCase("o")) ||
                ((board[0][1].getText().toString().equals(board[1][1].getText().toString()) && board[1][1].getText().toString().equals(board[2][1].getText().toString())) && board[0][1].getText().toString().equalsIgnoreCase("o")) ||
                ((board[0][2].getText().toString().equals(board[1][2].getText().toString()) && board[1][2].getText().toString().equals(board[2][2].getText().toString())) && board[0][2].getText().toString().equalsIgnoreCase("o")) ||
                ((board[0][0].getText().toString().equals(board[1][1].getText().toString()) && board[1][1].getText().toString().equals(board[2][2].getText().toString())) && board[0][0].getText().toString().equalsIgnoreCase("o")) ||
                ((board[0][2].getText().toString().equals(board[1][1].getText().toString()) && board[1][1].getText().toString().equals(board[2][0].getText().toString())) && board[0][2].getText().toString().equalsIgnoreCase("o"))) {
            msg = "O wins";
            return true;
        }


        return false;
    }

    public boolean isGameOver() {
        if (isWin()) return true;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (!board[i][j].getText().toString().equalsIgnoreCase("x") && !board[i][j].getText().toString().equalsIgnoreCase("o"))
                    return false;
        return true;
    }


}
