/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPBO_12;

/**
 *
 * @author ASUS
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Buku implements Serializable {
    private String judul;
    private String pengarang;
    private int tahunTerbit;

    // Konstruktor
    public Buku(String judul, String pengarang, int tahunTerbit) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
    }

    @Override
    public String toString() {
        return "Buku{" +
                "judul='" + judul + '\'' +
                ", pengarang='" + pengarang + '\'' +
                ", tahunTerbit=" + tahunTerbit +
                '}';
    }
}
    
