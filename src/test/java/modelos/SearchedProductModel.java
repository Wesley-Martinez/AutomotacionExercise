package modelos;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("Products")
public class SearchedProductModel {
    @ExcelCellName("products")
    private String products;

    public String getProducts() {
        return products;
    }
}
