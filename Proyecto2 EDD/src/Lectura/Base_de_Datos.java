package Lectura;

import ClaseHash.Hash_table;
import ClaseHash.Lista;
import ClaseHash.Lista2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

public class Base_de_Datos {

    Cargar cargar = new Cargar();  //Para cargar archivo.
    private Hash_table hash_table;
    File file;
    private String path;


    public Hash_table datos(Lista2 lista1) {
        Hash_table tablahash = new Hash_table(10111);
        String line;
        String prueba_text = "";
        try {
            file = cargar.abrirArchivo();
            path = file.getPath();

        } catch (Exception ex) {  
        }

        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        prueba_text += line + "\n";
                    }
                }

                if (!"".equals(prueba_text) && !prueba_text.isEmpty()) {
                    //String[] datos_split = prueba_text.split("\n");
                    String[] datos_split = prueba_text.split("\n");
                    //System.out.println(Arrays.toString(datos_split));
                    char punto = '.';
                    char coma = ',';
                    char punto_coma = ';';
                    char dos_puntos = ':';
                    char p1 = '(';
                    char p2 = ')';
                    char vacio = ' ';
                    for (int i = 0; i < datos_split.length; i++) {
                        String d = datos_split[i];
                        String[] palabra = d.split(" ");
                    for (int j = 0; j < palabra.length; j++) {
                        Boolean comprobar = true;
                        String p = palabra[j];
                        p = p.toLowerCase();
                        for (int k = 0; k < p.length(); k++){
                            if (p.charAt(k) == punto){
                              String replace1 = p.replace(punto, vacio);
                              String result1 = replace1.replaceAll(" ", "");
                              tablahash.insertar(result1, tablahash);
                              lista1.addAtTheEnd2(result1, lista1);
                              //System.out.println(result + "-------");
                              comprobar = false;
                            } else if (p.charAt(k) == coma){
                              String replace2 = p.replace(coma, vacio);
                              String result2 = replace2.replaceAll(" ", "");
                              //System.out.println(result);
                              tablahash.insertar(result2, tablahash);
                              lista1.addAtTheEnd2(result2, lista1);
                              comprobar = false;
                            } else if (p.charAt(k) == punto_coma){
                              String replace3 = p.replace(punto_coma, vacio);
                              String result3 = replace3.replaceAll(" ", "");
                              //System.out.println(result);
                              tablahash.insertar(result3, tablahash);
                              lista1.addAtTheEnd2(result3, lista1);
                              comprobar = false;
                            } else if (p.charAt(k) == dos_puntos){
                              String replace4 = p.replace(dos_puntos, vacio);
                              String result4 = replace4.replaceAll(" ", "");
                              tablahash.insertar(result4, tablahash);
                              lista1.addAtTheEnd2(result4, lista1);
                              comprobar = false;
                            } else if (p.charAt(k) == p1){
                              String replace5 = p.replace(p1, vacio);
                              String result5 = replace5.replaceAll(" ", "");
                              tablahash.insertar(result5, tablahash);
                              lista1.addAtTheEnd2(result5, lista1);
                              comprobar = false;
                            } else if (p.charAt(k) == p2){
                              String replace6 = p.replace(p2, vacio);
                              String result6 = replace6.replaceAll(" ", "");
                              //System.out.println(result);
                              tablahash.insertar(result6, tablahash);
                              lista1.addAtTheEnd2(result6, lista1);
                              comprobar = false;
                            } 
                        }
                        if (comprobar ==true){
                        String result7 = p.replaceAll(" ", "");
                        //System.out.println(p);
                        tablahash.insertar(result7, tablahash);
                        lista1.addAtTheEnd2(result7, lista1);}
                    }

                    }
//                    String linea = br.readLine();
//                    String []parts = linea.split(" ");
//                    for (int i = 0; i < parts.length; i++) {
//                        System.out.println(parts[i]);
//                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Exito al leer");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al leer. Se va a cargar un archivo default.");

            //return Lecturadefault();
        }
        return tablahash;
    }
    
    
    public Lista listas_info(Lista lista, Lista2 lista1){
        Hash_table tablahash = new Hash_table(10111);
        Base_de_Datos bdatos = new Base_de_Datos();
        tablahash = bdatos.datos(lista1);
        lista.addAtTheEnd(tablahash, lista1);
        return lista; 
    }

//    public ListDatos Lecturadefault() {
//
//        ListDatos pedidos = new ListDatos();
//
//        String line;
//        String samancito_txt = "";
//
//        path = "test\\samancito.txt";
//        file = new File(getPath());
//
//        //Objetos para grafos
//        Lista l = new Lista();
//        String tipo;
//
//        //
//        try {
//            if (!file.exists()) {
//                file.createNewFile();
//            } else {
//                FileReader fr = new FileReader(file);
//                BufferedReader br = new BufferedReader(fr);
//                while ((line = br.readLine()) != null) {
//                    if (!line.isEmpty()) {
//                        samancito_txt += line + "\n";
//                    }
//                }
//
//                if (!"".equals(samancito_txt) && !samancito_txt.isEmpty()) {
//                    String[] datos_split = samancito_txt.split("\n");
//                    for (int i = 0; i < datos_split.length; i++) {
//                        if (datos_split[i].equals("Restaurantes")) {
//                            int j = i + 1;
//                            tipo = "Restaurante";
//
//                            while (!datos_split[j].equals("Clientes")) {
//                                String[] alldatos = datos_split[j].split(",");
//                                l.addAtTheEnd(tipo, alldatos);
//                                //printArreglo(alldatos);
//                                //restaurantes.addAtTheStart(datos_split);
//                                j++;
//                            }
//
//                        } else if (datos_split[i].equals("Clientes")) {
//                            int j = i + 1;
//                            tipo = "Cliente";
//
//                            while (!datos_split[j].equals("Pedidos")) {
//                                String[] alldatos = datos_split[j].split(",");
//                                l.addAtTheEnd(tipo, alldatos);
//                                //l.addAtTheEnd(tipo, alldatos);
//                                //clientes.addAtTheStart(datos_split);
//                                j++;
//                            }
//
//                        } else if (datos_split[i].equals("Pedidos")) {
//                            int j = i + 1;
//                            while (!datos_split[j].equals("Rutas")) {
//                                String[] alldatos = datos_split[j].split(",");
//
//                                pedidos.addAtTheStart(alldatos);
//
//                                j++;
//                            }
//
//                            //pedidos.printList();
//                        } else if (datos_split[i].equals("Rutas")) {
//
//                            //Se crea el grafo
//                            grafo = new Grafo(l);
//                            //
//                            int j = i + 1;
//                            while (true) {
//                                if (datos_split.length - j == 0) {
//                                    break;
//                                }
//                                String[] alldatos = datos_split[j].split(",");
//                                //printArreglo(alldatos);
//                                getGrafo().rellenarFila(alldatos);
//                                j++;
//                            }
//
//                            getGrafo().CrearMatrizAD();
//                        }
//
//                    }
//                }
//                br.close();
//                JOptionPane.showMessageDialog(null, "Exito al leer el archivo default.");
//            }
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Error al leer al leer el archivo default.");
//
//        }
//        return pedidos;
//
//    }

    /**
     * @return the grafo
     */
    public Hash_table getHash_table() {    
        return hash_table;
    }
    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

}
