# 구성
```
example-plugin
└── src
    └── main
        ├── java
        └── resources
            ├── config.yml
            └── plugin.yml
```

# 매인
@Override
    public void onEnable() {
    // ...
    }
서버 시작메시지
```
getLogger().info("Jammand is enabled");
```
## 커맨드 등록
```
getCommand("jammand").setExecutor(this);
```





## 이벤트 등록
getServer().getPluginManager().registerEvents(this, this);

config.yml 있다면
```
        saveDefaultConfig(); // 이건 config.yml 있을때 쓰기
        saveResource("config.yml",  false); // 이건 config.yml 있을때 쓰기
```


# plugin.yml
```
name: 
version: 
main: 
description: A
author: 
website: 
api-version:
commands:
```

# config.yml
플러그인이 초기화되면 이 리소스를 플러그인의 데이터 디렉토리에 저장해야 사용자가 값을 편집할 수 있습니다. 플러그인에서 이를 수행하는 방법의 예는 다음과 같습니다 onEnable

```
public class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveResource("config.yml", /* replace */ false);

        // You can also use this for configuration files:
        saveDefaultConfig();
        // Where the default config.yml will be saved if it does not already exist

        // getConfig()...
    }

}
```


# command:

```
public class ExampleListener implements CommandExecutor {
    // ...
}
```
써주기!
```
    @Override
    public void onEnable() {
        getCommand("jammand").setExecutor(this);
    }

```
jammand 에 커맨드 이름 써주기 커맨드 이름은 plugin.yml에서
```
name: Jammand
version: '1.0-SNAPSHOT'
main: Jmmand.jammand
api-version: '1.20'
loader:
commands:
  Jammand:
    description: Jammand
```
써주기

// Ctrl + o 를 사용하여 onCommand  추가 
```
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // ...
        return false;
    }

```
여기서    return true; 도 가능 




# Event
```
public class ExampleListener implements Listener {
    // ...
}
```

필요 
```
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        // ...
    }
```
 꼭 @EventHandler 써주기!!

커맨드와 이밴트 핸들러를 같이써서  상자 ui를 열려면
```
public class Iv extends JavaPlugin implements Listener, CommandExecutor {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("iv").setExecutor(this);
    }
```

ctrl+o 로 onCommand 추가 그리고 예시:

```
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        Inventory inventory = Bukkit.createInventory(null, 27, ChatColor.BLACK + "Iv");
        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Usage: /iv <player>");

        }else{
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("player")) {
                    player.openInventory(inventory);
                }
            }


        }
        return false;
    }
}



```
여기서 상자가 1번칸이 아니라 0번칸부터 시작 
26칸의 상자를 열려면 27을 써주기 
plugin.yml에 추가 


### plugin.yml전체 코드:

```
name: Jammand
version: '1.0-SNAPSHOT'
main: Jmmand.jammand
api-version: '1.20'
loader:
commands:
  Jammand:
    description: Jammand
  iv:
    description: iv
```

# 주의사항
plugin.ymlㅣconfig.yml은  꼭 resources 파일안에 넣어두기


 
