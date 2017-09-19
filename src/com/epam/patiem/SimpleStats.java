package com.epam.patiem;

public class SimpleStats {

    private Commands name;
    private Integer success;
    private Integer fail;


    public SimpleStats(Commands name) {
        this.name = name;
        this.success = 0;
        this.fail = 0;
    }


    public Commands getName() {
        return name;
    }

    public void setName(Commands name) {
        this.name = name;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Integer getFail() {
        return fail;
    }

    public void setFail(Integer fail) {
        this.fail = fail;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleStats that = (SimpleStats) o;

        return name == that.name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
