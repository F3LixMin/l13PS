package sg.edu.rp.c346.id21008740.l13ps;

public class Kindergarten {
    private String enrolement;
    private String year;

    public Kindergarten(String enrolement, String year) {
        this.enrolement = enrolement;
        this.year = year;
    }

    public String getEnrolement() {
        return enrolement;
    }

    public void setEnrolement(String enrolement) {
        this.enrolement = enrolement;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Kindergarten{" +
                "year='" + enrolement + '\'' +
                ", enrolment='" + year + '\'' +
                '}';
    }


}
