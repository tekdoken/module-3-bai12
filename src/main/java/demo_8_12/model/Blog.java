package demo_8_12.model;

public class Blog {
   private int id;
   private String tittle;
   private String content;
   private int categoryId;

    public Blog(String tittle, String content, int categoryId) {
        this.tittle = tittle;
        this.content = content;
        this.categoryId = categoryId;
    }

    public Blog() {
    }

    public Blog(int id, String tittle, String content, int category) {
        this.id = id;
        this.tittle = tittle;
        this.content = content;
        this.categoryId = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
