package liu;/*
 * @author  yuan meng meng
 * @description:
 * @date 2019/12/30
 * */

import java.io.Serializable;

public class Pet implements Serializable {
    private static final long serialVersionUID = 514910705505845579L;

    private String id;
    private String name;
    public Pet() {
    }

    public Pet(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
