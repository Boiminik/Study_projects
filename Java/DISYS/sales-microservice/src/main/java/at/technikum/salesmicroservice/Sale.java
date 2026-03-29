package at.technikum.salesmicroservice;

public class Sale {

    private int productId;

    private float percent;

    public Sale() {
    }

    public Sale(int productId, float percent) {
        this.productId = productId;
        this.percent = percent;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
}
