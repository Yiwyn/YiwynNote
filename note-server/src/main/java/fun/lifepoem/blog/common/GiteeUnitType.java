package fun.lifepoem.blog.common;

/**
 * @author Yiwyn
 * @create 2022/9/17 16:00
 */
public enum GiteeUnitType {

    FILE("file"),
    DIR("dir"),
    MD("md");

    private final String typeName;

    GiteeUnitType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
