package uebung2;

public class ExampleMember implements uebung2.Member {
    private static int uniqueCounter = 0;

    public ExampleMember() {
        this.internalID = uniqueCounter++;
    }

    private Integer internalID;

    @Override
    public Integer getID() {
        return this.internalID;
    }

    @Override
    public String toString() {
        return "Member (ID = " + getID() + ")";
    }
}