# Blackjack 21點遊戲 - Agent 指南

## 專案概述

21點 PVP 對戰遊戲，支援單人練習 (PVE) 和多人對戰 (PVP) 模式。
採用 Java Socket 實作 Client-Server 架構。

## 目錄結構

```
im-java/
├── BlackjackServer/          # 伺服器程式
│   ├── src/
│   │   ├── Main.java         # 進入點
│   │   ├── server/           # 網路層
│   │   ├── game/             # 遊戲邏輯
│   │   ├── model/            # 資料模型
│   │   └── protocol/         # 通訊協定
│   └── out/                  # 編譯輸出
│
├── BlackjackClient/          # 客戶端程式
│   ├── src/
│   │   ├── Main.java         # 進入點
│   │   ├── client/           # 主視窗與網路
│   │   ├── handler/          # 訊息處理
│   │   ├── ui/               # UI 元件
│   │   └── protocol/         # 通訊協定
│   └── out/                  # 編譯輸出
│
└── AGENTS.md                 # 本文件
```

## 編譯與執行

### Server

```bash
cd BlackjackServer
javac -d out -sourcepath src src/Main.java src/server/*.java src/game/*.java src/model/*.java src/protocol/*.java
java -cp out Main
```

### Client

```bash
cd BlackjackClient
javac -d out -sourcepath src src/Main.java src/client/*.java src/handler/*.java src/ui/*.java src/protocol/*.java
java -cp out Main
```

## 通訊協定

指令格式：`COMMAND|PARAM1|PARAM2|...`

**Client → Server:**
- `LOGIN|name` - 登入
- `PVE_START` - 開始單人練習
- `CREATE_ROOM` - 創建房間
- `JOIN_ROOM|roomId` - 加入房間
- `START` - 開始遊戲 (莊家限定)
- `HIT` / `STAND` - 遊戲行動
- `CHAT|message` - 聊天
- `LEAVE` - 離開房間

**Server → Client:**
- `LOGIN_OK` - 登入成功
- `STATE|status|dealerHand|playerHand|playerList` - 遊戲狀態
- `TURN|YOUR/WAIT` - 輪次通知
- `GAME_OVER|dealerHand|playerHand|result` - 回合結束

## 程式碼慣例

- 類別名稱：PascalCase
- 方法/變數：camelCase
- 常數：UPPER_SNAKE_CASE
- 縮排：4 空格
- 註解語言：中文

## 遊戲規則

- 玩家初始 15 HP
- 閒家爆牌或輸給莊家：-1 HP
- 莊家爆牌：-2 HP
- 莊家消極懲罰（不拿牌且未獲勝）：-1 HP
- HP 歸零則淘汰
