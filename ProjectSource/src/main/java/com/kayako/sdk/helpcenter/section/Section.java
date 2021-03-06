package com.kayako.sdk.helpcenter.section;

import com.kayako.sdk.base.parser.Resource;
import com.kayako.sdk.helpcenter.category.Category;

/**
 * @author Neil Mathew (neil.mathew@kayako.com)
 * @date 24/08/16
 */
public class Section implements Resource {

    private Long id;

    private String title;

    private String description;

    private String visibility;

    private Category category;

    private Integer display_order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getDisplay_order() {
        return display_order;
    }

    public void setDisplay_order(Integer display_order) {
        this.display_order = display_order;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", visibility='" + visibility + '\'' +
                ", category=" + category +
                ", display_order=" + display_order +
                '}';
    }
}
