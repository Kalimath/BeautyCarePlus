package domain.model.measures;

import java.io.Serializable;

public class Checkup implements Serializable {
    private Circumferences circumferences;
    private Weights weights;
    private Heights heights;


    public Checkup(Heights heights, Weights weights, Circumferences circumferences) {
        this(heights);
        setWeights(weights);
        setCircumferences(circumferences);
    }
    public Checkup(Heights heights) {
        setHeights(heights);

    }


    public double getBmi() {
        return this.weights.getWeight()/(this.heights.getFullLength()*this.heights.getFullLength());
    }

    public Circumferences getCircumferences() {
        return circumferences;
    }

    public void setCircumferences(Circumferences circumferences) {
        this.circumferences = circumferences;
    }

    public Weights getWeights() {
        return weights;
    }

    public void setWeights(Weights weights) {
        this.weights = weights;
    }

    public Heights getHeights() {
        return heights;
    }

    public void setHeights(Heights heights) {
        this.heights = heights;
    }
}
