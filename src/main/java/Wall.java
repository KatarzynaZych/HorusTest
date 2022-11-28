import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {

    private CompositeBlock compositeBlock;
    private List<Block> blocks = compositeBlock.getBlocks();

    @Override
    public Optional<Block> findBlockByColor(String color) {
        featureValidation(color);
        return blocks.stream().filter(b -> (color.equals(b.getColor()))).findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        featureValidation(material);
        return blocks.stream().filter(b -> (material.equals(b.getMaterial()))).collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks == null ? 0 : blocks.size();
    }

    private static void featureValidation(String feature) {
        if (feature == null) {
            throw new RuntimeException("The feature is null. Please change the feature.");
        }
    }
}
