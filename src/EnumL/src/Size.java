public enum Size {
    SMALL("S"),LARGE("L"), MEDIUM("M"), EXTRA_LARGE("XL");

    private String abbreviation;

    Size(String abbreviation) {
        this.abbreviation = abbreviation;

    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
