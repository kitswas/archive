public class UI {
    private static Head[] h;

    private static void createHeads() {
        h = new Head[18];
        h[0] = new Head("1.Gross salary including perks" + tab(7));
        h[1] = new Head("2.Less professional tax" + tab(7));
        h[2] = new Head("3.Income under salaries(1-2)" + tab(7));
        h[3] = new Head("4.Less Interest on HBL" + tab(7));
        h[4] = new Head("5.Any other income reported by employee" + tab(6));
        h[5] = new Head("6.Income from house property" + tab(7));
        h[6] = new Head("7.Gross Taxable Income(3+4+5+6)" + tab(6));
        h[7] = new Head("8.Less: Standard Deduction" + tab(7));
        h[8] = new Head("9.Less Deduction u/s Chapter VI", 7, new Head[]
                {
                        new Head("a)Deduction u/s 80C" + tab(7)),
                        new Head("b)Contribution to NPS Fund u/s 80CCD(1B)" + tab(6)),
                        new Head("c)Medical Insurancee Premium u/s 80D" + tab(6)),
                        new Head("d)Handicapped Taxpayer (Employee) u/s 80DD" + tab(6)),
                        new Head("e)Physically handicapped dependant of the employee" + tab(5)),
                        new Head("f)Interest on Education Loan(80E)" + tab(6)),
                        new Head("g)Donation to charitable institution u/s 80G (if recovered through Pay-Slip)" + tab(4)),
                });
        h[9] = new Head("10.Net Taxable Income" + tab(7));
        h[10] = new Head("11.Tax on net taxable income" + tab(7));
        h[11] = new Head("12.Rebate of Tax u/s 87A" + tab(7));
        h[12] = new Head("13.Tax payable" + tab(8));
        h[13] = new Head("14.Surchages" + tab(8));
        h[14] = new Head("15.Health and Education cess" + tab(7));
        h[15] = new Head("16.Tax with Health and Education cess" + tab(6));
        h[16] = new Head("17.Less spread-over benefit (if any)" + tab(6));
        h[17] = new Head("18.Tax Liability" + tab(8));
        return;
    }

    protected static void begin(int i) throws Exception {
        int j;
        switch (i) {
            case 1:
                createHeads();
                updateConsole("Ready");
                setDisplay(h[0].name);
                break;

            case 2:
                h[0].c1 = getInput();
                setDisplay("\n" + h[1].name);
                break;

            case 3:
                h[1].c1 = getInput();
                h[2].c1 = h[0].c1 - h[1].c1;
                setDisplay("\n" + h[2].name + h[2].c1);
                setDisplay("\n" + h[3].name);
                break;

            case 4:
                h[3].c1 = getInput();
                setDisplay("\n" + h[4].name);
                break;

            case 5:
                h[4].c1 = getInput();
                setDisplay("\n" + h[5].name);
                break;

            case 6:
                h[5].c1 = getInput();
                h[6].c1 = h[2].c1 + h[3].c1 + h[4].c1 + h[5].c1;
                setDisplay("\n" + h[6].name + h[6].c1);
                setDisplay("\n" + h[7].name);
                break;

            case 7:
                h[7].c1 = getInput();
                if (h[7].c1 > 40000) {
                    h[7].c2 = h[7].c1;
                    h[7].c1 = 40000;
                    setDisplay("\tQualifying amount\t40000");
                }
                setDisplay("\n" + h[8].name);
                setDisplay("\n" + h[8].Subheads[0].name);
                break;

            case 8:
                h[8].Subheads[0].c1 = getInput();
                if (h[8].Subheads[0].c1 > 150000) {
                    h[8].Subheads[0].c2 = h[8].Subheads[0].c1;
                    h[8].Subheads[0].c1 = 150000;
                    setDisplay("\tQualifying amount\t150000");
                }
                setDisplay("\n" + h[8].Subheads[1].name);
                break;

            case 9:
                h[8].Subheads[1].c1 = getInput();
                if (h[8].Subheads[1].c1 > 50000) {
                    h[8].Subheads[1].c2 = h[8].Subheads[1].c1;
                    h[8].Subheads[1].c1 = 50000;
                    setDisplay("\tQualifying amount\t50000");
                }
                setDisplay("\n" + h[8].Subheads[2].name);
                break;

            case 10:
                h[8].Subheads[2].c1 = getInput();
                if (h[8].Subheads[2].c1 > 50000) {
                    h[8].Subheads[2].c2 = h[8].Subheads[2].c1;
                    h[8].Subheads[2].c1 = 50000;
                    setDisplay("\tQualifying amount\t50000");
                }
                setDisplay("\n" + h[8].Subheads[3].name);
                break;

            case 11:
                h[8].Subheads[3].c1 = getInput();
                setDisplay("\n" + h[8].Subheads[4].name);
                break;

            case 12:
                h[8].Subheads[4].c1 = getInput();
                setDisplay("\n" + h[8].Subheads[5].name);
                break;

            case 13:
                h[8].Subheads[5].c1 = getInput();
                setDisplay("\n" + h[8].Subheads[6].name);
                break;

            case 14:
                h[8].Subheads[6].c1 = getInput();
                h[9].c1 = h[6].c1 - h[7].c1;
                for (j = 0; j < 7; j++) {
                    h[9].c1 -= h[8].Subheads[j].c1;
                }
                setDisplay("\n" + h[9].name + h[9].c1);
                break;

            case 15:
                updateConsole("Calculating Tax");
                taxCalc();
                updateConsole("Tax Calculation Completed");
                setDisplay("\n" + h[16].name);
                break;

            case 16:
                h[16].c1 = getInput();
                h[17].c1 = h[15].c1 - h[16].c1;
                setDisplay("\n" + h[17].name + h[17].c1);
                break;

            default:
                updateConsole("Program terminated");
                System.gc();
        }
        return;
    }

    private static void taxCalc() {
        if (Tax.seniorcitizen.isSelected()) {
            if (h[9].c1 <= 250000)
                h[10].c1 = 0;
            else if (h[9].c1 <= 500000)
                h[10].c1 = 0.05 * (h[9].c1 - 250000);
            else if (h[9].c1 <= 1000000)
                h[10].c1 = 0.20 * (h[9].c1 - 500000) + 12500;
            else
                h[10].c1 = 0.30 * (h[9].c1 - 1000000) + 112500;
        } else {
            if (h[9].c1 <= 300000)
                h[10].c1 = 0;
            else if (h[9].c1 <= 500000)
                h[10].c1 = 0.05 * (h[9].c1 - 300000);
            else if (h[9].c1 <= 1000000)
                h[10].c1 = 0.20 * (h[9].c1 - 500000) + 10000;
            else
                h[10].c1 = 0.30 * (h[9].c1 - 1000000) + 110000;
        }
        setDisplay("\n" + h[10].name + h[10].c1);

        if (h[10].c1 < 350000) {
            h[11].c1 = h[10].c1 < 2500 ? h[10].c1 : 2500;
        } else {
            h[11].c1 = 0;
        }

        setDisplay("\n" + h[11].name + h[11].c1);
        h[12].c1 = h[10].c1 - h[11].c1;
        setDisplay("\n" + h[12].name + h[12].c1);

        if (h[9].c1 <= 5000000)
            h[13].c1 = 0;
        else if (h[9].c1 <= 10000000)
            h[13].c1 = 0.10 * h[12].c1;
        else
            h[13].c1 = 0.15 * h[12].c1;

        setDisplay("\n" + h[13].name + h[13].c1);
        h[14].c1 = 0.04 * (h[12].c1 + h[13].c1);
        setDisplay("\n" + h[14].name + h[14].c1);
        h[15].c1 = h[12].c1 + h[13].c1 + h[14].c1;
        setDisplay("\n" + h[15].name + h[15].c1);

    }

    private static String tab(int n) {
        String s = "";
        for (int i = 1; i <= n; i++)
            s += "\t";
        return s;
    }

    private static void setDisplay(String args) {
        Tax.display.append(args);
        Tax.in.requestFocusInWindow();
    }

    private static double getInput() throws Exception {
        double n;
        n = Double.parseDouble(Tax.in.getText());
        Tax.in.setText("");
        setDisplay("" + n);
        return n;
    }

    private static void updateConsole(String args) {
        Tax.console.append("\n" + args);
    }

}
