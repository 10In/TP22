package mr.formation.tp22;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.view.Gravity.CENTER;
import static android.view.Gravity.CENTER_VERTICAL;

public class MainActivity extends AppCompatActivity {
    public static final String BUNDLE_NAMES = "noms";

    EditText edt;
    TextView mTextView;
    Button btn;
    LinearLayout monLInearLayout;
    RelativeLayout monRelativeLayout;

    ArrayList<String> mNames;
    String  nom_actuel;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putStringArrayList(BUNDLE_NAMES,mNames);
        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //varaible
        initVariable();


        nom_actuel=edt.getText().toString();
        mNames=new ArrayList<>();
        // valeur lors du chargement
        if (savedInstanceState != null) {
            mNames = savedInstanceState.getStringArrayList(BUNDLE_NAMES);
            for(int i=0;i<mNames.size();i++) {
              ajouterText(mNames.get(i));
            }
        }

        //bouton
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nom_actuel=edt.getText().toString();
                ajouterText(nom_actuel);
                mNames.add(nom_actuel);
            }
        });


    }

    public void ajouterText(String a){
        mTextView = new TextView(getApplicationContext());
        mTextView.setGravity(CENTER_VERTICAL);
        mTextView.setTextSize(30.0f);
        mTextView.setTextColor(Color.BLUE);
        mTextView.setText("Bienvenue "+a);
        mTextView.setPadding(10,10,10,10);
        monLInearLayout.addView(mTextView);
    }
    public void initVariable(){
        edt=findViewById(R.id.edit1);
        btn=findViewById(R.id.btn1);
        monLInearLayout=findViewById(R.id.linear1);

    }
}