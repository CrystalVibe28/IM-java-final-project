import javax.swing.JOptionPane;

/**
 * 錯誤訊息處理器
 */
public class ErrorHandler implements ServerMessageHandler {
    @Override
    public void handle(MessageContext context) {
        String[] parts = context.getParts();
        JOptionPane.showMessageDialog(context.getClient(), parts[1]);
    }
}
