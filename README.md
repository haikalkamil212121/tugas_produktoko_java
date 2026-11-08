# Daftar Produk Toko

Aplikasi desktop sederhana untuk mengelola daftar produk toko, dibuat dengan **Java** dan **JavaFX**. Pengguna dapat menambah produk (lengkap dengan gambar), melihat detailnya, mencari dan memfilter produk, serta menghapusnya.

## Fitur

- **Tambah produk**: nama, kategori (Makanan atau Minuman), harga, dan gambar produk (opsional).
- **Kode produk otomatis**: `PR001`, `PR002`, dan seterusnya.
- **Halaman detail**: menampilkan gambar, kode, nama, kategori, dan harga dalam format Rupiah.
- **Daftar produk** dalam bentuk tabel, dengan:
  - pencarian berdasarkan nama (tidak membedakan huruf besar/kecil),
  - filter kategori (Semua, Makanan, Minuman),
  - tombol untuk menampilkan atau menyembunyikan kolom harga,
  - hapus produk dengan dialog konfirmasi,
  - keterangan jumlah data yang sedang tampil.
- **Validasi input**: nama dan kategori wajib diisi, harga harus bilangan bulat lebih dari nol.

## Teknologi

| Komponen | Versi |
|---|---|
| Java | 17 |
| JavaFX (`javafx-controls`, `javafx-fxml`) | 21 |
| Maven | 3.x |
| `javafx-maven-plugin` | 0.0.8 |

> `pom.xml` juga mencantumkan dependensi `mysql-connector-java` 8.0.33, tetapi belum dipakai oleh kode. Data produk saat ini hanya disimpan di memori.

## Struktur Proyek

```
daftar_produk_toko/
├── pom.xml
├── nbactions.xml
└── src/main/
    ├── java/kelas/
    │   ├── MainApp.java                     # Titik masuk aplikasi
    │   ├── Navigator.java                   # Perpindahan halaman (form, detail, daftar)
    │   ├── controller/
    │   │   ├── FormController.java          # Halaman tambah produk
    │   │   ├── DetailController.java        # Halaman detail produk
    │   │   └── DaftarController.java        # Halaman daftar produk
    │   ├── data/
    │   │   └── DataPembelian.java           # Penyimpanan daftar produk (di memori)
    │   └── model/
    │       └── Produk.java                  # Data satu produk
    └── resources/kelas/
        ├── form.fxml
        ├── detail.fxml
        ├── daftar.fxml
        └── styles/app.css                   # Tampilan
```

## Cara Menjalankan

### Prasyarat

- JDK 17 atau lebih baru
- Apache Maven (atau NetBeans, yang sudah menyertakan Maven)

### Menjalankan

Dari folder proyek (yang berisi `pom.xml`):

```bash
mvn clean javafx:run
```

Di NetBeans: klik kanan proyek, lalu **Clean and Build**, kemudian **Run**.

Kelas utama: `kelas.MainApp`. Aplikasi pertama kali terbuka di halaman **Tambah Produk**.

## Cara Menggunakan

1. **Tambah produk**: isi nama, pilih kategori, dan isi harga (angka bulat, misalnya `15000`).
2. **Pilih gambar** (opsional): klik **Pilih Gambar**, lalu pilih file `.png`, `.jpg`, `.jpeg`, `.gif`, atau `.bmp`. Nama file yang dipilih tampil di bawah tombol.
3. Klik **Simpan dan Lihat Detail**. Aplikasi membuka halaman detail produk yang baru disimpan.
4. Dari halaman detail, klik **Tambah Produk Lain** untuk menambah lagi, atau **Lihat Daftar** untuk melihat semua produk.
5. Di halaman **Daftar Produk**:
   - Ketik nama di kolom pencarian, lalu tekan Enter atau klik **Cari**.
   - Untuk memfilter kategori, pilih kategori di kotak pilihan, lalu klik **Cari**.
   - Klik **Reset** untuk mengosongkan pencarian dan filter.
   - Pilih satu baris, lalu klik **Lihat Detail** atau **Hapus**.
   - Centang atau hapus centang **Harga** untuk menampilkan atau menyembunyikan kolom harga.

## Catatan

- Data disimpan di memori saja. Semua produk hilang saat aplikasi ditutup.
- Aplikasi tidak menyalin gambar ke dalam proyek. Aplikasi hanya mengingat lokasi file gambar selama berjalan, jadi gambar tidak muncul jika file dipindah atau dihapus saat aplikasi masih terbuka.
- Gambar hanya ditampilkan di halaman detail, belum di tabel daftar.
- Nomor kode produk terus bertambah dan tidak dipakai ulang, meskipun produk sebelumnya sudah dihapus.
