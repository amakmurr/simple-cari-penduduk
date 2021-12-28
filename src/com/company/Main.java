package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Penduduk> pendudukList = Main.getDataPenduduk();

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Pilih aksi: \n1. cari \n2. tambah \n3. hapus \nPilih:");
            String aksi = input.next();
            switch (aksi) {
                case "1":
                    System.out.println("Cari penduduk dengan NIK atau nama: ");
                    String kataKunci = input.next();
                    Penduduk hasil = Main.cariPenduduk(pendudukList, kataKunci);
                    if (hasil == null) {
                        System.out.println("\n==============================");
                        System.out.println("Data penduduk tidak ditemukan!");
                        System.out.println("==============================\n");
                    } else {
                        System.out.println("\n==============================");
                        System.out.println("NIK : " + hasil.getNik());
                        System.out.println("Nama : " + hasil.getNama());
                        System.out.println("Tempat Lahir : " + hasil.getTempatLahir());
                        System.out.println("Tanggal Lahir : " + hasil.getTanggalLahir());
                        System.out.println("Status : " + hasil.getStatus());
                        System.out.println("==============================\n");
                    }
                    break;
                case "2":
                    System.out.println("Input NIK: ");
                    String nik = input.next();

                    System.out.println("Input Nama: ");
                    String nama = input.next();

                    System.out.println("Input Tempat Lahir: ");
                    String tempatLahir = input.next();

                    System.out.println("Input Tanggal Lahir: ");
                    String tanggalLahir = input.next();

                    System.out.println("Input Status: ");
                    String status = input.next();

                    pendudukList = Main.tambahPenduduk(pendudukList, nik, nama, tempatLahir, tanggalLahir, status);
                    System.out.println("\n==============================");
                    System.out.println("Penduduk dengan NIK " + nik + " berhasil ditambahkan");
                    System.out.println("==============================\n");
                    break;
                case "3":
                    System.out.println("Input NIK penduduk untuk dihapus: ");
                    String nikHapus = input.next();

                    pendudukList = Main.hapusPenduduk(pendudukList, nikHapus);
                    System.out.println("\n==============================");
                    System.out.println("Penduduk dengan NIK " + nikHapus + " berhasil dihapus");
                    System.out.println("==============================\n");
                    break;
                default:
                    System.out.println("\n==============================");
                    System.out.println("Input aksi salah! Harap ulangi");
                    System.out.println("==============================\n");
                    break;
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

    public static List<Penduduk> tambahPenduduk(List<Penduduk> pendudukList, String nik, String nama, String tempatLahir, String tanggalLahir, String status) {
        pendudukList.add(new Penduduk(nik, nama, tempatLahir, tanggalLahir, status));
        return pendudukList;
    }

    public static List<Penduduk> hapusPenduduk(List<Penduduk> pendudukList, String nik) {
        int index = -1;
        for (int i = 0; i < pendudukList.size(); i++) {
            Penduduk penduduk = pendudukList.get(i);
            if (penduduk.getNik().equals(nik)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            pendudukList.remove(index);
        }
        return pendudukList;
    }
}
