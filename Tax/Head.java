/**
 * Objects of this class store information about the heads in the sheet
 */
public class Head {
    String name;
    double c1;
    double c2;
    double c3;
    int subheads;
    Head[] Subheads;

    public Head() {
        this.name = "";
        this.subheads = 0;
    }

    public Head(String name) {
        this.name = name;
        this.subheads = 0;
    }

    public Head(String name, int subheads) {
        this.name = name;
        this.subheads = subheads;
        this.createSubheads();
    }

    public Head(String name, int subheads, Head[] Subheads) {
        this.name = name;
        this.subheads = subheads;
        this.Subheads = Subheads;
    }

    boolean hasSubhead() {
        return this.subheads > 0 ? true : false;
    }

    void createSubheads() {
        Subheads = new Head[subheads];
        for (int i = 0; i < subheads; i++)
            Subheads[i] = new Head();
    }
}
