import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * 登入畫面
 */
public class LoginPanel extends JPanel {
    private final JTextField nameField;
    private final JTextField ipField;
    private final JButton loginButton;
    private final UserConfig userConfig;

    public LoginPanel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(40, 40, 40));
        
        // 載入本地配置
        userConfig = new UserConfig();

        JLabel title = new JLabel("Blackjack Survival");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(Color.ORANGE);

        nameField = new JTextField(15);
        ipField = new JTextField(15);
        loginButton = new JButton("連線並進入遊戲");
        
        // 自動填入上次使用的配置
        nameField.setText(userConfig.getName());
        ipField.setText(userConfig.getServerIp());

        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(10, 10, 10, 10);
        g.gridx = 0;
        g.gridy = 0;
        add(title, g);

        g.gridy++;
        add(new JLabel("<html><font color='white'>伺服器 IP:</font></html>"), g);
        g.gridy++;
        add(ipField, g);

        g.gridy++;
        add(new JLabel("<html><font color='white'>暱稱:</font></html>"), g);
        g.gridy++;
        add(nameField, g);

        g.gridy++;
        add(loginButton, g);
    }

    public String getIp() {
        return ipField.getText().trim();
    }

    public String getPlayerName() {
        return nameField.getText().trim();
    }

    public JButton getLoginButton() {
        return loginButton;
    }
    
    public String getUid() {
        return userConfig.getUid();
    }
    
    public void saveCurrentConfig() {
        userConfig.setName(getPlayerName());
        userConfig.setServerIp(getIp());
        userConfig.saveConfig();
    }
}
