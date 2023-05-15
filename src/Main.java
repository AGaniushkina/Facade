import java.util.Scanner;
interface Account {
    boolean start(String str);
    void stop();
}
class Identification implements Account{
    String login = "annagan";
    public void setLogin(String login){
        this.login = login;
    }
    public boolean start(String login) {
        if (this.login.equals(login)){
            System.out.println("Идентификация");
            return true;
        }
        else{
            System.out.println("Неверное имя пользователя");
            return false;
        }
    }
    public void stop() {
        System.out.println("Выход");
    }
}
class Autentification implements Account {
    String password = "280802";
    public void setPassword(String password){
        this.password = password;
    }
    public boolean start(String password) {
        if (this.password.equals(password)){
            System.out.println("Аутентификация");
            return true;
        }
        else{
            System.out.println("Неверный пароль");
            return false;
        }
    }
    public void stop() {
        System.out.println("Блокировка аккаунта");
    }
}
class Facade {
    private Identification id;
    private Autentification password;
    public Facade() {
        id = new Identification();
        password = new Autentification();
    }
    public void logIn() {
        Scanner in = new Scanner(System.in);
        int i = 0;
        System.out.println("Введите логин");
        String login = in.nextLine();
        while(!id.start(login)){;
                System.out.println("Введите логин");
                login = in.nextLine();
        }
        System.out.println("Введите пароль");
        String pass = in.nextLine();
        while(!password.start(pass) & i < 3){
            System.out.println("Введите пароль. Осталось попыток " + (3 - i));
            pass = in.nextLine();
            i++;
        }
        if (i < 3) System.out.println("Авторизация");
        else System.out.println("Попытки закончились. Попробуйте снова позже");
//        autorise.start();
    }
    public void logOff() {
        id.stop();
        password.stop();
    }
}
public class Main {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Facade facade = new Facade();
    facade.logIn();
    System.out.println();
    facade.logOff();
    }
}
