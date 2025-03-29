package br.facapccp.appimc_n1_250426;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Encontrando os botões através do id

        Button Calcular = findViewById(R.id.btnCalcular);
        Button Limpar = findViewById(R.id.btnLimpar);

        // Lógica da calculadora de IMC e redirecionamento para as activitys correspondentes

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText campoPeso = findViewById(R.id.etxtPeso);
                EditText campoAltura = findViewById(R.id.etxtAltura);

                Double peso = Double.valueOf(campoPeso.getText().toString());
                Double altura = Double.valueOf(campoAltura.getText().toString());

                double imc = peso / (altura * altura);

                if(imc < 10) {
                    Intent itCalcular = new Intent(MainActivity2.this, desnutricao5.class);
                    itCalcular.putExtra("imc", imc);
                    startActivity(itCalcular);
                    finish();
                } else if(imc >= 10 && imc < 13) {
                    Intent itCalcular = new Intent(MainActivity2.this, desnutricao4.class);
                    itCalcular.putExtra("imc", imc);
                    startActivity(itCalcular);
                    finish();
                } else if(imc >= 13 && imc < 16) {
                    Intent itCalcular = new Intent(MainActivity2.this, desnutricao3.class);
                    itCalcular.putExtra("imc", imc);
                    startActivity(itCalcular);
                    finish();
                } else if(imc >= 16 && imc < 17) {
                    Intent itCalcular = new Intent(MainActivity2.this, desnutricao2.class);
                    itCalcular.putExtra("imc", imc);
                    startActivity(itCalcular);
                    finish();
                } else if(imc >= 17 && imc < 18.5) {
                    Intent itCalcular = new Intent(MainActivity2.this, desnutricao1.class);
                    itCalcular.putExtra("imc", imc);
                    startActivity(itCalcular);
                    finish();
                } else if (imc >= 18.5 && imc < 25) {
                    Intent itCalcular = new Intent(MainActivity2.this, normal.class);
                    itCalcular.putExtra("imc", imc);
                    startActivity(itCalcular);
                    finish();
                } else if (imc >= 25 && imc < 30) {
                    Intent itCalcular = new Intent(MainActivity2.this, preObesidade.class);
                    itCalcular.putExtra("imc", imc);
                    startActivity(itCalcular);
                    finish();
                } else if (imc >= 30 && imc < 34.6 ) {
                    Intent itCalcular = new Intent(MainActivity2.this, obesidade1.class);
                    itCalcular.putExtra("imc", imc);
                    startActivity(itCalcular);
                    finish();
                } else if (imc >= 34.6 && imc < 40) {
                    Intent itCalcular = new Intent(MainActivity2.this, Obesidade2.class);
                    itCalcular.putExtra("imc", imc);
                    startActivity(itCalcular);
                    finish();
                } else if (imc >= 40){
                    Intent itCalcular = new Intent(MainActivity2.this, obesidade3.class);
                    itCalcular.putExtra("imc", imc);
                    startActivity(itCalcular);
                    finish();
                }
            }
        });

        // Criando a função de Limpar

        Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    EditText campoPeso = findViewById(R.id.etxtPeso);
                    EditText campoAltura = findViewById(R.id.etxtAltura);
                    campoPeso.setText("");
                    campoAltura.setText("");
            }
        });

    }

}