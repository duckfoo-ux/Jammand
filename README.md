![Java 17](https://img.shields.io/badge/Java-17-orange)
![Maven Central](https://img.shields.io/badge/maven%20central-v3.1.7-blue)


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


 
