package com.kune.android.tictactoe;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int myActivePlayer = 0;
    int crossCount = 0;
    int circleCount = 0;
    // 0 for cross and 1 for circle

    //my Game state
    int[] myGameState = {2,2,2,2,2,2,2,2,2};

    public void winCheck(int x,String player) {
        if ((myGameState[0] == x && myGameState[1] == x && myGameState[2] == x) || (myGameState[3] == x && myGameState[4] == x && myGameState[5] == x) || (myGameState[6] == x && myGameState[7] == x && myGameState[8] == x)) {
            Toast.makeText(getApplicationContext(),player + " wins!!", Toast.LENGTH_SHORT).show();
            playAgain();
        }
        else if((myGameState[0] == x && myGameState[3] == x && myGameState[6] == x) || (myGameState[1] == x && myGameState[4] == x && myGameState[7] == x) || (myGameState[2] == x && myGameState[5] == x && myGameState[8] == x)){
            Toast.makeText(getApplicationContext(), player + " wins!!", Toast.LENGTH_SHORT).show();
            playAgain();
        }
        else if((myGameState[0] == x && myGameState[4] == x && myGameState[8] == x) || (myGameState[2] == x && myGameState[4] == x && myGameState[6] == x) ){
            Toast.makeText(getApplicationContext(), player + " wins!!", Toast.LENGTH_SHORT).show();
            playAgain();
        }
    }


    public void imageTapped(View view){
        ImageView myTapped = (ImageView) view;

  //      Log.i("tag is", "image number is " +myTapped.getTag().toString());
        int tappedImageTag = Integer.parseInt(myTapped.getTag().toString());
        if(myGameState[tappedImageTag] == 2){
            myGameState[tappedImageTag] = myActivePlayer;

            if(myActivePlayer == 0){
                crossCount++;
                myTapped.setImageResource(R.drawable.cross);
                myTapped.animate().rotation(360).setDuration(1000);
                myActivePlayer = 1;
            } else{
                circleCount++;
                myTapped.setImageResource(R.drawable.circle);
                myActivePlayer = 0;
            }

        } else{
            Toast.makeText(getApplicationContext(),"This place is filled already",Toast.LENGTH_SHORT).show();
        }
        if((crossCount == 5 && circleCount==4) || (crossCount == 4 && circleCount==5) ){
            Toast.makeText(getApplicationContext(),"DRAW!!!!",Toast.LENGTH_SHORT).show();
            playAgain();
        }
        if(crossCount >= 3) winCheck(0,"CROSS");
        if(circleCount >= 3) winCheck(1,"CIRCLE");


    }

    public void reset(View view) {
        //    Log.i("mssg","Play Again TApped!!");
        crossCount = 0;
        circleCount = 0;
        //Change game state back to 2
        for (int i = 0; i < myGameState.length; ++i) {
            myGameState[i] = 2;
        }

        //Make active player 0 again
        myActivePlayer = 0;

        //Change all images to ic launcher
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.line1);
        for (int i = 0; i < linearLayout1.getChildCount(); ++i) {
            ((ImageView) linearLayout1.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.line2);
        for (int i = 0; i < linearLayout2.getChildCount(); ++i) {
            ((ImageView) linearLayout2.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.line3);
        for (int i = 0; i < linearLayout3.getChildCount(); ++i) {
            ((ImageView) linearLayout3.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
    }

    public void playAgain(){
    //    Log.i("mssg","Play Again TApped!!");
        crossCount=0;
        circleCount=0;
        //Change game state back to 2
        for(int i = 0; i < myGameState.length; ++i){
            myGameState[i] = 2;
        }

        //Make active player 0 again
        myActivePlayer = 0;

        //Change all images to ic launcher
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.line1);
        for(int i=0; i<linearLayout1.getChildCount(); ++i){
            ((ImageView)linearLayout1.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.line2);
        for(int i=0; i<linearLayout2.getChildCount(); ++i){
            ((ImageView)linearLayout2.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.line3);
        for(int i=0; i<linearLayout3.getChildCount(); ++i){
            ((ImageView)linearLayout3.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
