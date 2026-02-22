package dto;

public record LineDetail(
        String itemName,
        int qty,
        double lineTotal
) {
}