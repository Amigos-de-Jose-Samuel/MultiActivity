package samuel.jose.multiactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        output = findViewById(R.id.output);
        Intent it = getIntent();
        Bundle params = it.getExtras();
        if (it != null) {
            String name = params.getString("name");
            Double media = params.getDouble("media");
            int frequencia = params.getInt("frequencia", 0);
            String result;

            if (media >= 7 && frequencia >= 75) {
                result = "Aprovado(a)";
            } else if (media >= 4 && media <=7 && frequencia >= 75) {
                result = "Final";
            } else if (frequencia < 75) {
                result = "Reprovado(a) por falta";
            } else {
                result = "Reprovado(a) por nota";
            }

            result += String.format(" com média = %.2f", media);

            output.setText("A situação na disciplina do(a) " + name + " é " + result);
        }
    }
}