package com.example.listview;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Save {

        public static final String FILENAME = "Tareas.txt";

        public static void guardar (ArrayList<String> tarea, Context context)
        {
            try {
                FileOutputStream fos = context.openFileOutput(FILENAME, context.MODE_PRIVATE);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(tarea);
                oos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static ArrayList <String> leertareas (Context context)
        {
            ArrayList <String> tareas = null;

            try {
                FileInputStream fis = context.openFileInput(FILENAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
                tareas = (ArrayList<String>) ois.readObject();
            } catch (FileNotFoundException e) {
                tareas = new ArrayList<>();
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return tareas;
        }
    }

