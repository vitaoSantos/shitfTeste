package Pojo;

import java.io.Serializable;
import java.util.Objects;

public abstract class Pojo implements Serializable {
    
    private Long id;
    private Boolean checkbox;
    
    public Pojo() {
        id = null;
        checkbox = null;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Boolean getCheckbox() {
        return checkbox;
    }
    
    public void setCheckbox(Boolean checkbox) {
        this.checkbox = checkbox;
    }
    
    @Override
    public boolean equals(Object obj) {
        return (this == obj)
                || !(obj == null
                || getClass() != obj.getClass()
                || this.getId() == null
                || this.getClass().cast(obj).getId() == null
                || !Objects.equals(this.getId(), this.getClass().cast(obj).getId()));
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        return 23 * hash + Objects.hashCode(this.getId());
    }
    
}
