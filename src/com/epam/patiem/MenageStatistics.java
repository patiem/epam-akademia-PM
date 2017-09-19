package com.epam.patiem;

import java.util.List;

public interface MenageStatistics {

    void add(Commands command, Boolean isSuccssed);
    List<String> getStatistics();
}
