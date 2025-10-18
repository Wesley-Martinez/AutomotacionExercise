package modelos;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("SignUpLogin")
public class SignUpLoginModel {

    @ExcelCellName("Nombre")
    private String name;
    @ExcelCellName("Email")
    private String email;
    @ExcelCellName("MensajeError")
    private String errorMessage;
    @ExcelCellName("MensajeErrorSignUp")
    private String errorMessageSignUp;

    public String getNombre() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorMessageSignUp() {
        return errorMessageSignUp;
    }
}