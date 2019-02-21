package io.destreza.android_component.Retrofits;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private Data data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public class Data {

        @SerializedName("count")
        @Expose
        private Integer count;
        @SerializedName("categories")
        @Expose
        private List<Category> categories = null;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public List<Category> getCategories() {
            return categories;
        }

        public void setCategories(List<Category> categories) {
            this.categories = categories;
        }

    }

    public class Category {

        @SerializedName("idCategory")
        @Expose
        private Integer idCategory;
        @SerializedName("categoryName")
        @Expose
        private String categoryName;
        @SerializedName("createAt")
        @Expose
        private String createAt;
        @SerializedName("updatedAt")
        @Expose
        private String updatedAt;
        @SerializedName("createdBy")
        @Expose
        private Integer createdBy;

        public Integer getIdCategory() {
            return idCategory;
        }

        public void setIdCategory(Integer idCategory) {
            this.idCategory = idCategory;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCreateAt() {
            return createAt;
        }

        public void setCreateAt(String createAt) {
            this.createAt = createAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Integer getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Integer createdBy) {
            this.createdBy = createdBy;
        }

    }


}
