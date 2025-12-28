/**
 * 登入命令 - 處理玩家登入
 */
public class LoginCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        String[] parts = context.getParts();
        ClientHandler handler = context.getHandler();

        if (parts.length > 2) {
            handler.setUid(parts[1]);
            handler.setName(parts[2]);
        } else if (parts.length > 1) {
            // 向後兼容：若只有 name 沒有 uid
            handler.setUid("unknown");
            handler.setName(parts[1]);
        } else {
            handler.setUid("unknown");
            handler.setName("Unknown");
        }

        System.out.println("玩家登入 - Name: " + handler.getName() + ", UID: " + handler.getUid());
        context.send(Protocol.LOGIN_OK);
    }
}
