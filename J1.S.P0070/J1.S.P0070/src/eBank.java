import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.Random;

public class eBank {
    private ResourceBundle messages;
    private String localeCode;

    public void setLocale(String localeCode) {
        this.localeCode = localeCode;
        Locale locale = new Locale(localeCode);
        messages = ResourceBundle.getBundle("Language.language", locale);
    }

    public String getLocale() {
        return localeCode;
    }

    public String checkAccountNumber(String accountNumber) {
        if (!Pattern.matches("\\d{10}", accountNumber)) {
            return messages.getString("accountNumber");
        }
        return "";
    }

    public String checkPassword(String password) {
        if (!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,31}$", password)) {
            return messages.getString("password.error");
        }
        return "";
    }

    public String generateCaptcha() {
        Random random = new Random();
        StringBuilder captcha = new StringBuilder(5);
        for (int i = 0; i < 5; i++) {
            captcha.append((char) ('A' + random.nextInt(26)));
        }
        return captcha.toString();
    }

    public String checkCaptcha(String captchaInput, String captchaGenerated) {
        if (!captchaGenerated.equalsIgnoreCase(captchaInput)) {
            return messages.getString("captcha");
        }
        return "";
    }
}
