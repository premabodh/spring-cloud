package se.callista.microservises.support.discovery.model;


import java.util.List;

/**
 * Created by magnus on 04/03/15.
 */
public class ProductAggregated {
    private int productId;
    private String name;
    private int weight;
    private List<RecommendationSummary> recommendations;
    private List<ReviewSummary> reviews;

    public ProductAggregated(Product product) {

        // 1. Setup product info
        this.productId = product.getProductId();
        this.name = product.getName();
        this.weight = product.getWeight();

        // 2. Copy summary recommendation info, if available
//        if (recommendations != null)
//            this.recommendations = recommendations.stream()
//                .map(r -> new RecommendationSummary(r.getRecommendationId(), r.getAuthor(), r.getRate()))
//                .collect(Collectors.toList());
//
//        // 3. Copy summary review info, if available
//        if (reviews != null)
//            this.reviews = reviews.stream()
//                .map(r -> new ReviewSummary(r.getReviewId(), r.getAuthor(), r.getSubject()))
//                .collect(Collectors.toList());
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public List<RecommendationSummary> getRecommendations() {
        return recommendations;
    }

    public List<ReviewSummary> getReviews() {
        return reviews;
    }
}
