public class Wine {
    private double fixed_acidity, volatile_acidity, citric_acid, residual_sugar, chlorides, free_sulfur_dioxide, total_sulfur_dioxide, density, pH, sulphates, alcohol, quality;


    // default constructor
    public Wine() {
        fixed_acidity = 0.0;
        volatile_acidity = 0.0;
        citric_acid = 0.0;
        residual_sugar = 0.0;
        chlorides = 0.0;
        free_sulfur_dioxide = 0.0;
        total_sulfur_dioxide = 0.0;
        density = 0.0;
        pH = 0.0;
        sulphates = 0.0;
        alcohol = 0.0;
        quality = 0.0;
    }

    // parameterized constructor
    public Wine(double fixed_acidity, double volatile_acidity, double citric_acid, double residual_sugar, double chlorides, double free_sulfur_dioxide, double total_sulfur_dioxide, double density, double pH, double sulphates, double alcohol, double quality) {
        this.fixed_acidity = fixed_acidity;
        this.volatile_acidity = volatile_acidity;
        this.citric_acid = citric_acid;
        this.residual_sugar = residual_sugar;
        this.chlorides = chlorides;
        this.free_sulfur_dioxide = free_sulfur_dioxide;
        this.total_sulfur_dioxide = total_sulfur_dioxide;
        this.density = density;
        this.pH = pH;
        this.sulphates = sulphates;
        this.alcohol = alcohol;
        this.quality = quality;
    }

    // copy constructor
    public Wine(Wine w) {
        fixed_acidity = w.fixed_acidity;
        volatile_acidity = w.volatile_acidity;
        citric_acid = w.citric_acid;
        residual_sugar = w.residual_sugar;
        chlorides = w.chlorides;
        free_sulfur_dioxide = w.free_sulfur_dioxide;
        total_sulfur_dioxide = w.total_sulfur_dioxide;
        density = w.density;
        pH = w.pH;
        sulphates = w.sulphates;
        alcohol = w.alcohol;
        quality = w.quality;
    }

    // getters

    public double getFixed_acidity() { return fixed_acidity; }
    public double getVolatile_acidity() { return volatile_acidity; }

    public double getCitric_acid() { return citric_acid; }
    public double getResidual_sugar() { return residual_sugar; }
    public double getChlorides() { return chlorides; }
    public double getFree_sulfur_dioxide() { return free_sulfur_dioxide; }
    public double getTotal_sulfur_dioxide() { return total_sulfur_dioxide; }
    public double getDensity() { return density; }
    public double getpH() { return pH; }
    public double getSulphates() { return sulphates; }
    public double getAlcohol() { return alcohol; }
    public double getQuality() { return quality; }

    // toString method
    @Override
    public String toString() {
        return fixed_acidity + "," + volatile_acidity + "," + citric_acid + "," + residual_sugar + "," + chlorides + ","
                + free_sulfur_dioxide + "," + total_sulfur_dioxide + "," + density + "," + pH + "," + sulphates + "," +
                alcohol + "," + quality;
    }
}
