package com.seffrey.socrates;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.seffrey.socrates.SocratesHome.fragmentSwapListener} interface
 * to handle interaction events.
 * Use the {@link SocratesHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SocratesHome extends Fragment {


    private fragmentSwapListener mListener;

    public static SocratesHome newInstance() {
        SocratesHome fragment = new SocratesHome();
        return fragment;
    }

    public SocratesHome() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_socrates_home, container, false);
    }

    public void onButtonPressed(int choice) {
        if (mListener != null) {
            mListener.fragmentSwap(choice);
        }
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (fragmentSwapListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement FragmentSwapListener");
        }

        mListener.fragmentSwap(3);


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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface fragmentSwapListener {
        public void fragmentSwap(int choice);
    }

}