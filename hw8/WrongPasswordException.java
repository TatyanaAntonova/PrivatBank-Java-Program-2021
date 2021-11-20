public class WrongPasswordException extends Exception {
    private String password;
    private String confirmPassword;

    public WrongPasswordException(String password) {
        this.password = password;
    }

    public WrongPasswordException(String message, String password) {
        super(message);
        this.password = password;
    }

    public WrongPasswordException(String message, String password, String confirmPassword){
        super(message);
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getPassword() {
        return "password: " + password + ",\n" +
                "confirmPassword: " + confirmPassword;
    }

}
