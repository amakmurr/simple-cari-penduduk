package com.company;

public class Penduduk {

    private String nik;
    private String nama;
    private String tempatLahir;
    private String tanggalLahir;
    private String status;

    public Penduduk(String nik, String nama, String tempatLahir, String tanggalLahir, String status) {
        setNik(nik);
        setNama(nama);
        setTempatLahir(tempatLahir);
        setTanggalLahir(tanggalLahir);
        setStatus(status);
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
