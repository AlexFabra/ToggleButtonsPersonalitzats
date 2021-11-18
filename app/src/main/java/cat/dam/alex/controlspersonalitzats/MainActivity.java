package cat.dam.alex.controlspersonalitzats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("ToggleButtons personalitzats");
        setContentView(R.layout.activity_main);
        
        //declaració de components:
        ToggleButton tbtn_catCast = (ToggleButton) findViewById(R.id.tbtn_CatCast);
        ToggleButton tbtn_ver = (ToggleButton) findViewById(R.id.tbtn_Ver);
        TextView tv_catCast = (TextView) findViewById(R.id.tv_CatCast);

        //al clicar a un botó, es dispararà aquesta funció, que deixarà que es canvii el text
        //si el togglebutton tbtn_ver està en false:

        tbtn_catCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!tbtn_ver.isChecked()){
                    if (tbtn_catCast.isChecked()){
                        tv_catCast.setText(R.string.textCast);
                    } else {
                        tv_catCast.setText(R.string.textCat);
                    }
                }
            }
        });

        //aquesta funció es dispara quan el togglebutton tbtn_ver canvia d'estat.
        //si és true, el text no és veurà. Si és false, el text canviarà segons l'estat
        //de tbtn_catCast.

        tbtn_ver.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (tbtn_ver.isChecked()) {
                    tv_catCast.setText("");
                } else {
                    if (tbtn_catCast.isChecked()){
                        tv_catCast.setText(R.string.textCast);
                    } else {
                        tv_catCast.setText(R.string.textCat);
                    }
                }
            }
        });
    }
}