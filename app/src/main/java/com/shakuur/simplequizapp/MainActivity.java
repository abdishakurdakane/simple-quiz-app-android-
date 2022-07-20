package com.shakuur.simplequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
     private TextView questionTv,questionNumberTv;
     private Button btnOption1,btnOption2,btnOption3,btnOption4;
     ArrayList<QuizModel> quizArrayList;
     Random random ;
     int currentScore = 0, questionsAttempted = 1 , currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTv = findViewById(R.id.idTvQuestion);
        questionNumberTv = findViewById(R.id.idTvQuestionAttempted);
        btnOption1 = findViewById(R.id.idBtOption1);
        btnOption2 = findViewById(R.id.idBtOption2);
        btnOption3 = findViewById(R.id.idBtOption3);
        btnOption4 = findViewById(R.id.idBtOption4);
        quizArrayList = new ArrayList<>();
        random = new Random();
        getQuiQuestion(quizArrayList);
        currentPos = random.nextInt(quizArrayList.size());
        setDataToViews(currentPos);
        // options listener

        // option 1 listener
        btnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOption1.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionsAttempted++;
                currentPos = random.nextInt(quizArrayList.size());
                setDataToViews(currentPos);
            }
        });

       // option2 listener
        btnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOption2.getText().toString().trim().toLowerCase())){
                    currentScore++;

                }
                questionsAttempted++;
                currentPos = random.nextInt(quizArrayList.size());
                setDataToViews(currentPos);
            }
        });

        // option3 listener
        btnOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOption3.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionsAttempted++;
                currentPos = random.nextInt(quizArrayList.size());
                setDataToViews(currentPos);
            }
        });

        // option4 listener
        btnOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOption4.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionsAttempted++;
                currentPos = random.nextInt(quizArrayList.size());
                setDataToViews(currentPos);
            }
        });

    }

    private void bottomSheetDialog(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottomsheet,(LinearLayout)findViewById(R.id.idLlScore));
        TextView tvScore = bottomSheetView.findViewById(R.id.idTvScore);
        Button reStartBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        tvScore.setText("your score is " + currentScore + "/10");

        reStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = random.nextInt(quizArrayList.size());
                setDataToViews(currentPos);
                questionsAttempted = 1;
                currentScore = 0;

                bottomSheetDialog.dismiss();
            }
        });

        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataToViews(int currentPos) {
        questionNumberTv.setText("questions attempted " + questionsAttempted + "/10");
        if(questionsAttempted == 10 ){
            bottomSheetDialog();
        }else{
            questionTv.setText(quizArrayList.get(currentPos).getQuestion());
            btnOption1.setText(quizArrayList.get(currentPos).getOption1());
            btnOption2.setText(quizArrayList.get(currentPos).getOption2());
            btnOption3.setText(quizArrayList.get(currentPos).getOption3());
            btnOption4.setText(quizArrayList.get(currentPos).getOption4());
        }



    }

    private void getQuiQuestion(ArrayList<QuizModel> quizArrayList) {
        quizArrayList.add(new QuizModel("somalia independence year","1950","1988","1977","1960","1960"));
        quizArrayList.add(new QuizModel("somalia's 9th president","xasan sheekh","farmajo","siyaad bare","shariif","farmajo"));
        quizArrayList.add(new QuizModel("labour day is ","May 1","October 29","January 10","dec 25","May 1"));
        quizArrayList.add(new QuizModel("world cup winner of 2018","France","England","Spain","USA","France"));
        quizArrayList.add(new QuizModel("CL winner of 2022","REAL MADRID","MAN CITY","CHELSEA","PSG","REAL MADRID"));

    }

}