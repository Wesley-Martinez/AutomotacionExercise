package modelos;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("ContactUs")
public class ContactUsModel {
    @ExcelCellName("Nombre")
    private String name;
    @ExcelCellName("Email")
    private String email;
    @ExcelCellName("Subject")
    private String subject;
    @ExcelCellName("YourMessageHere")
    private String yourMessageHere;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public String getYourMessageHere() {
        return yourMessageHere;
    }
}
