package com.bp.pruebatextwatcher;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/* Se puede modificar el TextWatcher para que además de controlar la longitud del texto, controle
* si se introducen caracteres especiales o numeros, y asi dar validez a una direccion de correo o
* password*/

public class MainActivity extends AppCompatActivity implements TextWatcher {

    private EditText msg;
    private TextView indicator;
    private Button send;

    private final static int NUMMAXCHAR = 6; //Numero máximo de caracteres

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = (EditText) findViewById(R.id.msg);
        /*Asociamos el TextWatcher al texto de entrada*/
        msg.addTextChangedListener(this);
        indicator = (TextView) findViewById(R.id.indicador);
        send = (Button) findViewById(R.id.send);

    }

    /*Se invoca para notificar que el texto supervisado está apunto de cambiar. Reaccionará a los cambios del
    * texto*/
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    /*Se invoca cuando se han realizado cambios en el texto supervisado*/
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    /*Se invoca para notificar que el texto supervisado ha cambiado*/
    @Override
    public void afterTextChanged(Editable s) {
        final int numChar = msg.getText().toString().length(); //Numero de caracteres introducidos
        final int leftChar = NUMMAXCHAR - numChar; //Numero de caracteres restantes

        if(leftChar >= 0){ //Si no se ha llegado al máximo de caracteres
            /*indicator.setText(NUMMAXCHAR - Integer.toString(leftChar).length()
            + " caracteres restantes");*/ //Muestra los caracteres restantes

            indicator.setText("Mensaje válido.");

            indicator.setTextColor(Color.GREEN); //Pone el texto en color verde

            send.setEnabled(true); //y permite enviar.

        }else{ //Si se llega al maximo
            indicator.setTextColor(Color.RED); //Pone el texto en color rojo

            indicator.setText("Mensaje incorrecto: "+Integer.toString(Math.abs(leftChar))
            + " caracteres de más."); //Muestra el valor absoluto de los caracteres introducidos de mas

            send.setEnabled(false); // e inhabilita el botón de enviar.
        }
    }
}
