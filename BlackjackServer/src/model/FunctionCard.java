/**
 * 機會牌類別
 * 封裝單張機會牌的資訊
 */
public class FunctionCard {
    private static int nextId = 1;

    private final int id;
    private final FunctionCardType type;

    public FunctionCard(FunctionCardType type) {
        this.id = nextId++;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public FunctionCardType getType() {
        return type;
    }

    /**
     * 轉換為協定格式字串
     * 格式: id,TYPE_NAME
     */
    public String toProtocol() {
        return id + "," + type.name();
    }

    /**
     * 從協定字串建立機會牌（用於重建物件）
     */
    public static FunctionCard fromProtocol(String data) {
        String[] parts = data.split(",");
        if (parts.length >= 2) {
            FunctionCardType type = FunctionCardType.fromString(parts[1]);
            if (type != null) {
                return new FunctionCard(type);
            }
        }
        return null;
    }
}
