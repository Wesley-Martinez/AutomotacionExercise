package data;

import com.poiji.bind.Poiji;
import modelos.*;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private static final String excelPath = "src/test/resources/data/SignUpLogin.xlsx";

    public static List<SignUpLoginModel> readListSignUpLoginExcel(){
        return Poiji.fromExcel(new File(excelPath), SignUpLoginModel.class);
    }

    public static List<AccountInfoModel> readListAccountInfoExcel(){
        return Poiji.fromExcel(new File(excelPath), AccountInfoModel.class);
    }

    public static List<ContactUsModel> readListContactUsExcel(){
        return Poiji.fromExcel(new File(excelPath), ContactUsModel.class);
    }

    public static List<SearchedProductModel> readListSearchedProductExcel(){
        return Poiji.fromExcel(new File(excelPath), SearchedProductModel.class);
    }

    public static List<PaymentModel> readListPaymentExcel(){
        return Poiji.fromExcel(new File(excelPath), PaymentModel.class);
    }


}