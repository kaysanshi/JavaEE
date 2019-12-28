package com.kaysanshi.springbootshop.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author kay三石
 * @date:2019/12/14
 */
public class CategoryDTO {
    private String id;
    private String name;
    private String open;
    private String checked;
    private List<CategoryDTO> children;
    public CategoryDTO(){
        this.children=new ArrayList <>();
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

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public List <CategoryDTO> getChildren() {
        return children;
    }

    public void setChildren(List <CategoryDTO> children) {
        this.children = children;
    }
}
