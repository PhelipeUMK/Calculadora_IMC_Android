package br.facapccp.appimc_n1_250426;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class obesidade3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);


        // Pegando o valor da intent ao inciar a Activity
        Intent intent = getIntent();
        double imc = intent.getDoubleExtra("imc", 0);

        // Formatando a saída do IMC para ter apenas uma casa decimal

        DecimalFormat df = new DecimalFormat("#.#");
        String imcFormatado = df.format(imc);

        // Mostrando o IMC na tela
        TextView txt = findViewById(R.id.txtImc_Obesidade3);
        txt.setText("Seu IMC:" + String.valueOf(imcFormatado));

        setContentView(R.layout.activity_obesidade3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // instanciando o botão que chama a função de voltar(finish()) ao ser clicado

        Button voltar = findViewById(R.id.btnObesidade3Voltar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}