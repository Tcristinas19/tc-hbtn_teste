public class Pessoa {
    public class static boolean emailValid(String email){
        return email.contains("@") && email.length() <= 50;
    }
}
