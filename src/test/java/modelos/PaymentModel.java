package modelos;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("Payment")
public class PaymentModel {
    @ExcelCellName("NameCard")
    private String name;
    @ExcelCellName("CardNumber")
    private String cardNumber;
    @ExcelCellName("CVC")
    private String cvc;
    @ExcelCellName("ExpirationMonth")
    private String expMonth;
    @ExcelCellName("ExpirationYear")
    private String expYear;

    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public String getExpYear() {
        return expYear;
    }
}
