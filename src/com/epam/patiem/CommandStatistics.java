package com.epam.patiem;

import java.util.ArrayList;
import java.util.List;

public class CommandStatistics implements MenageStatistics {

    List<SimpleStats> listOfStats = new ArrayList<>();

    {
        listOfStats.add(new SimpleStats(Commands.DIR));
        listOfStats.add(new SimpleStats(Commands.TREE));
        listOfStats.add(new SimpleStats(Commands.EXIT));
        listOfStats.add(new SimpleStats(Commands.PROMPT));
        listOfStats.add(new SimpleStats(Commands.STATISTICS));
        listOfStats.add(new SimpleStats(Commands.CD));
    }


    @Override
    public void add(Commands command, Boolean isSuccssed) {

    }

    @Override
    public List<String> getStatistics() {
        return null;
    }
}
