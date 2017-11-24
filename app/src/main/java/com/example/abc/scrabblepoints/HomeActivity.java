package com.example.abc.scrabblepoints;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by abc on 13/11/2017.
 */

public class HomeActivity extends AppCompatActivity {

    boolean doubleBackPressToGoBack = false;
    ArrayList<Integer> playscore1 = new ArrayList<Integer>();
    ArrayList<Integer> playscore2 = new ArrayList<Integer>();
    ArrayList<Integer> playscore3 = new ArrayList<Integer>();
    ArrayList<Integer> playscore4 = new ArrayList<Integer>();

    String finalscore1, finalscore2, finalscore3, finalscore4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView player1txt = findViewById(R.id.txt_player1);
        TextView player2txt = findViewById(R.id.txt_player2);
        TextView player3txt = findViewById(R.id.txt_player3);
        TextView player4txt = findViewById(R.id.txt_player4);


        player1txt.setText(getIntent().getStringExtra("player1"));
        player2txt.setText(getIntent().getStringExtra("player2"));
        player3txt.setText(getIntent().getStringExtra("player3"));
        player4txt.setText(getIntent().getStringExtra("player4"));


        Button player_1button = findViewById(R.id.player1_button);
        Button player_2button = findViewById(R.id.player2_button);
        Button player_3button = findViewById(R.id.player3_button);
        Button player_4button = findViewById(R.id.player4_button);

        LinearLayout linearLayout3 = findViewById(R.id.layout_player3);
        LinearLayout linearLayout4 = findViewById(R.id.layout_player4);
        View view_2 = findViewById(R.id.view2);
        View view_3 = findViewById(R.id.view3);

        ImageButton close_button = findViewById(R.id.button_close);
        close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               closeOption();

            }
        });





        ImageButton share_button = findViewById(R.id.button_share);
        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this,R.string.share_toast, Toast.LENGTH_SHORT).show();
//               takeScreenShot();
            }
        });


        if (player3txt.getText().equals("")) {
            view_2.setVisibility(View.INVISIBLE);
            linearLayout3.setVisibility(LinearLayout.INVISIBLE);
        }

        if (player4txt.getText().equals(""))

        {
            view_3.setVisibility(View.INVISIBLE);
            linearLayout4.setVisibility(LinearLayout.INVISIBLE);
        }


        player_1button.setOnClickListener(new View.OnClickListener() {

            EditText player_1input = (EditText) findViewById(R.id.player1_input);
            TextView scoreplayer1 = (TextView) findViewById(R.id.score_player1);

            @Override
            public void onClick(View view) {

                try {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(scoreplayer1.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
                } catch (Exception e) {
                }

                try {
                    int ix = Integer.parseInt(player_1input.getText().toString().trim());

                    int sum = 0;

                    if (scoreplayer1.getText().toString().length() != 0) {

                        playscore1.add(ix);

                        for (int num : playscore1) {
                            sum = sum + num;
                        }

                        scoreplayer1.append(" + " + String.valueOf(ix) + '\n' + sum);
                        player_1input.setText("");

                    } else {
                        scoreplayer1.setText(String.valueOf(ix));
                        playscore1.add(ix);
                        player_1input.setText("");
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Score cannot be empty", Toast.LENGTH_LONG).show();
                }

                finalscore1 = scoreplayer1.getText().toString();

            }

        });


        player_2button.setOnClickListener(new View.OnClickListener() {

            EditText player_2input = (EditText) findViewById(R.id.player2_input);
            TextView scoreplayer2 = (TextView) findViewById(R.id.score_player2);

            @Override
            public void onClick(View view) {

                try {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(scoreplayer2.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
                } catch (Exception e) {
                }

                try {


                    int ix = Integer.parseInt(player_2input.getText().toString().trim());

                    int sum = 0;

                    if (scoreplayer2.getText().toString().length() != 0) {

                        playscore2.add(ix);

                        for (int num : playscore2) {
                            sum = sum + num;
                        }

                        scoreplayer2.append(" + " + String.valueOf(ix) + '\n' + sum);
                        player_2input.setText("");

                    } else {
                        scoreplayer2.setText(String.valueOf(ix));
                        playscore2.add(ix);
                        player_2input.setText("");
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Score cannot be empty", Toast.LENGTH_LONG).show();
                }

                finalscore2 = scoreplayer2.getText().toString();
            }

        });


        player_3button.setOnClickListener(new View.OnClickListener() {

            EditText player_3input = (EditText) findViewById(R.id.player3_input);
            TextView scoreplayer3 = (TextView) findViewById(R.id.score_player3);

            @Override
            public void onClick(View view) {

                try {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(scoreplayer3.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
                } catch (Exception e) {
                }

                try {

                    int ix = Integer.parseInt(player_3input.getText().toString().trim());

                    int sum = 0;

                    if (scoreplayer3.getText().toString().length() != 0) {

                        playscore3.add(ix);

                        for (int num : playscore3) {
                            sum = sum + num;
                        }

                        scoreplayer3.append(" + " + String.valueOf(ix) + '\n' + sum);
                        player_3input.setText("");

                    } else {
                        scoreplayer3.setText(String.valueOf(ix));
                        playscore3.add(ix);
                        player_3input.setText("");
                    }


                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Score cannot be empty", Toast.LENGTH_LONG).show();
                }

                finalscore3 = scoreplayer3.getText().toString();


            }
        });


        player_4button.setOnClickListener(new View.OnClickListener() {

            EditText player_4input = (EditText) findViewById(R.id.player4_input);
            TextView scoreplayer4 = (TextView) findViewById(R.id.score_player4);

            @Override
            public void onClick(View view) {

                try {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(scoreplayer4.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
                } catch (Exception e) {
                }

                try {
                    int ix = Integer.parseInt(player_4input.getText().toString().trim());

                    int sum = 0;

                    if (scoreplayer4.getText().toString().length() != 0) {

                        playscore4.add(ix);

                        for (int num : playscore4) {
                            sum = sum + num;
                        }

                        scoreplayer4.append(" + " + String.valueOf(ix) + '\n' + sum);
                        player_4input.setText("");

                    } else {
                        scoreplayer4.setText(String.valueOf(ix));
                        playscore4.add(ix);
                        player_4input.setText("");
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Score cannot be empty", Toast.LENGTH_LONG).show();
                }

                finalscore4 = scoreplayer4.getText().toString();

            }
        });

    }

    private void takeScreenShot() {
        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

        try {
            //path to save to
            String pPath = "/" + now + ".jpg";

            //capture
            View view = getWindow().getDecorView().getRootView();
            view.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
            view.setDrawingCacheEnabled(false);

            File imageFile = new File(Environment.getExternalStorageDirectory().toString() + pPath);
//            if (!imageFile.exists())
//                imageFile.mkdirs();

            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(imageFile);
                int quality = 100;
                bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            MediaScannerConnection.scanFile(this,
                    new String[]{imageFile.toString()}, null,
                    new MediaScannerConnection.OnScanCompletedListener() {

                        @Override
                        public void onScanCompleted(String s, Uri uri) {
                            Log.i("ExternalStorage", "Scanned " + s + ":");
                            Log.i("ExternalStorage", "-> uri=" + uri);
                        }
                    });

            shareImage(imageFile);

        } catch (Throwable throwable) {
            throwable.printStackTrace();

        }
    }

    private void shareImage(File imageFile) {
        Uri uri = Uri.fromFile(imageFile);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("image/*");

        try {
            startActivity(Intent.createChooser(intent, "Share Scoreboard"));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No App Available", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onBackPressed() {
        if (doubleBackPressToGoBack) {
            super.onBackPressed();
            return;
        }
        this.doubleBackPressToGoBack = true;
        closeOption();
//        Toast.makeText(this, R.string.back_key, Toast.LENGTH_LONG).show();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                doubleBackPressToGoBack = false;
//            }
//        }, 2000);
    }

    private AlertDialog.Builder closeOption(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(HomeActivity.this);
        dialog.setCancelable(false);
        dialog.setTitle("End Game");
        dialog.setIcon(R.drawable.ic_close);
        dialog.setMessage("Are you sure you want to end game? Careful, your score will not be saved");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                HomeActivity.super.onBackPressed();

            }
        })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        final AlertDialog alertDialog = dialog.create();
        alertDialog.show();

        return dialog;
    }
}
