import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {
    private Player currentPlayer;
    private JButton btnStartGame;
    private JButton btnStatistics;
    private JButton btnTopScorers;
    private JButton btnExit;

    public MainMenuFrame(Player player) {
        this.currentPlayer = player; //pemain

        //buat ui di main menu
        buildUI();
        //tombol game mulai bermain
        btnStartGame.addActionListener(e -> {
            GameFrame gameFrame = new GameFrame(currentPlayer);
            gameFrame.setVisible(true);
            this.dispose();
        });
        //tombol statistik saya
        btnStatistics.addActionListener(e -> {
            StatisticsFrame statisticsFrame = new StatisticsFrame(currentPlayer);
            statisticsFrame.setVisible(true);
        });
        //tombol top 5 score
        btnTopScorers.addActionListener(e -> {
            TopScorersFrame topFrame = new TopScorersFrame();
            topFrame.setVisible(true);
        });
        //tombol keluar
        btnExit.addActionListener(e -> {
            System.exit(0);
        });
    }

    //ui buat main menu
    private void buildUI() {
        setTitle("Tic-Tac-Toe — Menu Utama");
        setSize(400, 470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel root = new JPanel(new GridBagLayout());
        root.setBackground(new Color(28, 28, 45));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 30, 8, 30);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Salam sambutan
        JLabel lblHello = new JLabel("Halo, " + currentPlayer.getUsername() + "!", SwingConstants.CENTER);
        lblHello.setFont(new Font("Arial", Font.BOLD, 20));
        lblHello.setForeground(new Color(100, 200, 255));
        gbc.gridx = 0; gbc.gridy = 0;
        root.add(lblHello, gbc);

        // Info score
        JLabel lblScore = new JLabel(
                "Score: " + currentPlayer.getScore() +
                        "  |  Menang: " + currentPlayer.getWins() +
                        "  Kalah: " + currentPlayer.getLosses(),
                SwingConstants.CENTER
        );
        lblScore.setFont(new Font("Arial", Font.PLAIN, 12));
        lblScore.setForeground(new Color(180, 180, 200));
        gbc.gridy = 1;
        root.add(lblScore, gbc);

        JSeparator sep = new JSeparator();
        sep.setForeground(new Color(60, 60, 90));
        gbc.gridy = 2;
        root.add(sep, gbc);

        btnStartGame  = makeMenuButton("🎮  Mulai Bermain",  new Color(40, 120, 200));
        btnStatistics = makeMenuButton("📊  Statistik Saya", new Color(60, 140, 80));
        btnTopScorers = makeMenuButton("🏆  Top 5 Scorers",  new Color(160, 110, 30));
        btnExit       = makeMenuButton("🚪  Keluar",          new Color(160, 50, 50));

        gbc.gridy = 3; root.add(btnStartGame,  gbc);
        gbc.gridy = 4; root.add(btnStatistics, gbc);
        gbc.gridy = 5; root.add(btnTopScorers, gbc);
        gbc.gridy = 6; root.add(btnExit,       gbc);

        add(root);
    }

    private JButton makeMenuButton(String teks, Color warna) {
        JButton btn = new JButton(teks);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setBackground(warna);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        return btn;
    }
}
