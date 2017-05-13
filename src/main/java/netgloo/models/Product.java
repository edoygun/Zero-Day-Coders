package netgloo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @NotNull
  @Size(min = 3, max = 80)
  private String title;

  @NotNull
  @Size(min = 2, max = 80)
  private String subtitle;

  @NotNull
  private double price;

  private double discountPrice;

  @NotNull
  @Size(min = 2, max = 50)
  private String category;

  public Product() { }

  public Product(int id) {
    this.id = id;
  }

  public Product(String title, String subtitle, double price, double discountPrice, String category) {
    this.title = title;
    this.subtitle = subtitle;
    this.price = price;
    this.discountPrice = discountPrice;
    this.category = category;
  }


  public long getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getDiscountPrice() {
    return discountPrice;
  }

  public void setDiscountPrice(double discountPrice) {
    this.discountPrice = discountPrice;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
