import javax.swing.SwingUtilities;
//buat kelas main
public class Main {
    public static void main(String[] args) {
        //menyuruh java menjalankan kodee GUI di jalur khususnya agar tidak eror dan tampilan tetap aman
        SwingUtilities.invokeLater(new Runnable() {
            //method run ini berisi kode yang akan dijalankan nantinya
            public void run() {
                //buat objek login yang memanggil constructor LoginFrame
                LoginFrame loginFrame = new LoginFrame();
                //menampilkan jendela login ke layar
                loginFrame.setVisible(true);
            }
        });
    }
}
