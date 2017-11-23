package com.example.abc.scrabblepoints.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abc.scrabblepoints.HomeActivity;
import com.example.abc.scrabblepoints.R;

//import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String EXTRA_MESSAGE1 = "com.example.abc.scrabblepoints.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "com.example.abc.scrabblepoints.MESSAGE2";
    public static final String EXTRA_MESSAGE3 = "com.example.abc.scrabblepoints.MESSAGE3";
    public static final String EXTRA_MESSAGE4 = "com.example.abc.scrabblepoints.MESSAGE4";

    private EditText player1Name, player2Name, player3Name, player4Name;
    private Button buttonStart;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

//    public void clickStart(){
//        TableLayout tableLayout;
//        tableLayout = getView().findViewById(R.id.table_layout_players);
//
//        TableRow tableRow = new TableRow(getContext());
//        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        tableLayout.setLayoutParams(layoutParams);
//        TextView textView = new TextView(getContext());
//        tableRow.addView(textView);
//        tableLayout.addView(tableRow);
//
//
//    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_home, container, false);

        player1Name = (EditText) rootview.findViewById(R.id.edit_player1);
        player2Name = (EditText) rootview.findViewById(R.id.edit_player2);
        player3Name = (EditText) rootview.findViewById(R.id.edit_player3);
        player4Name = (EditText) rootview.findViewById(R.id.edit_player4);

        buttonStart = (Button) rootview.findViewById(R.id.button_start);


            buttonStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (player1Name.getText().toString().trim().length() == 0 && player2Name.getText().toString().trim().length() == 0){
                        Toast.makeText(getContext(),R.string.text_toast_home_fragment,Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else {
                    Intent intent = new Intent(getActivity(), HomeActivity.class);
                        intent.putExtra("player1", player1Name.getText().toString());
                        intent.putExtra("player2", player2Name.getText().toString());
                        intent.putExtra("player3", player3Name.getText().toString());
                        intent.putExtra("player4", player4Name.getText().toString());
                    startActivity(intent);
                    }
                }
            });




//       buttonStart.setOnClickListener(new View.OnClickListener(){

//           @SuppressLint("ResourceType")
//           @Override
//           public void onClick(View view) {

//               TableRow tRow = (TableRow) view.findViewById(R.id.table_row_players);
//               tRow.setVisibility(View.INVISIBLE);
//               TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//               TableRow tableRow = new TableRow(view.getContext());
//               TextView textView = new TextView(view.getContext());
//               textView.setText(player1Name.getText().toString());
//               tableRow.addView(textView);
//               tableRow.setLayoutParams(layoutParams);
//               tableLayout = view.findViewById(R.id.table_layout_players);
//               tableLayout.addView(tableRow);

//               view = inflater.inflate(R.id.table_layout_players,container,false);
//
//               TextView textView = new TextView(view.getContext());
//               textView.setText(player1Name.getText().toString());
//               textView.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
////               (TableLayout.LayoutParams layoutParams).
//               tableLayout.addView(textView);
//
//           }
//       });

    return rootview;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }


//        else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
