package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Penduduk> pendudukList = Main.getDataPenduduk();

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Cari penduduk dengan NIK atau nama: ");

            String kataKunci = input.nextLine();
            Penduduk hasil = Main.cariPenduduk(pendudukList, kataKunci);
            if (hasil == null) {
                System.out.println("Data penduduk tidak ditemukan!");
            } else {
                System.out.println("==============================");
                System.out.println("NIK : " + hasil.getNik());
                System.out.println("Nama : " + hasil.getNama());
                System.out.println("Tempat Lahir : " + hasil.getTempatLahir());
                System.out.println("Tanggal Lahir : " + hasil.getTanggalLahir());
                System.out.println("Status : " + hasil.getStatus());
                System.out.println("==============================");
            }
        }
    }

    public static List<Penduduk> getDataPenduduk() {
        List<Penduduk> pendudukList = new ArrayList<>();

        pendudukList.add(new Penduduk("1234", "Rani Jubaedah", "Bandung", "1999-01-01", "kawin"));
        pendudukList.add(new Penduduk("2345", "Siti Cicingwae", "Semarang", "1999-02-02", "belum kawin"));
        // tambah lebih banyak data penduduk disini

        return pendudukList;
    }

    public static Penduduk cariPenduduk(List<Penduduk> pendudukList, String kataKunci) {
        Penduduk hasil = null;
        for (Penduduk penduduk: pendudukList) {
            if (penduduk.getNama().toLowerCase().contains(kataKunci.toLowerCase()) || penduduk.getNik().equals(kataKunci)) {
                hasil = penduduk;
                break;
            }
        }
        return hasil;
    }
}
