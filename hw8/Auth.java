public class Auth {
    private String login;
    private String password;

    public void signUp(String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {

        if (login.length() < 5 || login.length() > 20) {
            throw new WrongLoginException("Your login length should be from 5 to 20", login);
        } else if (!login.matches("^[a-zA-Z0-9]+$")) {
            throw new WrongLoginException("Use just Latin symbols. Please, try again!", login);
        }

        if (password.length() < 5) {
            throw new WrongPasswordException("Your password length should be longer than 5. Please, try again!", password);
        } else if (!password.matches("^[a-zA-Z0-9_]+$")) {
            throw new WrongPasswordException("Use just Latin symbols. Underscore isn't forbidden. Please, try again!", password);
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Your confirmPassword doesn't equal to password. Please, try again!", password, confirmPassword);
        }

        this.login = login;
        this.password = password;
    }

    public void signIn(String login, String password) throws WrongLoginException{
        if(!this.login.equals(login) && !this.password.equals(password)){
            throw new WrongLoginException("Your login or password isn't correct! Please try again!", login);
        }
    }
}
