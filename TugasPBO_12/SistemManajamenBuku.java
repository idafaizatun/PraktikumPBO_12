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

public class SistemManajamenBuku {
    private static final String FILE_TXT = "buku.txt";
    private static final String FILE_SER = "buku.ser";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Buku> bukuList = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Sistem Manajemen Buku ===");
            System.out.println("1. Tambah Buku Baru");
            System.out.println("2. Simpan Buku ke File (Serialisasi)");
            System.out.println("3. Tampilkan Buku dari File");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    // Tambah Buku Baru
                    System.out.print("Masukkan judul buku: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan pengarang: ");
                    String pengarang = scanner.nextLine();
                    System.out.print("Masukkan tahun terbit: ");
                    int tahunTerbit = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan buffer

                    Buku bukuBaru = new Buku(judul, pengarang, tahunTerbit);
                    bukuList.add(bukuBaru);
                    simpanKeFileTxt(bukuBaru);
                    System.out.println("Buku berhasil ditambahkan!");
                    break;

                case 2:
                    // Simpan Buku ke File (Serialisasi)
                    simpanKeFileSer(bukuList);
                    System.out.println("Buku berhasil disimpan dalam file serialisasi!");
                    break;

                case 3:
                    // Tampilkan Buku dari File
                    System.out.println("\nDaftar Buku dari File TXT:");
                    tampilkanDariFileTxt();
                    System.out.println("\nDaftar Buku dari File Serialisasi:");
                    tampilkanDariFileSer();
                    break;

                case 4:
                    // Keluar
                    System.out.println("Keluar dari program...");
                    System.exit(0);

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void simpanKeFileTxt(Buku buku) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_TXT, true))) {
            writer.write(buku.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Gagal menyimpan ke file TXT: " + e.getMessage());
        }
    }

    private static void simpanKeFileSer(ArrayList<Buku> bukuList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_SER))) {
            oos.writeObject(bukuList);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan ke file serialisasi: " + e.getMessage());
        }
    }

    private static void tampilkanDariFileTxt() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_TXT))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file TXT: " + e.getMessage());
        }
    }

    private static void tampilkanDariFileSer() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_SER))) {
            ArrayList<Buku> bukuList = (ArrayList<Buku>) ois.readObject();
            for (Buku buku : bukuList) {
                System.out.println(buku);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Gagal membaca file serialisasi: " + e.getMessage());
        }
    }
}
    
