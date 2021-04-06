# inheritance-rgpV3

PR INHERITANCE
Tugas Kelompok PBO - KOM4B
Anggota :
- M Adi Wahyudi | 1900180
- Seni Siti Inayah | 1902082

MERAPIKAN KODINGAN AGAR LEBIH MUDAH DIBACA

Urutannya :
- Atribut
- Setter Getter
- Opsi 
- Method
- Dan menambahkan Komentar pada setiap perubahan

LIST MODIFIKASI PROGRAM :

Class Pintu :
- menjadikan Class Pintu sebagai subclass (inheritance) dari Class Item, karena beberapa atribut & method mirip
- menghapus method setObjGameInfo karena sudah dibuat di class Item
- menjadikan method getAksi dan prosesAksi sebagai override karena nama method sama, namun intruksi didalamnya berbeda dengan superclass nya

Class Item :
- mengganti hak akses variabel objGameInfo dan arrAksi dari private menjadi protected, agar dapat digunakan oleh subclass
- constructor Item dibuat overloading, agar subclass dapat membuat constructor tanpa parameter

Class Ruangan :
- logika / perintah urutan menu memiliki beberapa perintah yang sama pada method pilihanAksi, maka dari itu ditambah 1 method lagi, dengan nama listDeskripsi agar tidak terjadi duplikasi logika / perintah

Class Player :
- karena di Class Player memiliki perintah yang sama dibagian method pilihanAksi, maka dibuat inisialisasi objRuangan guna untuk mengambil method listDeskripsi agar dapat digunakan kembali, dan mengurangi duplikasi
