package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ProductDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-10T06:57:22.619286147Z[Etc/UTC]", comments = "Generator version: 7.9.0-SNAPSHOT")
public class ProductDto {

  private String code;

  private String name;

  private String description;

  private Integer stock;

  private Double unitPrice;

  public ProductDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ProductDto(String code, String name, Double unitPrice) {
    this.code = code;
    this.name = name;
    this.unitPrice = unitPrice;
  }

  public ProductDto code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   */
  @NotNull 
  @Schema(name = "code", example = "P001", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ProductDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @NotNull 
  @Schema(name = "name", example = "Product 1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductDto description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  
  @Schema(name = "description", example = "This is product 1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductDto stock(Integer stock) {
    this.stock = stock;
    return this;
  }

  /**
   * Get stock
   * @return stock
   */
  
  @Schema(name = "stock", example = "100", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("stock")
  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public ProductDto unitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
    return this;
  }

  /**
   * Get unitPrice
   * @return unitPrice
   */
  @NotNull 
  @Schema(name = "unitPrice", example = "29.99", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("unitPrice")
  public Double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductDto productDto = (ProductDto) o;
    return Objects.equals(this.code, productDto.code) &&
        Objects.equals(this.name, productDto.name) &&
        Objects.equals(this.description, productDto.description) &&
        Objects.equals(this.stock, productDto.stock) &&
        Objects.equals(this.unitPrice, productDto.unitPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, name, description, stock, unitPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductDto {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    stock: ").append(toIndentedString(stock)).append("\n");
    sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

