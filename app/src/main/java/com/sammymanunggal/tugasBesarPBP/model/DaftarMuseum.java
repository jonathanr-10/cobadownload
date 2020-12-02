package com.sammymanunggal.tugasBesarPBP.model;

import java.util.ArrayList;

public class DaftarMuseum {
    public ArrayList<Museum> MUSEUM;

    public DaftarMuseum(){
        MUSEUM = new ArrayList();
        MUSEUM.add(Affandi);
        MUSEUM.add(Merapi);
        MUSEUM.add(Vredeburg);
        MUSEUM.add(Keraton);
        MUSEUM.add(Sandi);
        MUSEUM.add(Jogja);

    }

    public static final Museum Affandi = new Museum( "Museum Affandi",
            "Museum Sandi Yogyakarta merupakan museum pertama dan satu-satunya di dunia yang mengoleksi benda-benda dan peralatan untuk mengirimkan pesan rahasia. Di museum ini terekam sejarah persandian di Indonesia dan dunia.\n" +
                    "Konon, museum yang didirikan atas kerjasama Lembaga Sandi Negara dengan Kementrian Kebudayaan dan Pariwisata ini merupakan museum pertama dan satu-satunya di dunia yang mengoleksi peralatan untuk mengirimkan pesan rahasia. " +
                    "Koleksi tersebut diantaranya buku kode sandi, telegraf, hingga berbagai mesin sandi buatan Indonesia maupun luar negeri. Dulunya mesin-mesin tersebut digunakan untuk mengirimkan sinyal atau pesan penyerangan ke sarang musuh tanpa" +
                    " terdeteksi. Dengan bantuan mesin-mesin ini pejuang Indonesia berhasil merebut kembali daerah yang dikuasai penjajah.",
            3000,
            "https://farm9.staticflickr.com/8801/29532165140_bf89066e52_b.jpg","Senin - Jumat","09.00 - 16.00"
    ,"Jl. Faridan M Noto No.21, Kotabaru, Kec. Gondokusuman, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55224");

    public static final Museum Merapi = new Museum("Museum Merapi",
             "Museum Gunung Merapi merupakan salah tempat yang dibangun untuk menjadi sarana pembelajaran tentang gunung teraktif di dunia ini. Di museum ini pengunjung dapat mempelajari banyak hal mengenai Gunung" +
              " Merapi. Baik  dari sisi legenda, kearifan lokal, sejarah panjang letusannya, bahkan sampai melihat sisa-sisa efek dasyat letusan yang membuat merinding.Sebagai negara yang berada di lokasi paling " +
               "aktif dari ring of fire vulkanik bumi, tentu pemahaman kebencanaan geologi adalah hal yang penting untuk diberikan kepada masyarakat. Salah satu langkah untuk memberikan pemahaman pentingnya upaya mitigasi bencana, maka dibangunlah Museum Gunung Merapi ini."+
              "Terletak di kaki Merapi yang sejuk, Museum Gunung Merapi memiliki arsitektur bangunan yang khas, berupa segitiga yang menyerupai gunung. Saat cuaca cerah, pengunjung bisa menyaksikan gunung merapi nan gagah dari pelataran museum.",
          10000,"https://www.alodiatour.com/wp-content/uploads/2018/11/museum-1.jpg","Senin - Minggu","08.00 - 15.30","Jl. Kaliurang No.Km, Banteng, Hargobinangun, Kec. Pakem, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55582"
    );

    public static final Museum Vredeburg = new Museum("Museum Vredeburg",
            "Banyak tempat wisata di Yogyakarta yang menyimpan banyak sejarah, salah satunya Museum Benteng Vredeburg. Lokasinya masih dekat Malioboro.\n" +
                    "Museum Benteng Vredeburg sangat dekat dengan perempatan Titik Nol Kilometer yang sangat padat dengan para wisatawan, tepatnya di Jalan Ahmad Yani, " +
                    "Kota Yogyakarta. Bangunan yang dibangun pada tahun 1760-an oleh Sri Sultan Hamengku Buwono ini mempunyai " +
                    "pesona keren yang mampu mencuri perhatian para wisatawan yang hanya sekedar lewat lalu memutuskan untuk berkunjung ke museum tersebut.\n" +
                    "Tidak hanya ruang diorama dan arsitektur bangunan yang mampu mencuri perhatian para wisatawan, tetapi fasilitas yang dimiliki Museum" +
                    " Benteng Vredeburg ini sangat lengkap. Adanya toilet, tempat ibadah (mushola), ruang audio visual, kantin, cafe dan ruangan diorama nya " +
                    "yang dikelilingi AC. Fasilitas tersebut membuat kita semakin nyaman untuk menelusuri museum ini lebih dalam lagi.",
            2000,"https://raunmulu.com/wp-content/uploads/2017/02/feature-benteng-730x410.jpg","Senin - Minggu","07.00 - 16.00",
            "Jl. Margo Mulyo No.6, Ngupasan, Kec. Gondomanan, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55122");

    public static final Museum Keraton = new Museum("Museum Keraton",
            "Museum Keraton Yogyakarta terletak di tengah kota Yogyakarta. Dekat dengan Alun-alun Utara Yogyakarta. Museum ini Bernuansa budaya Jawa dengan daya tarik utama Karaton Kasultanan Ngayogyakarta Hadiningrat.\n" +
                    "Sejaran mencatat bahwa Kraton Yogyakarta telah dibangun sejak masa pemerintahan Sultan Hamengku Buwana I pada 7 Oktober 1756 yang disempurnakan kemudian oleh para sultan berikutnya. Di masa pemerintahan Sultan HB IX, " +
                    "kraton dibuka agar masyarakat luas dapat menikmatinya.Anda akan menyaksikan keagungan, kemegahan, dan kewibawaan para raja dan keluarganya saat \n" +
                    "memegang pemerintahan dari masa ke masa melalui koleksi kristal, kereta, kain batik, lukisan Raden Saleh, gamelan pusaka, hingga koleksi pribadi Sri Sultan Hamengku Buwana IX.",
            15000,"https://visitingjogja.com/wp-content/uploads/2017/01/keraton.jpg","Senin - Minggu","08.00 - 14.00",
            "Jl. Rotowijayan Blok No. 1, Panembahan, Kecamatan Kraton, Kota Yogyakarta, Daerah Istimewa Yogyakarta");

    public static final Museum Sandi = new Museum("Museum Sandi",
            "Museum Sandi Yogyakarta merupakan museum pertama dan satu-satunya di dunia yang mengoleksi benda-benda dan peralatan untuk mengirimkan pesan rahasia. Di museum ini terekam sejarah persandian di Indonesia dan dunia.\n" +
                    "Konon, museum yang didirikan atas kerjasama Lembaga Sandi Negara dengan Kementrian Kebudayaan dan Pariwisata ini merupakan museum pertama dan satu-satunya di dunia yang mengoleksi peralatan untuk mengirimkan pesan rahasia." +
                    " Koleksi tersebut diantaranya buku kode sandi, telegraf, hingga berbagai mesin sandi buatan Indonesia maupun luar negeri. Dulunya mesin-mesin tersebut digunakan untuk mengirimkan sinyal atau pesan penyerangan ke sarang musuh " +
                    "tanpa terdeteksi. Dengan bantuan mesin-mesin ini pejuang Indonesia berhasil merebut kembali daerah yang dikuasai penjajah.",
            3000,"https://farm9.staticflickr.com/8801/29532165140_bf89066e52_b.jpg","Senin - Jumat", "08.00 - 16.00",
            "Jl. Faridan M Noto No.21, Kotabaru, Kec. Gondokusuman, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55224");

    public static final Museum Jogja = new Museum("Museum Jogja Kembali",
            "Museum Sandi Yogyakarta merupakan museum pertama dan satu-satunya di dunia yang mengoleksi benda-benda dan peralatan untuk mengirimkan pesan rahasia. Di museum ini terekam sejarah persandian di Indonesia dan dunia.\n" +
                    "Konon, museum yang didirikan atas kerjasama Lembaga Sandi Negara dengan Kementrian Kebudayaan dan Pariwisata ini merupakan museum pertama dan satu-satunya di dunia yang mengoleksi peralatan untuk mengirimkan pesan rahasia." +
                    " Koleksi tersebut diantaranya buku kode sandi, telegraf, hingga berbagai mesin sandi buatan Indonesia maupun luar negeri. Dulunya mesin-mesin tersebut digunakan untuk mengirimkan sinyal atau pesan penyerangan ke sarang musuh " +
                    "tanpa terdeteksi. Dengan bantuan mesin-mesin ini pejuang Indonesia berhasil merebut kembali daerah yang dikuasai penjajah.",1000,"https://sanjayatour.com/wp-content/uploads/2020/02/Museum-Monumen-Yogya-Kembali-Monjali-696x398.jpg","Senin - Minggu","08.00 - 15.00",
            "Jl. Ring Road Utara, Jongkang, Sariharjo, Kec. Ngaglik, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55581"

    );

}
