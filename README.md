# Sistem Pemesanan & Pembayaran Menu Restoran

Proyek ini dibangun berdasarkan spesifikasi **Class Diagram Arsitektur Pemesanan Menu & Pembayaran** menggunakan **Full Stack Java Desktop Application (JavaFX + Core Java 17+ + Hibernate + MySQL)**.

---

## 📁 Struktur Direktori Proyek

```
D:\sistem_pesanan_resto/
├── docs/                               # FOLDER DOKUMENTASI LENGKAP
│   ├── prd.md                          # Product Requirements Document (PRD), alur sistem desktop, flowchart, & sequence diagram
│   ├── desain.md                       # Spesifikasi kelas, atribut, metode, relasi, & design pattern
│   └── arsitektur.md                   # Layered architecture (JavaFX + Hibernate + MySQL), ERD, & prinsip SOLID
└── README.md
```

---

## 📖 Ringkasan Dokumen dalam Folder `docs/`

1. **[`docs/prd.md`](file:///d:/sistem_pesanan_resto/docs/prd.md)**:
   - **Product Requirements Document (PRD)** komprehensif: latar belakang, persona pengguna (Kasir, Manajer, Pelanggan), Kebutuhan Fungsional (FR) antarmuka kasir desktop JavaFX, Kebutuhan Non-Fungsional (NFR), serta Kriteria Penerimaan (*Acceptance Criteria*).
   - Diagram Alir (*Flowchart*) proses operasional desktop kasir dari login hingga cetak struk thermal.
   - *Sequence Diagram* interaksi antarkomponen (*JavaFX Controller* -> *Domain Logic* -> *Hibernate ORM* -> *MySQL Database* -> *Java Print Service*).

2. **[`docs/desain.md`](file:///d:/sistem_pesanan_resto/docs/desain.md)**:
   - UML Class Diagram lengkap dengan penandaan visibilitas (`-` private, `#` protected, `+` public) berbasis tipe data murni Java.
   - Rincian tabel spesifikasi kelas, atribut, tipe data, dan metode.
   - Analisis relasi (Generalisasi/Inheritance, Realisasi Interface, Asosiasi, Komposisi, dan Agregasi).
   - Pola desain (*Strategy Pattern* pada Diskon & Pembayaran, *Template Method* pada penyesuaian harga Menu).

3. **[`docs/arsitektur.md`](file:///d:/sistem_pesanan_resto/docs/arsitektur.md)**:
   - Penerapan Arsitektur Berlapis (*Layered Architecture 4-Tier*): Presentation (JavaFX FXML & CSS), Controller/Service (Java SE), Domain Model (Pure OOP), dan Persistence (Hibernate ORM + MySQL 8.0+).
   - **Spesifikasi Stack Teknologi Terpadu**: Java SE 17+ LTS, JavaFX 21+, Hibernate 6.x / JPA, MySQL Connector/J, integrasi printer struk kasir thermal via `javax.print`, dan kemasan installer Windows mandiri (**`.exe`**) via `jpackage`.
   - Entity-Relationship Diagram (**ERD**) skema basis data relasional MySQL.
   - Kepatuhan terhadap prinsip **SOLID**, integritas transaksi finansial ACID, dan pencegahan *race condition* stok.
