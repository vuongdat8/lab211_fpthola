import java.util.Scanner;

public class LoginManager {
    private eBank ebank;
    private Scanner sc;

    public LoginManager(eBank ebank, Scanner sc) {
        this.ebank = ebank;
        this.sc = sc;
    }

    private String getPrompt(String englishPrompt, String vietnamesePrompt) {
        return ebank.getLocale().equals("vi") ? vietnamesePrompt : englishPrompt;
    }

    public void loginProcess() {
        String accountNumber;
        String accountMessage;
        do {
            System.out.print(getPrompt("Enter account number: ", "Nhập số tài khoản: "));
            accountNumber = sc.nextLine();
            accountMessage = ebank.checkAccountNumber(accountNumber);
            if (!accountMessage.isEmpty()) {
                System.out.println(accountMessage);
            }
        } while (!accountMessage.isEmpty());

        String password;
        String passwordMessage;
        do {
            System.out.print(getPrompt("Enter password: ", "Nhập mật khẩu: "));
            password = sc.nextLine();
            passwordMessage = ebank.checkPassword(password);
            if (!passwordMessage.isEmpty()) {
                System.out.println(passwordMessage);
            }
        } while (!passwordMessage.isEmpty());

        String captcha;
        String captchaInput;
        String captchaMessage;
        do {
            captcha = ebank.generateCaptcha();
            System.out.println("Captcha: " + captcha);
            System.out.print(getPrompt("Enter captcha: ", "Nhập captcha: "));
            captchaInput = sc.nextLine();
            captchaMessage = ebank.checkCaptcha(captchaInput, captcha);
            if (!captchaMessage.isEmpty()) {
                System.out.println(captchaMessage);
            }
        } while (!captchaMessage.isEmpty());

        System.out.println(getPrompt("Login successful!", "Đăng nhập thành công!"));
    }
}
