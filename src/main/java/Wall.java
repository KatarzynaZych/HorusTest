import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Wall implements Structure {

    private final List<Block> blocks;

    public Wall(CompositeBlock blocks) {
        this.blocks = blocks.getBlocks();
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        featureValidation(color);
        return getBlockStream((i) -> color.equals(i.getColor())).findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        featureValidation(material);
        return getBlockStream((i) -> material.equals(i.getMaterial())).collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks == null ? 0 : blocks.size();
    }

    private Stream<Block> getBlockStream(Predicate<Block> hasFeature) {
        return blocks.stream().filter(hasFeature);
    }

    private static void featureValidation(String feature) {
        if (feature == null) {
            throw new RuntimeException("The feature is null. Please change the feature.");
        }
    }
}

