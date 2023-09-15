package kr.mdcdev.job;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

public interface Job extends ConfigurationSerializable {
    String getName();
    String getBoardName();
    String getAIName();

    boolean isServant();

    int getLevel();
}
