/**
 * 訊息處理上下文 - 封裝訊息處理所需的資訊
 */
public class MessageContext {
    private final BlackjackClient client;
    private final String[] parts;

    public MessageContext(BlackjackClient client, String[] parts) {
        this.client = client;
        this.parts = parts;
    }

    /**
     * 取得客戶端主視窗
     */
    public BlackjackClient getClient() {
        return client;
    }

    /**
     * 取得解析後的訊息參數
     */
    public String[] getParts() {
        return parts;
    }

    /**
     * 取得指定索引的參數（若不存在則返回 null）
     */
    public String getParam(int index) {
        if (parts != null && index >= 0 && index < parts.length) {
            return parts[index];
        }
        return null;
    }

    /**
     * 取得參數數量
     */
    public int getParamCount() {
        return parts != null ? parts.length : 0;
    }

    /**
     * 取得遊戲面板
     */
    public GamePanel getGamePanel() {
        return client.getGamePanel();
    }

    /**
     * 取得網路客戶端
     */
    public NetworkClient getNetworkClient() {
        return client.getNetworkClient();
    }

    /**
     * 取得玩家名稱
     */
    public String getPlayerName() {
        return client.getPlayerName();
    }

    /**
     * 顯示指定面板
     */
    public void showPanel(String panelName) {
        client.showPanel(panelName);
    }

    /**
     * 設定 PVE 模式
     */
    public void setPveMode(boolean pveMode) {
        client.setPveMode(pveMode);
    }

    /**
     * 檢查開始按鈕可見性
     */
    public void checkStartButtonVisibility() {
        client.checkStartButtonVisibility();
    }

    /**
     * 更新功能牌
     */
    public void updateFunctionCards(String cardsData) {
        client.updateFunctionCards(cardsData);
    }
}
