package modelos;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("AccountInfo")
public class AccountInfoModel {

    @ExcelCellName("password")
    private String password;
    @ExcelCellName("firstname")
    private String name;
    @ExcelCellName("lastname")
    private String lastname;
    @ExcelCellName("company")
    private String company;
    @ExcelCellName("address")
    private String address;
    @ExcelCellName("state")
    private String state;
    @ExcelCellName("city")
    private String city;
    @ExcelCellName("zipcode")
    private String zipcode;
    @ExcelCellName("mobilenumber")
    private String mobilenumber;

    public String getPassword() {
        return password;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getAddress() {
        return address;
    }

    public String getCompany() {
        return company;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }
}
