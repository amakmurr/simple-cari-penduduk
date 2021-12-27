package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, Penduduk> pendudukMap = Main.getDataPenduduk();

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Pilih aksi 'cari' / 'tambah' / 'hapus': ");
            String aksi = input.next();
            switch (aksi) {
                case "cari":
                    System.out.println("Cari penduduk dengan NIK atau nama: ");
                    String kataKunci = input.next();
                    Penduduk hasil = Main.cariPenduduk(pendudukMap, kataKunci);
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
                    break;
                case "tambah":
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

                    pendudukMap = Main.tambahPenduduk(pendudukMap, nik, nama, tempatLahir, tanggalLahir, status);
                    System.out.println("Penduduk dengan NIK " + nik + " berhasil ditambahkan");
                    break;
                case "hapus":
                    System.out.println("Input NIK penduduk untuk dihapus: ");
                    String nikHapus = input.next();

                    pendudukMap = Main.hapusPenduduk(pendudukMap, nikHapus);
                    System.out.println("Penduduk dengan NIK " + nikHapus + " berhasil dihapus");
                    break;
                default:
                    System.out.println("Input aksi salah! Harap ulangi");
                    break;
            }
        }
    }

    public static Map<String, Penduduk> getDataPenduduk() {
        Map<String, Penduduk> pendudukMap = new HashMap<>();

        pendudukMap.put("1234", new Penduduk("1234", "Rani Jubaedah", "Bandung", "1999-01-01", "kawin"));
        pendudukMap.put("2345", new Penduduk("2345", "Siti Cicingwae", "Semarang", "1999-02-02", "belum kawin"));
        // tambah lebih banyak data penduduk disini

        return pendudukMap;
    }

    public static Penduduk cariPenduduk(Map<String, Penduduk> pendudukMap, String kataKunci) {
        Penduduk hasil = null;
        for (Map.Entry<String, Penduduk> entry: pendudukMap.entrySet()) {
            Penduduk penduduk = entry.getValue();
            if (penduduk.getNama().toLowerCase().contains(kataKunci.toLowerCase()) || penduduk.getNik().equals(kataKunci)) {
                hasil = penduduk;
                break;
            }
        }
        return hasil;
    }

    public static Map<String, Penduduk> tambahPenduduk(Map<String, Penduduk> pendudukMap, String nik, String nama, String tempatLahir, String tanggalLahir, String status) {
        pendudukMap.put(nik, new Penduduk(nik, nama, tempatLahir, tanggalLahir, status));
        return pendudukMap;
    }

    public static Map<String, Penduduk> hapusPenduduk(Map<String, Penduduk> pendudukMap, String nik) {
        pendudukMap.remove(nik);
        return pendudukMap;
    }
}
