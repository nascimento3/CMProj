package ua.cm.cmproj;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    public static final String ARG_POSITION = "position";
    public static final String ARG_TITLE = "title";
    public static final String ARG_DATA = "data";
    public static final String ARG_CANTINA = "cantina";
    public static final String ARG_TIPO = "tipo";
    public static final String ARG_SOPA = "sopa";
    public static final String ARG_CARNE = "carne";
    public static final String ARG_PEIXE = "peixe";
    public static final String ARG_OPEN = "open";


    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_details, container,
                false);
        Bundle args = getArguments();

        TextView textViewTitle = (TextView) rootView.findViewById(R.id.fragment_details_textView);
        TextView textViewCanteen = (TextView) rootView.findViewById(R.id.fragment_details_canteen);
        TextView textViewMealType = (TextView) rootView.findViewById(R.id.fragment_details_typemeal);

        TextView textViewSopa = (TextView) rootView.findViewById(R.id.fragment_details_sopa);
        TextView textViewPeixe = (TextView) rootView.findViewById(R.id.fragment_details_peixe);
        TextView textViewCarne = (TextView) rootView.findViewById(R.id.fragment_details_carne);
        TextView textSopa = (TextView) rootView.findViewById(R.id.fragment_details_text_sopa);
        TextView textPeixe = (TextView) rootView.findViewById(R.id.fragment_details_text_peixe);
        TextView textCarne = (TextView) rootView.findViewById(R.id.fragment_details_text_carne);

        if(args.getBoolean(ARG_OPEN)) {
            textViewTitle.setText(args.getString(ARG_DATA));
            textViewCanteen.setText(args.getString(ARG_CANTINA));
            textViewMealType.setText(args.getString(ARG_TIPO));

            textSopa.setText("Sopa: ");
            textViewSopa.setText(args.getString(ARG_SOPA));
            textPeixe.setText("Prato Peixe: ");
            textViewPeixe.setText(args.getString(ARG_PEIXE));
            textCarne.setText("Prato Carne: ");
            textViewCarne.setText(args.getString(ARG_CARNE));
        }
        else
        {
            textViewTitle.setText(args.getString(ARG_DATA));
            textViewCanteen.setText(args.getString(ARG_CANTINA));
            textViewMealType.setText(args.getString(ARG_TIPO));

            textSopa.setText("Cantina Encerrada");
            textViewSopa.setText("");
            textPeixe.setText("");
            textViewPeixe.setText("");
            textCarne.setText("");
            textViewCarne.setText("");
        }

        // Inflate the layout for this fragment
        return rootView;
    }
}
