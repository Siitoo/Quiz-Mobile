package l.sito.whois;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class whoisActivity extends AppCompatActivity {

    private PreguntaTest pregunta;
    private RadioGroup rview;

    private void generaPregunta() {
        String[] respostes = new String[4];
        respostes[0] = "Barcelona";
        respostes[1] = "Paris";
        respostes[2] = "Londres";
        respostes[3] = "Hanoi";

        pregunta = new PreguntaTest("quina es la capital de Vietnam?",respostes,3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whois);

        generaPregunta();

        TextView textview = findViewById(R.id.textView);
        rview = findViewById(R.id.respostesView);
        RadioButton r1 = findViewById(R.id.r1);
        RadioButton r2 = findViewById(R.id.r2);
        RadioButton r3 = findViewById(R.id.r3);
        RadioButton r4 = findViewById(R.id.r4);

        textview.setText(pregunta.getText());
        r1.setText(pregunta.getRespostes()[0]);
        r2.setText(pregunta.getRespostes()[1]);
        r3.setText(pregunta.getRespostes()[2]);
        r4.setText(pregunta.getRespostes()[3]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.quiz_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_comproba:
                comrpovaResposta();
                break;
        }
        return true;
    }

    private void comrpovaResposta() {
        int index = getIndex();
        if(index == pregunta.getCorrecta()){
            Toast.makeText(this,"Molt bé!!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Loser!!",Toast.LENGTH_SHORT).show();
        }
    }

    private int getIndex() {
        int selected = rview.getCheckedRadioButtonId();
        int ids[] = {R.id.r1,R.id.r2,R.id.r3,R.id.r4};
        int index = -1;
        for(int i = 0; i < ids.length;i++){
            if(ids[i] == selected) {
                index = i;
                break;
            }
        }
        return index;
    }
}
