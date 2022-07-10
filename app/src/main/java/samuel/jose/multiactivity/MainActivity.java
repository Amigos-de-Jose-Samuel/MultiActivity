package samuel.jose.multiactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText nameInput, notaUmInput, notaDoisInput, frequenciaInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        notaUmInput = findViewById(R.id.notaUmInput);
        notaDoisInput = findViewById(R.id.notaDoisInput);
        frequenciaInput = findViewById(R.id.frequenciaInput);
    }

    public void calculate(View view) {
        if (notaUmInput.length() == 0 || notaUmInput.length() == 0 || frequenciaInput.length() == 0 || nameInput.length() == 0) {
            Toast.makeText(this, "Informe todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }
        int frequenciaInt = Integer.parseInt(frequenciaInput.getText().toString());
        double notaUmDouble = Double.parseDouble(notaUmInput.getText().toString());
        double notaDoisDouble = Double.parseDouble(notaDoisInput.getText().toString());

        if(notaUmDouble < 0 || notaUmDouble > 10) {
            Toast.makeText(this, "Nota um informado fora dos valores de 0 a 10!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(notaDoisDouble < 0 || notaDoisDouble > 10) {
            Toast.makeText(this, "Nota dois informado fora dos valores de 0 a 10!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(frequenciaInt < 0 || frequenciaInt > 100) {
            Toast.makeText(this, "Frequência informada fora dos valores de 0 a 100!", Toast.LENGTH_SHORT).show();
            return;
        }

        double media = (notaUmDouble + notaDoisDouble) / 2;

        Intent it = new Intent(this, FinalActivity.class);
        Bundle params = new Bundle();
        params.putString("name", nameInput.getText().toString());
        params.putDouble("media", media);
        params.putInt("frequencia", frequenciaInt);
        it.putExtras(params);
        startActivity(it);
    }
}

