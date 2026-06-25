import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TopScorersFrame extends JFrame {

    private JTable table;
    private PlayerService playerService;

    public TopScorersFrame() {
        playerService = new PlayerService();

        String[] columns = {"Username", "Wins", "Losses", "Draws", "Score"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int col) { return false; }
        };

        //Get Top 5 players from playerService
        List<Player> topList = playerService.getTopFiveScorers();

        //Add each player data into the table model
        for (Player p : topList) {
            model.addRow(new Object[]{
                    p.getUsername(),
                    p.getWins(),
                    p.getLosses(),
                    p.getDraws(),
                    p.getScore()
            });
        }

        //buat tabel dan tambahkan ke scroll pane
        table = new JTable(model);
        add(new JScrollPane(table));

        //ui
        buildUI();
    }

    //buat ui
    private void buildUI() {
        setTitle("🏆 Top 5 Scorers");
        setSize(540, 320);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().removeAll();

        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBackground(new Color(28, 28, 45));
        root.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        JLabel lblJudul = new JLabel("🏆  TOP 5 SCORERS", SwingConstants.CENTER);
        lblJudul.setFont(new Font("Arial", Font.BOLD, 18));
        lblJudul.setForeground(new Color(255, 200, 50));
        root.add(lblJudul, BorderLayout.NORTH);

        table.setBackground(new Color(40, 40, 60));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Arial", Font.PLAIN, 13));
        table.setRowHeight(32);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 2));
        table.setSelectionBackground(new Color(70, 100, 160));

        table.getTableHeader().setBackground(new Color(50, 80, 140));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        table.getTableHeader().setReorderingAllowed(false);

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(
                    JTable t, Object value, boolean isSelected,
                    boolean hasFocus, int row, int col) {
                super.getTableCellRendererComponent(t, value, isSelected, hasFocus, row, col);
                setForeground(Color.WHITE);
                setHorizontalAlignment(col == 0 ? LEFT : CENTER);

                if (isSelected) {
                    setBackground(new Color(70, 100, 160));
                } else if (row == 0) {
                    setBackground(new Color(80, 60, 20)); // emas gelap untuk peringkat 1
                } else if (row % 2 == 0) {
                    setBackground(new Color(40, 40, 60));
                } else {
                    setBackground(new Color(50, 50, 75));
                }
                return this;
            }
        });

        int[] widths = {180, 75, 75, 75, 80};
        for (int i = 0; i < widths.length; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(new Color(28, 28, 45));
        scrollPane.getViewport().setBackground(new Color(40, 40, 60));
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 100)));
        root.add(scrollPane, BorderLayout.CENTER);

        JButton btnTutup = new JButton("Tutup");
        btnTutup.setBackground(new Color(60, 100, 160));
        btnTutup.setForeground(Color.WHITE);
        btnTutup.setFont(new Font("Arial", Font.BOLD, 12));
        btnTutup.setFocusPainted(false);
        btnTutup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnTutup.addActionListener(e -> this.dispose());

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(new Color(28, 28, 45));
        bottomPanel.add(btnTutup);
        root.add(bottomPanel, BorderLayout.SOUTH);

        add(root);
        revalidate();
        repaint();
    }
}
