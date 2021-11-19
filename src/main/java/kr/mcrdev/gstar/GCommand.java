package kr.mcrdev.gstar;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player) || !sender.isOp()) {
            return false;
        }

        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("system")) {
            // system 월가 번호
            if(args[0].equalsIgnoreCase("월가") && args.length == 2) {
                player.chat("/rg create GSTAR" + args[1]);
                player.chat("/rg flag GSTAR" + args[1] + " build none");
                player.chat("/rg flag GSTAR" + args[1] + " pvp deny");
                player.chat("/rg flag GSTAR" + args[1] + " interact allow");
                player.chat("/rg flag GSTAR" + args[1] + " use allow");
                player.chat("/rg flag GSTAR" + args[1] + " chest-access allow");
                player.chat("/rg flag GSTAR" + args[1] + " vehicle-place allow");
            }
        }

        if(args[0].equalsIgnoreCase("타이틀설정") && args.length > 1) {
            StringBuilder builder = new StringBuilder();

            for(int i=1; i<=args.length-1; i++) {
                builder.append(args[i].replace("&", "§")).append(" ");
            }

            GSTAR.TITLE_MESSAGE = builder.toString();
            player.sendMessage("타이틀 메세지 설정 완료: " + builder.toString());
        }

        if(args[0].equalsIgnoreCase("대기")) {
            GSTAR.WAITING = true;
            player.sendMessage("대기모드로 변경 완료");
        }

        if(args[0].equalsIgnoreCase("자유")) {
            GSTAR.WAITING = false;
            player.sendMessage("자유모드 변경 완료");
        }

        if(args[0].equalsIgnoreCase("예외") && args.length == 2) {
            Player target = Bukkit.getPlayerExact(args[1]);
            
            if(target == null) {
                player.sendMessage("닉네임을 다시 작성하세요");
                return true;
            }

            if(GSTAR.EXCEPT.contains(target)) {
                GSTAR.EXCEPT.remove(target);
                player.sendMessage("예외 처리 제거: " + target.getName());
            } else {
                GSTAR.EXCEPT.add(target);
                player.sendMessage("예외 처리 추가: " + target.getName());
            }
        }

        return false;
    }
}
