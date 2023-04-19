package com.tecnm.tuxtla.basquet_mxled;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;




public class MainActivity2 extends AppCompatActivity {

    int num_boton;
    String[] comandos = {"Wa", "W6", "W8", "W1", "W2", "W3", "W7", "W4", "W5",
            "Wi", "W9", "We", "Wd", "Wf", "Wc", "Wh", "Wg", "Wj"};
    private TextView monitor;
    private Button startstop;
    private ConstraintLayout mFondo;
    private MenuItem mBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Vista color
        mFondo = findViewById(R.id.fondo);

        //Icono de barra menu
        getSupportActionBar().setIcon(R.drawable.ball);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        monitor = (TextView) findViewById(R.id.monitor);
        //    startstop = (Button) findViewById(R.id.startstop);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
    }



    public void boton_star(View view) {
        num_boton = 0;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    public void boton_loc_inc(View view) {
        num_boton = 3;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    public void boton_loc_dec(View view) {
        num_boton = 4;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    public void boton_vis_inc(View view) {
        num_boton = 1;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    public void boton_vis_dec(View view) {
        num_boton = 2;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    public void boton_foul_loc(View view) {
        num_boton = 5;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    public void boton_foul_vis(View view) {
        num_boton = 6;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    public void boton_per(View view) {
        num_boton = 7;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    public void boton_min_inc(View view) {
        num_boton = 8;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    public void boton_min_dec(View view) {
        num_boton = 9;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    public void boton_reset(View view) {
        num_boton = 10;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    public void boton_star_24s(View view) {
        num_boton = 11;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    public void boton_24_14(View view) {
        num_boton = 12;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    public void boton_brillo(View view) {
        num_boton = 14;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    public void boton_color(View view) {
        num_boton = 13;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    public void boton_rst_24s(View view) {
        num_boton = 15;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    public void boton_posesion(View view) {
        num_boton = 16;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    public void boton_reset_all(View view) {
        num_boton = 17;
        monitor.setText("Botón Star oprimido" + comandos[num_boton]);
        Conectar();
    }

    private void Conectar() {
        String precios = "";
        String ip = "192.168.4.1";
        int puerto = 80;
        try {
            Socket sk = new Socket(ip, puerto);
            log("CONEXIÓN ABIERTA");
            BufferedReader entrada = new BufferedReader(new
                    InputStreamReader(sk.getInputStream()));

            PrintWriter salida = new PrintWriter(
                    new OutputStreamWriter(sk.getOutputStream()), true);
            monitor.setText("");
            log("envio: " + comandos[num_boton]);
            salida.printf(comandos[num_boton]);
//            log("recibiendo ... " + entrada.readLine());
            sk.close(); // cierra al recibir el mensaje con un enter
            log("www.mexicoled.com");
        } catch (Exception e) {
            log("error: " + e.toString());
        }
    }

    private void log(String cadena) {
        monitor.append(cadena + "\n");
    }




    //c1-Inflado del menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        mBorrar= menu.findItem(R.id.borrar);
        return super.onCreateOptionsMenu(menu);
    }

    //c2- Manejo de las opciones del menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.colores:
                Toast.makeText(this, "Cambiaste color", Toast.LENGTH_SHORT).show();
                mFondo.setBackgroundColor(Color.parseColor("#000000"));
                break;

            case R.id.borrar:
                Toast.makeText(this, "Opcion Borrar seleccionada", Toast.LENGTH_SHORT).show();
                mFondo.setBackgroundColor(Color.parseColor("#FFFFFFFF"));

                break;

            case R.id.acerca_de:
                Intent myLink = new Intent(Intent.ACTION_VIEW);
                myLink.setData(Uri.parse("https://www.youtube.com/user/mexicoledpuntocom/videos"));
                startActivity(myLink);
        }
        return super.onOptionsItemSelected(item);
    }
}